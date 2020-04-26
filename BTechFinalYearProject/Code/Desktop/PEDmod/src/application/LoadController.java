package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class LoadController 
{

	int total, completed, remaining, newlyadded, existing, percentage;
	ObservableList<String> items;
	@FXML
    private JFXListView<String> listView;

    @FXML
    private ImageView loadAnimation;
    
    @FXML
    private Label loadPercentage;

    @FXML
    private JFXTextField filePath;

    @FXML
    private JFXButton browseBtn;

    @FXML
    private JFXButton loadBtn;
    
    @FXML
	private JFXSnackbar snackbar;
    
    @FXML
    private AnchorPane loadPane;

    public void initialize()
    {
    	snackbar = new JFXSnackbar(loadPane);
    	loadPercentage.setVisible(false);
    	loadAnimation.setVisible(false);
    	listView.setVisible(false);
    	total = 0;completed= 0; remaining = 0;newlyadded = 0;existing = 0; percentage = 0;
    }
    
    @FXML
    public void browseBtnSelected() throws IOException 
    {
    	FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));                 
		fileChooser.getExtensionFilters().addAll(
		    new FileChooser.ExtensionFilter("All Text", "*.txt")
		);
		File file = fileChooser.showOpenDialog(null);
		String path = file.getCanonicalPath();
		filePath.setText(path);
		
    }

    @FXML
    public void loadBtnSelected(ActionEvent event) throws IOException 
    {
		if(filePath.getText().toString().length()==0)
		{
			snackbar.show("No input given",3000);
		
		}
    else {
    	total=completed=remaining=newlyadded=existing=percentage=0;
    	try {
    	total = numberOfLinesInAFile();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace(); 
    		Platform.runLater(
					  () -> {
					    // Update UI here.
						listView.setVisible(false);
						loadAnimation.setVisible(false);
						snackbar.show("unable to load",3000);
					  }
					);
    	}
		listView.setVisible(true);
    	loadAnimation.setImage(new Image("img-files/loading.gif"));  
    	filePath.setEditable(false);
    	snackbar.show("Please wait for the loading to complete!",3000);
    	browseBtn.setDisable(true);
    	loadBtn.setDisable(true);
    	loadPercentage.setVisible(true);
    	loadAnimation.setVisible(true);
    	new Thread(()-> {

       		 startAddToDB();
       
    	}).start();

    }
    }
    
    public void startAddToDB() {
    	
    	boolean success = addToDB();
		Platform.runLater(
				  () -> {
    	if(success)
    	{
    		snackbar.show("Successfully loaded",3000);
    		
    	}
    	else
    	{
    		snackbar.show("unable to load",3000);
    		loadAnimation.setVisible(false);
    		loadPercentage.setVisible(false);
    		
    	}
				  });
    	filePath.setEditable(true);
	}

	public boolean addToDB()
    {
		try 
		{
    		FileInputStream fis = null;
    		BufferedReader reader = null;
    		Connection c = null; 
    		Statement stmt = null;
    		
    			String fileloc = filePath.getText();
    			fis = new FileInputStream(fileloc);
    			reader = new BufferedReader(new InputStreamReader(fis));
    			String line = new String(reader.readLine());
    			int temp = total; 
    			A: while(line != null)
    			{
    				temp-=1;
    				completed = total - temp;
    				remaining = temp;
    				percentage = (completed*100/total);
    				Class.forName("org.sqlite.JDBC");         
    				c = DriverManager.getConnection("jdbc:sqlite:MASK.db");      
    				c.setAutoCommit(false); 
    				stmt = c.createStatement(); 
    				String[] details = line.substring(1,line.length()-3).split("\",\"");
    				
    				if(Main.pw.indexOf(containsIgnoreCase(details[0],Main.pw))>=0)
    				{
    					line = reader.readLine();
    					existing+=1;
    					 items =FXCollections.observableArrayList (
        						 "Words-Details","Total: "+total,"Newly added: "+newlyadded,"Already existing: "+existing );
    					Platform.runLater(
    							  () -> {
    							    // Update UI here.
    								listView.setItems(items);
    		        				loadPercentage.setText(""+percentage+" %");
    							  }
    							);
    					continue A;
    				}
    				
    				String sql = "INSERT INTO DICTIONARY "+
    	    					 "(WORD,TYPE,DEFINITION) "+ 
    	    					 "VALUES ("+line.replaceAll("\\|","\n");
    				stmt.executeUpdate(sql);
    				newlyadded+=1;
    				Main.pw.add(details[0]);
    				stmt.close();    
    				c.commit(); 
    				c.close(); 
    				line = reader.readLine();
    				 items =FXCollections.observableArrayList (
    						 "Words-Details","Total: "+total,"Newly added: "+newlyadded,"Already existing: "+existing );
					Platform.runLater(
							  () -> {
							    // Update UI here.
								listView.setItems(items);
		        				loadPercentage.setText(""+percentage+" %");
							  }
							);

			    	
    			}
    			reader.close();
    			return true;
    		} 
    		catch ( Exception e ) 
    			{ 
    			e.printStackTrace();
    			Platform.runLater(
						  () -> {
						    // Update UI here.
							listView.setVisible(false);
							loadAnimation.setVisible(false);
							snackbar.show("unable to load",3000);
						  }
						);
					return false;
    			} 
    		finally 
    		{
    			
    	
    			Platform.runLater(
						  () -> {
    		 	if(total == completed)
    	    	{
    	    		loadPercentage.setVisible(false);
    	        	loadAnimation.setVisible(false);
    	        	Collections.sort(Main.pw);
    	        	snackbar.show("Successfully loaded",3000);
    	    		
    	    	}
    	    	else
    	    	{
    	    		snackbar.show("unable to load",3000);
    	    		
    	    	}
    		 	loadBtn.setDisable(false);
				browseBtn.setDisable(false);
				filePath.setEditable(true);
				});
    		}
		
    		}
    		
    public int numberOfLinesInAFile() throws IOException
    {
    	int number = 0;
    	FileInputStream fis =  new FileInputStream(new File(filePath.getText()));
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		String line = new String(reader.readLine());
    	while(line!=null)
    	{
    		if(line.length()>0)
    		number+=1;
    		line = reader.readLine();
    	}
    	return number;
    }
    
	public String containsIgnoreCase(String str, ArrayList<String> list){
	    for(String i : list){
	        if(i.equalsIgnoreCase(str))
	            return i;
	    }
	    return str;
	}
   }
