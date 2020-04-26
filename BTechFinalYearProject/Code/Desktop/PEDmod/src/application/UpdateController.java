package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.controlsfx.control.textfield.TextFields;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class UpdateController 
{
	
    
    @FXML
    public AnchorPane	updatePane;

    @FXML
    private JFXButton findBtn;
    
    @FXML
    private JFXButton UpdateDbBtn;

    @FXML
    private JFXTextArea inputMeaning;
    
    @FXML
    private JFXTextField inputWord;
    
    @FXML
    private JFXTextField inputType;
    
    @FXML
	private JFXSnackbar snackbar;

	public void initialize() 
	{
		snackbar = new JFXSnackbar(updatePane);
		TextFields.bindAutoCompletion(inputWord, Main.pw);
		
		
	}
	
	@FXML
	public void findBtnSelected()
	{
		String word=containsIgnoreCase(inputWord.getText().toString(), Main.pw);
		
		if(word.length()==0)
		{
			inputType.setText("");
			inputMeaning.setText("");
			snackbar.show("No input given",3000);
		
		}
		else if ( Main.pw.indexOf(word)<0) 
		{ 
			inputType.setText("");
			inputMeaning.setText("");
			snackbar.show("Sorry word not found",3000);
		}
		 else
		 {
			 Connection c = null; 
			 Statement stmt = null;
			 try 
			 { 
				 Class.forName("org.sqlite.JDBC");         
				 c = DriverManager.getConnection("jdbc:sqlite:MASK.db");        
				 c.setAutoCommit(false); 
				 stmt = c.createStatement(); 
				 ResultSet rs = stmt.executeQuery( "SELECT * FROM DICTIONARY WHERE  WORD = \""+word+"\";" );
				 
				 if( rs.next() ) 
				 { 
					 inputWord.setText(word);
					 inputType.setText(rs.getString("type"));
					 inputMeaning.setText((((rs.getString("definition")).replaceAll("Examples :- ","\nExamples :- "))));
				 }
				 else
				 {
					 snackbar.show("Sorry word not found",3000);
				 }
				 rs.close();
				 stmt.close();      
				 c.close(); 
		}
		catch(Exception e)
		{
			inputType.setText("");
			inputMeaning.setText("");
			snackbar.show("Sorry unable to find",3000);
		}
		}

		
	}
	public void updateBtnSelected()
	{
		String type = "";
		String definition = "";
		
		if(inputType.getText().length()>0)
		{
			type = inputType.getText();
		}
		if(inputMeaning.getText().length()>0)
		{
			definition = (inputMeaning.getText());
		}
		if(inputWord.getText().toString().length()==0)
		{
			
			snackbar.show("No input given",3000);
		
		}
		else  if(Main.pw.indexOf(containsIgnoreCase(inputWord.getText().toString(), Main.pw))<0)
		{
			snackbar.show("Word doesn't exist",3000);
			
		}
		else
		{
		Connection c = null; 
		Statement stmt = null;
	try { 
		Class.forName("org.sqlite.JDBC");         
		c = DriverManager.getConnection("jdbc:sqlite:MASK.db");        
		c.setAutoCommit(false); 
	    stmt = c.createStatement(); 
	    String sql = "UPDATE DICTIONARY set TYPE = \""+type+"\",DEFINITION =\""+definition+"\" where WORD=\""+containsIgnoreCase(inputWord.getText().toString(), Main.pw)+"\";";
	    stmt.executeUpdate(sql);
	    stmt.close();         
	    c.commit();         
	    c.close(); 
	    snackbar.show("Successfully updated",3000);
	  
	    } 
	catch ( Exception e ) 
	{ 
		System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
		snackbar.show("unable to update",3000);
	} 
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
