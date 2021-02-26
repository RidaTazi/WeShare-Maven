package Web;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import Entities.Token;
import Entities.User;



@Path("/user")
public class UserController {
		
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
   
		try 
		{
			User user = User.objects.create(username, password, role); //create the user
			
			try 
			{
				Token.objects.create(user.getUsername(), password, user.getIdUser());	
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
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getUsernameAndEmail(@Context  HttpHeaders headers, HashMap<String, String> body, @PathParam(value = "id") Long id)
	{
        UserController.authorize(headers, body);
    }
	
	@POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUsernameOrPasswordOrEmail(@Context  HttpHeaders headers, HashMap<String, String> body, @PathParam(value = "id") Long id)
	{
        
    }
		
	public static Response response(HashMap<String, String> resbody, int status)
	{
		return Response.ok(resbody, MediaType.APPLICATION_JSON).status(status).build();
	}

	public static Response authorize(@Context  HttpHeaders headers, HashMap<String, String> body)
	{
		MultivaluedMap<String, String> mmap = headers.getRequestHeaders();
		
		String token = mmap.get("Authorization").get(0);
		
		HashMap<String, String> resbody = new HashMap<String, String>();
		
		if (token == null)
		{
			resbody.put("message", "Unauthorized access");
			return response(resbody, 400);
		}
		
		long user_id = -1;
		
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
	
		resbody.put("message", "Authorized access");
		return response(resbody, 200);
	}

}
