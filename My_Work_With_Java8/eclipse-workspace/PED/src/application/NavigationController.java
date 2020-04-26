package application;

import java.io.IOException;
import java.net.URL;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class NavigationController 
{
//Declaration of id to various components
@FXML
public Button HomeBtn;
@FXML
public Button AddBtn;
@FXML
public Button UpdateBtn;
@FXML
public Button DeleteBtn;
@FXML
public Button AboutBtn;
@FXML
public Button LoadBtn;
@FXML
public Button ExitBtn;
@FXML
private ImageView HomeIcn;
@FXML
private ImageView ExitIcn;
@FXML
private ImageView AddIcn;
@FXML
private ImageView UpdateIcn;
@FXML
private ImageView DeleteIcn;
@FXML
private ImageView AboutIcn;
@FXML
private ImageView LoadIcn;

@FXML
private ImageView nicon;

@FXML
ToggleController toggleController;
@FXML
public void initialize() 
{
	//setting icons to buttons
	nicon.setImage(new Image("img-files/reader.jpg"));
	ExitIcn.setImage(new Image("img-files/exit-white.png"));
	HomeIcn.setImage(new Image("img-files/find-white.png"));
	AddIcn.setImage(new Image("img-files/Add-white.png"));
	UpdateIcn.setImage(new Image("img-files/update-white.png"));
	DeleteIcn.setImage(new Image("img-files/delete-white.png"));
	AboutIcn.setImage(new Image("img-files/about-white.png"));
	LoadIcn.setImage(new Image("img-files/load-white.png"));
	//HomeBtn hover effect
    ImageView HomeHoverIcn = new ImageView(
            new Image("img-files/find-green.png")
    );
    
    
    HomeBtn.graphicProperty().bind(
            Bindings.when(
            		HomeBtn.hoverProperty()
            )
                    .then(HomeHoverIcn)
                    .otherwise(HomeIcn)
    );
    
    ImageView ExitHoverIcn = new ImageView(
            new Image("img-files/exit-green.png")
    );
    
    
    ExitBtn.graphicProperty().bind(
            Bindings.when(
            		ExitBtn.hoverProperty()
            )
                    .then(ExitHoverIcn)
                    .otherwise(ExitIcn)
    );
    
  //AddBtn hover effect
    ImageView AddHoverIcn = new ImageView(
            new Image("img-files/Add-green.png")
    );

    AddBtn.graphicProperty().bind(
            Bindings.when(
            		AddBtn.hoverProperty()
            )
                    .then(AddHoverIcn)
                    .otherwise(AddIcn)
    );
    
  //HomeBtn hover effect
    ImageView UpdateHoverIcn = new ImageView(
            new Image("img-files/update-green.png")
    );

    UpdateBtn.graphicProperty().bind(
            Bindings.when(
            		UpdateBtn.hoverProperty()
            )
                    .then(UpdateHoverIcn)
                    .otherwise(UpdateIcn)
    );
  //DeleteBtn hover effect
    ImageView DeleteHoverIcn = new ImageView(
            new Image("img-files/delete-green.png")
    );

    DeleteBtn.graphicProperty().bind(
            Bindings.when(
            		DeleteBtn.hoverProperty()
            )
                    .then(DeleteHoverIcn)
                    .otherwise(DeleteIcn)
    );
    
  //AboutBtn hover effect
    ImageView AboutHoverIcn = new ImageView(
            new Image("img-files/about-green.png")
    );

    AboutBtn.graphicProperty().bind(
            Bindings.when(
            		AboutBtn.hoverProperty()
            )
                    .then(AboutHoverIcn)
                    .otherwise(AboutIcn)
    );
    
    //LoadBtn hover effect
    ImageView LoadHoverIcn = new ImageView(
            new Image("img-files/load-green.png")
    );

    LoadBtn.graphicProperty().bind(
            Bindings.when(
            		LoadBtn.hoverProperty()
            )
                    .then(LoadHoverIcn)
                    .otherwise(LoadIcn)
    );

    
	//Navigation button styling
	BorderPane border = Main.getRoot();
	try
	{
	if(border.getCenter().getUserData().toString().equals("Find"))
	{
		HomeBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
		AddBtn.setStyle("-fx-background-color:  #e6f4fb");
		UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
		DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
		AboutBtn.setStyle("-fx-background-color: #e6f4fb");
		LoadBtn.setStyle("-fx-background-color: #e6f4fb");
		HomeIcn.setImage(new Image("img-files/find-green.png"));
		AddIcn.setImage(new Image("img-files/Add-white.png"));
		UpdateIcn.setImage(new Image("img-files/update-white.png"));
		DeleteIcn.setImage(new Image("img-files/delete-white.png"));
		AboutIcn.setImage(new Image("img-files/about-white.png"));
		LoadIcn.setImage(new Image("img-files/load-white.png"));
	}
	else 	if(border.getCenter().getUserData().toString().equals("Add"))
	{
		AddBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
		HomeBtn.setStyle("-fx-background-color:  #e6f4fb");
		UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
		DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
		AboutBtn.setStyle("-fx-background-color: #e6f4fb");
		LoadBtn.setStyle("-fx-background-color: #e6f4fb");
		HomeIcn.setImage(new Image("img-files/find-white.png"));
		AddIcn.setImage(new Image("img-files/Add-green.png"));
		UpdateIcn.setImage(new Image("img-files/update-white.png"));
		DeleteIcn.setImage(new Image("img-files/delete-white.png"));
		AboutIcn.setImage(new Image("img-files/about-white.png"));
		LoadIcn.setImage(new Image("img-files/load-white.png"));
	}
	else 	if(border.getCenter().getUserData().toString().equals("Update"))
	{
		UpdateBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
		AddBtn.setStyle("-fx-background-color:  #e6f4fb");
		HomeBtn.setStyle("-fx-background-color:  #e6f4fb");
		DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
		AboutBtn.setStyle("-fx-background-color: #e6f4fb");
		LoadBtn.setStyle("-fx-background-color: #e6f4fb");
		HomeIcn.setImage(new Image("img-files/find-white.png"));
		AddIcn.setImage(new Image("img-files/Add-white.png"));
		UpdateIcn.setImage(new Image("img-files/update-green.png"));
		DeleteIcn.setImage(new Image("img-files/delete-white.png"));
		AboutIcn.setImage(new Image("img-files/about-white.png"));
		LoadIcn.setImage(new Image("img-files/load-white.png"));
	}
	else 	if(border.getCenter().getUserData().toString().equals("Delete"))
	{
		DeleteBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
		AddBtn.setStyle("-fx-background-color:  #e6f4fb");
		UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
		HomeBtn.setStyle("-fx-background-color:  #e6f4fb");
		AboutBtn.setStyle("-fx-background-color: #e6f4fb");
		LoadBtn.setStyle("-fx-background-color: #e6f4fb");
		HomeIcn.setImage(new Image("img-files/find-white.png"));
		AddIcn.setImage(new Image("img-files/Add-white.png"));
		UpdateIcn.setImage(new Image("img-files/update-white.png"));
		DeleteIcn.setImage(new Image("img-files/delete-green.png"));
		AboutIcn.setImage(new Image("img-files/about-white.png"));
		LoadIcn.setImage(new Image("img-files/load-white.png"));
	}
	else 	if(border.getCenter().getUserData().toString().equals("About"))
	{
		AboutBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
		AddBtn.setStyle("-fx-background-color:  #e6f4fb");
		UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
		DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
		HomeBtn.setStyle("-fx-background-color: #e6f4fb");
		LoadBtn.setStyle("-fx-background-color: #e6f4fb");
		HomeIcn.setImage(new Image("img-files/find-white.png"));
		AddIcn.setImage(new Image("img-files/Add-white.png"));
		UpdateIcn.setImage(new Image("img-files/update-white.png"));
		DeleteIcn.setImage(new Image("img-files/delete-white.png"));
		AboutIcn.setImage(new Image("img-files/about-green.png"));
		LoadIcn.setImage(new Image("img-files/load-green.png"));
	}
	else 	if(border.getCenter().getUserData().toString().equals("Load"))
	{
		LoadBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
		AddBtn.setStyle("-fx-background-color:  #e6f4fb");
		UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
		DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
		HomeBtn.setStyle("-fx-background-color: #e6f4fb");
		AboutBtn.setStyle("-fx-background-color: #e6f4fb");
		HomeIcn.setImage(new Image("img-files/find-white.png"));
		AddIcn.setImage(new Image("img-files/Add-white.png"));
		UpdateIcn.setImage(new Image("img-files/update-white.png"));
		DeleteIcn.setImage(new Image("img-files/delete-white.png"));
		AboutIcn.setImage(new Image("img-files/about-green.png"));
		LoadIcn.setImage(new Image("img-files/load-green.png"));
	}
	}
	catch(Exception e)
	{
			HomeBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
			AddBtn.setStyle("-fx-background-color:  #e6f4fb");
			UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
			DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
			AboutBtn.setStyle("-fx-background-color: #e6f4fb");
			LoadBtn.setStyle("-fx-background-color: #e6f4fb");
			HomeIcn.setImage(new Image("img-files/find-green.png"));
			AddIcn.setImage(new Image("img-files/Add-white.png"));
			UpdateIcn.setImage(new Image("img-files/update-white.png"));
			DeleteIcn.setImage(new Image("img-files/delete-white.png"));
			AboutIcn.setImage(new Image("img-files/about-white.png"));
			LoadIcn.setImage(new Image("img-files/load-green.png"));
	}
}

//Any scene to Main switch
  @FXML
  void switchToMain(ActionEvent event) {

    try {
    	Main.appTitle.setValue("Find");
      URL mainUrl = getClass().getResource("Find.fxml");
      AnchorPane main = FXMLLoader.load( mainUrl );
      
      //Setting of FXML UI
      BorderPane border = Main.getRoot();
      border.setCenter(main);
      border.getCenter().setUserData("Find");
      //Changing stage title
      Stage primStage = (Stage) border.getScene().getWindow();
      primStage.setTitle("PED/Find");
      
      //Navigation button styling
      HomeBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
      AddBtn.setStyle("-fx-background-color:  #e6f4fb");
      UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
      DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
      AboutBtn.setStyle("-fx-background-color: #e6f4fb");
      LoadBtn.setStyle("-fx-background-color:  #e6f4fb");
      LoadIcn.setImage(new Image("img-files/load-white.png"));
      HomeIcn.setImage(new Image("img-files/find-green.png"));
      AddIcn.setImage(new Image("img-files/Add-white.png"));
  	  UpdateIcn.setImage(new Image("img-files/update-white.png"));
  	  DeleteIcn.setImage(new Image("img-files/delete-white.png"));
  	  AboutIcn.setImage(new Image("img-files/about-white.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

//Any scene to Add switch
  @FXML
  void switchToAdd(ActionEvent event) {
    
    try {
    	Main.appTitle.setValue("Add");
    	//Loading of FXML UI
      URL addUrl = getClass().getResource("Add.fxml");
      AnchorPane add = FXMLLoader.load( addUrl );
      
      //Setting of FXML UI
      BorderPane border = Main.getRoot();
      border.setCenter(add);
      border.getCenter().setUserData("Add");
      //Changing stage title
      Stage primStage = (Stage) border.getScene().getWindow();
      primStage.setTitle("PED/Add");
      
      //Navigation button styling
      HomeBtn.setStyle("-fx-background-color: #e6f4fb");
      AddBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
      UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
      DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
      AboutBtn.setStyle("-fx-background-color: #e6f4fb");
      LoadBtn.setStyle("-fx-background-color:  #e6f4fb");
      LoadIcn.setImage(new Image("img-files/load-white.png"));
  	HomeIcn.setImage(new Image("img-files/find-white.png"));
  	AddIcn.setImage(new Image("img-files/Add-green.png"));
  	UpdateIcn.setImage(new Image("img-files/update-white.png"));
  	DeleteIcn.setImage(new Image("img-files/delete-white.png"));
  	AboutIcn.setImage(new Image("img-files/about-white.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

//Any scene to Update switch
  @FXML
  void switchToUpdate(ActionEvent event) {

    try {
    	Main.appTitle.setValue("Update");
    	//Loading of FXML UI
      URL updateUrl = getClass().getResource("Update.fxml");
      AnchorPane update = FXMLLoader.load( updateUrl );
      
    //Setting of FXML UI
      BorderPane border = Main.getRoot();
      border.setCenter(update);
      border.getCenter().setUserData("Update");
      //Changing stage title
      Stage primStage = (Stage) border.getScene().getWindow();
      primStage.setTitle("PED/Update");
      
      //Navigation button styling
      HomeBtn.setStyle("-fx-background-color: #e6f4fb");
      AddBtn.setStyle("-fx-background-color: #e6f4fb");
      UpdateBtn.setStyle("-fx-background-color:  lightgrey; -fx-text-fill: #517abd");
      DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
      AboutBtn.setStyle("-fx-background-color: #e6f4fb");
      LoadBtn.setStyle("-fx-background-color:  #e6f4fb");
      LoadIcn.setImage(new Image("img-files/load-white.png"));
  	  HomeIcn.setImage(new Image("img-files/find-white.png"));
  	  AddIcn.setImage(new Image("img-files/Add-white.png"));
  	  UpdateIcn.setImage(new Image("img-files/update-green.png"));
  	  DeleteIcn.setImage(new Image("img-files/delete-white.png"));
  	  AboutIcn.setImage(new Image("img-files/about-white.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  
//Any scene to Delete switch
  @FXML
  void switchToDelete(ActionEvent event) {

    try {
    	Main.appTitle.setValue("Delete");
    	//Loading of FXML UI
      URL deleteUrl = getClass().getResource("Delete.fxml");
      AnchorPane delete = FXMLLoader.load( deleteUrl );
      
    //Setting of FXML UI
      BorderPane border = Main.getRoot();
      border.setCenter(delete);
      border.getCenter().setUserData("Delete");
      //Changing stage title
      Stage primStage = (Stage) border.getScene().getWindow();
      primStage.setTitle("PED/Delete");
      
      //Navigation button styling
      HomeBtn.setStyle("-fx-background-color: #e6f4fb");
      AddBtn.setStyle("-fx-background-color: #e6f4fb");
      UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
      DeleteBtn.setStyle("-fx-background-color:  lightgrey; -fx-text-fill: #517abd");
      AboutBtn.setStyle("-fx-background-color: #e6f4fb");
      LoadBtn.setStyle("-fx-background-color:  #e6f4fb");
      LoadIcn.setImage(new Image("img-files/load-white.png"));
  	HomeIcn.setImage(new Image("img-files/find-white.png"));
  	AddIcn.setImage(new Image("img-files/Add-white.png"));
  	UpdateIcn.setImage(new Image("img-files/update-white.png"));
  	DeleteIcn.setImage(new Image("img-files/delete-green.png"));
  	AboutIcn.setImage(new Image("img-files/about-white.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  
//Any scene to About switch
  @FXML
  void switchToAbout(ActionEvent event) {

    try {
    	Main.appTitle.setValue("About");
        //Loading of FXML UI
      URL aboutUrl = getClass().getResource("About.fxml");
      AnchorPane about = FXMLLoader.load( aboutUrl );
      
    //Setting of FXML UI
      BorderPane border = Main.getRoot();
      border.setCenter(about);
      border.getCenter().setUserData("About");
      //Changing stage title
      Stage primStage = (Stage) border.getScene().getWindow();
      primStage.setTitle("PED/About");
      
      //Navigation button styling
      HomeBtn.setStyle("-fx-background-color: #e6f4fb");
      AddBtn.setStyle("-fx-background-color: #e6f4fb");
      UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
      DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
      LoadBtn.setStyle("-fx-background-color:  #e6f4fb");
      LoadIcn.setImage(new Image("img-files/load-white.png"));
      AboutBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
  	HomeIcn.setImage(new Image("img-files/find-white.png"));
  	AddIcn.setImage(new Image("img-files/Add-white.png"));
  	UpdateIcn.setImage(new Image("img-files/update-white.png"));
  	DeleteIcn.setImage(new Image("img-files/delete-white.png"));
  	AboutIcn.setImage(new Image("img-files/about-green.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
//Any scene to Load switch
  @FXML
  void switchToLoad(ActionEvent event) 
  {
	  Main.appTitle.setValue("Load");
		  try {
	        //Loading of FXML UI
	      URL loadUrl = getClass().getResource("Load.fxml");
	      AnchorPane load = FXMLLoader.load( loadUrl );
	      
	    //Setting of FXML UI
	      BorderPane border = Main.getRoot();
	      border.setCenter(load);
	      border.getCenter().setUserData("Load");
	      //Changing stage title
	      Stage primStage = (Stage) border.getScene().getWindow();
	      primStage.setTitle("PED/Load");
	      
	      //Navigation button styling
	      HomeBtn.setStyle("-fx-background-color: #e6f4fb");
	      AddBtn.setStyle("-fx-background-color: #e6f4fb");
	      UpdateBtn.setStyle("-fx-background-color:  #e6f4fb");
	      DeleteBtn.setStyle("-fx-background-color:  #e6f4fb");
	      AboutBtn.setStyle("-fx-background-color:  #e6f4fb");
	      LoadBtn.setStyle("-fx-background-color: lightgrey; -fx-text-fill: #517abd");
	  	HomeIcn.setImage(new Image("img-files/find-white.png"));
	  	AddIcn.setImage(new Image("img-files/Add-white.png"));
	  	UpdateIcn.setImage(new Image("img-files/update-white.png"));
	  	DeleteIcn.setImage(new Image("img-files/delete-white.png"));
	  	AboutIcn.setImage(new Image("img-files/about-white.png"));
	  	LoadIcn.setImage(new Image("img-files/load-green.png"));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
  }
  
  @FXML
  public void exitSelected()
  {
	  System.exit(0);
  }
}