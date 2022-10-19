package fr.univtln.bruno.i111.tp.tp3.jdbc;

import lombok.extern.java.Log;

import java.sql.*;

@Log
public class JdbcBasic {
/*    public static String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
    public static String USER = "postgres";
    public static String PASS = "password";*/

    public static String DB_URL = "jdbc:h2:tcp://localhost/~/testdb";
    public static String USER = "sa";
    public static String PASS = "test";


    public static void main(String[] args) {
        final String QUERY = "select * from PERSON";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(QUERY);) {
            // Extract data from result set
            while (resultSet.next()) {
                log.info(new Person(
                        resultSet.getString("EMAIL"),
                        resultSet.getString("NAME")).toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
