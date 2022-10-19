package fr.univtln.bruno.i111.tp.tp3.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static fr.univtln.bruno.i111.tp.tp3.jdbc.JdbcBasic.*;


@Slf4j
/**
 * Une DAO minimale.
 * Utiliser des génériques pour réutiliser.
 * Utiliser un pool de datasources pour réutiliser les connections
 */
public class PersonDAO implements AutoCloseable {
    private final Connection connection;
    private final PreparedStatement findAll;
    private final PreparedStatement findbyId;
    private final PreparedStatement persist;
    private final PreparedStatement remove;

    private PersonDAO() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        findAll = connection.prepareStatement("SELECT * FROM PERSON");
        findbyId = connection.prepareStatement("SELECT * FROM PERSON WHERE EMAIL=?");
        persist = connection.prepareStatement("INSERT INTO PERSON VALUES (?,?)");
        remove = connection.prepareStatement("DELETE FROM PERSON WHERE EMAIL=?");
        log.debug("DB connection opened");
    }

    public static PersonDAO create() throws SQLException {
        return new PersonDAO();
    }

    public List<Person> findAll() throws SQLException {
        List<Person> person = new ArrayList<>();
        ResultSet rs = findAll.executeQuery();
        // Extract data from result set
        while (rs.next()) {
            person.add(new Person(rs.getString("EMAIL"),
                    rs.getString("NAME")));
        }
        return person;
    }

    public Person findById(String email) throws SQLException {
        Person person = null;
        findbyId.setString(1, email);
        ResultSet rs = findbyId.executeQuery();
        // Extract data from result set
        while (rs.next()) {
            person = new Person(rs.getString("EMAIL"), rs.getString("NAME"));
        }
        return person;
    }

    public boolean exist(Person person) throws SQLException {
        return exist(person.email());
    }

    public boolean exist(String email) throws SQLException {
        findbyId.setString(1, email);
        ResultSet rs = findbyId.executeQuery();
        return rs.next();
    }


    public Person persist(Person person) throws SQLException {
        return persist(person.email(), person.name());
    }

    public Person persist(String email, String name) throws SQLException {
        persist.setString(1, email);
        persist.setString(2, name);
        if (persist.executeUpdate() == 1)
            log.debug(email + " persisted.");
        //La création d'une personne est utile surtout si un id automatique est généré par la base de donnée.
        return new Person(email, name);
    }

    public void remove(Person person) throws SQLException {
        remove(person.email());
    }

    public void remove(String email) throws SQLException {
        remove.setString(1, email);
        remove.executeUpdate();
        log.debug(email + " removed.");
    }

    @Override
    public void close() throws SQLException {
        connection.close();
        log.debug("DB connection closed");
    }
}
