package application;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
public class MainController 
{
	
		public Button home = new Button();
		public Button plainToCipherButton = new Button();
	    public Button cipherToPlainButton = new Button();
	    public Button ntimesPlainToCipherButton = new Button();
	    public Button ntimesCipherToPlainButton = new Button();
		int upperCase=0,lowerCase=0,numberCount=0,others=0;
		
		public void plainToCipherButtonPressed(ActionEvent e) throws IOException
		{
			buttonNavigation("ptoc.fxml",e,"Plain Text to Cipher");
		}
		
		public void cipherToPlainButtonPressed(ActionEvent e) throws IOException
		{
			buttonNavigation("ctop.fxml",e,"Cipher to Plain Text");
		}
		
	    public void homePressed(ActionEvent e) throws IOException
	    {
	    	buttonNavigation("Main.fxml",e,"Criptiphy");
	    }
	    
	    public void buttonNavigation(String file,ActionEvent e,String title) throws IOException 
	    {
	    	Parent root = FXMLLoader.load(getClass().getResource(file));
	        
	    	Scene scene = new Scene(root,1024,720);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle(title);
			stage.show();
	    }
	    @FXML PieChart inputPie,outputPie;
	    @FXML TextArea inputText = new TextArea();
		@FXML TextArea outputText = new TextArea();
	    @FXML PasswordField password = new PasswordField();
	
	    public void plainToCipher(ActionEvent e) throws IOException
	    {
	    	if(inputText.getText().length()>0 && password.getText().length()>0)
	    	{
	    	lowerCase=numberCount=others=upperCase=0;
	    	char[] input;
	    	char[] inputActual = inputText.getText().toCharArray();
	    	input =  inputText.getText().toCharArray();
	    	char[] key = password.getText().toCharArray();
	    	char[] output;
	    	KrisTryEncrypt obj1 = new KrisTryEncrypt();
	    
	    	output=obj1.Encrypt(key,input);
	    
	    	outputText.setText(String.valueOf(output));
            
	    	for ( int i = 0; i < input.length ; i++ ) 
            {
             
				if (Character.isUpperCase(String.valueOf(inputActual).charAt(i))){ upperCase++; }
                else if (Character.isLowerCase(String.valueOf(inputActual).charAt(i))){ lowerCase++; }
                else if (Character.isDigit(String.valueOf(inputActual).charAt(i)))    { numberCount++;}
                else {others++;}
            }
           
	    	ObservableList<Data> inputList = FXCollections.observableArrayList
	    			(
	    			new PieChart.Data("Capital Alphabets",(upperCase*100/input.length)),
	    			new PieChart.Data("Small Alphabets",(lowerCase*100/input.length)),
	    			new PieChart.Data("Numericals",(numberCount*100/input.length)),
	    			new PieChart.Data("Others",(others*100/input.length))
	    			);
	    	inputPie.setData(inputList);
	    	
	    	lowerCase=numberCount=others=upperCase=0;
	    	
	    	for ( int i = 0; i < output.length ; i++ ) 
	    	{
                if (Character.isUpperCase(String.valueOf(output).charAt(i))){ upperCase++; }
                else if (Character.isLowerCase(String.valueOf(output).charAt(i))){ lowerCase++; }
                else if (Character.isDigit(String.valueOf(output).charAt(i)))    { numberCount++;}
                else {others++;}
            }
	    	ObservableList<Data> outputList = FXCollections.observableArrayList
	    			(
	    			new PieChart.Data("Capital Alphabets",(upperCase*100/input.length)),
	    			new PieChart.Data("Small Alphabets",(lowerCase*100/input.length)),
	    			new PieChart.Data("Numericals",(numberCount*100/input.length)),
	    			new PieChart.Data("Others",(others*100/input.length))
	    			);
	    	outputPie.setData(outputList);
	    	}
	    }   
	    public void cipherToPlain(ActionEvent e) throws IOException
	    {
	    	if(inputText.getText().length()>0 && password.getText().length()>0)
	    	{
	    	lowerCase=numberCount=others=upperCase=0;
	    	char[] input; 
	    	char[] inputActual = inputText.getText().toCharArray();
	    	input =  inputText.getText().toCharArray();
	    	
	    	char[] key = password.getText().toCharArray();
	    	char[] output;
	    	KrisTryDecrypt obj1 = new KrisTryDecrypt();
	    	output=obj1.Decrypt(key,input);

	    	
	    	outputText.setText(String.valueOf(output));
            
	    	for ( int i = 0; i < input.length ; i++ ) 
            {
                if (Character.isUpperCase(String.valueOf(inputActual).charAt(i))){ upperCase++; }
                else if (Character.isLowerCase(String.valueOf(inputActual).charAt(i))){ lowerCase++; }
                else if (Character.isDigit(String.valueOf(inputActual).charAt(i)))    { numberCount++;}
                else {others++;}
            }
           
	    	ObservableList<Data> inputList = FXCollections.observableArrayList
	    			(
	    			new PieChart.Data("Capital Alphabets",(upperCase*100/input.length)),
	    			new PieChart.Data("Small Alphabets",(lowerCase*100/input.length)),
	    			new PieChart.Data("Numericals",(numberCount*100/input.length)),
	    			new PieChart.Data("Others",(others*100/input.length))
	    			);
	    	inputPie.setData(inputList);
	    	
	    	lowerCase=numberCount=others=upperCase=0;
	    	
	    	for ( int i = 0; i < output.length ; i++ ) 
	    	{
                if (Character.isUpperCase(String.valueOf(output).charAt(i))){ upperCase++; }
                else if (Character.isLowerCase(String.valueOf(output).charAt(i))){ lowerCase++; }
                else if (Character.isDigit(String.valueOf(output).charAt(i)))    { numberCount++;}
                else {others++;}
            }
	    	ObservableList<Data> outputList = FXCollections.observableArrayList
	    			(
	    			new PieChart.Data("Capital Alphabets",(upperCase*100/input.length)),
	    			new PieChart.Data("Small Alphabets",(lowerCase*100/input.length)),
	    			new PieChart.Data("Numericals",(numberCount*100/input.length)),
	    			new PieChart.Data("Others",(others*100/input.length))
	    			);
	    	outputPie.setData(outputList);
	    	}
	    }   
}