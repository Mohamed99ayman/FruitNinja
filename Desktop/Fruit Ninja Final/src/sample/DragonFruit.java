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

public class DragonFruit extends SpecialFruit {
    File input = new File("dragonfruit.png");

    public DragonFruit(){
        t=1;
        Random r=new Random();
        Random axis = new Random();
        //under the canvas

            x = 900;
        //in the middle of the canvas
        y=250+r.nextInt(100);
        xspeed=9+r.nextFloat();
        yspeed=(r.nextFloat()-0.5)*1.5;
        circle=new Circle(x,y,20, Color.BLUE);

        try {
            bf = ImageIO.read(input);
        } catch (IOException ex) {
            Logger.getLogger(WaterMelon.class.getName()).log(Level.SEVERE, null, ex);
        }
        image = SwingFXUtils.toFXImage(bf, null);
    }
    File sliced = new File("dragonfruit-sliced.png");
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