package Dao;

import java.sql.SQLException;
import java.util.List;

import Entities.Token;

public interface TokenDao 
{
	public String create(String username, String password, long user_id) throws SQLException;
	public boolean update(Long id, String username, String password, String email) throws SQLException;
	public Token get(Long user_token) throws SQLException;
	public long get(String token) throws SQLException;
	public List<Token> all() throws SQLException;
}
