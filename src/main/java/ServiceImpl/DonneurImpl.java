package ServiceImpl;

import Dao.AssociationDao;
import Dao.DonDao;
import Dao.DonneurDAO;
import Dao.PublicationDao;
import DaoImpl.AssociationDaoImpl;
import DaoImpl.DonDaoImpl;
import DaoImpl.DonneurDaoImpl;
import DaoImpl.PublicationDaoImpl;
import Entities.Don;
import Entities.Donneur;
import Service.IDonneur;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class DonneurImpl implements IDonneur {
    private final DonneurDAO donneurDAO;
    private final DonDao donDao;
    private final PublicationDao publicationDao;
    private final AssociationDao associationDao;
    

    public DonneurImpl() {
        this.donneurDAO = new DonneurDaoImpl();
        this.donDao=new DonDaoImpl();
        this.publicationDao = new PublicationDaoImpl();
        this.associationDao = new AssociationDaoImpl();
    }

    @Override
    public int addDonneur(String data) {
        Donneur donneur=new Donneur();
        Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        donneur.setNomDonneur(object.get("nom_donneur").getAsString());
        donneur.setPrenomDonneur(object.get("prenom_donneur").getAsString());
        donneur.setAddrDonneur(object.get("addr_donneur").getAsString());
        try {
            donneurDAO.createDonneur(donneur);
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public Boolean updateDonneur(String data) {
        Donneur donneur = new Donneur();
        Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        donneur.setIdDonneur(object.get("id_donneur").getAsLong());
        donneur.setNomDonneur(object.get("nomField").getAsString());
        donneur.setPrenomDonneur(object.get("prenomField").getAsString());
        donneur.setAddrDonneur(object.get("addressField").getAsString());
        donneur.setDesc_donneur(object.get("descField").getAsString());
        donneur.setVille(object.get("villeField").getAsString());
        donneur.setPays(object.get("paysField").getAsString());
        try {
            donneurDAO.updateDonneur(donneur);
            return Boolean.TRUE;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @Override
    public Donneur getDonneurById(Long id) {
        try {
            return donneurDAO.getDonneurById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }    }

    @Override
    public Long deleteDonneur(Long id) {
        try {
            donneurDAO.deleteDonneur(id);
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1L;
        }
    }

    //Don (String type, String logo, String desc, String state, Donneur donneur)
    @Override
    public int addDon(Long id, String data) {
        Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        String type=object.get("typeDon").getAsString();
        String logo=object.get("logoDon").getAsString();
        String desc=object.get("descDon").getAsString();
        String state=object.get("stateDon").getAsString();
        try {
            Donneur donneur=donneurDAO.getDonneurById(id);
            Don don=new Don(type, logo, desc, state, donneur);
            donDao.createDon(don);
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateDon(Long idDon, String data) {
    	 Gson gson = new Gson();
         com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
         String type=object.get("typeDon").getAsString();
         String logo=object.get("logoDon").getAsString();
         String date=object.get("dateDon").getAsString();
         String desc=object.get("descDon").getAsString();
         String state=object.get("stateDon").getAsString();
         int etatInfo=object.get("etatInfo").getAsInt();
         Don don=new Don(idDon,type, logo, desc, Date.valueOf(date), state, etatInfo); //the date doesn't change anyways
         donDao.updateDon(don);
         return 0;
       
    }

    @Override
    public int deleteDon(Long id) {
        donDao.deleteDon(id);
        return 1;
    }

	@Override
	public int donateToPub(Long idPub, String data) {
		 Gson gson = new Gson();
         com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
         long idDon = object.get("idDon").getAsLong();
         String type=object.get("typeDon").getAsString();
         String logo=object.get("logoDon").getAsString();
         String desc=object.get("descDon").getAsString();
         String state=object.get("stateDon").getAsString();
         int etatInfo=object.get("etatInfo").getAsInt();
         Don don=new Don(idDon,type, logo, desc, new Date(5), state, etatInfo); //the date doesn't change anyways
         don.setPublication(publicationDao.findById(idPub));
         return donDao.updateDon(don);
	}

	@Override
	public int donateToAssociation(Long idAssoc, String data) {
		Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        long idDon = object.get("idDon").getAsLong();
        String type=object.get("typeDon").getAsString();
        String logo=object.get("logoDon").getAsString();
        String desc=object.get("descDon").getAsString();
        String state=object.get("stateDon").getAsString();
        int etatInfo=object.get("etatInfo").getAsInt();
        Don don=new Don(idDon,type, logo, desc, new Date(5), state, etatInfo); //the date doesn't change anyways
        try {
        	don.setAssociation(associationDao.getAssociationById(idAssoc));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return donDao.updateDon(don);
	}

    @Override
    public int donateToPublication(Long idPub, String data) {
        Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        Long idDonneur=object.get("idDonneur").getAsLong();
        String type=object.get("type").getAsString();
        String desc=object.get("desc").getAsString();
        try {
            Don don=new Don (type,desc,donDao.idAssociationFromIdPub(idPub),idPub,donneurDAO.getDonneurById(idDonneur));
            donDao.addDon(don);
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
	public List<Don> getDons(Long id) {
		Donneur donneur= null;
		try {
			donneur = donneurDAO.getDonneurById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return donDao.findByDonneur(donneur);
	}
}
