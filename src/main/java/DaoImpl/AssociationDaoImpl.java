package DaoImpl;

import Dao.AssociationDao;
import Entities.Association;
import Connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AssociationDaoImpl implements AssociationDao {
    private Connection connection;
    private Statement statement;
    private String req;


    private void init() throws SQLException {
        connection= DBConnection.getInstance();
        statement=connection.createStatement();
    }


    @Override
    public boolean createAssociation(Association association) {
        try {
            init();
            req="insert into association values("+association.getNomAssoc()+","+association.getCodeAssoc()+","+association.getDescAssoc()+","+association.getAddrAssoc()+");";
            statement.executeQuery(req);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAssociation(Long id,Association association)  {
        try {
            init();
            req="update association " +
                    "set nomAssoc="+association.getNomAssoc() +
                    ", descAssoc="+association.getDescAssoc()+
                    ", addrAssoc="+association.getAddrAssoc()+"" +
                    "where idAssoc="+id;
            statement.executeQuery(req);
            statement.close();
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
            statement.executeQuery(req);
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
            req="select * from association  where idAssoc="+id;
            ResultSet result = statement.executeQuery(req);
            System.out.println("i made it to here 1");
            System.out.println(result.getObject(1));
            System.out.println("i made it to here 2");
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
        req="select idAssoc from association";
        ResultSet result=statement.executeQuery(req);
        while (result.next()){
            associations.add(getAssociationById(result.getLong("idAssoc")));
        }
        return associations;
    }
}
