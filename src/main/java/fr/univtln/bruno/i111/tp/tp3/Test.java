package fr.univtln.bruno.i111.tp.tp3;

import fr.univtln.bruno.i111.tp.tp3.animal.Chat;
import fr.univtln.bruno.i111.tp.tp3.animal.Chien;
import fr.univtln.bruno.i111.tp.tp3.animal.datastructures.MapAnimal;
import fr.univtln.bruno.i111.tp.tp3.animal.exceptions.BadAnimalNameException;
import lombok.extern.slf4j.Slf4j;

import java.util.TreeMap;

@Slf4j
public class Test {
    //private static Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        /*
        //Map<Tatouage, Animal> animalMap = new HashMap<>();
        Map<Animal.Tatouage, Animal> animalMap = new TreeMap<>();
        //MapAnimaux animalMap = new MapAnimaux();


        final Animal.Tatouage tatouageChien1 = Animal.Tatouage.of("Chien", 1);
        final Animal.Tatouage tatouageChien2 = Animal.Tatouage.of("Chien", 2);
        final Animal.Tatouage tatouageChat1 = Animal.Tatouage.of("Chat", 1);

        animalMap.put(tatouageChien1,Animal.of("Rex",tatouageChien1));
        animalMap.put(tatouageChien2,Animal.of("Médor",tatouageChien2));
        animalMap.put(tatouageChat1,Animal.of("Félix",tatouageChat1));

        System.out.println(animalMap);
        System.out.println("Chien1 par la clé d'origine :"+animalMap.get(tatouageChien1));
        System.out.println("Chien1 par un clone de la clé d'origine :"+animalMap.get(Animal.Tatouage.of("Chien", 1)));
        */

        try {
            MapAnimal animalMap = new MapAnimal(new TreeMap<>());
            animalMap.put(Chien.of("Rex"));
            animalMap.put(Chien.of("Médor"));
            animalMap.put(Chat.of("Félix"));

            log.info(Chat.of("Sirius").toString());
            log.info(Chat.of("Alf").toString());
        } catch (BadAnimalNameException e) {
            log.error(e.getMessage());
        } finally {

        }
    }
}
