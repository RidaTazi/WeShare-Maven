package ServiceImpl;

import Dao.MembreDao;
import DaoImpl.MembreDaoImpl;
import Entities.MembreAssociation;
import Service.IMembre;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.sql.SQLException;

public class MembreImpl implements IMembre {
    private final MembreDao membreDao;

    public MembreImpl() {
        this.membreDao = new MembreDaoImpl();
    }

    @Override
    public int addMembre(String data) {
        MembreAssociation membreAssociation=new MembreAssociation();
        Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        membreAssociation.setNomMembre(object.get("nomMembre").getAsString());
        membreAssociation.setPrenomMembre(object.get("prenomMembre").getAsString());
        membreAssociation.setPosteMembre(object.get("posteMembre").getAsString());
        membreAssociation.setIdAssoc(object.get("idAssoc").getAsLong());
        try {
            membreDao.createMembreAssoc(membreAssociation);
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public Long updateMembre(String data) {
        MembreAssociation membreAssociation=new MembreAssociation();
        Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        Long id =object.get("idMembre").getAsLong();
        membreAssociation.setNomMembre(object.get("nomMembre").getAsString());
        membreAssociation.setPrenomMembre(object.get("prenomMembre").getAsString());
        membreAssociation.setPosteMembre(object.get("posteMembre").getAsString());
        membreAssociation.setIdAssoc(object.get("idAssoc").getAsLong());
        membreAssociation.setIdMembre(id);
        try {
            membreDao.updateMembreAssoc(membreAssociation);
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1L;
        }
    }

    @Override
    public MembreAssociation getMembreById(Long id) {
        try {
            return membreDao.getMembreById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public Long deleteMembre(Long id) {
        try {
            membreDao.deleteMembre(id);
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1L;
        }
    }
}
