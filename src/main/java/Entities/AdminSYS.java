package Entities;

import Dao.AdminSYSDao;
import DaoImpl.UserDaoImpl;

public class AdminSYS extends User 
{
	public static AdminSYSDao objects;
	
	public AdminSYS()
	{
		
	}
	
	public AdminSYS(Long id, String username, String password, String email)
	{
		super(id,1, username, password, email);
	}
}