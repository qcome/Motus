package modele;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Quentin on 08/09/2016.
 */
public class Fenetre extends JFrame {
    private Panneau pan = new Panneau();
    public Fenetre(){
        //creation fenetre
        //titre
        this.setTitle("Motus");
        //taille fenetre
        this.setSize(300,300);
        //position centre écran
        this.setLocationRelativeTo(null);

        //jpanel
        this.setContentPane(pan);

        //fin du processus quand clique croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fenetre visible
        this.setVisible(true);
        go();
    }
    private void go(){
        for (int i = -50; i< pan.getWidth(); i++){
            int x = pan.getPosX(), y=pan.getPosY();
            x++;
            y++;
            pan.setPosX(x);
            pan.setPosY(y);
            pan.repaint();
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
