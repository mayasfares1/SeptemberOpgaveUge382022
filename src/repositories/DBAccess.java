package repositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBAccess {

        public Connection getConnection() {
            Connection connection = null;
            String url = "jdbc:mysql://localhost:3306/projectsep?serverTimezone=CET&useSSL=false";
            String user = "root";
            String password = "123456";
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }

}
