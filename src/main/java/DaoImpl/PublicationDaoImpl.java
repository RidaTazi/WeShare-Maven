package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.PublicationDao;
import Entities.Association;
import Entities.Don;
import Entities.Publication;

public class PublicationDaoImpl implements PublicationDao{
	Connection connection;
	PreparedStatement prepstatement;
	ResultSet res;
	
	
	public PublicationDaoImpl(){
		this.connection = DBConnection.getInstance();
	}

	@Override
	public void createPub(Publication p) {             // make sure you associate pub to its association
		try {
			prepstatement = connection.prepareStatement("INSERT INTO Publication VALUES (?,?,?,?,?,?,?)");
			prepstatement.setInt(1, (int)p.getId());
			prepstatement.setString(2, p.getTitre());
			prepstatement.setString(3, p.getDesc());
			prepstatement.setDate(4, p.getDate());
			prepstatement.setString(5, p.getType());
			prepstatement.setInt(6, p.getEtatInfo());
			prepstatement.setInt(7, p.getAssociation().getIdAssoc().intValue());
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
		try {
			
			prepstatement = connection.prepareStatement("UPDATE Publication SET titrePub = ?, descPub = ?, datePub = ?, typePub = ?, etatInfoPub = ?, associationId = ? WHERE idPub = ?" );
			
			prepstatement.setString(1, p.getTitre());
			prepstatement.setString(2, p.getDesc());
			prepstatement.setDate(3, p.getDate());
			prepstatement.setString(4, p.getType());
			prepstatement.setInt(5, p.getEtatInfo());
			prepstatement.setInt(6, p.getAssociation().getIdAssoc().intValue());
			prepstatement.setInt(7, (int)p.getId());
			int status = prepstatement.executeUpdate();
			if(status == 0)
			{
				System.out.println("erreur creation don !!!!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				prepstatement.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deletePub(long id) {
		try {
			prepstatement = connection.prepareStatement("DELETE FROM Publication WHERE idPub = ? ");
			prepstatement.setInt(1,(int)id);
			int status = prepstatement.executeUpdate();
			if(status == 0)
			{
				System.out.println("erreur suppression publication !!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				prepstatement.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Publication findById(long id) {
		Publication returnedPub = null;
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Publication WHERE idPub = ? ");
			prepstatement.setInt(1,(int)id);
			res = prepstatement.executeQuery();
			res.next();
			returnedPub = new Publication((long)res.getInt(1),
									  res.getString(2),
									  res.getString(3),
									  res.getDate(4),
									  res.getString(5),
									  res.getInt(6)
									  );
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				prepstatement.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return returnedPub;
	}

	@Override
	public List<Publication> findAll() {
		List<Publication> returnedList = new ArrayList<Publication>();
		Publication returnedPub = null;
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Publication");
			res = prepstatement.executeQuery();
			while(res.next()) {
				returnedPub = new Publication((long)res.getInt(1),
						  res.getString(2),
						  res.getString(3),
						  res.getDate(4),
						  res.getString(5),
						  res.getInt(6)
						  );
				returnedList.add(returnedPub);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				prepstatement.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return returnedList;
	}

	@Override
	public List<Publication> findByAssociation(Association assoc) {
		List<Publication> returnedList = new ArrayList<Publication>();
		Publication returnedPub = null;
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Publication WHERE associationId = ?");
			prepstatement.setInt(1, assoc.getIdAssoc().intValue());
			res = prepstatement.executeQuery();
			while(res.next()) {
				returnedPub = new Publication((long)res.getInt(1),
						  res.getString(2),
						  res.getString(3),
						  res.getDate(4),
						  res.getString(5),
						  res.getInt(6)
						  );
				returnedList.add(returnedPub);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				prepstatement.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return returnedList;
	}
	

}
