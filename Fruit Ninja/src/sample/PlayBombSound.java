package sample;

import javafx.scene.media.AudioClip;

import javax.swing.*;

public class PlayBombSound implements ICommand {
    AudioClip audioClip = new AudioClip(this.getClass().getResource("Explosion2.mp3").toString());

    @Override
    public void unexecute() {

    }

    @Override
    public void execute() {
        audioClip.play();
    }
}
