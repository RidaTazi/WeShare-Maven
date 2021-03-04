package Dao;

import java.sql.SQLException;
import java.util.List;

import Entities.Token;

public interface TokenDao 
{
	String create(String username, String password, long user_id) throws SQLException;
	boolean update(Long id, String username, String password, String email) throws SQLException;
	Token get(Long user_token) throws SQLException;
	long get(String token) throws SQLException;
	List<Token> all() throws SQLException;
}
