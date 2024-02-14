package somuna.fxapp;

import java.util.ArrayList;

public class Model {
	protected int points;
	protected String currentDescription;
	protected ArrayList<String> descriptions;
	
	public Model() {
		points = 0;
		descriptions = new ArrayList<>();
		descriptions.add("Here is the first and smallest planet in the solar system and closest to the Sun. \n It has a heavily cratered surface and no atmosphere.");
		descriptions.add("Venus is the second planet from the sun and the hottest planet in our solar system. \n It has a thick atmosphere of carbon dioxide, making it unsuitable for human life. \n It is also known for its bright appearance as a morning star or evening star.");
		descriptions.add("Our home planet, Earth is the third planet from the Sun and the only known planet with life. \n It has a diverse ecosystem and a protective atmosphere.");
		descriptions.add("The moon is Earth's natural satellite, orbiting around our planet. It is the brightest object in the night sky after the sun and plays a vital role in Earth's climate, tides, and ecosystems.");
		descriptions.add("The fourth planet from the Sun. \n Mars is a rocky world with a thin atmosphere and evidence of liquid water in the past.");
		descriptions.add("The asteroid belt is a region of space located between the orbits of Mars and Jupiter, where numerous small celestial bodies called asteroids are found.");
		descriptions.add("The largest planet in the solar system. \n Jupiter is a gas giant with a strong magnetic field, many moons. \n It also has a great red spot that is a massive storm.");
		descriptions.add("The second-largest planet and sixth planet in the solar system. \n Saturn is a gas giant with a system of rings made of ice and rock particles.");
		descriptions.add("The seventh planet from the Sun. \n Uranus is a gas giant with a tilted axis that causes extreme seasons and many moons.");
		descriptions.add("The eighth and farthest planet from the Sun. \n Neptune is a gas giant with the strongest winds in the solar system. \n It also has a system of moons and rings.");
		descriptions.add("The sun is a luminous star at the center of our solar system, providing light, heat, and energy to the planets orbiting around it.");
		currentDescription = descriptions.get(0);
	}
	
	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getCurrentPlanet() {
		return currentDescription;
	}

	public void setCurrentPlanet(String currentDescription) {
		this.currentDescription = currentDescription;
	}
}
