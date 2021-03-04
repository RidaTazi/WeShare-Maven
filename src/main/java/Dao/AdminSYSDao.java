package Dao;

import java.sql.SQLException;
import Entities.AdminSYS;

public interface AdminSYSDao 
{
	int create(String admin_username, String admin_password, String admin_email) throws SQLException;
    boolean update(Long id, String username, String password, String email) throws SQLException;
    boolean delete(Long id) throws SQLException;
    AdminSYS get(Long id) throws SQLException;
//    List<AdminSYS> filter() throws SQLException;
//    List<AdminSYS> all() throws SQLException;
    
}


