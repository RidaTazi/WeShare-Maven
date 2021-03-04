package Entities;


public class AdminSYS extends User 
{

	public AdminSYS()
	{
		
	}
	
	public AdminSYS(Long id, String username, String password, String email)
	{
		super(id,1, username, password, email);
	}
}