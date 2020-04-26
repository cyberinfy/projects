package application;
import java.io.FileOutputStream;
import java.io.File;
import java.math.BigInteger;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

public class jworkingWord {
	public String htickets="";
	int countA=0,countB=0,countC=0,countD=0;
    String tempsArray;
	

    public java.util.Queue<String> arr = new java.util.LinkedList<String>();
    public java.util.Queue<String> arrbac = new java.util.LinkedList<String>();
    public java.util.Queue<String> arrrestore = new java.util.LinkedList<String>();
    public java.util.Queue<String> arr2 = new java.util.LinkedList<String>();
    public java.util.Queue<String> arrbac2 = new java.util.LinkedList<String>();
    public java.util.Queue<String> arrrestore2 = new java.util.LinkedList<String>();
    public java.util.Queue<Character> setrestore = new java.util.LinkedList<Character>();
    public java.util.Queue<String> room = new java.util.LinkedList<String>();
    public String hts[][][];
    public void begin(int a1,int a2,int a3,int a4,String hs,String hs2,String rs,String EY,String EM,String ED,String Sem,String Doe,String Trade,String Trade2,String OMRsheetn,String Subject,String OMRsheetn2,String Subject2) throws java.io.IOException{
    this.getData(hs);
    this.getData2(hs2);
    this.getRoom(rs);
    this.run(a1,a2,a3,a4,EY,EM,ED,Sem,Doe,Trade,Trade2,Long.parseLong(OMRsheetn),Subject,Long.parseLong(OMRsheetn2),Subject2);
   
    
    }



    public void run(int a1,int a2,int a3,int a4,String EY,String EM,String ED,String Sem,String Doe,String Trade,String Trade2,Long OMRsheetno,String Subject,Long OMRsheetno2,String Subject2) {
    	OMRsheetno-=1;
    	OMRsheetno2-=1;
    	String hts[][][] = new String[a2][a3][a4];
        Inp obj = new Inp();
        obj.setP(a1);
        obj.setR(a2);
        obj.setM(a3);
        obj.setN(a4);

        int c = obj.getP();
        c = obj.getP();
        int mem=0,ar1s=arr.size(),ar2s=arr2.size();
    	XWPFDocument document=new XWPFDocument();
    	CTSectPr sectPr;
    	CTPageMar pageMar;
    	FileOutputStream out;

        try{
 			 
		   document= new XWPFDocument();
		   XWPFDocument document2 = new XWPFDocument();
		   sectPr = document.getDocument().getBody().addNewSectPr();
		   pageMar = sectPr.addNewPgMar();
		   pageMar.setLeft(BigInteger.valueOf(720L));
		   pageMar.setTop(BigInteger.valueOf(360L));
		   pageMar.setRight(BigInteger.valueOf(720L));
		   pageMar.setBottom(BigInteger.valueOf(360L));
		   out = new FileOutputStream(new File("./res/SETplan.docx"));
 			
 			
 			
 			obj.setM(a3);
 			obj.setN(a4);
			String Temp=Trade;
		
 			for(int k=0;k<obj.getR();k++)
 			{
 				
 				
 				for(int j=0;j<obj.getN();j++)
                {
 					 
 	 				for(int i=0;i<obj.getM();i++)
                    
                    {
                    	if(obj.getM()%2==0 )
                    	{
                    	if(Temp == Trade && i< (a3-1))
                    	{
                    		hts[k][i][j]=Temp+"~"+arr.remove();
                    		Temp = Trade2;
                    		
                    	}
                    	else if(Temp == Trade2 && i< (a3-1))
                    	{
                    		hts[k][i][j]=Temp+"~"+arr2.remove();
                    		Temp = Trade;
                    		
                    	}
                    	else 
                    	{

                        	if(Temp == Trade )
                        	{
                        		hts[k][i][j]=Temp+"~"+arr.remove();
                        		
                        		
                        	}
                        	else if(Temp == Trade2 )
                        	{
                        		hts[k][i][j]=Temp+"~"+arr2.remove();
                        		
                        		
                        	}
                    	}
                    }
                    	else
                    	{
                    		if(Temp == Trade)
                        	{
                        		hts[k][i][j]=Temp+"~"+arr.remove();
                        		Temp = Trade2;
                        		
                        	}
                        	else if(Temp == Trade2)
                        	{
                        		hts[k][i][j]=Temp+"~"+arr2.remove();
                        		Temp = Trade;
                        		
                        	}

                    	}
                    	
                    }
                }
 			}
 			XWPFParagraph paragraph,title,titleEnd,page2title,nextend,temp1;
 			XWPFRun run,run2,run3,run4;
 			XWPFTable wadtable,wdtable0,nextwadtable;
 			XWPFTableRow wadtableRow,wdtable0Row,wdtable0Row1,wdtable0Row2,nextwadtableRow,laterwadtableRow;
      for(int k=0;k<obj.getR();k++)
            {  
    	  int arrsize=arr.size();
			int arr2size=arr2.size();
			int hs1=(a3*a4)/2;
			int hs2=(a3*a4)/2;
			if((a3*a4)%2==1)
			{
			if(k%2==0||k==0)
				hs1+=1;
			else
				hs2+=1;
			}
    	  paragraph = document.createParagraph();            
          paragraph.setAlignment(ParagraphAlignment.CENTER);  
          paragraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);  
          paragraph.setBorderLeft(Borders.BASIC_BLACK_DASHES);           
          paragraph.setBorderRight(Borders.BASIC_BLACK_DASHES);
          paragraph.setBorderTop(Borders.BASIC_BLACK_DASHES); 
          
          run=paragraph.createRun();   
          run.setText("T.T.C. Dr.B.R.Ambedkar Memorial Industrial Institute Centre. Gollapudi, Vijayawada.");
          run.addBreak();
          run.setText("A.I.T.T.Examination to be held From "+ED+"-"+EM+"-"+EY);
          run.addBreak();
          run.setText("SEATING ARRANGEMENT-SEMESTER-"+Sem+"");
          run.addBreak();
          run.setText("Date Of Examination: "+Doe+" ");           
				  
                    
               mem=mem+1;
               String RoomNumber="";
               
                RoomNumber="          Room number :"+this.room.remove()+"   "+"";
                mem=mem+obj.getM()*obj.getN()-1;
                title=document.createParagraph();
                title.setAlignment(ParagraphAlignment.CENTER);  
                title.setBorderBottom(Borders.BASIC_BLACK_DASHES);  
                title.setBorderLeft(Borders.BASIC_BLACK_DASHES);           
                title.setBorderRight(Borders.BASIC_BLACK_DASHES);
                title.setBorderTop(Borders.BASIC_BLACK_DASHES); 
                
				run=title.createRun(); 
				run.setText(RoomNumber);
				
       
                wadtable=document.createTable(obj.getM(),obj.getN());
                
                wadtable.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10860));
                wadtableRow=wadtable.getRow(0);
                
                htickets="";
                for(int i=0;i<obj.getM();i++)
                {
            		 wadtableRow=wadtable.getRow(i);
            		 for(int j=0;j<obj.getN();j++)
                    {

                    	
                    	if(c>0)
                    	{
                        	
                    		String temper;
                    		String TempTrade="";
                    		temper=hts[k][i][j].substring(hts[k][i][j].indexOf('~')+1);
                    		TempTrade=hts[k][i][j].substring(0,hts[k][i][j].indexOf('~'));
                    		htickets=htickets+","+temper;
                    		temp1=document2.createParagraph();
                    		temp1.setAlignment(ParagraphAlignment.CENTER);
                    		run=temp1.createRun(); 
                    		run.setText(""+TempTrade);
                    		run.addBreak();
                    		run.setText("");
                    		run.addBreak();
                    		run.setText(""+temper);
                    		wadtableRow.getCell(j).setParagraph(temp1);
                    		 
                    		
                    	}
                    	else
                    		wadtableRow.getCell(j).setText("-");
                    	
                    	
                     
                   
                     c=c-1;

                    }
                    if(c <= 0) break;
                }
                XWPFParagraph parag = document.createParagraph();
                XWPFRun runpbg = parag.createRun(); 
               
                wdtable0=document.createTable(3,2);
                wdtable0.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10860));
                wdtable0Row=wdtable0.getRow(0);
                title=document2.createParagraph();
                title.setAlignment(ParagraphAlignment.CENTER);
                run=title.createRun(); 
        		run.setText("Number of question papers : ");

                wdtable0Row.getCell(0).setParagraph(title);
                title=document2.createParagraph();
                title.setAlignment(ParagraphAlignment.CENTER);  
      
                run=title.createRun(); 
        		run.setText(""+(a3*a4)+"");
                wdtable0Row.getCell(1).setParagraph(title);
                wdtable0Row1=wdtable0.getRow(1);
                title=document2.createParagraph();
                title.setAlignment(ParagraphAlignment.CENTER);
                run=title.createRun(); 
        		run.setText("Number of "+Subject+":");
                wdtable0Row1.getCell(0).setParagraph(title);
                title=document2.createParagraph();
                title.setAlignment(ParagraphAlignment.CENTER);  

                run=title.createRun(); 
        		run.setText(""+(hs1)+"");
                wdtable0Row1.getCell(1).setParagraph(title);
                wdtable0Row2=wdtable0.getRow(2);
                title=document2.createParagraph();
                title.setAlignment(ParagraphAlignment.CENTER);
                run=title.createRun(); 
        		run.setText("Number of "+Subject2+":");
                wdtable0Row2.getCell(0).setParagraph(title);
                title=document2.createParagraph();
                title.setAlignment(ParagraphAlignment.CENTER);  

                run=title.createRun(); 
        		run.setText(""+(hs2)+"");
        		wdtable0Row2.getCell(1).setParagraph(title);
                String htickets="";
                int count=0;
             
                	
                	for(int l=0;l<hs1;l++)
                	{
                		
                		 htickets=htickets+",  "+arrbac.peek();
                		 arrrestore.add(arrbac.remove());
                		 count++;
                	}
              
                
                parag = document.createParagraph();
                runpbg = parag.createRun(); 
              
                titleEnd=document.createParagraph(); 
                titleEnd.setBorderBottom(Borders.BASIC_BLACK_DASHES);
                titleEnd.setBorderLeft(Borders.BASIC_BLACK_DASHES);
                titleEnd.setBorderRight(Borders.BASIC_BLACK_DASHES);
                titleEnd.setBorderTop(Borders.BASIC_BLACK_DASHES); 
                run2=titleEnd.createRun();
                run2.setText(Trade);
                run2.addBreak();
                run2.setText(htickets.substring(2));
                run2.addBreak();
                run2.setText(" -"+count+"No's");
                count=0;
                htickets="";
                
                	
                	for(int l=0;l<hs2;l++)
                	{
                		
                		 htickets=htickets+",  "+arrbac2.peek();
                		 arrrestore2.add(arrbac2.remove());
                		 count++;
                	}
                	
                
                titleEnd=document.createParagraph(); 
                titleEnd.setBorderBottom(Borders.BASIC_BLACK_DASHES);
                titleEnd.setBorderLeft(Borders.BASIC_BLACK_DASHES);
                titleEnd.setBorderRight(Borders.BASIC_BLACK_DASHES);
                titleEnd.setBorderTop(Borders.BASIC_BLACK_DASHES); 
                run2=titleEnd.createRun();
                run2.setText(Trade2);
                run2.addBreak();
                run2.setText(htickets.substring(1));
                run2.addBreak();
                run2.setText(" -"+count+"No's");
                count=0;
                
                String datecur = Doe ;
                XWPFParagraph para = document.getLastParagraph();
                XWPFRun runpb = para.createRun(); runpb.addBreak(BreakType.PAGE);
              
                
                page2title = document.createParagraph();
                page2title.setBorderBottom(Borders.BASIC_BLACK_DASHES);
                page2title.setBorderLeft(Borders.BASIC_BLACK_DASHES);
                page2title.setBorderRight(Borders.BASIC_BLACK_DASHES);
                page2title.setBorderTop(Borders.BASIC_BLACK_DASHES); 
                run3=page2title.createRun();
                run3.setText("                                                                  AITT-"+EM+"-"+EY+"-EXAMINATIONS-SEMESTER-"+Sem+"");
                run3.addBreak();
                run3.setText("                                                                                     ATTENDANCE SHEET");
                run3.addBreak();
                run3.setText("                               Name of the ITI/ITC   Dr. B.R.AMBEDKAR MEMORIAL INDUSTRIAL TRAINING INSTITUTE");
                run3.addBreak();
                run3.setText("                         Class Room No/LAB :   "+RoomNumber.substring(23)+"    "+Trade+" Subject:    "+Subject+",");
                run3.addBreak();
                run3.setText(Trade2+" Subject:    "+Subject2+"                      Date:"+datecur);
                

                nextwadtable=document.createTable();
                nextwadtable.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10860));
                nextwadtableRow=nextwadtable.getRow(0);
                nextwadtableRow.getCell(0).setText("S No");
                nextwadtableRow.createCell();
                nextwadtableRow.getCell(1).setText("Trade");
                nextwadtableRow.createCell();
                nextwadtableRow.getCell(2).setText("Hall-ticket Number"); 
                nextwadtableRow.createCell();
                nextwadtableRow.getCell(3).setText("OMR SHEET NUMBER");
                nextwadtableRow.createCell();
                nextwadtableRow.getCell(4).setText("Question Paper Series");
                nextwadtableRow.createCell();
                nextwadtableRow.getCell(5).setText("Signature of the Trainee ");
  			    int tk=1;
                for(int i=1;i<=a3*a4;i++)
  			    {
                		   laterwadtableRow=nextwadtable.createRow();
                	if(arrrestore.size()>0) {
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                       
                        run=title.createRun(); 
        				run.setText(tk+++"");
                		laterwadtableRow.getCell(0).setParagraph(title);
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                      
                        run=title.createRun(); 
                		run.setText(Trade);
                		laterwadtableRow.getCell(1).setParagraph(title);
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                      
                        run=title.createRun(); 
                		run.setText(arrrestore.remove());
                		laterwadtableRow.getCell(2).setParagraph(title);
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                   
                        run=title.createRun(); 
                		run.setText((OMRsheetno=OMRsheetno+1)+"");
                		laterwadtableRow.getCell(3).setParagraph(title);
                		String temper="";
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                     
                        run=title.createRun(); 
                		run.setText(temper);
                		laterwadtableRow.getCell(4).setParagraph(title);
                
                		laterwadtableRow.getCell(5).setText(" ");
                	}
                	else if(arrrestore2.size()>0) {
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                       
                        run=title.createRun(); 
        				run.setText(tk+++"");
                		laterwadtableRow.getCell(0).setParagraph(title);
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                      
                        run=title.createRun(); 
                		run.setText(Trade2);
                		laterwadtableRow.getCell(1).setParagraph(title);
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                      
                        run=title.createRun(); 
                		run.setText(arrrestore2.remove());
                		laterwadtableRow.getCell(2).setParagraph(title);
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                   
                        run=title.createRun(); 
                		run.setText((OMRsheetno2=OMRsheetno2+1)+"");
                		laterwadtableRow.getCell(3).setParagraph(title);
                		String temper="";
                		title=document2.createParagraph();
                        title.setAlignment(ParagraphAlignment.CENTER);  
                     
                        run=title.createRun(); 
                		run.setText(temper);
                		laterwadtableRow.getCell(4).setParagraph(title);
                
                		laterwadtableRow.getCell(5).setText(" ");
                	}
                	else
                	{
                		laterwadtableRow.getCell(0).setText("");
                
                		laterwadtableRow.getCell(1).setText("");
          
                		laterwadtableRow.getCell(2).setText("");
                	
                		laterwadtableRow.getCell(3).setText("");
                	
                		laterwadtableRow.getCell(4).setText("");
              
                		laterwadtableRow.getCell(5).setText("");
                	}
                    
                    
  			    }
                XWPFParagraph parag2 = document.createParagraph();
                XWPFRun runpbg2 = parag2.createRun(); 
                nextend = document.createParagraph();
                nextend.setBorderBottom(Borders.BASIC_BLACK_DASHES);
                nextend.setBorderLeft(Borders.BASIC_BLACK_DASHES);
                nextend.setBorderRight(Borders.BASIC_BLACK_DASHES);
                nextend.setBorderTop(Borders.BASIC_BLACK_DASHES); 
                run4=nextend.createRun();
                run4.setText("           Total Number:"+(tk-1)+"");
                run4.addBreak();
                run4.setText("           No of Present:");
                run4.addBreak();
                run4.setText("           No of Absent:");
                run4.addBreak();
                run4.setText("                                                                                                                       -Signature of Invigilator");
                para = document.getLastParagraph();
                runpb = para.createRun(); 
                runpb.addBreak(BreakType.PAGE);
                if(c <= 0) break;
                document2.close();
                
            }
      XWPFParagraph nextTitle = document.createParagraph();
      nextTitle.setBorderBottom(Borders.BASIC_BLACK_DASHES);
      nextTitle.setBorderLeft(Borders.BASIC_BLACK_DASHES);
      nextTitle.setBorderRight(Borders.BASIC_BLACK_DASHES);
      nextTitle.setBorderTop(Borders.BASIC_BLACK_DASHES); 
      XWPFRun run5=nextTitle.createRun();
      run5.setText("Requirements for the exam"); 			
      XWPFTable wdtable1=document.createTable();
      wdtable1.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(10860));
      XWPFTableRow wdtable1Row=wdtable1.getRow(0);
      title=document2.createParagraph();
      title.setAlignment(ParagraphAlignment.CENTER);
      run=title.createRun(); 
		run.setText("Total Number of questionpapers : ");
      wdtable1Row.getCell(0).setParagraph(title);
      wdtable1Row.createCell();
      title=document2.createParagraph();
      title.setAlignment(ParagraphAlignment.CENTER); 
      run=title.createRun();
      run.setText(""+a1+"");
      wdtable1Row.getCell(1).setParagraph(title);
      XWPFTableRow wdtable1Row1=wdtable1.createRow();
      title=document2.createParagraph();
      title.setAlignment(ParagraphAlignment.CENTER);
      run=title.createRun(); 
		run.setText("Total Number of "+Subject+":");
      wdtable1Row1.getCell(0).setParagraph(title);
      title=document2.createParagraph();
      title.setAlignment(ParagraphAlignment.CENTER);  
  
      run=title.createRun();
      run.setText(""+(ar1s-arr.size())+"");
      wdtable1Row1.getCell(1).setParagraph(title);
      XWPFTableRow wdtable2Row2=wdtable1.createRow();
      title=document2.createParagraph();
      title.setAlignment(ParagraphAlignment.CENTER);
      run=title.createRun(); 
		run.setText("Total Number of "+Subject2+":");
      wdtable2Row2.getCell(0).setParagraph(title);
      title=document2.createParagraph();
      title.setAlignment(ParagraphAlignment.CENTER);  

      run=title.createRun();
      run.setText(""+(ar2s-arr2.size())+"");
      wdtable2Row2.getCell(1).setParagraph(title);

      XWPFParagraph nextTitleEnd = document.createParagraph();
      nextTitleEnd.setPageBreak(true);
      XWPFRun run6=nextTitleEnd.createRun();
      
      run6.addBreak();
      document.write(out);
      out.close();
      document.close();
        }
      		 catch(Exception e) {
      			e.printStackTrace();
      		 }
        
      		}
      	
    public void getData(String hs) throws java.io.IOException {

        String fileName = hs;


        String line = null;

        try {
    
            java.io.FileReader fileReader = 
                new java.io.FileReader(fileName);

  
            java.io.BufferedReader bufferedReader = 
                new java.io.BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

                this.arr.add(line);
                this.arrbac.add(line);

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
          
    }  
    public void getData2(String hs) throws java.io.IOException {

        String fileName = hs;


        String line = null;

        try {
    
            java.io.FileReader fileReader = 
                new java.io.FileReader(fileName);

  
            java.io.BufferedReader bufferedReader = 
                new java.io.BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

                this.arr2.add(line);
                this.arrbac2.add(line);

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
          
    }  
    public void getRoom(String rs) throws java.io.IOException {

        String fileName = rs;


        String line = null;

        try {
    
            java.io.FileReader fileReader = 
                new java.io.FileReader(fileName);

  
            java.io.BufferedReader bufferedReader = 
                new java.io.BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

                this.room.add(line);

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
          
    } 
}
