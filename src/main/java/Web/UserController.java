package Web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Entities.MembreAssociation;

@Path("/user")
public class UserController {
	
	HashMap<String, String> convertMultiValueMapToMap(MultivaluedMap<String, String> mmap)
	{
		HashMap<String, String> hmap = new HashMap<String, String>();
		for (Map.Entry<String, List<String>> entry : mmap.entrySet()) 
		{
		    String key = entry.getKey();
		    String value = entry.getValue().get(0);
		   
		    hmap.put(key, value);
		}
		return hmap;
	}
	
	
	@POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> register(String data, @Context  HttpHeaders headers)
    {
		MultivaluedMap<String, String> rh = headers.getRequestHeaders();
	    return convertMultiValueMapToMap(rh);
    }
	
	@POST
    @Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void authenticate(String data)
    {
        
    }
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getUsernameAndEmail(@PathParam(value = "id") Long id)
	{
        
    }
	
	@POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateUsernameOrPasswordOrEmail(@PathParam(value = "id") Long id)
	{
        
    }
}
