package somuna.fxapp;

public class Model {
	protected int points;
	protected String currentPlanet;
	
	public Model() {
		points = 0;
	}
	
	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getCurrentPlanet() {
		return currentPlanet;
	}

	public void setCurrentPlanet(String currentPlanet) {
		this.currentPlanet = currentPlanet;
	}
}
