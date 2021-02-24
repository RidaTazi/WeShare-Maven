package Entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Dao.TokenDao;

public class Token 
{
	private long id_token;
	private String value_token;
	private long user_token;
	
	public static TokenDao objects;
	
	public static String generateToken(String username, String password)
	{
		String salt = "84B03D034B409D4E";
		int numberOfIterations = 50000;
    	String salted_username_password = salt + password + salt;
    
    	try 
    	{
    		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    		
    		for (int counter = 0; counter < numberOfIterations; counter++)
    		{
    			messageDigest.update(salted_username_password.getBytes());
        		
    			salted_username_password = new String(messageDigest.digest());
    		}
    		
    		return salted_username_password;
    	}
    	catch (NoSuchAlgorithmException e) 
    	{
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Token()
	{
		
	}
	
	public Token(String username, String password, long user_token)
	{
		this.user_token = user_token;
		this.value_token = generateToken(username, password);
	}
	
	public long getIdToken()
	{
		return this.id_token;
	}
	
	public String getValueToken()
	{
		return value_token;
	}
	
	public long getUserId()
	{
		return user_token;
	}
	
	
	public void setUserToken(long user_token)
	{
		this.user_token = user_token;
	}
	
	public void setValueToken(String value_token)
	{
		this.value_token = value_token;
	}
	
	public void setIdToken(long id_token)
	{
		this.id_token = id_token;
	}
	
}
