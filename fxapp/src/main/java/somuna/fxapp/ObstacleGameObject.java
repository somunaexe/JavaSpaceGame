package somuna.fxapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

public class ObstacleGameObject extends GameObject{

	public ObstacleGameObject(double x, double y, GraphicsContext gc) {
		super(x, y, gc);
		img = new Image(Objects.requireNonNull(this.getClass().getResource("mercury.png")).toExternalForm());
	}

	public void move() {
		y += dy;
		update();
	}
}
