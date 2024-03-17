package org.corecode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

        private static String url = "jdbc:postgresql://localhost:5432/OkaneDev";

        private static String user = "rick";

        private static String password = "admin123";

        private static Connection conn;

            public static Connection getInstance() throws SQLException{
                if(conn == null){
                        conn = DriverManager.getConnection(url, user, password);
                }
                return conn;
            }
}
