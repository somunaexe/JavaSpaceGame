package somuna.fxapp;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class View {
	protected Pane root;
	protected Model model;
	protected Scene scene;
	protected Canvas canvas = new Canvas(800, 600);
	public GraphicsContext gc = canvas.getGraphicsContext2D();
	protected Label nameLabel = new Label();
	protected Button playButton;
	protected Label textLabel = new Label();
	protected Image background;

	public View(Pane root, Model model, Scene scene) throws IOException {
		super();
		this.root = root;
		this.model = model;
		this.scene = scene;
		gc.setFill(Color.LIGHTCYAN);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		textLabel.setText("Hey! I'm so glad you chose to join my astronaut journey. \n For each planet you learn about, you will earn points. Click the button to learn!");
	    Font font = Font.font("Arial", FontWeight.BOLD, 14);
		textLabel.setFont(font);
	    textLabel.setTextFill(Color.WHITE);
	    textLabel.setLayoutX(80);
		textLabel.setLayoutY(515);

		playButton = new Button("Next");
	    playButton.setLayoutX(380);
	    playButton.setLayoutY(560);

		root.getChildren().addAll(canvas, textLabel, playButton);
	}
}
