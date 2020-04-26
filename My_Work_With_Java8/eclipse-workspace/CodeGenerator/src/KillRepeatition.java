import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class KillRepeatition
{
public static void main(String[] args) throws IOException 
{
	Scanner s = new Scanner(System.in);
	String inputFile = s.next();

PrintWriter pw = new PrintWriter(new File("C:\\Users\\k\\Desktop\\Dictionary\\"+inputFile+"\\Dictionary\\"+inputFile+".txt"));

BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k\\Desktop\\Dictionary\\"+inputFile+"\\Dictionary\\final.txt")));
String line = br.readLine();

List<String> al = new ArrayList<String>();

while(line != null)
{
			if(line.indexOf("\"\",\"\");")>0)
			{
				System.out.println(line);
				line = br.readLine();
				continue;
			}
			int i=0;
			boolean contains = false;
			while(al.size()>i) 
			{
				if(al.get(i).equalsIgnoreCase(line))
					contains = true;
				i++;
			}
			if(contains==false)
				{
					al.add(line);
					line.replaceAll("Examples :- ","\nExamples :- ").replace("–","-");
					pw.println(line);
				}
			line = br.readLine();
}

br.close();
pw.close();
System.out.println("File operation performed successfully");
}
}