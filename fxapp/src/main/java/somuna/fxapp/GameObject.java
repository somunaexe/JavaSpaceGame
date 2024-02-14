package somuna.fxapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class GameObject {
	protected Image img;
	protected double x, y, width, height, dx, dy;
	protected GraphicsContext gc;
	protected Rectangle rectangle;
	
	public GameObject(double x, double y, GraphicsContext gc) {
		super();
		this.x = x;
		this.y = y;
		this.dx = 5;
		this.dy = 5;
		this.width = 50;
		this.height = 50;
		this.gc = gc;
		rectangle = new Rectangle(x, y, width, height);
	}

	public void updateRectangle() {
		rectangle.setX(x);
		rectangle.setY(y);
		rectangle.setWidth(width);
		rectangle.setHeight(height);
	}
	
	public void update() {
		if(img != null) {
			gc.drawImage(img, x, y, width, height);
			updateRectangle();
		}
	}
}
