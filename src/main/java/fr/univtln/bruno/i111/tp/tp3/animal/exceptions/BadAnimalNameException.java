package fr.univtln.bruno.i111.tp.tp3.animal.exceptions;

public class BadAnimalNameException extends Exception {
    public BadAnimalNameException(String name, String pattern) {
        super(String.format("Bad format for animal name %s expected %s", name, pattern));
    }
}
