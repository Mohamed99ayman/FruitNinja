package sample;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static sample.MainMenu.gameController;

public class GameModel{



    private static GameModel instance = null;
    private int score;
    private int lives = 3;
    private Time time;
    int combo =0;
    private boolean gameType;
    private static int level;
    public static int easyScore = 0;
    public static int hardScore = 0;
    public static int insaneScore = 0;
    public static int arcadeScore = 0;
    SaveLoad saveLoad = new SaveLoad();
    Factory factory = new Factory();

//    GameController gameController = new GameController();




    private GameModel(){

    }

    public static GameModel getInstance(){
        if(instance ==null) {
            instance = new GameModel();
            return instance;
        }
        else
            return instance;
    }

    public void removeLive(){
        lives--;
        if(lives==0)
            gameController.loseGame();
    }
    public List<GameObject> generateFruits(){
        //TODO: generate random objects through factory
        List<GameObject> fruits=new ArrayList<>();
        Random r=new Random();
        int x=0;
        if(!gameType)
            x=5;
        for (int i = 0; i < r.nextInt(fruitsBound)+x; i++) {
            fruits.add(factory.makeFruit(r.nextInt(5)));
           // System.out.println(i);
        }
        GameObject specialFruit =factory.makeSpecialFruit(r.nextInt(specialFruitsBound));
        GameObject bomb = factory.makeBomb(r.nextInt(bombsBound));
        if(bomb!=null)
             if(!gameType&&bomb.getClass()==DangerousBomb.class)
                 bomb = null;
        if(specialFruit!=null)
                if(!gameType&& specialFruit.getClass()==Pomegranate.class)
                    specialFruit=null;
        if(specialFruit!=null)
        fruits.add(specialFruit);
        if(bomb!=null)
        fruits.add(bomb);
        return fruits;
    }
    public SpecialFruit makeSpecialFruit(){
        Random r = new Random();
        SpecialFruit specialFruit = factory.makeSpecialFruit(r.nextInt(2));
        return specialFruit;
    }
    public int getScore() {
        return score;
    }

    public static int getLevel() {
        return level;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void handleSliced(GameObject object){
        if(object.getClass().equals(WaterMelon.class)||object.getClass().equals(Apple.class)||object.getClass().equals(Pineapple.class)||object.getClass().equals(Orange.class)||object.getClass().equals(Mango.class))
            score = score+1;
    //   else if(object.getClass().equals(DragonFruit.class)||object.getClass().equals(Pomegranate.class))
      //  {
            else if(object.getClass().equals(DragonFruit.class))
                score = score+25;
            else if(object.getClass().equals(Pomegranate.class))
            {
                if(lives <3) {
                    lives++;
                    //TODO: show add life message
                    gameController.showLivesLabels();
                   // gameController.addLife();
                    //gameController.removeCross();
                }
            }
      //  else if(object.getClass().isInstance(Bomb.class))
        //{
            else if(object.getClass().equals(DangerousBomb.class))
            {
                if(lives>0) {
                    lives--;
                    combo =0;
                    //TODO: show labels of lives
                    gameController.showLivesLabels();
                    //gameController.showLivesLabel
                }
                if(lives==0){
                    gameController.loseGame();
                }
            }
            if(object.getClass().equals(FatalBomb.class)){
                lives =0;
                gameController.showLivesLabels();
               // gameController.showScore();
                gameController.loseGame();

            }
        gameController.showScore();

    }

    public Bomb makeBomb(){
        Factory factory = new Factory();
        Random r = new Random();
        Bomb bomb = factory.makeBomb(r.nextInt(3));
        return bomb;
    }
    public void addScore(int amount){
        score+=amount;
        gameController.showScore();
    }
    public void checkOutOfBoundries(List<GameObject>fruits){
        Iterator<GameObject> it= fruits.iterator();
        GameObject fruit;
        while (it.hasNext())
        {
            fruit=it.next();
            if(fruit.getClass()==Pomegranate.class||fruit.getClass()==DragonFruit.class){
                if(fruit.getX()<-150){
              //      System.out.println(fruit.getX());

                    it.remove();

                }
        }
            else if(fruit.getY()>750)
            {
                it.remove();
                if(!fruit.isSliced() &&  !fruit.getClass().equals(FatalBomb.class) && !fruit.getClass().equals(DangerousBomb.class)&& gameType) {
                    lives--;
                    gameController.showLivesLabels();
                    if(lives==0)
                        gameController.loseGame();
                }

            }
        }
    }

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }

    public void sliceFruits(List<GameObject>fruits, double x, double y){
        Iterator<GameObject>it= fruits.iterator();
        GameObject fruit;
        while (it.hasNext()){
            fruit=it.next();
            if(fruit.getCircle().contains(x,y)){
                if(!fruit.isSliced()) {
                    fruit.slice();
                    fruit.setImage(fruit.getSlicedImage());
                    // System.out.println("Sliced");
                    //gameController.handleSliced(fruit);
                    handleSliced(fruit);
                    combo++;
                }
            }
        }
        //addScore(combo);
        gameController.showScore();
    }
    public void updateComboScore() {
        int amount = 1;
        if (combo > 2) {
            for (int i = 1; i < combo; i++) {
                //amount *= i;
                 amount = combo*5;
            }
            score = score + amount;
            gameController.showScore();
            Invoker invoker = new Invoker(new PlayComboSound());
            invoker.press();
            combo = 0;
        }
    }
    int fruitsBound;
    int bombsBound;
    int specialFruitsBound;
    public void setLevel(int level){
        this.level = level;
        gameType = true;
        if(level == 1)
        {
            fruitsBound = 5;
            specialFruitsBound = 6;
            bombsBound = 4;
        }else if(level == 2)
        {
            bombsBound=3;
            specialFruitsBound=7;
            fruitsBound=7;

        }else if(level == 3)
        {
            fruitsBound =10;
            specialFruitsBound=8;
            bombsBound=2;
        }
        else if(level==4){
            gameType = false;
            fruitsBound =10;
            specialFruitsBound=8;
            bombsBound=2;
        }
    }

    public static int getEasyScore() {
        return easyScore;
    }

    public static void setEasyScore(int easyScore) {
        GameModel.easyScore = easyScore;
    }
    public static int getHardScore() {
        return hardScore;
    }

    public static void setHardScore(int hardScore) {
        GameModel.hardScore = hardScore;
    }
    public static int getInsaneScore() {
        return insaneScore;
    }

    public static void setInsaneScore(int insaneScore) {
        GameModel.insaneScore = insaneScore;
    }
    public static int getArcadeScore() {
        return arcadeScore;
    }

    public static void setArcadeScore(int arcadeScore) {
        GameModel.arcadeScore = arcadeScore;
    }
    public void saveGame(){
        saveLoad.Save();
    }
    public void loadGame(){
        saveLoad.Load();
    }
    public void resetScore(){

        setScore(0);
    }
}
