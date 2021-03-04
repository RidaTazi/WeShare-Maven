package DaoImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Dao.AdminSYSDao;
import Entities.AdminSYS;

public class AdminSYSDaoImpl implements AdminSYSDao 
{
	private Connection connection;
    private Statement statement;
    private String sqlQuery;
	
    
    private void init() throws SQLException 
    {
        connection = DBConnection.getInstance();
        statement = connection.createStatement();
    }
    
    private void close() throws SQLException
    {
    	if (statement != null)
		{
			statement.close();
		}
		else if (connection != null)
		{
			connection.close();
		}
    }
    
    private String hashPassword(String password)
    {
    	String salt = "E1F53135E559C253";
    	String saltedPassword = salt + password + salt;
    	int numberOfiteration = 50000;
    
    	try 
    	{
    		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    		
    		for (int counter = 0; counter < numberOfiteration; counter++)
    		{
    			messageDigest.update(saltedPassword.getBytes());
        		
    			saltedPassword = new String(messageDigest.digest());
    		}
    		
    		return saltedPassword;
    	}
    	catch (NoSuchAlgorithmException e) 
    	{
			e.printStackTrace();
			return null;
		}
    }
	
	public int create(String admin_username, String admin_password, String admin_email) throws SQLException
	{
		init();
		
		String adminhashedPassword = hashPassword(admin_password);
		
		sqlQuery = "INSERT INTO AdminSYS VALUES " + "(" +admin_username + " , " + adminhashedPassword + " , " 
				+ admin_email + ")";
		
		statement.executeUpdate(sqlQuery);
		
		close();
		return 0;
	}
	
	
    public boolean update(Long id, String username, String password, String email) throws SQLException
    {
    	init();
    
		String adminhashedPassword = hashPassword(password);
		sqlQuery = "UPDATE AdminSYS SET admin_username = " + username + " , " 
				+ "admin_password = " + adminhashedPassword 
				+ " , " + " admin_email = " + email 
				+ " WHERE admin_id = " + id; 
		statement.executeQuery(sqlQuery);
	
		close();
    	return true;
    	
    }
    
    
    public boolean delete(Long id) throws SQLException
    {
    	init();
  
    	sqlQuery = "UPDATE AdminSYS SET etatInfo_admin = 0" + " WHERE admin_id = " + id;
    	statement.executeQuery(sqlQuery);
		close();
		return false;
    	
    }
    
    
    public AdminSYS get(Long id) throws SQLException
    {
    	init();
    	
    	AdminSYS adminSYS = null;
    	
    	sqlQuery = "select * from AdminSYS where id_admin = " + id + ";";
        
        ResultSet result = statement.executeQuery(sqlQuery); result.next();

		assert false;
		adminSYS.setUsername(result.getObject("username_admin").toString());
        adminSYS.setPassword(result.getObject("password_admin").toString());
        adminSYS.setEmail(result.getObject("password_admin").toString());
    
		close();
    	return adminSYS;
    }
    
    public List<AdminSYS> all() throws SQLException
    {
    	init();
    	
    	ArrayList<AdminSYS> admins = new ArrayList<>();

        sqlQuery = "select id_admin from AdminSYS";
        
        ResultSet result = statement.executeQuery(sqlQuery);
        
        while (result.next())
        {
        	admins.add(get(result.getLong("id_admin")));
        }
    	
		close();
		return admins;
    	
    }
    
    public List<AdminSYS> filter() throws SQLException
    {
    	init();
		close();
		return null;
    }
}
