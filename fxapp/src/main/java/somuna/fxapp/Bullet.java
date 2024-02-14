package somuna.fxapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Objects;

public class Bullet extends GameObject{
    protected Clip clip;
    protected AudioInputStream stream;
    public Bullet(double x, double y, GraphicsContext gc) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        super(x, y, gc);
        img = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("bullet.png")));
        this.clip = AudioSystem.getClip();
        stream = AudioSystem.getAudioInputStream(Objects.requireNonNull(this.getClass().getResourceAsStream("collision.mp3")));
    }

    public void move() {
        y -= dy;
        update();
    }

    public void playMusic() throws LineUnavailableException, IOException {
        clip.open(stream);
        clip.start();
    }
}
