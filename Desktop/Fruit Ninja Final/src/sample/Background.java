package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Background {

    BufferedImage bg=new BufferedImage(100, 200, BufferedImage.TYPE_INT_RGB);
    javafx.scene.image.Image image;

    public Background(){
        File input = new File("BackGround.jpg");
        try {
            bg = ImageIO.read(input);
        } catch (IOException ex) {
            Logger.getLogger(Fruit.class.getName()).log(Level.SEVERE, null, ex);
        }
        image = SwingFXUtils.toFXImage(bg, null);
    }
    public Image getImage() {
        return image;
    }
}
