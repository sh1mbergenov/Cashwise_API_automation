package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilities {

  private static   String url = Config.getProperty("cashwiseDbUrl");
   private static String username = Config.getProperty("cashwiseDbUsername");
    private  static  String password = Config.getProperty("cashwiseDbPassword");
    public static Connection getDBConnection() throws SQLException {
      return DriverManager.getConnection(url,username,password);
    }

    /**
     * This will close any open connection to DB
     * author Yryskeldi
     * @param connection
     */
    public static void closeConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
        }
        }catch (SQLException e)  {
            e.printStackTrace();
        }
    }

    /**
     * closes ResultSet
     * @param rs
     */
    public static void closeResultSet(ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
