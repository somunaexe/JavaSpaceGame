package somuna.fxapp;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Controller {
	protected Model model;
	protected View view;
	protected Spaceship sprite;
	protected ObstacleGameObject asteroid;
	protected ConcurrentHashMap<Integer, ObstacleGameObject> myObstacles;
	protected ConcurrentHashMap<Integer, Bullet> myBullets;
	protected Image obstacleImage;
	protected Image bulletImage;
	protected AnimationTimer timer;
	protected Random xAxis;
	public Controller(Model model, View view) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		this.model = model;
		this.view = view;
        sprite = new Spaceship(50, 50, view.gc);
		asteroid = new ObstacleGameObject(50, 50, this.view.gc);
		myObstacles = new ConcurrentHashMap<>();
		myBullets = new ConcurrentHashMap<>();
		obstacleImage = new Image(Objects.requireNonNull(this.getClass().getResource("mercury.png")).toExternalForm());
		bulletImage = new Image(Objects.requireNonNull(this.getClass().getResource("bullet.png")).toExternalForm());

		playMusic();
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
			sprite.update();
                try {
                    addObstacles();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(!myObstacles.isEmpty()) {
				for (int key : myObstacles.keySet()) {
					ObstacleGameObject obstacle = myObstacles.get(key);
					obstacle.move();
					if (obstacle.rectangle.getBoundsInParent().intersects(sprite.rectangle.getBoundsInParent())) { stop(); }
					if (obstacle.y >= view.canvas.getHeight()) { myObstacles.remove(key); }

					if (!myBullets.isEmpty()) {
						for (int keyB : myBullets.keySet()) {
							Bullet bullet = myBullets.get(keyB);
							bullet.move();

							if (obstacle.rectangle.getBoundsInParent().intersects(bullet.rectangle.getBoundsInParent())) {
                                try {
                                    bullet.playMusic();
                                } catch (LineUnavailableException | IOException e) {
                                    throw new RuntimeException(e);
                                }
                                myObstacles.remove(key);
								myBullets.remove(keyB);
							}
							if (bullet.y <= -bullet.height) {
								myBullets.remove(keyB);
							}
						}
					}
				}
			}
			}
		};
		this.view.scene.setOnKeyPressed(keyHandler);
		timer.start();
	}

	EventHandler<KeyEvent> keyHandler = new EventHandler<>() {
        @Override
        public void handle(KeyEvent event) {
            if ((event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) && sprite.y > 0) {
                sprite.moveUp();
            }
            if ((event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) && sprite.y < view.canvas.getHeight()) {
                sprite.moveDown();
            }
            if ((event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) && sprite.x > 0) {
                sprite.moveLeft();
            }
            if ((event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) && sprite.x < view.canvas.getWidth()) {
                sprite.moveRight();
            }
            if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.SPACE) {
                try {
                    sprite.playMusic();
                } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                }
                Bullet bullet;
                try {
                    bullet = new Bullet(sprite.x, sprite.y - sprite.height, view.gc);
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                    throw new RuntimeException(e);
                }
                myBullets.put(myBullets.size(), bullet);
            }
            if (event.getCode() == KeyCode.P) {
                timer.stop();
            }
            if (event.getCode() == KeyCode.R) {
                timer.start();
            }
        }
    };

	public void addObstacles() throws InterruptedException {
		ObstacleGameObject obstacle = new ObstacleGameObject(xAxis.nextDouble() * view.canvas.getWidth() + 1.0, -50.0, view.gc);
		Thread.sleep(3000);
		myObstacles.put(myObstacles.size(), obstacle);
	}

	public void playMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		Clip clip = AudioSystem.getClip();
		AudioInputStream stream = AudioSystem.getAudioInputStream(Objects.requireNonNull(this.getClass().getResourceAsStream("backgroundMusic.mp3")));
		clip.open(stream);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}