package modele;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by o2122505 on 06/09/16.
 */
public class FacadeMotus implements IFacadeMotus {

    private Map<String,Partie> joueursConnectes= new HashMap<>();

    public boolean creationPartie(String pseudo1, String pseudo2, String dictionnaire){
        boolean connexionPossible = joueursConnectes.containsKey(pseudo1)||joueursConnectes.containsKey(pseudo2);
        if (!connexionPossible){
            Partie motus = new Partie(pseudo1, pseudo2, dictionnaire);
            joueursConnectes.put(pseudo1, motus);
            joueursConnectes.put(pseudo2, motus);
            return true;
        }
        return false;
    }

    public boolean deconnexion(String pseudo){
        if (joueursConnectes.get(pseudo)==null)
            return true;
        else
            return false;

    }
    public String jouer(String pseudo, String mot){
        Partie p = joueursConnectes.get(pseudo);
        return(p.correspondance(mot));
    }
    public Partie getPartie(String pseudo){
        return  joueursConnectes.get(pseudo);
    }
    public String getMotRecherche(String pseudo){
        Partie p = joueursConnectes.get(pseudo);
        return p.getMotRecherche();
    }
    public int getTour(String pseudo){
        Partie p = joueursConnectes.get(pseudo);
        return p.getTour();
    }
}
