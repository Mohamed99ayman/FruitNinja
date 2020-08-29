package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.image.BufferedImage;

public abstract class Fruit implements GameObject{

    boolean sliced=false;
    int x;
    int y;
    double yspeed;
    double xspeed;
    double t;
    BufferedImage bf=new BufferedImage(100,200,BufferedImage.TYPE_INT_RGB);
    javafx.scene.image.Image image;
    Circle circle;

    public void setCircle(double x, double y) {
        this.circle.setCenterX(x);
        this.circle.setCenterY(y);
        this.circle.setRadius(50);
// this.circle.setFill(Color.WHITE);
    }
    public Circle getCircle() {
        return circle;
    }


    public void update(){
        y-=yspeed*t-3*(t*t);
        x+=xspeed;
        t+=(0.017);
        setCircle(x+55,y+55);

// Thread.sleep(10);
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    public void slice(){
        Invoker invoker1 = new Invoker(new PlaySlicingSound());
        invoker1.press();
        sliced = true;

    }
    public void setImage(Image img){

    }
    public Image getSlicedImage(){
        return null;
    }

    public boolean isSliced() {
        return sliced;
    }
}