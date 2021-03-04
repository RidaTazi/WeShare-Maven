package ServiceImpl;

import Dao.AssociationDao;
import Dao.DonDao;
import Dao.MembreDao;
import Dao.PublicationDao;
import DaoImpl.AssociationDaoImpl;
import DaoImpl.DonDaoImpl;
import DaoImpl.MembreDaoImpl;
import DaoImpl.PublicationDaoImpl;
import Entities.Association;
import Entities.Don;
import Entities.Publication;
import Service.IAssociation;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class AssociationImpl implements IAssociation {
    private final AssociationDao associationDao;
    private final PublicationDao publicationDao;
    private final DonDao donDao;
    private final MembreDao membreDao;

    public AssociationImpl() {
        this.associationDao = new AssociationDaoImpl();
        this.publicationDao = new PublicationDaoImpl();
        this.donDao = new DonDaoImpl();
        this.membreDao=new MembreDaoImpl();
        }

    @Override
    public List<String> getAssociationsName() {
        List<String> list=new ArrayList<>();
        try {
            associationDao.getAll().forEach(association -> list.add(association.getNomAssoc()));
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Long deleteAssociation(Long id) {
        try {
            associationDao.deleteAssociation(id);
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1L;
        }
    }

    @Override
    public int addAssociation(String data) {
        Association association=new Association();
        Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        association.setNomAssoc(object.get("nomAssoc").getAsString());
        association.setCodeAssoc(object.get("codeAssoc").getAsString());
        association.setDescAssoc(object.get("descAssoc").getAsString());
        association.setAddrAssoc(object.get("addrAssoc").getAsString());
        try {
            associationDao.createAssociation(association);
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public Long updateAssociation(String data) {
        Association association=new Association();
        Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        Long id =object.get("idAssoc").getAsLong();
        association.setNomAssoc(object.get("nomAssoc").getAsString());
        association.setDescAssoc(object.get("descAssoc").getAsString());
        association.setAddrAssoc(object.get("addrAssoc").getAsString());
        try {
            associationDao.updateAssociation(id, association);
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1L;
        }
    }

    @Override
    public Association getAssociationById(Long id) {
        try {
            return associationDao.getAssociationById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    
    @Override
    public List<Publication> getPublications(Long id) {
    	try {
    	return publicationDao.findByAssociation(associationDao.getAssociationById(membreDao.getAssociationId(id)));
    	} catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

	@Override
	public int addPublication(Long idAssoc,String data) {
		Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        String titre = object.get("titrePub").getAsString();
        String desc = object.get("descPub").getAsString();
        String type = object.get("typePub").getAsString();
        
        try {
        	Publication pub = new Publication(titre,desc, type, associationDao.getAssociationById(idAssoc));
           return publicationDao.createPub(pub);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
	}

	@Override
	public int updatePublication(Long idAssoc, Long idPub, String data) {
		Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        String titre = object.get("titrePub").getAsString();
        String desc = object.get("descPub").getAsString();
        String type = object.get("typePub").getAsString();
        int etatInfo = object.get("etatInfo").getAsInt();
        try {
        	Publication pub = new Publication(titre,desc, type, associationDao.getAssociationById(idAssoc));
        	pub.setEtatInfo(etatInfo);
        	pub.setId(idPub);
           return publicationDao.updatePub(pub);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
	}

	@Override
	public int deletePublication(Long id) {
		 return publicationDao.deletePub(id);
	}

	@Override
	public int acceptRefuseDon(String data) {
		Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        Long id = object.get("idDon").getAsLong();
        String type=object.get("typeDon").getAsString();
        String logo=object.get("logoDon").getAsString();
        String desc=object.get("descDon").getAsString();
        String state=object.get("stateDon").getAsString();
        int etatInfo=object.get("etatInfo").getAsInt();
        Don don=new Don(id,type, logo, desc, new Date(5), state, etatInfo); //the date doesn't change anyways
        donDao.updateDon(don);
        return 0;
	}

	@Override
	public List<Publication> getAllPublications() {
		return publicationDao.findAll();
	}

	@Override
	public List<Don> getDonsByPublication(Long pubId) {
		return donDao.findByPublication(publicationDao.findById(pubId.longValue()));
	}
	
	
}
