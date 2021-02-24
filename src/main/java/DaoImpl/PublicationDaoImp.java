package DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Connection.DBConnection;
import DAO.PublicationDao;
import Entities.Association;
import Entities.Don;
import Entities.Publication;

public class PublicationDaoImp implements PublicationDao{
	Connection connection;
	PreparedStatement prepstatement;
	ResultSet res;
	
	
	public PublicationDaoImp(){
		this.connection = DBConnection.getInstance();
	}

	@Override
	public void createPub(Publication p) {
		try {
			prepstatement = connection.prepareStatement("INSERT INTO Publication (idPub,titrePub,descPub,datePub,typePub,etatInfoPub) VALUES (?,?,?,?,?,?)");
			prepstatement.setInt(1, (int)p.getId());
			prepstatement.setString(2, p.getTitre());
			prepstatement.setString(3, p.getDesc());
			prepstatement.setDate(4, p.getDate());
			prepstatement.setString(5, p.getType());
			prepstatement.setInt(6, p.getEtatInfo());
			int status = prepstatement.executeUpdate();
			if(status == 0)
			{
				System.out.println("erreur creation publication !!!!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				prepstatement.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void updatePub(Publication p) {
		
	}

	@Override
	public void deletePub(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Publication findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publication> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Association> findByAssociation(Association assoc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
