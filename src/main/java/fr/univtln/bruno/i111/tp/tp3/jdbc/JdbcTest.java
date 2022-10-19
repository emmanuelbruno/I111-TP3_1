package fr.univtln.bruno.i111.tp.tp3.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.time.Period;

@Slf4j
public class JdbcTest {
    public static void main(String[] args) {
        try (PersonDAO personDAO = PersonDAO.create()) {
            log.info(personDAO.findById("a.b@ici.fr").toString());
            Person person = new Person("john.doe@nowhere.fr", "John");
            if (personDAO.exist(person)) {
                log.info(person.email() + " already exist.");
                personDAO.remove(person);
            } else
                personDAO.persist(person);
            log.info(personDAO.findAll().toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
