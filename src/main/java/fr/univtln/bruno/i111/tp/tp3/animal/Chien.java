package fr.univtln.bruno.i111.tp.tp3.animal;

import fr.univtln.bruno.i111.tp.tp3.animal.exceptions.BadAnimalNameException;

public class Chien extends Animal{

    public Chien(String nom) throws BadAnimalNameException {
        super(nom);
    }

    public static Chien of(String nom) throws BadAnimalNameException {
        return new Chien(nom);
    }
}
