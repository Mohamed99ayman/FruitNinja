package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.image.BufferedImage;

public abstract class SpecialFruit implements GameObject{

    boolean sliced=false;
    int x;
    int y;
    double yspeed;
    double xspeed;
    double t;
    BufferedImage bf=new BufferedImage(100,200,BufferedImage.TYPE_INT_RGB);
    javafx.scene.image.Image image;
    Circle circle;
    ImageView imageView = new ImageView();
    SnapshotParameters parameters=new SnapshotParameters();
    Image snapshot;

    public ImageView getImageView(){
        imageView.setImage(image);
        return imageView;
    }

    public void setCircle(double x, double y) {
        this.circle.setCenterX(x);
        this.circle.setCenterY(y);
        this.circle.setRadius(50);
    }
    public Circle getCircle() {
        return circle;
    }


    public void update(){
        parameters.setFill(Color.TRANSPARENT);
        x-=xspeed*t;
        y+=yspeed;
        t+=(0.012);
        setCircle(x+55,y+55);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Image getImage() {
        imageView.setRotate(getImageView().getRotate()+1);
        // System.out.println(imageView.getRotate());
        snapshot=imageView.snapshot(parameters,null);
        return snapshot;
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