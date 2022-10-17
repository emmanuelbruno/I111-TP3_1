package fr.univtln.bruno.i111.tp.tp3.animal;

import fr.univtln.bruno.i111.tp.tp3.animal.exceptions.BadAnimalNameException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;

import java.util.regex.Pattern;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Slf4j
@AllArgsConstructor(staticName = "of")
public /* abstract */ class Animal implements AutoCloseable{
    // Manuellement (sans lombok) Logger Avec Slf4j
    //private static Logger log = LoggerFactory.getLogger(Animal.class);
    // Directement avec le Logger Avec le logger standard du JDK
    //public static java.util.logging.Logger log = java.util.logging.Logger.getLogger(Animal.class.getName());

    final static int MAX_SPECIES = 10;
    final static MutableObjectIntMap<String> ids = new ObjectIntHashMap<>(MAX_SPECIES);

    //final static Pattern p = Pattern.compile("\\w+");
    final static Pattern namePattern = Pattern.compile("[a-zA-Z]+");

    static int nbAnimaux = 0;

    String nom;
    Tatouage tatouage;

    protected Animal(String nom) throws BadAnimalNameException {
        if (!namePattern.matcher(nom).matches()) throw new BadAnimalNameException(nom, namePattern.toString());
        this.nom = nom;
        final String realClassname = this.getClass().getSimpleName();
        final int id = ids.getIfAbsent(realClassname, 0);
        ids.put(realClassname, id + 1);
        this.tatouage = Tatouage.of(realClassname, id);
        nbAnimaux++;
    }

    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @AllArgsConstructor(staticName = "of")
    @ToString
    public static class Tatouage implements Comparable<Tatouage> {
        String espece;
        int id;

        @Override
        public int hashCode() {

            log.debug("using hashcode");

            int result = espece.hashCode();
            result = 31 * result + id;
            return result;
        }

        @Override
        public boolean equals(Object o) {

            log.debug("using equals");

            if (this == o) return true;
            if (!(o instanceof Tatouage tatouage)) return false;

            if (id != tatouage.id) return false;
            return espece.equals(tatouage.espece);
        }

        @Override
        public int compareTo(Tatouage o) {
            int ordre = espece.compareTo(o.espece);
            if (ordre == 0) return id - o.id;
            else return ordre;
        }
    }

    @Override
    public void close() throws Exception {

    }
}
