package application;

import java.io.IOException;
import java.net.URL;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


public class SplashController {
	Thread mSplashThread;
	@FXML
	public ImageView loading;
	@FXML
	public void initialize()
	{
		Platform.runLater(
				  () -> {
		 loading.setImage(new Image("img-files/start_load.gif")); 
				  });
		 mSplashThread = new Thread() {
			 @Override
	            public void run() {
				 try {
				 synchronized (this) {
					
					 Main.fillPW();
					
						wait(1000);
					} 
				}
				 catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
									  try {
										  	change();
									  }
										  	catch (IOException e) {
										  		// TODO Auto-generated catch block
										  		e.printStackTrace();
						}
				
					
				}
				

	                    
		 };
	        mSplashThread.start();
	        

		 }

	@FXML
	  public void change() throws IOException {
		    URL mainUrl = getClass().getResource("Find.fxml");
		    AnchorPane main = FXMLLoader.load( mainUrl );

		    URL topUrl = getClass().getResource("Toggle.fxml");
		    HBox toggle = FXMLLoader.load( topUrl );

		    // constructing our scene using the static root
			Platform.runLater(
					  () -> {
		    Main.getRoot().setCenter(main);
		    Main.getRoot().getCenter().setUserData("Find");
		    Main.getRoot().setTop(toggle);
					  });
	  }
	}
