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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class AddController 
{
	
    @FXML
    private AnchorPane addPane;

    @FXML
    private JFXTextField inputWord;

    @FXML
    private JFXTextField inputType;

    @FXML
    private TextArea inputMeaning;

    @FXML
    private JFXButton AddToDbBtn;
    
    @FXML
    JFXSnackbar snackbar;
	public void initialize() 
	{
		
		snackbar = new JFXSnackbar(addPane);
		TextFields.bindAutoCompletion(inputWord, Main.pw);
	}
	
	@FXML
	public void AddToDbBtnSelected()
	{
		String word="";

			if(inputWord.getText().toString().length()==0)
			{
				snackbar.show("No input given",3000);
			
			}
			else if ( Main.pw.indexOf(containsIgnoreCase(inputWord.getText(),Main.pw))>0) 
			{ 
				snackbar.show("word already exists",3000);
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

				String type = "";
				String definition = "";
				if(inputType.getText().length()>0) 
				{
					type = inputType.getText();
				}
				if(inputMeaning.getText().length()>0)
				{
					definition = inputMeaning.getText();
				}
			   String sql = "INSERT INTO DICTIONARY "+
   					 "(WORD,TYPE,DEFINITION) "+ 
   					 "VALUES (\""+word+"\",\""+type+"\",\""+definition+"\");";
			   Main.pw.add(word);
			   Collections.sort(Main.pw);
			   stmt.executeUpdate(sql);
			   snackbar.show("Successfully added",3000);

			
			   stmt.close();     
			   c.commit();
			   c.close(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

		
		Platform.runLater(()->{
			TextFields.bindAutoCompletion(inputWord, Main.pw);
			}
			);
	}
	public String containsIgnoreCase(String str, ArrayList<String> list){
	    for(String i : list){
	        if(i.equalsIgnoreCase(str))
	            return i;
	    }
	    return str;
	}
}
