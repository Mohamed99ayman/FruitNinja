package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cross {
    javafx.scene.image.Image image;
    BufferedImage bf= new BufferedImage(100,200,BufferedImage.TYPE_INT_RGB);
    public Cross(){
        File input =new File("clearResized.png");
        try {
            bf = ImageIO.read(input);
        } catch (IOException ex) {
            Logger.getLogger(Cross.class.getName()).log(Level.SEVERE, null, ex);
        }
        image = SwingFXUtils.toFXImage(bf, null);

    }

    public Image getImage() {
        return image;
    }

}