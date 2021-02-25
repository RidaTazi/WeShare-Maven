package ServiceImpl;

import Dao.DonneurDAO;
import Dao.MembreDao;
import DaoImpl.DonneurDaoImpl;
import DaoImpl.MembreDaoImpl;
import Entities.Donneur;
import Entities.MembreAssociation;
import Service.IDonneur;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.sql.SQLException;

public class DonneurImpl implements IDonneur {
    private DonneurDAO donneurDAO;

    public DonneurImpl() {
        this.donneurDAO = new DonneurDaoImpl();
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
    public Long updateDonneur(String data) {
        Donneur donneur=new Donneur();
        Gson gson = new Gson();
        com.google.gson.JsonObject object = gson.fromJson(data, JsonObject.class);
        Long id =object.get("idDonneur").getAsLong();
        donneur.setNomDonneur(object.get("nom_donneur").getAsString());
        donneur.setPrenomDonneur(object.get("prenom_donneur").getAsString());
        donneur.setAddrDonneur(object.get("addr_donneur").getAsString());
        try {
            donneurDAO.updateDonneur(id,donneur);
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1L;
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
}
