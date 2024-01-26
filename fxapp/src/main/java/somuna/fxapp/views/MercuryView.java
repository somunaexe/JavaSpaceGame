package somuna.fxapp.views;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import somuna.fxapp.Model;
import somuna.fxapp.PlanetFactory;
import somuna.fxapp.PlanetInterface;
import somuna.fxapp.Space;

public class MercuryView extends View{
	Space space;
	PlanetFactory factory;

	public MercuryView(Pane root, Model model, Scene scene) {
		super(root, model, scene);
		space = new Space(800, 600, gc);
		factory = new PlanetFactory(310, 200, gc, "mercury.png");
		PlanetInterface planetInt = factory.createPlanet("mercury.png");
	    textLabel.setText(planetInt.writeDescription()); 
	    Font font = Font.font("Arial", FontWeight.BOLD, 14);
	    textLabel.setFont(font);
		textLabel.setLayoutX(150);
		textLabel.setLayoutY(410);
	    playButton.setOnAction(e -> changePlanet(e));
	}

	public void changePlanet(ActionEvent event) {
		new VenusView(root, model, scene);
		model.setPoints(model.getPoints() + 10);
	}
	
}