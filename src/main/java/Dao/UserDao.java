package Dao;

import java.sql.SQLException;
import java.util.List;

import Entities.User;

public interface UserDao 
{
	User create(String username, String password, String role) throws SQLException;
    boolean update(Long id, String username, String password, String email, String role) throws SQLException;
    boolean delete(Long id) throws SQLException;
    User get(Long id) throws SQLException;
    List<User> all() throws SQLException;
    List<User> filter() throws SQLException;
}


