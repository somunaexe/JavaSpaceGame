package somuna.fxapp.views;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import somuna.fxapp.Model;
import somuna.fxapp.Space;

public class PointsView extends View{
	Space space;

	public PointsView(Pane root, Model model, Scene scene) {
		super(root, model, scene);
		space = new Space(800, 600, gc);
	    textLabel.setText("Hurray! You have gained " + Integer.toString(model.getPoints()) + ". Way to go!"); 
	    Font font = Font.font("Arial", FontWeight.BOLD, 14);
	    textLabel.setFont(font);
		textLabel.setLayoutX(150);
		textLabel.setLayoutY(410);
		playButton.setText("Close");
		playButton.setOnAction(e -> closeProgram(e));
	}
	
	public void closeProgram(ActionEvent event) {
        Platform.exit();
	}
}
