package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import org.controlsfx.control.textfield.TextFields;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class DeleteController 
{
    @FXML
    private AnchorPane deletePane;
   
    
    @FXML
    private JFXTextField inputWord;

    @FXML
    private JFXButton deleteFromDbBtn;

    @FXML
	private JFXSnackbar snackbar;

	public void initialize() 
	{

		snackbar = new JFXSnackbar(deletePane);
		TextFields.bindAutoCompletion(inputWord, Main.pw);

	}
	@FXML
	public void deleteFromDbBtnSelected()
	{
	String word="";
	if(inputWord.getText().toString().length()==0)
	{
		snackbar.show("No input given",3000);
	
	}
	else if(Main.pw.indexOf(containsIgnoreCase(inputWord.getText(),Main.pw))<0)
	{
		snackbar.show("Word doesn't exist",3000);
	}
	else
	{
	word = containsIgnoreCase(inputWord.getText(),Main.pw);

	Connection c = null; 
	Statement stmt = null;
	try 
	{ 
		Class.forName("org.sqlite.JDBC");         
			c = DriverManager.getConnection("jdbc:sqlite:MASK.db");        
			c.setAutoCommit(false); 
		    stmt = c.createStatement(); 
		    String sql = "DELETE from DICTIONARY where WORD=\""+containsIgnoreCase(inputWord.getText(),Main.pw)+"\";"; 
		    stmt.executeUpdate(sql);  
		    stmt.close();     
			c.commit();
			c.close(); 
			
	         snackbar.show("Successfully deleted",3000);
	         Main.pw.remove(word);	       
	         Collections.sort(Main.pw);
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace(); 
		snackbar.show("Unable to delete",3000);
	}

	Platform.runLater(()->{
	TextFields.bindAutoCompletion(inputWord, Main.pw);
	}
	);
	}
}
	public String containsIgnoreCase(String str, ArrayList<String> list){
	    for(String i : list){
	        if(i.equalsIgnoreCase(str))
	            return i;
	    }
	    return str;
	}
}
