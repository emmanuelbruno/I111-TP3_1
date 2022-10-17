package fr.univtln.bruno.i111.tp.tp3.animal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class X {

    public int n(int x) throws XPairException, XNegatifException {
        return m(2*x);
    }

    public int m(int x) throws XPairException, XNegatifException {
        if (x % 2== 0) throw new XPairException();

        if (x<0) throw new XNegatifException();
        return x;
    }

    public static void main(String[] args) {
        try {
          log.info("Résultat: "+new X().n(-10));
        } catch (XPairException e) {
            log.error(e.getMessage());
        } catch (XNegatifException e) {
            log.error(e.getMessage());
        } finally {
            log.info("execute dans tous les cas!");
        }
    }

    public static void inconnu() {
        try {
            log.info("Résultat bis: "+new X().n(-10));
        } catch (Exception e) {
            log.error("X ne doit pas être négatif !");
        }
    }


}
