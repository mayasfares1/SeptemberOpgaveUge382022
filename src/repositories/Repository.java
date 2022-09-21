package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Repository {

    protected Connection connection;
    private DBAccess dbAccess = new DBAccess();


    // ResultSet is the same values from the rows and coulombs
    protected ResultSet read(String sql) {
        getConnection();

        // Allows code to become functional in java

        // Query only receives data
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }


    // execute function can: delete, update, & insert values
    protected boolean execute(String sql) {
        getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    private void getConnection() {
        connection = dbAccess.getConnection();
    }
}
