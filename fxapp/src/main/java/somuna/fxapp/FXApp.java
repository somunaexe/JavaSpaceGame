package somuna.fxapp;

import javafx.application.Application;
import javafx.stage.Stage;
import somuna.fxapp.views.View;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class FXApp extends Application{
	protected Model model;
	protected View view;
	protected Controller controller;
	private Pane root = new Pane();
	private Scene scene = new Scene(root, 800, 600);
		
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Space Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		model = new Model();
		view = new View(root, model, scene);
		controller = new Controller(model, view);
	}
}
