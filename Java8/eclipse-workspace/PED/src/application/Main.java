package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

	public static ArrayList<String> pw = new ArrayList<String>();
	public static StringProperty appTitle = new SimpleStringProperty("Find");
 
  private static BorderPane root = new BorderPane();


  public static BorderPane getRoot() {
    return root;
  }

  @Override
  public void start(Stage primaryStage) throws IOException {


    URL mainUrl = getClass().getResource("Splash.fxml");

    VBox main = FXMLLoader.load( mainUrl );


    root.setCenter(main);

    Scene scene = new Scene(root,1024,720);
    scene
      .getStylesheets()
      .add(getClass()
      .getResource("application.css")
      .toExternalForm());
    
    primaryStage.setTitle("PED");

    primaryStage.getIcons().add(new Image("img-files/PED.png"));

    primaryStage.initStyle(StageStyle.DECORATED);
    

    primaryStage.setScene(scene);
    
    primaryStage.show();

  }

  public static void main(String[] args) {
	  
    launch(args);
  
  }
  

  public static void fillPW()
	{

	  pw = new ArrayList<String>();

		Connection c = null; 
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{ 
			Class.forName("org.sqlite.JDBC");         
			c = DriverManager.getConnection("jdbc:sqlite:MASK.db");        
			c.setAutoCommit(false); 
		
			stmt = c.createStatement(); 
			
			rs = stmt.executeQuery("SELECT WORD FROM DICTIONARY");
			
			while(rs.next()) 
			{

				pw.add(rs.getString("WORD"));

			}
			
			rs.close();

			stmt.close();      

			c.close(); 
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
		
		}
		finally
		{
			Collections.sort(pw);
			try {
				rs.close();
				stmt.close(); 
				c.close(); 
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
		}
	}
  
}