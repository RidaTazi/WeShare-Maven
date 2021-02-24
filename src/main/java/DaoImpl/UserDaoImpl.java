package DaoImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    private String hashPassword(String password)
    {
    	try 
    	{
    		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    		
        	messageDigest.update(password.getBytes());
    		
    		String hashedPassword = new String(messageDigest.digest());
    		
    		return hashedPassword;
    	}
    	catch (NoSuchAlgorithmException e) 
    	{
			e.printStackTrace();
			return null;
		}
    }
    
	@Override
	public int create(String username, String password, String email) throws SQLException
	{
		init();
		
		String hashedPassword = hashPassword(password);
		
		sqlQuery = "INSERT INTO AdminSYS VALUES " + "(" + username + " , " + hashedPassword + ")";
		
		statement.executeUpdate(sqlQuery);
		
		if (statement != null)
		{
			statement.close();
		}
		else if (connection != null)
		{
			connection.close();
		}
		return 0;
	}
	
	@Override
    public boolean update(Long id, String username, String password, String email) throws SQLException
    {
		init();
		
		String hashedPassword = hashPassword(password);
		
		sqlQuery = "UPDATE User SET username = " + username + " , " 
				+ "password = " + hashedPassword + " , " + " email = " + email + " WHERE user_id = " + id; 
		
		statement.executeQuery(sqlQuery);
		statement.close();
		connection.close();
    	return true;
    }
    
	@Override
    public boolean delete(Long id) throws SQLException
    {
    	init();
    	sqlQuery = "UPDATE User SET etatInfo_user = 0" + " WHERE user_id = " + id;
    	statement.executeQuery(sqlQuery);
		statement.close();
		connection.close();
    	return false;
    }
    
    @Override
	public User get(Long id) throws SQLException
    {
    	init();
    	
    	User user = null;
    	
    	sqlQuery = "select * from User where id_user = " + id + ";";
        
        ResultSet result = statement.executeQuery(sqlQuery); result.next();
    	
    	user.setUsername(result.getObject("username_user").toString());
    	user.setPassword(result.getObject("password_user").toString());
    	user.setEmail(result.getObject("password_user").toString());
    
		statement.close();
		connection.close();
		
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
       
		statement.close();
		connection.close();
		return users;
    }
    
    @Override
    public List<User> filter() throws SQLException
    {
    	init();
    	
		statement.close();
		connection.close();
		return null;
    }
}
