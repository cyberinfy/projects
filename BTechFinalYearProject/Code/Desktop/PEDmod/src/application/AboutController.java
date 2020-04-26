package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AboutController
{
    @FXML
    public AnchorPane aboutPane;
    @FXML
    Label label = new Label();
    @FXML
    Hyperlink webLink = new Hyperlink();
    @FXML
    Hyperlink googleplus = new Hyperlink();
    @FXML
    Hyperlink facebook = new Hyperlink();
    @FXML
    Hyperlink twitter = new Hyperlink();
    @FXML
    Hyperlink youtube = new Hyperlink();
    @FXML
    ImageView googleIcn = new ImageView();
    @FXML
    ImageView facebookIcn = new ImageView();
    @FXML
    ImageView twitterIcn = new ImageView();
    @FXML
    ImageView youtubeIcn = new ImageView();
    
	public void initialize() 
	{
		
		googleIcn.setImage(new Image("img-files/google-black.png"));
		facebookIcn.setImage(new Image("img-files/fb-black.png"));
		twitterIcn.setImage(new Image("img-files/twitter-black.png"));
		youtubeIcn.setImage(new Image("img-files/youtube-black.png"));
		
		ImageView googleHoverIcn = new ImageView(new Image("img-files/google-red.png"));
	    googleplus.graphicProperty().bind(
	            Bindings.when(
	            		googleplus.hoverProperty()
	            )
	                    .then(googleHoverIcn)
	                    .otherwise(googleIcn)
	    );
	    
		ImageView facebookHoverIcn = new ImageView(new Image("img-files/fb-blue.png"));
	    facebook.graphicProperty().bind(
	            Bindings.when(
	            		facebook.hoverProperty()
	            )
	                    .then(facebookHoverIcn)
	                    .otherwise(facebookIcn)
	    );
	    
		ImageView twitterHoverIcn = new ImageView(new Image("img-files/twitter-blue.png"));
	    twitter.graphicProperty().bind(
	            Bindings.when(
	            		twitter.hoverProperty()
	            )
	                    .then(twitterHoverIcn)
	                    .otherwise(twitterIcn)
	    );
	    
		ImageView youtubeHoverIcn = new ImageView(new Image("img-files/youtube-red.png"));
	    youtube.graphicProperty().bind(
	            Bindings.when(
	            		youtube.hoverProperty()
	            )
	                    .then(youtubeHoverIcn)
	                    .otherwise(youtubeIcn)
	    );
		label.setText("			We developed this application for you to have a personal offline dictionary application in which you can not only search for meanings of different words, but you can also add new words that you come across, update an existing word's meaning if you found a much better one and even delete a word if you feel that it's unnecessary. \n \nThank you for installing our application  :) ");
		label.setWrapText(true);
		
		webLink.setOnAction(e -> {
		    if(Desktop.isDesktopSupported())
		    {
		        try {
		            Desktop.getDesktop().browse(new URI("http://www.krishnasastry.me/#/projects/7"));
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        } catch (URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		googleplus.setOnAction(e -> {
		    if(Desktop.isDesktopSupported())
		    {
		        try {
		            Desktop.getDesktop().browse(new URI("https://plus.google.com/u/0/+KVRKS"));
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        } catch (URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		facebook.setOnAction(e -> {
		    if(Desktop.isDesktopSupported())
		    {
		        try {
		            Desktop.getDesktop().browse(new URI("https://www.facebook.com/kvrks"));
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        } catch (URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		twitter.setOnAction(e -> {
		    if(Desktop.isDesktopSupported())
		    {
		        try {
		            Desktop.getDesktop().browse(new URI("https://twitter.com/kvrksastry"));
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        } catch (URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
		youtube.setOnAction(e -> {
		    if(Desktop.isDesktopSupported())
		    {
		        try {
		            Desktop.getDesktop().browse(new URI("https://www.youtube.com/channel/UCuSLGWcQmwU7aSOdEqSTb_w"));
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        } catch (URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});

 }
}
