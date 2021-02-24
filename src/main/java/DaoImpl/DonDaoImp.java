package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Dao.DonDao;
import Entities.Association;
import Entities.Don;
import Entities.Donneur;
import Entities.Publication;


public class DonDaoImp implements DonDao{
	Connection connection;
	PreparedStatement prepstatement;
	ResultSet res;
	
	
	public DonDaoImp() {
		
		this.connection = DBConnection.getInstance();
	}

	@Override
	public void createDon(Don d){
		try {
			if(d.getAssociation() != null)
			{
				prepstatement = connection.prepareStatement("INSERT INTO Don (idDon,typeDon,logoDon,descDon,dateDon,stateDon,etatInfo,associationId,publicationId,donneurId) VALUES (?,?,?,?,?,?,?,?,?,?)");
				prepstatement.setInt(8, d.getAssociation().getIdAssoc().intValue());
				prepstatement.setInt(9, Types.NULL);
			}
			else {
				if(d.getPublication() != null)
				{
					prepstatement = connection.prepareStatement("INSERT INTO Don (idDon,typeDon,logoDon,descDon,dateDon,stateDon,etatInfo,associationId,publicationId,donneurId) VALUES (?,?,?,?,?,?,?,?,?,?)");
					prepstatement.setInt(8, Types.NULL);
					prepstatement.setInt(9, (int)d.getPublication().getId());
				}
				else {
					prepstatement = connection.prepareStatement("INSERT INTO Don (idDon,typeDon,logoDon,descDon,dateDon,stateDon,etatInfo,associationId,publicationId,donneurId) VALUES (?,?,?,?,?,?,?,?,?,?)");
					prepstatement.setInt(8, Types.NULL);
					prepstatement.setInt(9, Types.NULL);
				}		
			}
			prepstatement.setInt(1, (int)(d.getiD()));
			prepstatement.setString(2, d.getType());
			prepstatement.setString(3, d.getLogo());
			prepstatement.setString(4, d.getDesc());
			prepstatement.setDate(5, d.getDate());
			prepstatement.setString(6, d.getState());
			prepstatement.setInt(7, d.getEtatInfo());
			prepstatement.setInt(10, d.getDonneur().getIdDonneur().intValue());
			int status = prepstatement.executeUpdate();
			if(status == 0)
			{
				System.out.println("erreur creation don !!!!");
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
	public void updateDon(Don d) {
		
		try {
			if(d.getAssociation() != null)
			{
				prepstatement = connection.prepareStatement("UPDATE Don SET typeDon = ?, logoDon = ?, descDon = ?, dateDon = ?, stateDon = ?, etatInfo = ?, associationId = ?, publicationId = ? WHERE idDon = ?");
				prepstatement.setInt(7, d.getAssociation().getIdAssoc().intValue());
				prepstatement.setInt(8, Types.NULL);
			}
			else {
				if(d.getPublication() != null)
				{
					prepstatement = connection.prepareStatement("UPDATE Don SET typeDon = ?, logoDon = ?, descDon = ?, dateDon = ?, stateDon = ?, etatInfo = ?, associationId = ?, publicationId = ? WHERE idDon = ?");
					prepstatement.setInt(7, Types.NULL);
					prepstatement.setInt(8, (int)d.getPublication().getId());
				}
				else {
					prepstatement = connection.prepareStatement("UPDATE Don SET typeDon = ?, logoDon = ?, descDon = ?, dateDon = ?, stateDon = ?, etatInfo = ?, associationId = ?, publicationId = ? WHERE idDon = ?");
					prepstatement.setInt(7, Types.NULL);
					prepstatement.setInt(8, Types.NULL);
				}		
			}
			
			prepstatement = connection.prepareStatement("UPDATE Don SET typeDon = ?, logoDon = ?, descDon = ?, dateDon = ?, stateDon = ?, etatInfo = ?, associationId = ?, publicationId = ? WHERE idDon = ?" );
			
			prepstatement.setString(1, d.getType());
			prepstatement.setString(2, d.getLogo());
			prepstatement.setString(3, d.getDesc());
			prepstatement.setDate(4, d.getDate());
			prepstatement.setString(5, d.getState());
			prepstatement.setInt(6, d.getEtatInfo());
			prepstatement.setInt(9, (int)(d.getiD()));
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
	public void deleteDon(long id) {
		
		try {
			prepstatement = connection.prepareStatement("DELETE FROM Don WHERE idDon = ? ");
			prepstatement.setInt(1,(int)id);
			int status = prepstatement.executeUpdate();
			if(status == 0)
			{
				System.out.println("erreur suppression don !!!!");
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
	public Don findById(long id) {
		Don returnedDon = null;
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don WHERE idDon = ? ");
			prepstatement.setInt(1,(int)id);
			res = prepstatement.executeQuery();
			res.next();
			returnedDon = new Don((long)res.getInt(1),
									  res.getString(2),
									  res.getString(3),
									  res.getString(4),
									  res.getDate(5),
									  res.getString(6),
									  res.getInt(7)
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
		return returnedDon;
	}

	@Override
	public List<Don> findAll() {
		List<Don> returnedList = new ArrayList<Don>();
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don");
			res = prepstatement.executeQuery();
			while(res.next()) {
				Don returnedDon = new Don((long)res.getInt(1),
										  res.getString(2),
										  res.getString(3),
										  res.getString(4),
										  res.getDate(5),
										  res.getString(6),
										  res.getInt(7)
										  );
				returnedList.add(returnedDon);
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
	public List<Don> findByDonneur(Donneur donneur) {
		List<Don> returnedList = new ArrayList<Don>();
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don WHERE donneurId = ?");
			prepstatement.setInt(1,donneur.getIdDonneur().intValue());
			res = prepstatement.executeQuery();
			while(res.next()) {
				Don returnedDon = new Don((long)res.getInt(1),
										  res.getString(2),
										  res.getString(3),
										  res.getString(4),
										  res.getDate(5),
										  res.getString(6),
										  res.getInt(7)
										  );
				returnedList.add(returnedDon);
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
	public List<Don> findByPublication(Publication pub) {
		List<Don> returnedList = new ArrayList<Don>();
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don WHERE publicationId = ?");
			prepstatement.setInt(1,(int)pub.getId());
			res = prepstatement.executeQuery();
			while(res.next()) {
				Don returnedDon = new Don((long)res.getInt(1),
										  res.getString(2),
										  res.getString(3),
										  res.getString(4),
										  res.getDate(5),
										  res.getString(6),
										  res.getInt(7)
										  );
				returnedList.add(returnedDon);
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
	public List<Don> findByAssociation(Association assoc) {
		List<Don> returnedList = new ArrayList<Don>();
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don WHERE associationId = ?");
			prepstatement.setInt(1,assoc.getIdAssoc().intValue());
			res = prepstatement.executeQuery();
			while(res.next()) {
				Don returnedDon = new Don((long)res.getInt(1),
										  res.getString(2),
										  res.getString(3),
										  res.getString(4),
										  res.getDate(5),
										  res.getString(6),
										  res.getInt(7)
										  );
				returnedList.add(returnedDon);
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
