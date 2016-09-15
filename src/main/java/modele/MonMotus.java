package modele;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.util.converter.CharacterStringConverter;

/**
 * Created by o2122505 on 06/09/16.
 */
public class MonMotus extends Application  {

    IFacadeMotus maFacade;
    String[] tab, tabJoueur, tabSaisie;
    Stage window;
    Scene scene1, scene2, sceneJeu;
    String joueurActuel;
    String mot, motPartie;
       StringBuilder     aideMotSuivant;
    boolean b =false;
    int Tour=0;

    public static void main(String[]args){

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Motus");
        aideMotSuivant=new StringBuilder("_______");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //name label bienvenu
        Text bienvenu = new Text("Bienvenue");
        bienvenu.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(bienvenu, 0, 0, 2, 1);

        //Name1 Label - constrains use (child, column, row)
        Label luser1 = new Label("Joueur 1:");
        GridPane.setConstraints(luser1, 0, 1);

        //Name1 Input
        TextField user1 = new TextField();
        GridPane.setConstraints(user1, 1, 1);


        //Name2 Label
        Label luser2 = new Label("Joueur 2:");
        GridPane.setConstraints(luser2, 0, 2);

        //Name2 Input
        TextField user2 = new TextField();
        GridPane.setConstraints(user2, 1, 2);

        //diffeculte label
        Label diffLabel = new Label("Difficulté:");
        GridPane.setConstraints(diffLabel, 0, 3);

        //choicebox
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("87 mots");
        choiceBox.getItems().add("25444 mots");
        choiceBox.setValue("Facile");
        GridPane.setConstraints(choiceBox, 1, 3);

        //vue 2


        //Button valider
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 6);
        loginButton.setOnAction(e -> {
            if (!TraitementValidationMenu(user1.getText(), user2.getText())){
                AlertBox.display("Erreur", "Le choix de pseudos est nécessaire pour démarrer la partie");
            }else{
                InitialiserPartie(user1.getText(), user2.getText(), choiceBox.getValue());
                System.out.println(choiceBox.getValue());
                // window.show();
            }
        });


        //Add everything to grid
        grid.getChildren().addAll(bienvenu, user1, luser1, user2, luser2,diffLabel, choiceBox, loginButton);

        Scene scene = new Scene(grid, 500, 350);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.show();
    }
    private boolean InitialiserPartie(String j1, String j2, String difficulte) {
        maFacade = new FacadeMotus();
        tab = new String[7];
        tabSaisie = new String[7];
        if(maFacade.creationPartie(j1,j2, difficulte)) {
            System.out.println("Partie créée oklm!");
            System.out.println();
            motPartie=maFacade.getMotRecherche(j1);
            //tab
            tab = new String[7];
            tabSaisie = new String[7];
            for (int i = 0; i < 7; i++) {
                tab[i] = "";
                tabSaisie[i] = "";
            }
            //tabJoueur
            tabJoueur = tabJoueur(j1, j2);
            joueurActuel = tabJoueur[0];
            TourPartie(joueurActuel, tab);


/*

            for(int i=0;i<7;i++){

                System.out.println(mot);
                String Resultat = maFacade.jouer(joueurActuel, mot);

                if (!(Resultat.equals("XXXXXXX"))){
                    System.out.println(Resultat);
                }
                else{
                    System.out.println(Resultat);
                }
                System.out.println();
                System.out.println();
                if (Resultat.equals ("XXXXXXX")){
                    System.out.println("------GG------");
                    System.out.println();
                    System.out.println();
                    break;
                }
            }
            System.out.println("----------FIN-DU-GAME----------");
            System.out.println("Le mot recherché était:'"+maFacade.getMotRecherche(j1)+"'");
            System.out.println();
            System.out.println();
            System.out.println("Refaire une partie? o/n");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            String reponse = sc.nextLine();
            return (reponse.charAt(0)=='o');
        }else{
            System.out.println("ERREUR");
            return false;
        }*/
        }
        return true;
    }

    public void TourPartie(String user, String[] tab){
System.out.println(motPartie);
        GridPane gridJeu = new GridPane();
        gridJeu.setAlignment(Pos.CENTER);
        gridJeu.setPadding(new Insets(10, 10, 10, 10));
        gridJeu.setVgap(8);
        gridJeu.setHgap(10);


    aideMotSuivant.setCharAt(0, motPartie.charAt(0));
if(Tour != 0){
    for (int i = 1; i < 7; i++) {
        if (aideMotSuivant.charAt(i) == '_') {
            if (tab[Tour-1].charAt(i) == 'X') {
                aideMotSuivant.setCharAt(i, mot.charAt(i));
            }
        }
    }
}
        System.out.println(aideMotSuivant);
        Tour++;

        //VBox layoutJeu = new VBox(10);
        //Label labelUser1 = new Label(user1 + ", à toi de jouer:");
        //Label labelUser2 = new Label(user2 + ", à toi de jouer:");
        Label vide = new Label("");
        //zdazdazdazd
        //boolean nouvellePartie;
        //do{
        //   nouvellePartie=LancerPartie(user1, user2);
        //}while(nouvellePartie);
        //tab.toString();
        //tabSaisie.toString();
        //tableau jeu
        Text title = new Text("Data");
        Boolean bool=true;
        Boolean boolbis = true;
        //pour chaque ligne
        for (int i = 1 ; i<8 ; i++){
            //System.out.println(tabSaisie[i-1]);
            //pour chaque char
            for (int j = 1 ; j<8 ; j++) {

                if (!tab[i - 1].equals("")) {
                    //System.out.println(tab[i-1].charAt(j-1));
                    //System.out.println(tabSaisie[i-1].charAt(j-1));
                    //System.out.println(tabSaisie[0]);
                    //System.out.println(mot.charAt(j-1));

                    Label l = new Label(Character.toString(tabSaisie[i - 1].charAt(j - 1)));
                    l.setPrefWidth(10);
                    // l.setBackground();
                    if (tab[i - 1].charAt(j - 1) == 'm') {
                        l.setStyle("-fx-background-color: green");

                    } else if (tab[i - 1].charAt(j - 1) == 'X') {
                        l.setStyle("-fx-background-color: red");
                    }
                    //Label l = new Label (Character.toString(mot.charAt(j-1)));
                    //Label l = new Label (Character.toString(tabSaisie[i-1].charAt(j-1)));

                    GridPane.setConstraints(l, j, i);
                    gridJeu.getChildren().add(l);
                    boolbis=false;

                    //affichage tours non fait
                } else {
                    if(i==Tour){

                    }
                    Label l;
                    if (!bool && i>Tour) {
                        l = new Label("_");


                        //ligne suivante
                    }else  {

                            l = new Label(Character.toString(aideMotSuivant.charAt(j - 1)));


                        if(aideMotSuivant.charAt(j - 1)!='_'){
                            l.setStyle("-fx-background-color: red");
                        }

                    }
                    l.setPrefWidth(10);

                    GridPane.setConstraints(l, j, i);


                    gridJeu.getChildren().add(l);
                    bool = false;
                }
            }

        }
        TextField answer = new TextField();
        answer.setPrefWidth(150);
        GridPane.setConstraints(answer, 0, 9, 8, 1);

        GridPane.setConstraints(vide, 0, 7, 8, 1);

        Text tourMessage = new Text(user + ", à toi de jouer:");
        tourMessage.setFont(Font.font("Tahoma", FontWeight.NORMAL, 13));
        tourMessage.setFill(Color.BEIGE);
        GridPane.setConstraints(tourMessage, 0, 8, 8, 1);

        Button validate = new Button("Valider");
        GridPane.setConstraints(validate, 0, 10, 8, 1);


        gridJeu.getChildren().addAll(vide, tourMessage, answer, validate);
        validate.setOnAction(e ->
                FinTourPartie(answer.getText(), user)
        );

        //GridPane.setConstraints(labelUser1, 0, 0);
        //GridPane.setConstraints(labelUser2, 0, 1);

        //gridJeu.getChildren().addAll(labelUser1, labelUser2);

        sceneJeu = new Scene(gridJeu, 500, 350);
        sceneJeu.getStylesheets().add("style.css");

        window.setScene(sceneJeu);
    }
    public void FinTourPartie(String mot, String user){

        for (int i=0; i<7;i++){
            System.out.println(tabSaisie[i]);
        }
        tabSaisie[maFacade.getTour(user)-1]=mot;
        for (int i=0; i<7;i++){
            System.out.println(tabSaisie[i]);
        }
        //System.out.println(Character.toString(tabSaisie[0].charAt(0)));
        this.mot=mot;
        String Resultat = maFacade.jouer(joueurActuel, mot);
        tab[maFacade.getTour(user)-2]=Resultat;



        if (!(Resultat.equals("XXXXXXX"))){
            System.out.println(Resultat);
            TourPartie(user, tab);
        }
        else{
            System.out.println(Resultat);
        }
        System.out.println();
        System.out.println();
        if (Resultat.equals ("XXXXXXX")){
            System.out.println("------GG------");
            System.out.println();
            System.out.println();
        }


    }


public boolean TraitementValidationMenu(String user1, String user2){
 if(!user1.equals("") && !user2.equals(""))
     return true;
 else
     return false;

}

    private static int alea(int maxValue){
        Random randGen = new Random();
        return (randGen.nextInt(maxValue));
    }
    private static String[] tabJoueur(String a, String b){
        String[] tab = new String[7];
        int random = alea(2);
        if (random==1){
            for (int i=0; i<7;i++){
                if (i%2 == 0)
                    tab[i]=a;
                else
                    tab[i]=b;
            }
        }else{
            for (int i=0; i<7;i++){
                if (i%2 == 0)
                    tab[i]=b;
                else
                    tab[i]=a;
            }
        }
        return tab;
    }


}
