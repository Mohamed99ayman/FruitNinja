package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static sample.GameModel.arcadeScore;
import static sample.GameModel.insaneScore;
import static sample.MainMenu.gameController;
import static sample.MainMenu.gameView;

public class GameController{
    //GameView gameView = GameView.getInstance();
    GameModel gameModel = GameModel.getInstance();
    //private static GameController instance = null;
   // FruitFactory fruitFactory = new FruitFactory();

    /*   private GameController(){

    }
    public static GameController getInstance(){
        if(instance==null){
            instance = new GameController();
            return instance;
        }
        return instance;
    }*/
    public void handleSliced(GameObject obj){
        gameModel.handleSliced(obj);
    }

//    public void addSpecialScore(){
  //      gameModel.addScore(10);
 //  }

//    public void addScore(GameObject fruit){
//
 //       //TODO: if fruit is special add more points to the score
   //     gameModel.addScore(1);

    //}
    public void addComboScore(int combo){
        gameModel.addScore(combo*combo);
    }
    public int getScore(){
        return gameModel.getScore();
    }
 //   public void removeLive(){
   //     gameModel.removeLive();
   // }
    public void loseGame(){
        //TODO: show "YOU LOST" message
        gameModel.setLives(0);
        gameView.loseGame();

        //System.out.println("YOU LOST");
    }
    public Bomb makeBomb(){
        return gameModel.makeBomb();
    }
    public SpecialFruit makeSpecialFruit(){
        return gameModel.makeSpecialFruit();
    }

 //   public List<Fruit> createGameObject() {
   //     return gameModel.generateFruits();
    //}
    public List<GameObject> generateObjects(){
        return gameModel.generateFruits();
    }
  public void showLivesLabels(){
        gameView.setLifeLabels(3-gameModel.getLives());
  }
  public void checkOutOfBoundries(List<GameObject> list){
        gameModel.checkOutOfBoundries(list);
  }
  public void sliceFruits(List<GameObject> list,double x,double y){
        gameModel.sliceFruits(list,x,y);
  }
  public void setCombo(int val){
        gameModel.setCombo(val);
  }
  public void showScore(){
        gameView.showScore();
  }
  public void updateComboScore(){
        gameModel.updateComboScore();
  }
  public int getGameLevel(){
        return gameModel.getLevel();
  }

  public int getEasyScore(){
        return gameModel.getEasyScore();
  }
  public void setEasyScore(int easyScore){
        gameModel.setEasyScore(easyScore);
  }
    public int getHardScore(){
        return gameModel.getHardScore();
    }
    public void setHardScore(int hardScore){
        gameModel.setHardScore(hardScore);
    }
    public int getInsaneScore(){
        return gameModel.getInsaneScore();
    }
    public void setInsaneScore(int insaneScore){
        gameModel.setInsaneScore(insaneScore);
    }
    public int getArcadeScore(){
        return gameModel.getArcadeScore();
    }
    public void setArcadeScore(int arcadeScore){
        gameModel.setArcadeScore(arcadeScore);
    }

  public void saveGame(){
        gameModel.saveGame();
  }
  public void loadGame(){
        gameModel.loadGame();
  }
  public void resetScore(){gameModel.resetScore();}
  public void removeCross(){gameView.removeCross();}

}
