import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONObject;

public class Main {
	  public static void main(String[] args) throws IOException{
	      JSONObject obj = new JSONObject();

	      obj.put("name", "KVRKS");
	      obj.put("num", new Integer(563));
	      obj.put("Year", new Double(4.2));
	      obj.put("Programmer", new Boolean(true));
	      //method one to give output
	      System.out.println(obj);
	      
	      //Another way to give output
	      String jsonText = obj.toString();
	      System.out.println(jsonText);
	      
	      //accessing individual pair
	      System.out.println(obj.get("name"));
	   }
}
