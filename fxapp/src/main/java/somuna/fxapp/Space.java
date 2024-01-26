package somuna.fxapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Space extends GameObject {

	public Space(double x, double y, GraphicsContext gc) {
		super(x, y, gc);
		img = new Image(Space.class.getResource("space.png").toExternalForm());
		gc.drawImage(img, 0, 0, x, y);
	}
}
