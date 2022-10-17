import fr.univtln.bruno.i111.tp.tp3.animal.Chat;
import fr.univtln.bruno.i111.tp.tp3.animal.Chien;
import fr.univtln.bruno.i111.tp.tp3.animal.exceptions.BadAnimalNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AnimalTest {

    @Test
    public void testChienCreation() {
        try {
            String nom = "Médor";
            Chien chien = Chien.of(nom);
            Assertions.assertAll(
                    () -> assertEquals(chien.getNom(), nom),
                    () -> assertEquals(chien.getTatouage().getEspece(), "Chien")
            );
        } catch (BadAnimalNameException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testChatCreation() {
        try {
            String nom = "Félix";
            Chat chat = Chat.of(nom);
            Assertions.assertAll(
                    () -> assertEquals(chat.getNom(), nom),
                    () -> assertEquals(chat.getTatouage().getEspece(), "Chat")
            );
        } catch (BadAnimalNameException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAnimalCreationException() {
        Assertions.assertThrows(BadAnimalNameException.class,
                () -> Chien.of("Médor%"));
    }
}
