package Entities;

import Dao.AdminSYSDao;
import DaoImpl.UserDaoImpl;

public class AdminSYS extends User 
{
	public static AdminSYSDao objects;
	
	public AdminSYS()
	{
		
	}
	
	public AdminSYS(long id, String username, String password, String email) 
	{
		super(id, username, password, email);
	}
}