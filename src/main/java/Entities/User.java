package Entities;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;

public class User 
{
	protected long id_user;
	protected Byte etatInfo_user;
	protected String username_user;
	protected String password_user;
	protected String email_user;
	

	public static UserDaoImpl objects;
	
	public User()
	{

	}
	
	public User(long id_user, String username_user, String password_user, String email_user) 
	{
		this.id_user = id_user;
		this.etatInfo_user = 1;
		this.username_user = username_user;
		this.password_user = password_user;
		this.email_user = email_user;
		
	}

	public String getUsername() {
		return this.username_user;
	}

	public void setUsername(String aUsername) {
		this.username_user = aUsername;
	}

	public String getPassword() {
		return this.password_user;
	}

	public void setPassword(String aPassword) {
		this.password_user = aPassword;
	}

	public String getEmail() {
		return this.email_user;
	}

	public void setEmail(String aEmail) 
	{
		this.email_user = aEmail;
	}
}