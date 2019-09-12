package sample;

import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

import java.awt.image.BufferedImage;

public interface GameObject {

    public void setCircle(double x, double y);

    public Circle getCircle();

    public void update();

    public double getX();

    public double getY();

    public Image getImage();

    public void slice();

    public void setImage(Image img);

    public Image getSlicedImage();

    public boolean isSliced();
}