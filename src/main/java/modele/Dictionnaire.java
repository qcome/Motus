package modele;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by o2122505 on 06/09/16.
 */
public class Dictionnaire {
    private int numDictionnaire;
    private String localisation;
    private int taille=0;
    private ArrayList<String> ListeMots;

    public Dictionnaire(int numDictionnaire) {
        this.numDictionnaire = numDictionnaire;
        if (numDictionnaire==1)
            this.localisation="D:/Projets/Java/Motus/src/main/java/resources/dico1";
        else
            this.localisation="D:/Projets/Java/Motus/src/main/java/resources/dico2";
        Scanner s = null;
        try {
            s = new Scanner(new File(localisation));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
            taille++;
        }
        s.close();
        this.ListeMots = list;
    }

    public boolean motExists(String s){
        if (ListeMots.contains(s))
            return false;
        else
            return true;
    }

    public String getMot(int pos){
        return ListeMots.get(pos);
    }

    public ArrayList getMots() {
        return ListeMots;
    }
    @Override
    public String toString() {
        return "Dictionnaire{" +
                "mots=" + ListeMots +
                '}';
    }
    public ArrayList<String> getListeMots() {
        return ListeMots;
    }
    public int getTaille() {
        return taille;
    }
}
