package somuna.fxapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlanetFactory extends GameObject {
	String planet;
	
	public PlanetFactory(double x, double y, GraphicsContext gc, String currentPlanet) {
		super(x, y, gc);
		this.planet = currentPlanet;
		img = new Image(Space.class.getResource(this.planet).toExternalForm());
		gc.drawImage(img, x, y, 200, 200);
	}
	
	public PlanetInterface createPlanet(String currentPlanet) {
		PlanetInterface planetInt = null;
		if(this.planet.equals("mercury.png")) {
			planetInt = new Mercury();
		} else if(this.planet.equals("venus.png")) {
			planetInt = new Venus();
		} else if(this.planet.equals("earth.png")) {
			planetInt = new Earth();
		} else if(this.planet.equals("mars.png")) {
			planetInt = new Mars();
		} else if(this.planet.equals("jupiter.png")) {
			this.planet = "jupiter.png";
			planetInt = new Jupiter();
		} else if(this.planet.equals("saturn.png")) {
			planetInt = new Saturn();
		} else if(this.planet.equals("uranus.png")) {
			planetInt = new Uranus();
		} else if(this.planet.equals("neptune.png")) {
			planetInt = new Neptune();
		} else {
            throw new IllegalArgumentException("Invalid planet type: " + currentPlanet);
        }
        return planetInt;
	}
}
