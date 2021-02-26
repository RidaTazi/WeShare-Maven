package ServiceImpl;

import Dao.DonDao;
import Dao.DonneurDAO;
import Dao.MembreDao;
import DaoImpl.DonDaoImpl;
import DaoImpl.DonneurDaoImpl;
import DaoImpl.MembreDaoImpl;
import Entities.Don;
import Entities.Donneur;
import Entities.MembreAssociation;
import Entities.Publication;
import Service.IDonneur;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.sql.SQLException;

public class DonneurImpl implements IDonneur {
    private DonneurDAO donneurDAO;
    private DonDao donDao;

    public DonneurImpl() {
        this.donneurDAO = new DonneurDaoImpl();
        this.donDao=new DonDaoImpl();
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
            Donneur donneur=donneurDAO.getDonneurById(object.get("donneurId").getAsLong());
            Don don=new Don(type, logo, desc, state, donneur);
            donDao.createDon(don);
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateDon(Long idAssoc, Long idDon, String data) {
        return 0;
        //Zakaria qad m3ak hadi xD
    }

    @Override
    public int deleteDon(Long id) {
        donDao.deleteDon(id);
        return 1;
    }
}
