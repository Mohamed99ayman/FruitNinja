package sample;

import javafx.scene.media.AudioClip;

public class PlaySlicingSound implements ICommand {
    @Override
    public void unexecute() {

    }

    AudioClip audioClip = new AudioClip(this.getClass().getResource("Cutting sound.mp3").toString());
    @Override
    public void execute() {
        audioClip.play();
    }
}
