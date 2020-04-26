 package application;

import java.awt.Desktop;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;

public class MainController2 {

	@FXML public Button browseH = new Button();
	@FXML public Button browseR = new Button();
	@FXML public Button generate = new Button();
	@FXML public Button button3 = new Button();
	@FXML public TextField noc = new TextField();
	@FXML public TextField nor = new TextField();
	@FXML public TextField rpr = new TextField();
	@FXML public TextField cpr = new TextField();
	@FXML public TextField htf = new TextField();
	@FXML public TextField rtf = new TextField();
	@FXML public Label ErrorMessage = new Label();
	@FXML public TextField ExamYear = new TextField();
	@FXML public TextField ExamMonth = new TextField();
	@FXML public TextField ExamDate = new TextField();
	@FXML public TextField Semester = new TextField();
	@FXML public DatePicker DateoE = new DatePicker();
	@FXML public TextField Trade = new TextField();
	@FXML public TextField Trade2 = new TextField();
	@FXML public TextField Trade1 = new TextField();
	@FXML public TextField OMRsheetn = new TextField();
	@FXML public TextField Subject = new TextField();
	@FXML public ToggleGroup group = new ToggleGroup();
	@FXML public RadioButton An = new RadioButton();
	@FXML public RadioButton Fn = new RadioButton();
	@FXML public Button jbrowseH = new Button();
	@FXML public Button jbrowseH2 = new Button();
	@FXML public Button jbrowseR = new Button();
	@FXML public Button jgenerate = new Button();
	@FXML public Button jbutton3 = new Button();
	@FXML public Button HomeB = new Button();
	@FXML public TextField jnoc = new TextField();
	@FXML public TextField jnor = new TextField();
	@FXML public TextField jrpr = new TextField();
	@FXML public TextField jcpr = new TextField();
	@FXML public TextField jhtf = new TextField();
	@FXML public TextField jhtf2 = new TextField();
	@FXML public TextField jrtf = new TextField();
	@FXML public Label jErrorMessage = new Label();
	@FXML public TextField jExamYear = new TextField();
	@FXML public TextField jExamMonth = new TextField();
	@FXML public TextField jExamDate = new TextField();
	@FXML public TextField jSemester = new TextField();
	@FXML public DatePicker jDateoE = new DatePicker();
	@FXML public TextField jOMRsheetn = new TextField();
	@FXML public TextField jSubject = new TextField();
	@FXML public TextField jOMRsheetn2 = new TextField();
	@FXML public TextField jSubject2 = new TextField();
	@FXML public ToggleGroup jgroup = new ToggleGroup();
	@FXML public RadioButton jAn = new RadioButton();
	@FXML public RadioButton jFn = new RadioButton();
	@FXML public Button word = new Button();
	@FXML public Button pdf = new Button();
	@FXML public ComboBox<String> comboBox = new ComboBox<String>();
	public String[] sets;
	public java.util.Queue<String> out = new java.util.LinkedList<String>();
    public java.io.File file=new java.io.File("out.txt");
    public java.io.File jfile=new java.io.File("jout.txt");
    public Stage stagep;
	@FXML
	public void initialize() throws FileNotFoundException{
		try {
			comboBox.getItems().addAll(
				    "A",
				    "B",
				    "C",
				    "D"
				);
			comboBox.setValue("A");
	An.setToggleGroup(group);
	Fn.setToggleGroup(group);
	jAn.setToggleGroup(jgroup);
	jFn.setToggleGroup(jgroup);
	Fn.setSelected(true);
	jFn.setSelected(true);
	
		}
		catch(Exception e) {}

	}
	public int a1,a2,a3,a4;
	public String ele0="",ele1="",ele2="",ele3="",ele4="",ele5="",ele6="",ele7="",ele8="",ele9,ele10,startingset;
	FileChooser fileChooser = new FileChooser();
	
		
		

	public void browseHPressed() throws IOException{
		
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));                 
				fileChooser.getExtensionFilters().addAll(
				    new FileChooser.ExtensionFilter("All Text", "*.txt")
				);
				File file = fileChooser.showOpenDialog(null);
				String path = file.getCanonicalPath();
				
				htf.setText(path);
		
	}
	public void HomeBPressed(ActionEvent e) throws IOException {
		Parent root2 = FXMLLoader.load(getClass(). getResource("Main.fxml"));
	    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	    int width = gd.getDisplayMode().getWidth();
	    int height = gd.getDisplayMode().getHeight();
	    Scene scene2 = new Scene(root2,width-20,height-90);
		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene2);
		window.show();
		
	}
	public void jbrowseHPressed() throws IOException{
		
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));                 
				fileChooser.getExtensionFilters().addAll(
				    new FileChooser.ExtensionFilter("All Text", "*.txt")
				);
				File file = fileChooser.showOpenDialog(null);
				String path = file.getCanonicalPath();
				
				jhtf.setText(path);
		
	}
	public void jbrowseH2Pressed() throws IOException{
		
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));                 
				fileChooser.getExtensionFilters().addAll(
				    new FileChooser.ExtensionFilter("All Text", "*.txt")
				);
				File file = fileChooser.showOpenDialog(null);
				String path = file.getCanonicalPath();
				
				jhtf2.setText(path);
		
	}
    public void button3Pressed(ActionEvent e) throws IOException
    {
   
		
	ele0=ExamYear.getText();
	ele1=ExamMonth.getText();
	ele2=ExamDate.getText();
	ele3=Semester.getText();
	ele4=DateoE.getValue().toString()+"  "+group.getSelectedToggle()+"";
	ele5=Trade.getText();
	ele6=OMRsheetn.getText();
	ele4=ele4.substring(0,10)+" "+ele4.substring(ele4.length()-3,ele4.length()-1);
	ele7=Subject.getText();

	
	FileWriter outFile = new FileWriter("out.txt", true);
    PrintWriter out1 = new PrintWriter(outFile);
    try {
        out1.append(ele0);
        out1.println();
        out1.append(ele1);
        out1.println();
        out1.append(ele2);
        out1.println();
        out1.append(ele3);
        out1.println();
        out1.append(ele4);
        out1.println();
        out1.append(ele5);
        out1.println();
        out1.append(ele6);
        out1.println();
        out1.append(ele7);
        out1.println();
        
    } finally {
       out1.close();
    }

 
    Parent root2 = FXMLLoader.load(getClass(). getResource("Main1.fxml"));
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    Scene scene2 = new Scene(root2,width-20,height-90);
	scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
	window.setScene(scene2);
	window.show();
    
    }
    public void jbutton3Pressed(ActionEvent e) throws IOException
    {
   
		
	ele0=jExamYear.getText();
	ele1=jExamMonth.getText();
	ele2=jExamDate.getText();
	ele3=jSemester.getText();
	ele4=jDateoE.getValue().toString()+"  "+jgroup.getSelectedToggle()+"";
	ele5=Trade1.getText();
	ele6=Trade2.getText();
	ele4=ele4.substring(0,10)+" "+ele4.substring(ele4.length()-3,ele4.length()-1);
	ele7=jOMRsheetn.getText();
	ele8=jSubject.getText();
	ele9=jOMRsheetn2.getText();
	ele10=jSubject2.getText();
	FileWriter outFile = new FileWriter("jout.txt", true);
    PrintWriter out1 = new PrintWriter(outFile);
    try {
        out1.append(ele0);
        out1.println();
        out1.append(ele1);
        out1.println();
        out1.append(ele2);
        out1.println();
        out1.append(ele3);
        out1.println();
        out1.append(ele4);
        out1.println();
        out1.append(ele5);
        out1.println();
        out1.append(ele6);
        out1.println();
        out1.append(ele7);
        out1.println();
        out1.append(ele8);
        out1.println();
        out1.append(ele9);
        out1.println();
        out1.append(ele10);
        out1.println();
    } finally {
       out1.close();
    }

    
    Parent root2 = FXMLLoader.load(getClass(). getResource("Main3.fxml"));
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    Scene scene2 = new Scene(root2,width-20,height-90);
	scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
	window.setScene(scene2);
	window.show();
    }
	public void browseRPressed() throws IOException{
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));                 
		fileChooser.getExtensionFilters().addAll(
		    new FileChooser.ExtensionFilter("All Text", "*.txt")
		);
		File file = fileChooser.showOpenDialog(null);
		String path = file.getPath().toString();
		
		rtf.setText(path);
	}
	public void jbrowseRPressed() throws IOException{
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));                 
		fileChooser.getExtensionFilters().addAll(
		    new FileChooser.ExtensionFilter("All Text", "*.txt")
		);
		File file = fileChooser.showOpenDialog(null);
		String path = file.getPath().toString();
		
		jrtf.setText(path);
	}
	public void generatePressed() throws IOException{
		File in=new File("./res/SETplan.pdf");
    	in.delete();
    	
		 a1=Integer.parseInt(noc.getText());a2=Integer.parseInt(nor.getText());a3=Integer.parseInt(rpr.getText());a4=Integer.parseInt(cpr.getText());
		String hs=htf.getText();
		String rs=rtf.getText();
		String startingSet = comboBox.getValue().toString();
		try {
			
		workingWord obj = new workingWord();
		try {
		getOut("out.txt");	
		ele0=out.remove();
		ele1=out.remove();
		ele2=out.remove();
		ele3=out.remove();
		ele4=out.remove();
		ele5=out.remove();
		ele6=out.remove();
        ele7=out.remove();
		obj.begin(a1, a2, a4, a3,hs,rs,ele0,ele1,ele2,ele3,ele4,ele5,ele6,ele7,startingSet);
		
		}
		catch(Exception ie)
		{
			ie.printStackTrace();
		}
		if(a1<1) ErrorMessage.setText("Invalid number of Candidates!");
		else if(a1>(a2*a3*a4)) ErrorMessage.setText("Insufficient rooms!");
		else if(numberOfLines(hs)<a1-1) ErrorMessage.setText("given halltickets are less than "+a1+"!");
		else if(numberOfLines(rs)<a2-1) ErrorMessage.setText("given rooms are less than "+a2+"!");
		
		else 
			{
			ErrorMessage.setText("");
			

			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
			ErrorMessage.setText("Invalid Input!");
		}
		Runtime.getRuntime().exec("1.bat");
		try 
		{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popup.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Scene scene = new Scene(root1);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 stagep = new Stage();
		stagep.setTitle("Selection Window");
		stagep.getIcons().add(
				new Image("file:ExamManager.png")	);
		stagep.setScene(scene);
		
		stagep.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void jgeneratePressed() throws IOException{
		File in=new File("./res/SETplan.pdf");
    	in.delete();
		 a1=Integer.parseInt(jnoc.getText());a2=Integer.parseInt(jnor.getText());a3=Integer.parseInt(jrpr.getText());a4=Integer.parseInt(jcpr.getText());
		String hs=jhtf.getText();
		String hs2=jhtf2.getText();
		String rs=jrtf.getText();
		
		try {
			
		jworkingWord obj = new jworkingWord();
		try {
		getOut("jout.txt");	
		ele0=out.remove();
		ele1=out.remove();
		ele2=out.remove();
		ele3=out.remove();
		ele4=out.remove();
		ele5=out.remove();
		ele6=out.remove();
        ele7=out.remove();
        ele8=out.remove();
        ele9=out.remove();
        ele10=out.remove();
		obj.begin(a1, a2, a3, a4,hs,hs2,rs,ele0,ele1,ele2,ele3,ele4,ele5,ele6,ele7,ele8,ele9,ele10);
		
		}
		catch(Exception ie)
		{
			ie.printStackTrace();
		}
		if(a1<1) jErrorMessage.setText("Invalid number of Candidates!");
		else if(a1>(a2*a3*a4)) jErrorMessage.setText("Insufficient rooms!");
		else if(numberOfLines(hs)+numberOfLines(hs2)<a1-1) jErrorMessage.setText("given halltickets are less than "+a1+"!");
		else if(numberOfLines(rs)<a2-1) jErrorMessage.setText("given rooms are less than "+a2+"!");
		
		else 
			{
			jErrorMessage.setText("");
			

			}
		}
		catch(Exception E)
		{
			E.printStackTrace();
			jErrorMessage.setText("Invalid Input!");
		}
		Runtime.getRuntime().exec("1.bat");
		try 
		{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popup.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Scene scene = new Scene(root1);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 stagep = new Stage();
		stagep.setTitle("Selection Window");
		stagep.getIcons().add(
				new Image("file:ExamManager.png")	);
		stagep.setScene(scene);
		
		stagep.show();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void wordPressed() {
		if (Desktop.isDesktopSupported()) {
	           try {
	           	File myFile = new File( "./res/SETplan.docx");
	               Desktop.getDesktop().open(myFile);
	               
	           } catch (IOException ex) {
	               // no application registered for PDFs
	           } 
	        
	        
	          
	      
	       }
	}
	public void pdfPressed() {
		try
		{
			
			if (Desktop.isDesktopSupported()) {
		           try {
		           	File myFile = new File( "./res/SETplan.pdf");
		               Desktop.getDesktop().open(myFile);
		               
		           } catch (IOException ex) {
		               // no application registered for PDFs
		           }
		           
		    
		       }

		  }
		  catch(Exception e) {}
		
	}
		
	
	public static int numberOfLines(String filename) throws IOException {
	    InputStream fileinp = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] charact = new byte[1024];
	        int count = 0;
	        int readC = 0;
	        boolean empty = true;
	        while ((readC = fileinp.read(charact)) != -1) {
	            empty = false;
	            for (int i = 0; i < readC; ++i) {
	                if (charact[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        fileinp.close();
	    }
	}
	public void getOut(String rs) throws java.io.IOException {

        String fileName = rs;
        

        String line = null;

        try {
    
            java.io.FileReader fileReader = 
                new java.io.FileReader(fileName);

  
            java.io.BufferedReader bufferedReader = 
                new java.io.BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

                this.out.add(line);

             }   

            
            bufferedReader.close(); 
        }
        
        catch(java.io.FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'"); 
            }
        catch(java.io.IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");
            
        }
        finally {

        }
          
    } 
}

