package application;

import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ToggleController 
{
	
    @FXML
    private JFXHamburger ham;
    @FXML
    public Label appTitle;
    
    public void initialize()
    {
    	appTitle.textProperty().bind(Main.appTitle);
    	HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(ham);
    	transition.setRate(-1);
    ham.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->
	{
		
		if(transition.getRate() == 1)
		{
			
			BorderPane borderCurrent = Main.getRoot();
			try {
				borderCurrent.getLeft().setUserData("None");
				borderCurrent.getLeft().toBack();
				transition.setRate(-1);
				transition.play();
		}
		catch (Exception e2) 
		{
			
		}
		   
		}
		else
		{
	
			try 
			{
				URL navigateUrl = getClass().getResource("Navigate.fxml");
				VBox navigate;
				navigate = FXMLLoader.load( navigateUrl );
				BorderPane borderCurrent = Main.getRoot();
				borderCurrent.setLeft(navigate);
				borderCurrent.getLeft().setUserData("Navigation");
				transition.setRate(1);
				transition.play();
			}
			catch (IOException e1) 
			{
				
			}
		}
	});
    }
}