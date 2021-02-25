package DaoImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import Dao.TokenDao;
import Entities.Token;
import Entities.User;

public class TokenDaoImpl implements TokenDao {
	
	private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private String sqlQuery;
	
    private void init() throws SQLException 
    {
        connection = DBConnection.getInstance();
        statement = connection.createStatement();
    }
    
    private void close() throws SQLException
    {
    	if (statement != null)
		{
			statement.close();
		}
		else if (connection != null)
		{
			connection.close();
		}
    }
    
	@Override
	public int create(String username, String password, long user_id) throws SQLException
	{
		init();
		
		String token = Token.generateToken(username, password);
		
		sqlQuery = "INSERT INTO Token VALUES " + "(" + token + " , " + user_id + ")";
		
		statement.executeUpdate(sqlQuery);
		close();
		return 0;
	}
	
	@Override
    public boolean update(Long user_token, String username, String password, String email) throws SQLException
    {
		init();
		
		String token = Token.generateToken(username, password);
		
		sqlQuery = "UPDATE Token SET token_value = " + token + " WHERE user_token = " + user_token; 
		
		statement.executeQuery(sqlQuery);
		
		close();
    	return true;
    }
   
    
    @Override
	public Token get(Long user_token) throws SQLException
    {
    	init();
    	Token token = null;
    	sqlQuery = "select * from Token where id_user = " + user_token + ";";
        ResultSet result = statement.executeQuery(sqlQuery); result.next();
    	token.setValueToken(result.getObject("value_token").toString());
    	token.setUserToken((long)result.getObject("user_token"));
    	token.setIdToken((long)result.getObject("id_token"));
    	close();
    	return token;
    }
    
    @Override
    public List<Token> all() throws SQLException
    {
    	init();
    	
    	ArrayList<Token> tokens = new ArrayList<Token>();

        sqlQuery = "select id_token from Token";
        
        ResultSet result = statement.executeQuery(sqlQuery);
        
        while (result.next())
        {
        	tokens.add(get(result.getLong("id_token")));
        }
       
        close();
		return tokens;
    }
    
}