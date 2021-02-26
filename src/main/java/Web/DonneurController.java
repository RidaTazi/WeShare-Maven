package Web;

import Entities.Donneur;
import Entities.MembreAssociation;
import Service.IDonneur;
import Service.IMembre;
import ServiceImpl.DonneurImpl;
import ServiceImpl.MembreImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/donneur")
public class DonneurController {
    private IDonneur iDonneur;
    public DonneurController() {
        this.iDonneur = new DonneurImpl();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Donneur getById(@PathParam(value = "id") Long id){
        return iDonneur.getDonneurById(id);
    }


    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long updateDonneur(String data){
        return iDonneur.updateDonneur(data);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int addDonneur(String data){
        return iDonneur.addDonneur(data);
    }

    @POST
    @Path("/{id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Long deleteDonneur(@PathParam(value = "id") Long id){
        return iDonneur.deleteDonneur(id);
    }

    @POST
    @Path("/{id}/addDon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int addDon(@PathParam(value = "id") Long id,String data){
        return iDonneur.addDon(id, data);
    }


    @POST
    @Path("/{idDon}/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int updateDon(@PathParam(value = "idDon") Long idDon, String data){
        return iDonneur.updateDon(idDon, data);
    }


    @POST
    @Path("/{idDon}/deleteDon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int deleteDon(@PathParam(value = "idDon") Long idDon){
        return iDonneur.deleteDon(idDon);
    }
    
    @POST
    @Path("/{idPub}/donateToPublication")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int donateToPublication(@PathParam(value = "idPub") Long idPub, String data){
        return iDonneur.donateToPub(idPub, data);
    }
    
    @POST
    @Path("/{idPub}/donateToAssociation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int donateToAssociation(@PathParam(value = "idAssociation") Long idAssoc, String data){
        return iDonneur.donateToAssociation(idAssoc, data);
    }
}
