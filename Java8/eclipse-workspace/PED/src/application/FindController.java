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

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class FindController
{
	String input;

	
    @FXML
    public AnchorPane mainPane;
    
    @FXML
    private JFXButton pronounciationBtn;

    @FXML
    private JFXButton findBtn;
    
    @FXML
    private JFXButton previousBtn;
    
    @FXML
    private JFXButton nextBtn;

    @FXML
    private JFXTextArea wordMeaning;
    
    @FXML
    private JFXTextField inputWord;
    
    @FXML
    private JFXTextField wordType;

    @FXML
    private ImageView previousIcn;
    
    @FXML
    private ImageView nextIcn;
    
    @FXML
    private ImageView pronounceIcn;
   
    @FXML
    private JFXSnackbar snackbar;
    
    TextToSpeech obj = new TextToSpeech();
	
    
    
	public void initialize() 
	{	
		snackbar = new JFXSnackbar(mainPane);
		TextFields.bindAutoCompletion(inputWord, Main.pw);

		pronounceIcn.setImage(new Image("img-files/pronounce.png"));
		previousIcn.setImage(new Image("img-files/previous.png"));
		nextIcn.setImage(new Image("img-files/next.png"));
		
		//pronounceBtn hover effect
	    ImageView pronounceHoverIcn = new ImageView(
	            new Image("img-files/pronounce_hover.png")
	    );

	    pronounciationBtn.graphicProperty().bind(
	            Bindings.when(
	            		pronounciationBtn.hoverProperty()
	            )
	                    .then(pronounceHoverIcn)
	                    .otherwise(pronounceIcn)
	    );
		
		//previousBtn hover effect
	    ImageView previousHoverIcn = new ImageView(
	            new Image("img-files/previoushover.png")
	    );

	    previousBtn.graphicProperty().bind(
	            Bindings.when(
	            		previousBtn.hoverProperty()
	            )
	                    .then(previousHoverIcn)
	                    .otherwise(previousIcn)
	    );

	    
		//nextBtn hover effect
	    ImageView nextHoverIcn = new ImageView(
	            new Image("img-files/nexthover.png")
	    );

	    nextBtn.graphicProperty().bind(
	            Bindings.when(
	            		nextBtn.hoverProperty()
	            )
	                    .then(nextHoverIcn)
	                    .otherwise(nextIcn)
	    );
		obj.setVoice("cmu-bdl-hsmm");


			//Removing editable property for type and meaning
			wordType.setEditable(false);
			wordMeaning.setEditable(false);
			
	}
	@FXML
	public void pronounciationBtnSelected()
	{
		String s="";
		if(Main.pw.indexOf(inputWord.getText())>=0)
		{
		s = inputWord.getText();
		}
		else 
		{
			s="SORRY!       word  not  found  in  the  dictionary";
		}
		
		obj.speak(" "+s+" ", 2.0f, false, true);
	
		
	}
	@FXML
	public void findBtnSelected()
	{
		String word=containsIgnoreCase(inputWord.getText().toString(), Main.pw);
		
		if(word.length()==0)
		{
			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("No input given",3000);
		
		}
		else if ( Main.pw.indexOf(word)<0) 
		{ 
			wordType.setText("");
			wordMeaning.setText("");
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
					 wordType.setText(rs.getString("type"));
					 wordMeaning.setText(rs.getString("definition").replaceAll("Examples :- ","\nExamples :- "));
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
			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("Sorry unable to find",3000);
		}
		}

		
	}
	@FXML
	public void findBtnSelectedSimulation()
	{
		String word=input;
		System.out.println(word);
		if(word.length()==0)
		{
			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("No input given",3000);
		
		}
		else if ( Main.pw.indexOf(word)<0) 
		{ 
			wordType.setText("");
			wordMeaning.setText("");
			System.out.println(input);
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
				wordType.setText(rs.getString("type"));
				wordMeaning.setText((((rs.getString("definition")).replaceAll("Examples :- ","\nExamples :- "))));
			}
			else
			{
				System.out.println(input);
				snackbar.show("Sorry word not found", 3000);
			}
			rs.close();
			stmt.close();      
			c.close(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("Sorry unable to find", 3000);
		}
		}

		
	}
	@FXML
	public void previousBtnSelected()
	{
		String word=containsIgnoreCase(inputWord.getText().toString(), Main.pw);
		if(word.length()==0)
		{
			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("No input given",3000);
		
		}
		else if ( Main.pw.indexOf(word)<0) 
		{ 
			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("Sorry word not found",3000);
		}
		else if ( Main.pw.indexOf(word)==0) 
		{ 
			input = Main.pw.get(Main.pw.size()-1);
			findBtnSelectedSimulation();
		}
		else
		{

		try 
		{ 

			if(Main.pw.indexOf(word)>0)
			{

			
			int id = Main.pw.indexOf(word);
			if(id == 0)
				id = Main.pw.size()-1;
			else
				id = id-1;
			input = Main.pw.get(id);
			findBtnSelectedSimulation();
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("Sorry unable to find", 3000);
			System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
		
		}
		}
		
	}
	@FXML
	public void nextBtnSelected()
	{
		String word=containsIgnoreCase(inputWord.getText().toString(), Main.pw);
		if(word.length()==0)
		{

			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("No input given",3000);
		
		}
		else if ( Main.pw.indexOf(word)<0) 
		{ 

			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("Sorry word not found",3000);
		}
		else if ( Main.pw.indexOf(word)==Main.pw.size()-1) 
		{ 
			input = Main.pw.get(0);
			findBtnSelectedSimulation();
		}
		else
		{

		try 
		{ 

			
			int id = Main.pw.indexOf(word);

				id = id+1;
			input = Main.pw.get(id);
			System.out.println(input);
			findBtnSelectedSimulation();


		}
		catch(Exception e)
		{
			e.printStackTrace();
			wordType.setText("");
			wordMeaning.setText("");
			snackbar.show("Sorry unable to find", 3000);
			System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
		
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
		

