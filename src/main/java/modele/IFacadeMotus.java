package modele;

/**
 * Created by o2122505 on 06/09/16.
 */
public interface IFacadeMotus {
    boolean creationPartie(String pseudo1, String pseudo2);

    boolean deconnexion(String pseudo);

    String jouer(String pseudo, String mot);

    Partie getPartie(String pseudo);

    String getMotRecherche(String pseudo);

}
