package sample;

import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;

public class FontLoader  {
    Font font;
    Font gameOverFont;

    public FontLoader() throws Exception{
        font = Font.loadFont(new FileInputStream(new File("font.ttf")),34);
        gameOverFont = Font.loadFont(new FileInputStream(new File("font.ttf")), 100);

    }

    public Font getFont() {

        return font;
    }
    public Font getGameOverFont() {
    return gameOverFont;
    }

}