package Web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Entities.MembreAssociation;

@Path("/user")
public class UserController {
	
	@POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String register(String data)
    {
        System.out.println("***********");
        return "helloWorld";
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