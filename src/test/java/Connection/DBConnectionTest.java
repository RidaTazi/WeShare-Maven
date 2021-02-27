package Connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class DBConnectionTest {
    @Test
    public void testConnection() throws Exception {
        Connection connection = DBConnection.getInstance();
        assertEquals(connection != null, true);
    }

    @Test
    public void testDataInsertion() throws Exception{

        String data = "insert into donneur values ('tamtaoui', 'abdelwadoud', 'harhoura', 1, 999)";
        try{
            Connection connection;
            connection= DBConnection.getInstance();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(data);
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            data = "select * from donneur  where idDonneur = 999;";
            Connection connection;
            connection= DBConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(data);
            result.next();
            String nom = result.getObject("nom_donneur").toString();
            String prenom = result.getObject("prenom_donneur").toString();
            String addr = result.getObject("addr_donneur").toString();

            assertEquals("tamtaoui",nom);
            assertEquals("abdelwadoud",prenom);
            assertEquals("harhoura",addr);

            result.close();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
