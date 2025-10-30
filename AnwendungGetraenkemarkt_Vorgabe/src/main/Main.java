package main;

import gui.GetrankControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new GetrankControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
