package DaoImpl;

import java.sql.SQLException;
import java.util.List;

import Dao.AdminSYSDao;
import Entities.AdminSYS;

public class AdminSYSDaoImpl implements AdminSYSDao 
{
	
	public int create(AdminSYS user) throws SQLException
	{
		return 0;
	}
	
	
    public boolean update(Long id, AdminSYS user) throws SQLException
    {
		return false;
    	
    }
    
    
    public boolean delete(Long id) throws SQLException
    {
		return false;
    	
    }
    
    
    public AdminSYS get(Long id) throws SQLException
    {
		return null;
    	
    }
    
    public List<AdminSYS> all() throws SQLException
    {
		return null;
    	
    }
    
    public List<AdminSYS> filter() throws SQLException
    {
		return null;
    	
    }
}
