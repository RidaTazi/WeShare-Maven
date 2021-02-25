package Web;


import Entities.Association;
import Entities.MembreAssociation;
import Service.IAssociation;
import Service.IMembre;
import ServiceImpl.AssociationImpl;
import ServiceImpl.MembreImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/membre")
public class MembreController {
    private IMembre iMembre;
    public MembreController() {
        this.iMembre = new MembreImpl();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MembreAssociation getById(@PathParam(value = "id") Long id){
        return iMembre.getMembreById(id);
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long updateMembre(String data){
        return iMembre.updateMembre(data);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int addMembre(String data){
        return iMembre.addMembre(data);
    }

    @POST
    @Path("/{id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long deleteMembre(@PathParam(value = "id") Long id){
        return iMembre.deleteMembre(id);
    }





}
