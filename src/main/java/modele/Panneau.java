package modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Quentin on 08/09/2016.
 */
public class Panneau extends JPanel{

    private int posX = -50;
    private int posY = -50;

    public void paintComponent(Graphics g){
       /* int x1 = this.getWidth()/4;
        int y1 = this.getHeight()/4;
        System.out.println("Je suis executé");
        g.drawString("Bonjour", 10, 20);
        g.drawOval(x1, y1, this.getWidth()/2, this.getHeight()/2);*/

       /*
       try{
           Image img = ImageIO.read(new File("D:\\Projets\\Java\\Motus\\src\\main\\java\\resources\\maxresdefault.jpg"));
           g.drawImage(img,0,0,this);
       }catch(IOException e){
           e.printStackTrace();
        }*/

        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(), this.getHeight());

        g.setColor(Color.black);
        g.fillOval(posX, posY, 50, 50);


    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
