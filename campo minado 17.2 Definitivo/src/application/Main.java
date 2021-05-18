package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {


	public static Stage stage;
	public static Scene Inicial;



	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		Parent fxmlInicial = FXMLLoader.load(getClass().getResource("Inicial.fxml"));
		Inicial = new Scene(fxmlInicial);
		stage.setScene(Inicial);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
