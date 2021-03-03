package DaoImpl;

import Dao.DonneurDAO;
import Entities.Donneur;
import Connection.DBConnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonneurDaoImpl implements DonneurDAO {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String req;


    private void init() throws SQLException {
        connection= DBConnection.getInstance();
        statement=connection.createStatement();
    }

    @Override
    public int createDonneur(Donneur donneur)  {
        try {
            init();
            req="insert into donneur (idDonneur,nom_donneur,prenom_donneur,addr_donneur) values(?,?,?,?);";
            preparedStatement=connection.prepareStatement(req);
            preparedStatement.setLong(1, donneur.getIdDonneur());
            preparedStatement.setString(2, donneur.getNomDonneur());
            preparedStatement.setString(3, donneur.getPrenomDonneur());
            preparedStatement.setString(4, donneur.getAddrDonneur());
            preparedStatement.execute();
            preparedStatement.close();
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean updateDonneur(Long id, Donneur donneur)  {
        try {
            init();
            //idDonneur from user table?
            //
            //
            req="update donneur set nom_donneur=?, prenom_donneur=?, addr_donneur=? where idDonneur=? ";
            preparedStatement=connection.prepareStatement(req);
            preparedStatement.setString(1, donneur.getNomDonneur());
            preparedStatement.setString(2, donneur.getPrenomDonneur());
            preparedStatement.setString(3, donneur.getAddrDonneur());
            preparedStatement.setLong(4, id);
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDonneur(Long id){
        try {
            init();
            req="update donneur set etatInfo=0 where idDonneur="+id;
            statement.executeUpdate(req);
            statement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public Donneur getDonneurById(Long id) {
        Donneur donneur = new Donneur();
        donneur.setIdDonneur(id);
        try {
            init();
            req="select * from donneur INNER JOIN User ON User.id_user=donneur.idDonneur where idDonneur = " + id + ";";
            ResultSet result = statement.executeQuery(req);
            result.next();
            donneur.setNomDonneur(result.getObject("nom_donneur").toString());
            donneur.setPrenomDonneur(result.getObject("prenom_donneur").toString());
            donneur.setAddrDonneur(result.getObject("addr_donneur").toString());
            donneur.setUsername(result.getObject("username_user").toString());
            donneur.setPays((String)result.getObject("pays_donneur"));
            donneur.setVille((String)result.getObject("ville_donneur"));
            donneur.setDesc_donneur((String) result.getObject("desc_donneur"));
            donneur.setEmail((String) result.getObject("email_user"));
            result.close();
            statement.close();
            return donneur;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    // Wach 7ta ana ndir EtatInfo ??? <YES>
    @Override
    public List<Donneur> getAllDonneur() throws SQLException {
        List<Donneur> donneurs = new ArrayList<>();
        init();
        req="select idDonneur from donneur where etatInfo=1";
        ResultSet result=statement.executeQuery(req);
        while (result.next()){
            donneurs.add(getDonneurById(result.getLong("idDonneur")));
        }
        return donneurs;
    }
}
