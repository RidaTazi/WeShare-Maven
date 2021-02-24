package DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.UserDao;
import Entities.Association;
import Entities.User;

public class UserDaoImpl implements UserDao 
{
	@Override
	public int create(User user) throws SQLException
	{
		return 1;
	}
	
	@Override
    public boolean update(Long id, User user) throws SQLException
    {
    	return true;
    }
    
    @Override
    public boolean delete(Long id) throws SQLException
    {
    	return false;
    }
    
    @Override
	public User get(Long id) throws SQLException
    {
    	return new User();
    }
    
    @Override
    public List<User> all() throws SQLException
    {
    	return null;
    }
    
    @Override
    public List<User> filter() throws SQLException
    {
    	return null;
    }
}
