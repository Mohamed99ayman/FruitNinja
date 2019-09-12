package sample;

import javafx.scene.media.AudioClip;

public class PlayEndGameSound implements ICommand {
    @Override
    public void unexecute() {

    }

    AudioClip audioClip = new AudioClip(this.getClass().getResource("endgame sound.mp3").toString());
    @Override
    public void execute() {
        audioClip.play();
    }
}
