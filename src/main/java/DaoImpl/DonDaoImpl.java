package DaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Dao.DonDao;
import Entities.*;


public class DonDaoImpl implements DonDao{
	private final Connection connection;
	private PreparedStatement prepstatement;
	private ResultSet res;
	private String req;



	
	
	public DonDaoImpl() {
		
		this.connection = DBConnection.getInstance();
	}

	@Override
	public int createDon(Don d){
		int status = 0;
		try {
			if(d.getAssociation() != null)
			{
				prepstatement = connection.prepareStatement("INSERT INTO Don (typeDon,logoDon,descDon,dateDon,stateDon,etatInfo,associationId,publicationId,donneurId) VALUES (?,?,?,?,?,?,?,?,?)");
				prepstatement.setInt(7, d.getAssociation().getIdAssoc().intValue());
				prepstatement.setNull(8, Types.NULL);
			}
			else {
				if(d.getPublication() != null)
				{
					prepstatement = connection.prepareStatement("INSERT INTO Don (typeDon,logoDon,descDon,dateDon,stateDon,etatInfo,associationId,publicationId,donneurId) VALUES (?,?,?,?,?,?,?,?,?)");
					prepstatement.setNull(7, Types.NULL);
					prepstatement.setInt(8, (int)d.getPublication().getId());
				}
				else {
					prepstatement = connection.prepareStatement("INSERT INTO Don (typeDon,logoDon,descDon,dateDon,stateDon,etatInfo,associationId,publicationId,donneurId) VALUES (?,?,?,?,?,?,?,?,?)");
					prepstatement.setNull(7, Types.NULL);
					prepstatement.setNull(8, Types.NULL);
				}		
			}
			prepstatement.setString(1, d.getType());
			prepstatement.setString(2, d.getLogo());
			prepstatement.setString(3, d.getDesc());
			prepstatement.setDate(4, d.getDate());
			prepstatement.setString(5, d.getState());
			prepstatement.setInt(6, d.getEtatInfo());
			prepstatement.setInt(9, d.getDonneur().getIdDonneur().intValue());
			status = prepstatement.executeUpdate();
			prepstatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateDon(Don d) {
		int status = 0;
		try {
			if(d.getAssociation() != null)
			{
				prepstatement = connection.prepareStatement("UPDATE Don SET typeDon = ?, logoDon = ?, descDon = ?, stateDon = ?, etatInfo = ?, associationId = ?, publicationId = ? WHERE idDon = ?");
				prepstatement.setInt(6, d.getAssociation().getIdAssoc().intValue());
				prepstatement.setNull(7, Types.NULL);
			}
			else {
				if(d.getPublication() != null)
				{
					prepstatement = connection.prepareStatement("UPDATE Don SET typeDon = ?, logoDon = ?, descDon = ?, stateDon = ?, etatInfo = ?, associationId = ?, publicationId = ? WHERE idDon = ?");
					prepstatement.setNull(6, Types.NULL);
					prepstatement.setInt(7, (int)d.getPublication().getId());
				}
				else {
					prepstatement = connection.prepareStatement("UPDATE Don SET typeDon = ?, logoDon = ?, descDon = ?, stateDon = ?, etatInfo = ?, associationId = ?, publicationId = ? WHERE idDon = ?");
					prepstatement.setNull(6, Types.NULL);
					prepstatement.setNull(7, Types.NULL);
				}		
			}
			
			prepstatement.setString(1, d.getType());
			prepstatement.setString(2, d.getLogo());
			prepstatement.setString(3, d.getDesc());
			prepstatement.setString(4, d.getState());
			prepstatement.setInt(5, d.getEtatInfo());
			prepstatement.setInt(8, (int)(d.getiD()));
			status = prepstatement.executeUpdate();
			prepstatement.close();
			if(status == 0)
			{
				System.out.println("erreur creation don !!!!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteDon(long id) {
		int status = 0;
		try {
			prepstatement = connection.prepareStatement("DELETE FROM Don WHERE idDon = ? ");
			prepstatement.setInt(1,(int)id);
			status = prepstatement.executeUpdate();
			prepstatement.close();
			if(status == 0)
			{
				System.out.println("erreur suppression don !!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Don findById(long id) {
		Don returnedDon = null;
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don WHERE idDon = ? ");
			prepstatement.setInt(1,(int)id);
			res = prepstatement.executeQuery();
			res.next();
			returnedDon = new Don(res.getInt(1),
									  res.getString(2),
									  res.getString(3),
									  res.getString(4),
									  res.getDate(5),
									  res.getString(6),
									  res.getInt(7)
									  );
			prepstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnedDon;
	}

	@Override
	public List<Don> findAll() {
		List<Don> returnedList = new ArrayList<>();
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don");
			res = prepstatement.executeQuery();
			while(res.next()) {
				Don returnedDon = new Don(res.getInt(1),
										  res.getString(2),
										  res.getString(3),
										  res.getString(4),
										  res.getDate(5),
										  res.getString(6),
										  res.getInt(7)
										  );
				returnedList.add(returnedDon);
			}
			prepstatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return returnedList;
	}

	@Override
	public long acceptDon(long id) {
		try {
			req="update Don set stateDon=? where idDon=? ";
			prepstatement=connection.prepareStatement(req);
			prepstatement.setString(1, "accepted");
			prepstatement.setLong(2, id);
			prepstatement.execute();
			prepstatement.close();
			return id;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return -1L;
		}
	}

	@Override
	public long refuseDon(long id) {
		try {
			req="update Don set stateDon=? where idDon=? ";
			prepstatement=connection.prepareStatement(req);
			prepstatement.setString(1, "refused");
			prepstatement.setLong(2, id);
			prepstatement.execute();
			prepstatement.close();
			return id;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return -1L;
		}
	}

	@Override
	public List<Don> findByDonneur(Donneur donneur) {
		List<Don> returnedList = new ArrayList<>();
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don WHERE donneurId = ?");
			prepstatement.setInt(1,donneur.getIdDonneur().intValue());
			res = prepstatement.executeQuery();
			while(res.next()) {
				Don returnedDon = new Don(res.getInt(1),
										  res.getString(2),
										  res.getString(3),
										  res.getString(4),
										  res.getDate(5),
										  res.getString(6),
										  res.getInt(7)
										  );
				returnedList.add(returnedDon);
			}
			prepstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return returnedList;
	}

	@Override
	public List<Don> findByPublication(Publication pub) {
		List<Don> returnedList = new ArrayList<>();
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don WHERE publicationId = ?");
			prepstatement.setInt(1,(int)pub.getId());
			res = prepstatement.executeQuery();
			while(res.next()) {
				Don returnedDon = new Don(res.getInt(1),
										  res.getString(2),
										  res.getString(3),
										  res.getString(4),
										  res.getDate(5),
										  res.getString(6),
										  res.getInt(7)
										  );
				returnedList.add(returnedDon);
			}
			prepstatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnedList;
	}

	@Override
	public List<Don> findByAssociation(MembreAssociation membreAssociation) {
		List<Don> returnedList = new ArrayList<>();
		try {
			prepstatement = connection.prepareStatement("SELECT * FROM Don WHERE associationId in ( select idAssoc from membreAssociation where idMembre= ? )");
			prepstatement.setLong(1,membreAssociation.getIdMembre());
			res = prepstatement.executeQuery();
			while(res.next()) {
				Don returnedDon = new Don(res.getInt(1),
										  res.getString(2),
										  res.getString(3),
										  res.getString(4),
										  res.getDate(5),
										  res.getString(6),
										  res.getInt(7)
										  );
				returnedList.add(returnedDon);
			}
			prepstatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return returnedList;
	}

}
