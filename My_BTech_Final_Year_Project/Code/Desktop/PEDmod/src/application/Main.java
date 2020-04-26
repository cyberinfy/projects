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

	  //Creating an object of type Connection
		Connection c = null; 
	  //Creating an object of type Statement
		Statement stmt = null;
	  //Creating an object of type ResultSet
		ResultSet rs = null;
		
		try 
		{ 
		//This line is to say to JDBC that we are going to use sqlite Database
			Class.forName("org.sqlite.JDBC");         
		//Setting up connection
			c = DriverManager.getConnection("jdbc:sqlite:MASK.db");        
		//Setting Auto Commit feature to false
			c.setAutoCommit(false); 
		
		//Creating an object for statement to execute a query
			stmt = c.createStatement(); 
			
		//The query result will be stored into the resultSet variable rs
			rs = stmt.executeQuery("SELECT WORD FROM DICTIONARY");
			
		//This loop continues till all the elements in the result set gets iterated
			while(rs.next()) 
			{
		//Adding word from result set into our arraylist pw
				pw.add(rs.getString("WORD"));

			}
			
		//closing result set
			rs.close();
		//closing statement
			stmt.close();      
		//closing connection
			c.close(); 
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
		
		}
		finally
		{
			//Sorting the words in the array list pw
			Collections.sort(pw);
			try {
				rs.close();
				stmt.close(); 
				c.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
  
}