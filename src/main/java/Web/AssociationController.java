package Web;

import Entities.Association;
import Service.IAssociation;
import ServiceImpl.AssociationImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/association")
public class AssociationController {
    private IAssociation iAssociation;

    public AssociationController() {
        this.iAssociation = new AssociationImpl();
    }

    @GET()
    @Path("allNames")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAssociationsName(){
        return iAssociation.getAssociationsName();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam(value = "id") Long id){
        return iAssociation.getAssociationById(id).getDescAssoc();
    }
}
