package application;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application 
{
	Parent root;
	Scene scene;
    Stage stage;   
    
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException 
    {
        root = FXMLLoader.load(getClass(). getResource("Main.fxml"));
        
        scene = new Scene(root,1024,720);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		stage = primaryStage;
		stage.setScene(scene);
        stage.setTitle("Criptiphy");
        stage.getIcons().add(new Image("Criptiphy_icon.png"));
        stage.setResizable(false);
        stage.show();
    }
}
