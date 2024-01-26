package somuna.fxapp.views;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import somuna.fxapp.Space;
import somuna.fxapp.Model;

public class View {
	protected Pane root;
	protected Model model;
	protected Scene scene;
	protected Canvas canvas = new Canvas(800, 600);
	protected GraphicsContext gc = canvas.getGraphicsContext2D();
	protected Label nameLabel = new Label();
	protected Button playButton;
	protected Label textLabel = new Label();
	protected Space space = new Space(800, 600, gc);
	
	public View(Pane root, Model model, Scene scene) {
		super();
		this.root = root;
		this.model = model;
		this.scene = scene;
	    textLabel.setText("Hey! I'm so glad you chose to join my astronaut journey. \n For each planet you learn about, you will earn points. Click the button to learn!");
	    Font font = Font.font("Arial", FontWeight.BOLD, 14);
	    textLabel.setFont(font);
	    textLabel.setTextFill(Color.WHITE);
	    textLabel.setLayoutX(80);
		textLabel.setLayoutY(515);
	    playButton = new Button("Next");
	    playButton.setLayoutX(380);
	    playButton.setLayoutY(560);
	    playButton.setOnAction(e -> changePlanet(e));
		root.getChildren().addAll(canvas, textLabel, playButton); 
	}

	public void changePlanet(ActionEvent event) {
        new MercuryView(root, model, scene);
        model.setCurrentPlanet("mercury.png");
        model.setPoints(model.getPoints() + 10);
	}
}	 
