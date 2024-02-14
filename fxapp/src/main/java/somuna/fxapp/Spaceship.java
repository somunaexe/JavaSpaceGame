package somuna.fxapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Objects;

public class Spaceship extends GameObject {
	protected Clip clip;
	protected AudioInputStream stream;
	
	public Spaceship(double x, double y, GraphicsContext gc) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		super(x, y, gc);
		try {
			img = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("spaceship.png")));
		} catch (NullPointerException e) {
			System.err.println("Error loading spaceship.png: " + e.getMessage());
			// Handle the error or provide fallback behavior
		}
		this.clip = AudioSystem.getClip();
		//stream = AudioSystem.getAudioInputStream(Objects.requireNonNull(this.getClass().getResourceAsStream("shoot.mp3")));
	}

	public void moveLeft() {
		x -= dx;
	}
	public void moveRight() {
		x += dx;
	}
	public void moveUp() {
		y -= dy;
	}
	public void moveDown() {
		y += dy;
	}

	public void playMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		clip.open(stream);
		clip.start();
	}
}
