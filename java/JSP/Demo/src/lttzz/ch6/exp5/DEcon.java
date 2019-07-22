package lttzz.ch6.exp5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DEcon {
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://120.79.147.108:3306/jsp?useUnicode = true&characterEncoding = utf-8";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PWD = "root";

    public static Connection getConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DRIVER_CLASS);
            dbConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

    public static void closeConnection(Connection dbConnection) {
        try {
            if (dbConnection != null && (!dbConnection.isClosed())) {
                dbConnection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeResult(ResultSet res) {
        try {
            if (res != null) {
                res.close();
                res = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
                preparedStatement = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
