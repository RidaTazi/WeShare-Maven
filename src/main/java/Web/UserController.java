package Web;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import Entities.Token;
import Entities.User;

@Path("/user")
public class UserController 
{
		
	@POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Context  HttpHeaders headers, HashMap<String, String> body)
    {
		String username = body.get("username");
		String password = body.get("password");
		String role = body.get("role");
		HashMap<String, String> resbody = new HashMap<String, String>();
		User user = null;
		String token = null;
    	
		
		if ((username == null) || (password == null) || (role == null))
		{
			resbody.put("message", "Incorrect format of http request");
			return response(resbody, 400);
		}
		
		try 
		{
			user = User.objects.create(username, password, role); //create the user
			
			try 
			{
				token = Token.objects.create(user.getUsername(), password, user.getIdUser());	
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				resbody.put("message", "Internal server error");
				return response(resbody, 500);
			}
			
		} 
		catch (SQLIntegrityConstraintViolationException e) 
		{
			e.printStackTrace();
			resbody.put("message", "Username already exists");
			return response(resbody, 400);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			resbody.put("message", "Internal server error");
			return response(resbody, 500);
		}
		
		resbody.put("message", "User successfully created");
		resbody.put("userId", String.valueOf(user.getIdUser()));
		resbody.put("username", user.getUsername());
		resbody.put("token", token);
		resbody.put("role", user.getRoleUser());
		
		return response(resbody, 200);
    }
	
	@POST
    @Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(@Context  HttpHeaders headers, HashMap<String, String> body)
    {
    	HashMap<String, String> resbody = new HashMap<String, String>();
    	
    	String username = body.get("username");
		String password = body.get("password");
    	
    	String token = Token.generateToken(username, password);
    	
    	System.out.println(token);
    	
    	try
		{
			long user_token = Token.objects.get(token);
			
			if (user_token != -1)
			{
				resbody.put("user_token", token);
				resbody.put("user_id",  String.valueOf(user_token));
				resbody.put("message", "Authentication succeeded");
				return response(resbody, 200);
			}
			else 
			{
				resbody.put("message", "Unauthorized access");
				return response(resbody, 430);
			}
		} 
    	catch (SQLException e)
		{
			e.printStackTrace();
			resbody.put("message", "Internal server error");
			return response(resbody, 500);
		}
    }
	
	public static Response authorize(@Context  HttpHeaders headers, HashMap<String, String> body)
	{
		MultivaluedMap<String, String> mmap = headers.getRequestHeaders();
		HashMap<String, String> resbody = new HashMap<String, String>();
		List<String> authorization = mmap.get("Authorization");
		String token = null;
		long user_id = -1;
				
		if (authorization == null)
		{
			resbody.put("message", "Unauthorized access");
			return response(resbody, 400);
		}

		token = authorization.get(0).substring(6);
		
		System.out.println(token);
	
		try
		{
			user_id = Token.objects.get(token);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			resbody.put("message", "Internal server error");
			return response(resbody, 500);
		}
		
		if (user_id == -1)
		{
			resbody.put("message", "Unauthorized access");
			return response(resbody, 400);
		}
	
		return response(resbody, 200);
	}
	
	public static Response response(HashMap<String, String> resbody, int status)
	{
		return Response.ok(resbody, MediaType.APPLICATION_JSON).status(status).build();
	}

}
