package Connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static String url;
    private static String user;
    private static String passwd;
    private static Connection connect;

    public static Connection getInstance() {
        try {
            InputStream in = DBConnection.class.getClassLoader().getResourceAsStream("application.properties");
            Properties properties = new Properties();
            properties.load(in);
            assert in != null;
            in.close();
            Class.forName(properties.getProperty("jdbc.driverClass"));
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.user");
            passwd = properties.getProperty("jdbc.password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;

    }
}