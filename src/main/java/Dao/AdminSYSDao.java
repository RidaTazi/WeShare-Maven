package Dao;

import java.sql.SQLException;
import java.util.List;
import Entities.AdminSYS;

public interface AdminSYSDao 
{
	int create(AdminSYS user) throws SQLException;
    boolean update(Long id, AdminSYS user) throws SQLException;
    boolean delete(Long id) throws SQLException;
    AdminSYS get(Long id) throws SQLException;
    List<AdminSYS> filter() throws SQLException;
    List<AdminSYS> all() throws SQLException;
    
}


