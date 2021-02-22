package Web;

import Entities.Association;
import Service.IAssociation;
import ServiceImpl.AssociationImpl;

import javax.ws.rs.*;
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
    public Association getById(@PathParam(value = "id") Long id){
        return iAssociation.getAssociationById(id);
    }

    @POST
    @Path("/{id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long deleteAssociation(@PathParam(value = "id") Long id){
        return iAssociation.deleteAssociation(id);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long updateAssociation(String data){
        return iAssociation.updateAssociation(data);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int addAssociation(String data){
        return iAssociation.addAssociation(data);
    }



}
