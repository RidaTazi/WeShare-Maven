package ServiceImpl;

import Dao.AssociationDao;
import Dao.PublicationDao;
import DaoImpl.AssociationDaoImpl;
import DaoImpl.PublicationDaoImpl;
import Entities.Association;
import Entities.Publication;
import Service.IAssociation;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.codehaus.jettison.json.JSONObject;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class AssociationImpl implements IAssociation {
    private AssociationDao associationDao;
    private PublicationDao publicationDao;

    public AssociationImpl() {
        this.associationDao = new AssociationDaoImpl();
        this.publicationDao = new PublicationDaoImpl();
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
    	return publicationDao.findByAssociation(associationDao.getAssociationById(id));
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


}
