package DaoImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Dao.UserDao;
import Entities.Association;
import Entities.User;
import java.security.MessageDigest;


public class UserDaoImpl implements UserDao 
{
	private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
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
    
    static String hashPassword(String password)
    {
    	String salt = "E1F53135E559C253";
    	String saltedPassword = password + salt;
    	int numberOfiteration = 50000;
    	StringBuffer buffer = new StringBuffer();
    	byte[] bytes = saltedPassword.getBytes();
    
    	try 
    	{
    		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    		
    		for (int counter = 0; counter < numberOfiteration; counter++)
    		{
    			messageDigest.update(bytes);
    			bytes = messageDigest.digest();	
    		}
    		
			for (byte b : bytes)
			{
			    buffer.append(String.format("%02x", b < 0 ? b + 256 : b));
			}
    		
    		return buffer.toString();
    	}
    	catch (NoSuchAlgorithmException e) 
    	{
			e.printStackTrace();
			return null;
		}
    }
    
	@Override
	public User create(String username, String password, String role) throws SQLIntegrityConstraintViolationException, SQLException
	{
		init();
		
		String hashedPassword = hashPassword(password);
		
		sqlQuery = "INSERT INTO User (etatInfo_user, username_user, password_user, role_user) VALUES " + "(" + 1 + ",'" + username + "' , '" + hashedPassword + "','" + role + "')";
		
		int etat = statement.executeUpdate(sqlQuery);
		
		ResultSet resultat = statement.executeQuery( "SELECT id_user, etatInfo_user, username_user, password_user, role_user FROM User WHERE username_user = " + "'" + username + "'" + ";");
		
		resultat.next();
		
		User user = new User(resultat.getLong("id_user"), resultat.getInt("etatInfo_user"), resultat.getString("username_user"), resultat.getString("password_user"), resultat.getString("role_user"));
		
		close();
		
		return user;
	}
	
	@Override
    public boolean update(Long id, String username, String password, String email, String role) throws SQLException
    {
		init();
		
		String hashedPassword = hashPassword(password);
		
		sqlQuery = "UPDATE User SET username_user = '" + username + "' , " 
				+ "password_user = '" + hashedPassword + "' , " + " email_user = '" + email + "'," + " role_user = '" + role + "' WHERE user_id = " + id; 
		
		statement.executeQuery(sqlQuery);
		
		close();
    	return true;
    }
    
	@Override
    public boolean delete(Long id) throws SQLException
    {
    	init();
    	sqlQuery = "UPDATE User SET etatInfo_user = 0" + " WHERE user_id = " + id;
    	statement.executeQuery(sqlQuery);
    	close();
    	return false;
    }
    
    @Override
	public User get(Long id) throws SQLException
    {
    	init();
    	User user = new User();
    	sqlQuery = "SELECT * FROM User WHERE id_user = " + id + ";";
        ResultSet result = statement.executeQuery(sqlQuery);
        result.next();
        
        user.setUsername(result.getObject("username_user").toString());
    	user.setPassword(result.getObject("password_user").toString());
    	user.setRoleUser(result.getObject("role_user").toString());
    	close();
    	return user;
    }
    
    @Override
    public List<User> all() throws SQLException
    {
    	init();
    	
    	ArrayList<User> users = new ArrayList<User>();

        sqlQuery = "select id_user from User";
        
        ResultSet result = statement.executeQuery(sqlQuery);
        
        while (result.next())
        {
        	users.add(get(result.getLong("id_user")));
        }
       
        close();
		return users;
    }
    
    @Override
    public List<User> filter() throws SQLException
    {
    	init();
    	close();
		return null;
    }
}
