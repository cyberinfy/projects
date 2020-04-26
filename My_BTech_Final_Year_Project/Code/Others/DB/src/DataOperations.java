import java.sql.*;

public class DataOperations 
{
	public String insertIntoDB(String word, String type, String definition) 
	{
			Connection c = null; 
			Statement stmt = null;
		try { 
			Class.forName("org.sqlite.JDBC");         
			c = DriverManager.getConnection("jdbc:sqlite:test.db");        
			c.setAutoCommit(false); 
			System.out.println("Opened database successfully");
		    stmt = c.createStatement(); 
		    String sql = "SELECT Count(*) FROM DICTIONARY;";
		    int id = stmt.executeUpdate(sql)+1;
		    sql = "INSERT INTO DICTIONARY "+
		    					 "(WORD,TYPE,DEFINITION) "+ 
		    					 "VALUES ("+word+","+type+","+definition+");";
		    stmt.executeUpdate(sql);
		    stmt.close();         
		    c.commit();         
		    c.close(); 
		    } 
		catch ( Exception e ) 
		{ 
			return ("Exception");
		} 
		
		return ("Records created successfully");
	}
	public String updateDB(String type,String definition) 
	{
			Connection c = null; 
			Statement stmt = null;
		try { 
			Class.forName("org.sqlite.JDBC");         
			c = DriverManager.getConnection("jdbc:sqlite:test.db");        
			c.setAutoCommit(false); 
			System.out.println("Opened database successfully");
		    stmt = c.createStatement(); 
		    String sql = "UPDATE DICTIONARY set TYPE = "+type+",DEFINITION ="+definition+" where ID="+1+";";
		    stmt.executeUpdate(sql);
		    stmt.close();         
		    c.commit();         
		    c.close(); 
		    } 
		catch ( Exception e ) 
		{ 
			return ("Exception");
		} 
		
		return ("Records updated successfully");
	}

	public String deleteFromDB(String word) 
	{
			Connection c = null; 
			Statement stmt = null;
		try { 
			Class.forName("org.sqlite.JDBC");         
			c = DriverManager.getConnection("jdbc:sqlite:test.db");        
			c.setAutoCommit(false); 
			System.out.println("Opened database successfully");
		    stmt = c.createStatement(); 
		    String sql = "DELETE from DICTIONARY where WORD="+word+";";         
	         stmt.executeUpdate(sql);  
		    stmt.close();         
		    c.commit();         
		    c.close(); 
		    } 
		catch ( Exception e ) 
		{ 
			return ("Exception");
		} 
		
		return ("Records deleted successfully");
	}
	
	public String retrieveFromDB() 
	{
			Connection c = null; 
			Statement stmt = null;
		try { 
			Class.forName("org.sqlite.JDBC");         
			c = DriverManager.getConnection("jdbc:sqlite:test.db");        
			c.setAutoCommit(false); 
			System.out.println("Opened database successfully");
		    stmt = c.createStatement(); 
	      	ResultSet rs = stmt.executeQuery( "SELECT * FROM DICTIONARY;" );
	      	while ( rs.next() ) 
	      	{ 
	      		int id = rs.getInt("id"); 
	      		String  word = rs.getString("word");
	      		String startswith = rs.getString("startswith");
	      		String type  = rs.getString("type"); 
	      		String  definition = rs.getString("definition"); 
	      		
	      		System.out.println( "ID = " + id ); 
	      		System.out.println( "WORD = " + word ); 
	      		System.out.println( "STARTSWITH = " + startswith ); 
	      		System.out.println( "TYPE = " + type ); 
	      		System.out.println( "DEFINITION = " + definition ); 
	      		System.out.println("------------------------------------------------");
	      	}      		
	      	rs.close();   
		    
		    stmt.close();         
		    c.commit();         
		    c.close(); 
		    } 
		catch ( Exception e ) 
		{ 
			return ("Exception");
		} 
		
		return ("Records retrieved successfully");
	}
	public ResultSet getThis(String word)
	{
		
		Connection c = null; 
		Statement stmt = null;
		ResultSet rs;
		try { 
		Class.forName("org.sqlite.JDBC");         
		c = DriverManager.getConnection("jdbc:sqlite:test.db");        
		c.setAutoCommit(false); 
		System.out.println("Opened database successfully");
		stmt = c.createStatement(); 
      	rs = stmt.executeQuery( "SELECT * FROM DICTIONARY WHERE WORD="+word+";" );
	    stmt.close();         
	    c.commit();         
	    c.close(); 
	    } 
	catch ( Exception e ) 
	{ 
		return null;
	} 
	
	return rs;
		
	}

	public ResultSet getNext(String word)
	{
		
		Connection c = null; 
		Statement stmt = null;
		ResultSet rs;
		try { 
		Class.forName("org.sqlite.JDBC");         
		c = DriverManager.getConnection("jdbc:sqlite:test.db");        
		c.setAutoCommit(false); 
		System.out.println("Opened database successfully");
		stmt = c.createStatement(); 
		
		String sql = "SELECT id FROM DICTIONARY WHERE WORD="+word+";";
	    int id = stmt.executeUpdate(sql)+1;
	    if(id > stmt.executeUpdate("SELECT Count(*) FROM DICTIONARY;"))
	    {
	    	id=1;
	    }
      	rs = stmt.executeQuery( "SELECT * FROM DICTIONARY WHERE id="+id+";" );
	    stmt.close();         
	    c.commit();         
	    c.close(); 
	    } 
	catch ( Exception e ) 
	{ 
		return null;
	} 
	
	return rs;
		
	}
	
	public ResultSet getPrevious(String word)
	{
		
		Connection c = null; 
		Statement stmt = null;
		ResultSet rs;
		try { 
		Class.forName("org.sqlite.JDBC");         
		c = DriverManager.getConnection("jdbc:sqlite:test.db");        
		c.setAutoCommit(false); 
		System.out.println("Opened database successfully");
		stmt = c.createStatement(); 
		
		String sql = "SELECT id FROM DICTIONARY WHERE WORD="+word+";";
	    int id = stmt.executeUpdate(sql)-1;
	    if(id <1)
	    {
	    	id=stmt.executeUpdate("SELECT Count(*) FROM DICTIONARY;");
	    }
      	rs = stmt.executeQuery( "SELECT * FROM DICTIONARY WHERE id="+id+";" );
	    stmt.close();         
	    c.commit();         
	    c.close(); 
	    } 
	catch ( Exception e ) 
	{ 
		return null;
	} 
	
	return rs;
		
	}
	
}
