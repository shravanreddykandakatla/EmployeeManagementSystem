package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectionFactory {
    private static Connection con= null;

    public static Connection getDBConnection() throws Exception{
        if(con==null){
            ResourceBundle bundle=ResourceBundle.getBundle("dbconstants");
            String driverClass= bundle.getString("jdbc.driverclass");
            String url=bundle.getString("jdbc.url");
            String userName=bundle.getString("jdbc.username");
            String password=bundle.getString("jdbc.password");

            Class.forName(driverClass);
            con= DriverManager.getConnection(url,userName,password);
        }
        return con;
    }
}
