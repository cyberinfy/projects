
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IntermediateFileCreation 
{

	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(System.in);
		String inputFile = s.next();
		FileInputStream fis = null;
		BufferedReader reader = null;
		
		 PrintWriter printWriter = new PrintWriter(new FileWriter(new File("C:\\Users\\k\\Desktop\\Dictionary\\"+inputFile+"\\Dictionary\\intermediate.txt")));
		try 
		{
			String filePath = "C:\\Users\\k\\Desktop\\Dictionary\\"+inputFile+"\\Dictionary\\Dictionary.txt";
			fis = new FileInputStream(filePath);
			reader = new BufferedReader(new InputStreamReader(fis));
			String line = reader.readLine();
			
			while(line != null)
			{
				
				
				line = line.replaceAll("\"","");
				line =	line.replaceAll("‘", "");
				line =	line.replaceAll("’", "");
				line =	line.replaceAll("|", "");
				line =	line.replaceAll("UnKnownKind, ", "");
				line =	line.replaceAll("UnKnownKind", "");
				
				
				if(line.length()!=0) 
				{
					if(line.equals("--Word--"))
						printWriter.println();
					printWriter.append(line+"|");
				}
				line = reader.readLine();
			}
		}
		catch(Exception e) 
		{
			
		}
		finally 
		{
			printWriter.close();
			reader.close();
		}
	}

}
