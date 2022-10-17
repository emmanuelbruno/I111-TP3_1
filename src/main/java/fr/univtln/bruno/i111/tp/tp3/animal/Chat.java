package fr.univtln.bruno.i111.tp.tp3.animal;

import fr.univtln.bruno.i111.tp.tp3.animal.exceptions.BadAnimalNameException;

public class Chat extends Animal {
    public static Chat of(String nom) throws BadAnimalNameException {
        return new Chat(nom);
    }
    private Chat(String nom) throws BadAnimalNameException {
        super(nom);
    }
}
