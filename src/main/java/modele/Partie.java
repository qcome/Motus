package modele;
import java.util.*;

/**
 * Created by o2122505 on 06/09/16.
 */
public class Partie {
    private Joueur joueur1, joueur2;
    private Dictionnaire dico;
    private String motRecherche;
    private String propostion;
    private int nbTours = 7;
    private int tour = 1;
    private HashMap hm;


    public Partie(String joueur1,String joueur2) {
        this.joueur1=new Joueur(joueur1);
        this.joueur2=new Joueur(joueur2);

        Random r = new Random();
        int numDico=r.nextInt((2 - 1) + 1) + 1;
        this.dico = new Dictionnaire(numDico);

        Random rand = new Random();
        this.posMot=rand.nextInt((dico.getTaille() - 1) + 1) + 1;

        this.motRecherche=dico.getMot(this.posMot);
        //this.grille = new Grille();
    }

    public String correspondance(String mot){
        char[] resultat = new char[mot.length()];
        boolean[] match = new boolean[motRecherche.length()];
        /* marque les lettres à la bonne place */
        for(int i = 0; i<mot.length();i++){
            char c =mot.charAt(i);
            if (c==motRecherche.charAt(i)){
                resultat[i]='X';
                match[i]=true;
            }else{
                resultat[i]='*';
                match[i]=false;
            }
        }
        //marque les lettres à la mauvaise place

        for(int i = 0; i<mot.length();i++){
            if (resultat[i]=='*'){
                char c = mot.charAt(i);
                int start = 0;
                while (start>=0 && start<motRecherche.length()){
                    int j = motRecherche.indexOf(c, start);
                    if (j>=0 && !match[j]){
                        resultat[i] = 'm';
                        match[j]=true;
                        start=-1;
                    }else
                        start=(j>=0?j+1:j);
                }
            }
        }
        this.tour++;
        return new String(resultat);
    }

    public int getposMot() {
        return posMot;
    }

    public String getMotRecherche() {
        return motRecherche;
    }

    private int posMot;

    public Dictionnaire getDico() {
        return dico;
    }
}
