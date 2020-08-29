package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static sample.Main.currentStage;

//import java.awt.*;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {

    public static GameView gameView;
    public static GameController gameController;
    public static int level = 0;
    @FXML
    Button classicModeButton;
    @FXML Button arcadeModeButton;
    @FXML ImageView backGroundImage;
    @FXML ImageView characterImage;
    @FXML RadioButton easyButton,hardButton,insaneButton;
    Circle circle = new Circle(100,100,25);
    Invoker invokerSliceSound = new Invoker(new PlaySlicingSound());
    Invoker invokerBackGroundSound = new Invoker(new PlayBackGroundMusic());




    Fruit waterMelon=new WaterMelon();
    Background bg=new Background();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FontLoader fontLoader=null;
        try {
            fontLoader = new FontLoader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        classicModeButton.setFont(fontLoader.getFont());
        arcadeModeButton.setFont(fontLoader.getFont());
        easyButton.setFont(fontLoader.getFont());
        hardButton.setFont(fontLoader.getFont());
        insaneButton.setFont(fontLoader.getFont());
        classicModeButton.setTextFill(Color.YELLOW);
        arcadeModeButton.setTextFill(Color.YELLOW);
        easyButton.setTextFill(Color.YELLOW);
        hardButton.setTextFill(Color.YELLOW);
        insaneButton.setTextFill(Color.YELLOW);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        insaneButton.setVisible(false);
        characterImage.setDisable(true);
        invokerBackGroundSound.press();
        Image backGround = new Image("fruit ninja background.jpg");
        Image character = new Image("Character 1.png");
        backGroundImage.setImage(backGround);
        characterImage.setImage(character);
    }

    public void classicModeButtonClicked(ActionEvent event)throws Exception{
        invokerSliceSound.press();
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        insaneButton.setVisible(true);
        /*gameController = new GameController();
        gameView = GameView.getInstance();
        gameView.engineStart();*/
        }
    public void arcadeModeButtonClicked(ActionEvent event)throws Exception{
        /*Invoker invoker = new Invoker(new PlaySlicingSound());
        invoker.press();*/
        //level = 4;
        //setLevel(level);
        GameModel gameModel = GameModel.getInstance();
        gameModel.setLevel(4);
        invokerSliceSound.press();
        gameController = new GameController();
        gameView = GameView.getInstance();
        gameView.engineStart();
        gameController.loadGame();
    }
    public void easyButtonClicked(ActionEvent event)throws Exception{

        //level = 1;
        //setLevel(level);
        GameModel gameModel = GameModel.getInstance();
        gameModel.setLevel(1);
        gameController = new GameController();
        gameView = GameView.getInstance();
        gameView.engineStart();
        gameController.loadGame();

    }
    public void hardButtonClicked(ActionEvent event)throws Exception{

        //level = 2;
        //setLevel(level);
        GameModel gameModel = GameModel.getInstance();
        gameModel.setLevel(2);
        gameController = new GameController();
        gameView = GameView.getInstance();
        gameView.engineStart();
        gameController.loadGame();

    }
    public void insaneButtonClicked(ActionEvent event)throws Exception{

        //level = 3;
        GameModel gameModel = GameModel.getInstance();
        gameModel.setLevel(3);
        //setLevel(level);
        gameController = new GameController();
        gameView = GameView.getInstance();
        gameView.engineStart();
        gameController.loadGame();
    }

}