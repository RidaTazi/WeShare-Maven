package Dao;

import java.sql.SQLException;
import java.util.List;

import Entities.User;

public interface UserDao 
{
	int create(User user) throws SQLException;
    boolean update(Long id, User user) throws SQLException;
    boolean delete(Long id) throws SQLException;
    User get(Long id) throws SQLException;
    List<User> all() throws SQLException;
    List<User> filter() throws SQLException;
}


