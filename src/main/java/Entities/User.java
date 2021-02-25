package Entities;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;

public class User 
{
	protected long id_user;
	protected int etatInfo_user;
	protected String username_user;
	protected String password_user;
	protected String email_user;
	protected String role_user;
	

	public static UserDaoImpl objects = new UserDaoImpl();
	
	public User()
	{

	}
	
	public User(long id_user, int etatInfo_user,  String username_user, String password_user, String role_user) 
	{
		this.id_user = id_user;
		this.etatInfo_user = etatInfo_user;
		this.username_user = username_user;
		this.password_user = password_user;
		this.role_user = role_user;
	}
	
	public User(long id_user, int etatInfo_user, String username_user, String password_user, String email_user, String role_user) 
	{
		this.id_user = id_user;
		this.etatInfo_user = etatInfo_user;
		this.username_user = username_user;
		this.password_user = password_user;
		this.email_user = email_user;
		this.role_user = role_user;
		
	}
	
	public String getRoleUser()
	{
		return this.role_user;
	}
	
	public void setRoleUser(String role_user)
	{
		this.role_user = role_user;
	}
	
	public long getIdUser()
	{
		return this.id_user;
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