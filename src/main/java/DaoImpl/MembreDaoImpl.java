package DaoImpl;

import Dao.MembreDao;
import Entities.Association;
import Entities.MembreAssociation;

import java.sql.*;

import Connection.DBConnection;


public class MembreDaoImpl implements MembreDao {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String req;


    private void init() throws SQLException {
        connection= DBConnection.getInstance();
        statement=connection.createStatement();
    }



    @Override
    public boolean createMembreAssoc(MembreAssociation membre){
        try {
            connection= DBConnection.getInstance();
            req="insert into membreAssociation (nomMembre,prenomMember,posteMembre,idAssoc) values(?,?,?,?);";
            preparedStatement=connection.prepareStatement(req);
            preparedStatement.setString(1, membre.getNomMembre());
            preparedStatement.setString(2, membre.getPrenomMembre());
            preparedStatement.setString(3, membre.getPosteMembre());
            preparedStatement.setLong(4, membre.getIdAssoc());
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return false;
        }
    }

    @Override
    public Long updateMembreAssoc(MembreAssociation membre) {
        try {
            connection= DBConnection.getInstance();
            req="update membreAssociation set nomMembre=?, prenomMember=?, posteMembre=?, idAssoc=? where idMembre=? ";
            preparedStatement=connection.prepareStatement(req);
            preparedStatement.setString(1,membre.getNomMembre() );
            preparedStatement.setString(2, membre.getPrenomMembre());
            preparedStatement.setString(3, membre.getPosteMembre());
            preparedStatement.setLong(4,membre.getIdAssoc());
            preparedStatement.setLong(5,membre.getIdMembre());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return membre.getIdMembre();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1L;
        }
    }

    @Override
    public MembreAssociation getMembreById(Long id){
        MembreAssociation membreAssociation=new MembreAssociation();
        membreAssociation.setIdMembre(id);
        try {
            init();
            req="select * from membreAssociation  where idMembre="+id+";";
            ResultSet result = statement.executeQuery(req);
            result.next();
            membreAssociation.setNomMembre(result.getObject("nomMembre").toString());
            membreAssociation.setPrenomMembre(result.getObject("prenomMember").toString());
            membreAssociation.setPosteMembre(result.getObject("posteMembre").toString());
            membreAssociation.setIdAssoc(result.getLong("idAssoc"));
            result.close();
            statement.close();
            return membreAssociation;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}