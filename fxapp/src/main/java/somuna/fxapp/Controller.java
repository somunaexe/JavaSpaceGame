package somuna.fxapp;

import javafx.scene.Scene;
import somuna.fxapp.views.*;

public class Controller {
	protected Model model;
	protected View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
}