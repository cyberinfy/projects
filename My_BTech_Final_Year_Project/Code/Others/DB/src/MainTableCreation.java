import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainTableCreation 
{ 
	public static void main( String args[] ) 
	{ 
		Connection c = null; 
		Statement stmt = null;
		try 
		{ 
			Class.forName("org.sqlite.JDBC");         
			c = DriverManager.getConnection("jdbc:sqlite:MASK.db");        
			c.setAutoCommit(false); 
			System.out.println("Opened database successfully");
			stmt = c.createStatement(); 
			String sql = "CREATE TABLE DICTIONARY "+ 
				    			 "(_id     INTEGER      PRIMARY KEY   AUTOINCREMENT    NOT NULL,"+
				    			 "WORD   TEXT  UNIQUE  NOT NULL,"+ 
				    			 "TYPE    TEXT    NOT NULL,"+ 
				    			 "DEFINITION    TEXT)";   
			 stmt.executeUpdate(sql);  
			stmt.close();         
			c.commit();         
			c.close(); 
	    } 
	catch ( Exception e ) 
	{ 
		System.err.println( e.getClass().getName() + ": " + e.getMessage() ); 
		System.exit(0);
	} 
	System.out.println("Table created successfully");
	}
}