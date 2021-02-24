package Entities;

import Dao.AdminSYSDao;
import DaoImpl.UserDaoImpl;

public class AdminSYS extends User 
{
	public static AdminSYSDao objects;
	
	public AdminSYS()
	{
	}
	
	public AdminSYS(long id_user, String username_user, String password_user, String email_user) 
	{
		super(id_user, username_user, password_user, email_user);
	}
}