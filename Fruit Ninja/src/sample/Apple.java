package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Apple extends Fruit {
    File input = new File("apple.png");

    public Apple(){
        t=1;
        Random r=new Random();
        //under the canvas
        y=750;
        //in the middle of the canvas
        x=400+r.nextInt(100);
        yspeed=9+r.nextFloat();
        xspeed=(r.nextFloat()-0.5)*1.5;
        circle=new Circle(x,y,20, Color.BLUE);

        try {
            bf = ImageIO.read(input);
        } catch (IOException ex) {
            Logger.getLogger(WaterMelon.class.getName()).log(Level.SEVERE, null, ex);
        }
        image = SwingFXUtils.toFXImage(bf, null);
    }
    File sliced = new File("sliced-apple.png");
    public Image getSlicedImage(){
        BufferedImage b = null;
        try {
            b = ImageIO.read(sliced);
        } catch (IOException ex){
            Logger.getLogger(WaterMelon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SwingFXUtils.toFXImage(b,null);
    }
    public void setImage(Image img){
        image = img;
    }
}