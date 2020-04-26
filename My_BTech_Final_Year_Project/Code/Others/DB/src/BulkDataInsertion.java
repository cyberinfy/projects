import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BulkDataInsertion {

	
	public static void main( String args[] ) throws Throwable 
	{ 
		
		Scanner s = new Scanner(System.in);
		String inputFile = s.next();
		FileInputStream fis = null;
		BufferedReader reader = null;
		Connection c = null; 
		Statement stmt = null;
		ResultSet n = null;
		try 
		{
			String filePath = "C:\\Users\\kvrks\\Desktop\\Dictionary\\"+inputFile+"\\Dictionary\\finalMod.txt";
			fis = new FileInputStream(filePath);
			reader = new BufferedReader(new InputStreamReader(fis));
			String line = new String(reader.readLine());

			A: while(line != null)
			{
				System.out.println(line.substring(0,line.indexOf(",")).toLowerCase());
				try 
				{
				Class.forName("org.sqlite.JDBC");         
				c = DriverManager.getConnection("jdbc:sqlite:MASK.db");      
				c.setAutoCommit(false); 
				System.out.println("Opened database successfully");
				stmt = c.createStatement(); 
				String sql = "SELECT * FROM DICTIONARY WHERE LOWER(WORD)="+line.substring(0,line.indexOf(",")).toLowerCase()+";"; 
				n = stmt.executeQuery(sql);
				if(n.next())
				{
					n.close();
					stmt.close();
					c.close(); 
					line = reader.readLine().replaceAll("\\|", "\n");
					
					continue A;
				}
				n.close();
				sql = "INSERT INTO DICTIONARY "+
	    					 "(WORD,TYPE,DEFINITION) "+ 
	    					 "VALUES ("+line ;
				stmt.executeUpdate(sql);
				stmt.close();    
				c.commit(); 
				c.close(); 
				line = reader.readLine();
				}
				catch(Exception e)
				{
					System.out.println("Exception");
					System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
					
				}
				
				finally
				{
					n.close();
					stmt.close(); 
					c.close(); 
				}
				
			}
			System.out.println("Records created successfully");
		} 
		catch ( Exception e ) 
			{ 
				
			} 
			
	}
}