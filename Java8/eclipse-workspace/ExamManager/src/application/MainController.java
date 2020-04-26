package application;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
	public Button button1 = new Button();
    public Button button2 = new Button();


    public void button1Pressed(ActionEvent e) throws IOException
    {
    	
    	Parent root1 = FXMLLoader.load(getClass(). getResource("Main0.fxml"));
    	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        Scene scene1 = new Scene(root1,width-20,height-90);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		File in=new File("out.txt");
    	in.delete();
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setTitle("iExamManager");
		window.setScene(scene1);
		window.show();
		
    }
    public void button2Pressed(ActionEvent e) throws IOException
    {
    	
    	Parent root1 = FXMLLoader.load(getClass(). getResource("Main2.fxml"));
    	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        Scene scene1 = new Scene(root1,width-20,height-90);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		File in=new File("jout.txt");
    	in.delete();
    	
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setTitle("iExamManager");
		window.setScene(scene1);
		window.show();
    }

    }    


