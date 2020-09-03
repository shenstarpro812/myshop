package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String URL ="jdbc:mysql://localhost:3306/myshop?characterEncoding=UTF-8";
    private static String user = "root";
    private static String password = "123456789";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){

        try {
            return DriverManager.getConnection(URL,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
    public static Connection getConnection(String dbName){
        URL ="jdbc:mysql://localhost:3306/"+dbName+"?characterEncoding=UTF-8";

        try {
            return DriverManager.getConnection(URL,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

}
