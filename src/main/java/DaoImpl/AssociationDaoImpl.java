package DaoImpl;

import Dao.AssociationDao;
import Entities.Association;
import Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AssociationDaoImpl implements AssociationDao {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String req;


    private void init() throws SQLException 
    {
        connection = DBConnection.getInstance();
        statement = connection.createStatement();
    }


    @Override
    public int createAssociation(Association association) {
        try {
            init();
            req="insert into association (nomAssoc,codeAssoc,descAssoc,addrAssoc) values(?,?,?,?);";
            preparedStatement=connection.prepareStatement(req);
            preparedStatement.setString(1, association.getNomAssoc());
            preparedStatement.setString(2, association.getCodeAssoc());
            preparedStatement.setString(3, association.getDescAssoc());
            preparedStatement.setString(4, association.getAddrAssoc());
            preparedStatement.execute();
            preparedStatement.close();
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean updateAssociation(Long id,Association association)  {
        try {
            init();
            req="update association set nomAssoc=?, descAssoc=?, addrAssoc=? where idAssoc=? ";
            preparedStatement=connection.prepareStatement(req);
            preparedStatement.setString(1, association.getNomAssoc());
            preparedStatement.setString(2, association.getDescAssoc());
            preparedStatement.setString(3, association.getAddrAssoc());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAssociation(Long id)  {
        try {
            init();
            req="update association set etatInfo=0 where idAssoc="+id;
            statement.executeUpdate(req);
            statement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public Association getAssociationById(Long id)  {
        Association association=new Association();
        association.setIdAssoc(id);
        try {
            init();
            req="select * from association  where idAssoc="+id+";";
            ResultSet result = statement.executeQuery(req);
            result.next();
            association.setNomAssoc(result.getObject("nomAssoc").toString());
            association.setCodeAssoc(result.getObject("codeAssoc").toString());
            association.setDescAssoc(result.getObject("descAssoc").toString());
            association.setLogoAssoc(result.getObject("logoAssoc").toString());
            association.setAddrAssoc(result.getObject("addrAssoc").toString());
            association.setEtatInfo(result.getInt("etatInfo"));
            result.close();
            statement.close();
            return association;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Association> getAll() throws SQLException {
        List<Association> associations=new ArrayList<>();
        init();
        req="select idAssoc from association where etatInfo=1";
        ResultSet result=statement.executeQuery(req);
        while (result.next()){
            associations.add(getAssociationById(result.getLong("idAssoc")));
        }
        return associations;
    }
}
