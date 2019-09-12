package sample;

import javafx.scene.media.AudioClip;

public class PlayBackGroundMusic implements ICommand {
    static AudioClip backGroundMusic;
    @Override
    public void execute() {
         backGroundMusic = new AudioClip(this.getClass().getResource("Game-Menu.mp3").toString());
        backGroundMusic.play();
        backGroundMusic.setCycleCount(5);
    }
    public void unexecute(){
        backGroundMusic.stop();
    }
}
