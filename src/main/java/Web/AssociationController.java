package Web;

import Entities.Association;
import Entities.Don;
import Entities.Publication;
import Service.IAssociation;
import ServiceImpl.AssociationImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/association")
public class AssociationController {
    private final IAssociation iAssociation;

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
    
    @GET
    @Path("/publications")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publication> getAllPublications(@PathParam(value = "id") Long id){
        return iAssociation.getAllPublications();
    }
    
    @GET
    @Path("/{idPub}/dons")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Don> getDonsByPublications(@PathParam(value = "idPub") Long idPub){
        List<Don> dons=new ArrayList<>();
        (iAssociation.getDonsByPublication(idPub).stream().filter(don -> don.getState().equals("attente"))).forEach(dons::add);
        return dons;
    }

//    @GET
//    @Path("/{idMembre}/acceptedDons")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Don> getAcceptedDons(@PathParam(value = "idMembre") Long idMembre){
//        List<Don> dons=iAssociation.findDonByAssociation(idMembre);
//        return dons;
//    }
    
    @GET
    @Path("/{id}/publications")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publication> getPublications(@PathParam(value = "id") Long id){
        return iAssociation.getPublications(id);
    }

    @GET
    @Path("/{idAssoc}/acceptedDons/{typeDon}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Don> getDonByAssociation(@PathParam(value = "idAssoc") Long idAssoc,@PathParam(value = "typeDon") String typeDon){
        List<Don> acceptedDons=new ArrayList<>();
        (iAssociation.findDonByAssociation(idAssoc).stream().filter(don ->
            don.getState().equals("accepted") && don.getType().equals(typeDon)
        )).forEach(acceptedDons::add);
        return acceptedDons;
    }
    
    @POST
    @Path("/{id}/addPublication")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int addPublication(@PathParam(value = "id") Long id,String data){
        return iAssociation.addPublication(id,data);
    }
    
    
    @POST
    @Path("/{idAssoc}/{idPub}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updatePublication(@PathParam(value = "idAssoc") Long idAssoc,@PathParam(value = "idPub") Long idPub, String data){
        return iAssociation.updatePublication(idAssoc, idPub,data);
    }
    
    @POST
    @Path("/{idDon}/accept")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public long AcceptDon(@PathParam(value = "idDon") long idDon){
        return iAssociation.acceptDon(idDon);
    }

    @POST
    @Path("/{idDon}/refuse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public long RefuseDon(@PathParam(value = "idDon") long idDon){
        return iAssociation.refuseDon(idDon);
    }
    
    @POST
    @Path("/{idPub}/deletePub")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int deletePublication(@PathParam(value = "idPub") Long idPub){
        return iAssociation.deletePublication(idPub);
    }



}
