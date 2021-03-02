package DaoImpl;

import org.junit.Test;

import Entities.User;
import Web.UserController;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

public class UserDaoTest 
{
    @Test
    public void hashPasswordTest() throws Exception
    {
    	String hashed_password = UserDaoImpl.hashPassword("hamza123456789");
    	assertEquals(hashed_password, "335bd337120cb0c4b4292d98b5e787856b67c3779dcc8ef2f295cca72ff572df");
    }
    
    @Test
    public void create()
    {
    	String username = "hamza10";
    	String password = "hamza123456789123456789";
    	String role = "A";
    	try
		{
			User user = User.objects.create(username, password, role);
			assertEquals(user.getUsername(), username);
			assertEquals(user.getPassword(), "5e3b2bae5ad2d2ed9563d739ff83e0e28267e71a3481efc59c995707c9e54c14");
			assertEquals(user.getRoleUser(), "A");
			
		} 
    	catch (SQLException e)
		{
			e.printStackTrace();
		}
    }
}
