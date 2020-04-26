import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FinalFileCreation 
{

	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(System.in);
		String inputFile = s.next();
		FileInputStream fis = null;
		BufferedReader reader = null;
		int i = 0,n=0;
		int total,indexOfWord,indexOfType,indexOfMeanings,indexOfExamples;
		String word="",type = "",meanings="",examples="";
		PrintWriter printWriter = new PrintWriter(new FileWriter(new File("C:\\Users\\k\\Desktop\\Dictionary\\"+inputFile+"\\Dictionary\\final.txt")));
		try 
		{
			String filePath = "C:\\Users\\k\\Desktop\\Dictionary\\"+inputFile+"\\Dictionary\\intermediate.txt";
			fis = new FileInputStream(filePath);
			reader = new BufferedReader(new InputStreamReader(fis));
			String line = new String(reader.readLine());

			while(line != null)
			{
				meanings = "";
				examples = "";
				i=0;
				n=0;
				
				if(line.length()!=0) 
				{
					
					line = line.substring(0, line.length()-1); 
					String[] content = line.split("\\|");
					List<String> arrayList = new ArrayList<String>();
					Collections.addAll(arrayList, content);
					total = arrayList.size();
					indexOfWord = arrayList.indexOf("--Word--");
					indexOfType = arrayList.indexOf("--Type--");
					indexOfMeanings = arrayList.indexOf("--Meanings--");
					indexOfExamples = arrayList.indexOf("--Examples--");
					word = arrayList.get(1);
					if(indexOfMeanings - indexOfType > 1)
					{
						type = arrayList.get(3);
						String arr[] = type.split(", ");
						if(arr.length>1)
						{
							
						HashSet<String> th = new HashSet<String>();
						for(String g : arr)
						{
							
							th.add(g);
						}
						type = "";
						for(String g:th)
						{
							type+=g+", ";
						}
						type = type.substring(0,type.length()-2);
						}
					}
					else
						type = "";
					if(indexOfExamples-indexOfMeanings > 1)
					{
						i = indexOfMeanings;
						n=0;
						while(i<indexOfExamples-1)
						{
							i=i+1;
							n=n+1;
							meanings = meanings+"("+(n)+") "+arrayList.get(i);
							meanings = meanings+"|";
						}
						
					}
					else
						meanings = "";
					
				if(total-indexOfExamples > 1)
					{
						i = indexOfExamples;
						n=0;
						while(i<total-1)
						{
							if(n==0) examples = "Examples :- |";
							i=i+1;
							n=n+1;
							examples = examples+"(Ex: "+(n)+") "+arrayList.get(i);
							examples= examples+"|";
						}
					}
					else
						examples = "";
					line = "\""+word.substring(0,word.length()-1)+"\",\""+type+"\",\""+meanings+examples+"\");";
					line = line.replaceAll("â€“", "-");
					line = line.replaceAll("â?»Â", " ");
					line = line.replaceAll("Â", "");
					line = line.replaceAll("Ã´lÃ©e", "olee");
					line = line.replaceAll("Ã—", "x");
					
					printWriter.append(line);
					printWriter.println();
					
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
