package Entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import DaoImpl.TokenDaoImpl;

public class Token 
{
	private long id_token;
	private String value_token;
	private long user_token;
	
	public static TokenDaoImpl objects = new TokenDaoImpl();
	
	public static String generateToken(String username, String password)
	{
		String salt = "84B03D034B409D4E";
		int numberOfIterations = 50000;
    	String salted_username_password = username + password + salt;
    	StringBuffer buffer = new StringBuffer();
    	byte[] bytes = salted_username_password.getBytes();
    
    	try 
    	{
    		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    		
    		for (int counter = 0; counter < numberOfIterations; counter++)
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
