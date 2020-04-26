import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBG 
{ 
	public static void main( String args[] ) throws FileNotFoundException 
	{ 
		Connection c = null; 
		Statement stmt = null;
		PrintWriter pw = new PrintWriter(new File("words.txt"));
		try 
		{ 
			Class.forName("org.sqlite.JDBC");         
			c = DriverManager.getConnection("jdbc:sqlite:MASK.db");        
			c.setAutoCommit(false); 
			System.out.println("Opened database successfully");
			stmt = c.createStatement(); 
			String sql = "Select * from DICTIONARY";   
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String str = "\""+rs.getString(2)+"\",\""+rs.getString(3)+"\",\""+rs.getString(4).replaceAll("\n", "\\|")+"\");";
				pw.println(str);
				
			}
			pw.close();
			stmt.close();         
			c.commit();         
			c.close(); 
	    } 
	catch ( Exception e ) 
	{ 
		System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
		System.exit(0);
	} 

	}
}