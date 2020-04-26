import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Desktop;
import java.awt.Dimension;
import javax.swing.JTextField;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JComboBox;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.TextArea;
import java.awt.Toolkit;
public class n extends JFrame implements ActionListener,inter  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField Empid;
	 JTextField Cno;
	 JTextField Email;
	 JLabel lblOutput;
	 String leave,ad,empid,dep,des,nod,idnum,reason,email,emailt,phone,address,cwap,supe;
	 JTextField Desig;
	 JDateChooser From;
	 JDateChooser To;
	 JDateChooser Adate;
	 TextArea Reason;
	 TextArea Address;
	 JLabel phonenumberwarning;
	 JLabel empidwarning;
	 JLabel Adatewarning;
	 JLabel fromwarning;
	 JLabel towarning;
	 JLabel deswarning;
	 JComboBox<String> mail;
	 JComboBox<String> leavetype;
	 JComboBox<String> Nod;
	 JButton wadjust;
     JButton btnPrint;
     JButton btnNewButton;
     JLabel Reasonwarning;
     JLabel fwarning;
     tabs objt;
     int count=1;
     int w1,w2,w3,w4,w5,w6,w7,w8,w9,w10;
	 private tabs frame2 = null;
	

	 int emp=0,flag=0;
	 int n;
	  JLabel emailwarning;
	  JLabel addresswarning;
	  private JTextField id;
	  private JTextField Dept;
	  private JLabel depwarning;
	 
	 
	public void checkEmpid()
	{
		String message="\t\tWelcome to Before Leave";
		lblOutput.setText(message);
		phonenumberwarning.setVisible(false);
	    empidwarning.setVisible(false);
	    Adatewarning.setVisible(false);
	    fromwarning.setVisible(false);
	    towarning.setVisible(false);
	    deswarning.setVisible(false);
	    depwarning.setVisible(false);
	    Reasonwarning.setVisible(false); 
	    emailwarning.setVisible(false); 
	    addresswarning.setVisible(false); 
	    fwarning.setVisible(false);
	    btnNewButton.setEnabled(false);
	    btnPrint.setEnabled(false);
	    btnNewButton.setVisible(false);
	    btnPrint.setVisible(false);
	    
	}
	public static boolean isValidDate(String inDate) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    dateFormat.setLenient(false);
	    try {
	      dateFormat.parse(inDate.trim());
	    } catch (ParseException pe) {
	      return false;
	    }
	    return true;
	  }
	
	
	public boolean compared(String date1,String date2)
	{
	int a=date2.compareTo(date1);
	if(a<0)  return false; //System.out.println("date2 is before date1");  break;
	else if(a==0)   return true; //System.out.println("date2 and date1 equal");  break;
	else if(a>0)   return true; //System.out.println("date2 is after date1");  break;
	return false;
    }         
    
	public boolean isChar(String str) {                

	    if(str == null || str.isEmpty()) return true;

	    for(char c : str.toCharArray()){
	    	String s=Character.toString(c);
	        if(s.matches("[^a-z A-Z.]")){
	            
	            return true;
	        }
	    }
	        return false;
	}  
 public boolean isChar1(String str) {                

	    if(str == null || str.isEmpty()) return true;

	    for(char c : str.toCharArray()){
	    	String s=Character.toString(c);
	        if(s.matches("[^a-zA-Z0-9!#$%'*+-/=?^_`{|}~.]")){
	            
	            return true;
	        }
	    }
	        return false;
	}  

	        


	
	public static boolean isNumber(String string) {
	    if (string == null || string.isEmpty()) {
	        return false;
	    }
	    int i = 0;
	    if (string.charAt(0) == '-') {
	        if (string.length() > 1) {
	            i++;
	        } else {
	            return false;
	        }
	    }
	    for (; i < string.length(); i++) {
	        if (!Character.isDigit(string.charAt(i))) {
	            return false;
	        }
	    }
	    return true;
	}
	public void reset() throws IOException
	{
		 Empid.setText("");
		 Cno.setText("");
		 Email.setText("");	 
		 Desig.setText("");
		 Dept.setText("");
		 From.setDate(null);
		 To.setDate(null);
		 Adate.setDate(null);
		 Reason.setText("");
		 id.setText("");
		 Address.setText("");
		 mail.setSelectedIndex(0);
		 leavetype.setSelectedIndex(0);
		 Nod.setSelectedIndex(0);
		 
			phonenumberwarning.setVisible(false);
		    empidwarning.setVisible(false);
		    Adatewarning.setVisible(false);
		    fromwarning.setVisible(false);
		    towarning.setVisible(false);
		    deswarning.setVisible(false);
		    deswarning.setVisible(false);
		    Reasonwarning.setVisible(false); 
		    emailwarning.setVisible(false); 
		    addresswarning.setVisible(false);
		    String message="\t\tWelcome to Before Leave";
			lblOutput.setText(message);
		    fwarning.setVisible(false);
		    btnNewButton.setEnabled(false);
		    btnPrint.setEnabled(false);
		    btnNewButton.setVisible(false);
		    btnPrint.setVisible(false);
		    
		    frame2=null;
		    int i;
		    for(i=1;i<19;i++)
		    {
		    	sl1[i]=null;
		    	sl2[i]=null;
		    	sl3[i]=null;
		    	sl4[i]=null;
		    	sl5[i]=null;
		    	sl6[i]=null;
		    	sl7[i]=null;
		    	ybs1[i]=null;
		    	ybs2[i]=null;
		    	ybs3[i]=null;
		    	ybs4[i]=null;
		    	ybs5[i]=null;
		    	ybs6[i]=null;
		    	ybs7[i]=null;
		    	Nof1[i]=null;
		    	Nof2[i]=null;
		    	Nof3[i]=null;
		    	Nof4[i]=null;
		    	Nof5[i]=null;
		    	Nof6[i]=null;
		    	Nof7[i]=null;
		    
		    	
		    }
		    
	}
	
	public n() throws IOException{
		String fontstyle = "Arial";
		getContentPane().setBackground(Color.DARK_GRAY);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1024,720);
     getContentPane().setLayout(null);
             
		getContentPane().setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		JLabel lblBeforeLeave = new JLabel("Before Leave");
		lblBeforeLeave.setForeground(new Color(135, 206, 250));
		lblBeforeLeave.setFont(new Font(fontstyle, Font.CENTER_BASELINE | Font.ITALIC, 20));
		lblBeforeLeave.setBounds(329, 11, 196, 21);
		getContentPane().add(lblBeforeLeave);
		
		JLabel lblEmployeeId = new JLabel("Employee Name:");
		lblEmployeeId.setForeground(Color.WHITE);
		lblEmployeeId.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblEmployeeId.setBounds(10, 35, 150, 16);
		getContentPane().add(lblEmployeeId);
		
		Empid = new JTextField();
		Empid.setHorizontalAlignment(SwingConstants.CENTER);
		Empid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				empid=Empid.getText();
				if(!isNumber(empid)||isChar(empid))
				{
					w1=1;
				    
					empidwarning.setVisible(true);
				}
				if(!isChar(empid))
				{ 
				    w1=0;
					empidwarning.setVisible(false);
				}
			}
		});
		Empid.setBackground(Color.WHITE);
		Empid.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
		Empid.setBounds(250, 34, 375, 20);
		getContentPane().add(Empid);
		Empid.setColumns(10);
		
		JLabel lblTypeOfLeave = new JLabel("Type of leave:");
		lblTypeOfLeave.setForeground(Color.WHITE);
		lblTypeOfLeave.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblTypeOfLeave.setBounds(10, 63, 108, 16);
		getContentPane().add(lblTypeOfLeave);
		
		leavetype = new JComboBox<String>();
		leavetype.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
		leavetype.setBounds(250, 66, 182, 20);
		leavetype.addItem("Casual");
		leavetype.addItem("Special Casual");
		leavetype.addItem("On Duty");
		leavetype.addItem("Compensatory Casual");
		leavetype.addItem("Earned");
		leavetype.addItem("Half Pay");
		leavetype.addItem("Communication of HPL");
		leavetype.addItem("Extraordinary");
		leavetype.addItem("Leave Not Due");
		leavetype.addItem("Study ");
		leavetype.addItem("Sabbatical");
		leavetype.addItem("Maternity");
		leavetype.addItem("Paternity");
		leavetype.addItem("Quarantine");
		leavetype.addItem("Loss of Pay");
		getContentPane().add(leavetype);
		
		JLabel lblNumberOfDays = new JLabel("Number of days:");
		lblNumberOfDays.setForeground(Color.WHITE);
		lblNumberOfDays.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblNumberOfDays.setBounds(10, 93, 150, 16);
		getContentPane().add(lblNumberOfDays);
		
		JLabel lblFromDateddmmyyyy = new JLabel("From(dd-mm-yyyy):");
		lblFromDateddmmyyyy.setForeground(Color.WHITE);
		lblFromDateddmmyyyy.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblFromDateddmmyyyy.setBounds(10, 150, 162, 21);
		getContentPane().add(lblFromDateddmmyyyy);
		
		JLabel lblToDateddmmyyyy = new JLabel("To(dd-mm-yyyy):");
		lblToDateddmmyyyy.setForeground(Color.WHITE);
		lblToDateddmmyyyy.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblToDateddmmyyyy.setBounds(8, 184, 152, 16);
		getContentPane().add(lblToDateddmmyyyy);
		
		JLabel lblReason = new JLabel("Reason:");
		lblReason.setForeground(Color.WHITE);
		lblReason.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblReason.setBounds(10, 340, 71, 16);
		getContentPane().add(lblReason);
		
		JLabel lblContactNumber = new JLabel("Contact number:");
		lblContactNumber.setForeground(Color.WHITE);
		lblContactNumber.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblContactNumber.setBounds(10, 407, 136, 14);
		getContentPane().add(lblContactNumber);
		
		Cno = new JTextField();
		Cno.addFocusListener(new FocusAdapter() {
			@Override
			
			public void focusLost(FocusEvent e) {
				phone=Cno.getText(); 
			if(phone.length()!=10||!isNumber(phone))
			{
			    w7=1;
				phonenumberwarning.setVisible(true);
			}
			if(phone.length()==10&&isNumber(phone))
			{
				w7=0;
				phonenumberwarning.setVisible(false);
			}
			
			
			}
		});
		Cno.setHorizontalAlignment(SwingConstants.CENTER);
		Cno.setFont(new Font(fontstyle, Font.BOLD, 14));
		Cno.setBounds(165, 404, 162, 20);
		getContentPane().add(Cno);
		Cno.setColumns(10);
		
		
		JLabel lblEmailId = new JLabel("E-mail id:");
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblEmailId.setBounds(10, 437, 90, 16);
		getContentPane().add(lblEmailId);
		
		Email = new JTextField();
		Email.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				emailt=Email.getText();
				
				if((isChar1(emailt)||emailt.isEmpty())&&count==1)
				{
				    w8=1;
					emailwarning.setVisible(true);
				}
				else
				{
				w8=0;
				emailwarning.setVisible(false);
				}
			
			}
		});
	
		
		Email.setHorizontalAlignment(SwingConstants.CENTER);
		Email.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
		Email.setBounds(165, 435, 273, 20);
		getContentPane().add(Email);
		Email.setColumns(10);
	   
		JLabel lblAddressDuringLeave = new JLabel("Address during leave:");
		lblAddressDuringLeave.setForeground(Color.WHITE);
		lblAddressDuringLeave.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblAddressDuringLeave.setBounds(10, 508, 185, 16);
		getContentPane().add(lblAddressDuringLeave);
		
		JLabel lblWorkloadAdjustment = new JLabel("Workload adjustment:");
		lblWorkloadAdjustment.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblWorkloadAdjustment.setForeground(Color.WHITE);
		lblWorkloadAdjustment.setBounds(10, 576, 185, 20);
		getContentPane().add(lblWorkloadAdjustment);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				leave=(String) leavetype.getSelectedItem();
				
				empid=Empid.getText();
				
				dep=(String) Dept.getText();
				nod=(String) Nod.getSelectedItem();
				from[1]=((JTextField)From.getDateEditor().getUiComponent()).getText();
				to[1]=((JTextField)To.getDateEditor().getUiComponent()).getText();
				ad=((JTextField)Adate.getDateEditor().getUiComponent()).getText();
			    emailt=Email.getText();
				email=Email.getText()+mail.getSelectedItem();
				phone=Cno.getText();
				reason=Reason.getText();
				address=Address.getText();
				des=Desig.getText();
				
				
				address=Address.getText();

				
	        		
	        		des=Desig.getText();
	        		if(phone.length()!=10||!isNumber(phone))
	    			{
	    			    w7=1;
	    				phonenumberwarning.setVisible(true);
	    			}
	    			if(phone.length()==10&&isNumber(phone))
	    			{
	    				w7=0;
	    				phonenumberwarning.setVisible(false);
	    			}
	    			
	        		if(!isNumber(dep)||isChar(dep))
					{
					w10=1;
					depwarning.setVisible(true);
					}
				    if(!isChar(dep))
				     {
				    w10=0;
					depwarning.setVisible(false);
				    }
					if(!isNumber(des)||isChar(des))
						{
						w5=1;
						deswarning.setVisible(true);
						}
					if(!isChar(des))
					{
					    w5=0;
						deswarning.setVisible(false);
					}
	        		if(!isNumber(empid)||isChar(empid))
					{
						
					    w1=1;
						empidwarning.setVisible(true);
					}
					if(!isChar(empid))
					{
					    w1=0;
						empidwarning.setVisible(false);
					}
	        		if(!isValidDate(ad))
	        		{
                        w2=1;
	        			Adatewarning.setVisible(true);
	        		}
					if(isValidDate(ad))
					{
						w2=0;
						Adatewarning.setVisible(false);
					}
					if((isChar1(emailt)||emailt.isEmpty())&&count==1)
					{
					    w8=1;
						emailwarning.setVisible(true);
					}
					if(!isChar1(emailt)&&(!emailt.isEmpty()))
					{
					w8=0;
					emailwarning.setVisible(false);
					}
					if(address.isEmpty())
					{
						w9=1;
						addresswarning.setVisible(true);
					}
	        		if(!address.isEmpty())
	        		{
	        			w9=0;
	        			addresswarning.setVisible(false);
	        		}
			     	if(reason.isEmpty())
			     	{
			     		w6=1;
			     		Reasonwarning.setVisible(true);
			     	}
         			if(!reason.isEmpty())
         			{
         				w6=0;
         				Reasonwarning.setVisible(false); 
         			}
					
			    	if(!isValidDate(from[1])||compared(ad,from[1])==false)
			    	{
			    		w3=1;
			    		fromwarning.setVisible(true);
			    	}
				    if(isValidDate(from[1])&&compared(ad,from[1])==true)
				    {
				    	w3=0;
				    	fromwarning.setVisible(false);
				    }
				    if(!isValidDate(to[1])||compared(from[1],to[1])==false)
				    {
				    	w4=1;
				    	towarning.setVisible(true);
				    }
				    if(isValidDate(to[1])&&compared(from[1],to[1])==true)
				    {
				    	w4=0;
				    	towarning.setVisible(false);
				    }
				
				if(emailt.isEmpty())
					email="";
				    pdf();
			  	if((w1+w2+w3+w4+w5+w6+w7+w8+w9)==0)
			  	{
			  		btnPrint.setVisible(true);
			  	    btnPrint.setEnabled(true);
			  	}   
			  	else
			  	{
			  		btnNewButton.setVisible(true);
			  		btnNewButton.setEnabled(true); 
			  	}
			}
		});
		 btnApply.setForeground(new Color(51, 153, 255));
	     btnApply.setBackground(new Color(0, 0, 0));
		btnApply.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 18));
		btnApply.setBounds(581, 628, 89, 23);
		getContentPane().add(btnApply);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (Desktop.isDesktopSupported()) {
		            try {
		            	//File myFile = new File( "C:\\Users/Gylfoil/workspace/pdf/Super.pdf");
		                File myFile = new File("Super1.pdf");
		                Desktop.getDesktop().open(myFile);
		            } catch (IOException ex) {
		                // no application registered for PDFs
		            }
		       
		        }
			}
		});
		btnPrint.setForeground(new Color(51, 153, 255));
		btnPrint.setBackground(new Color(0, 0, 0));
		btnPrint.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 18));
		btnPrint.setBounds(877, 628, 89, 23);
		getContentPane().add(btnPrint);
		
		lblOutput = new JLabel(":)");
		lblOutput.setFont(new Font("Papyrus", Font.CENTER_BASELINE, 20));
		lblOutput.setForeground(new Color(0, 153, 255));
		lblOutput.setBounds(10, 628, 540, 38);
		getContentPane().add(lblOutput);
		
		JLabel lblApplyingDate = new JLabel("Applying Date(dd-mm-yyyy):");
		lblApplyingDate.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
		lblApplyingDate.setForeground(Color.WHITE);
		lblApplyingDate.setBounds(8, 122, 230, 15);
		getContentPane().add(lblApplyingDate);
        
        JLabel lblDesignation = new JLabel("Designation :");
        lblDesignation.setForeground(Color.WHITE);
        lblDesignation.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
        lblDesignation.setBounds(9, 270, 137, 15);
        getContentPane().add(lblDesignation);
        
        Desig = new JTextField();
        Desig.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		des=Desig.getText();
				if(!isNumber(des)||isChar(des))
					{
					w5=1;
					deswarning.setVisible(true);
					}
				if(!isChar(des))
				{
				    w5=0;
					deswarning.setVisible(false);
				}
        		
        	}
        	@Override
        	public void focusGained(FocusEvent e) {
        		from[1]=((JTextField)From.getDateEditor().getUiComponent()).getText();
				to[1]=((JTextField)To.getDateEditor().getUiComponent()).getText();
				ad=((JTextField)Adate.getDateEditor().getUiComponent()).getText();
				if(!isValidDate(ad))
        		{
                    w2=1;
        			Adatewarning.setVisible(true);
        		}
				if(isValidDate(ad))
				{
					w2=0;
					Adatewarning.setVisible(false);
				}
				if(!isValidDate(from[1])||compared(ad,from[1])==false)
		    	{
		    		w3=1;
		    		fromwarning.setVisible(true);
		    	}
			    if(isValidDate(from[1])&&compared(ad,from[1])==true)
			    {
			    	w3=0;
			    	fromwarning.setVisible(false);
			    }
			    if(!isValidDate(to[1])||compared(from[1],to[1])==false)
			    {
			    	w4=1;
			    	towarning.setVisible(true);
			    }
			    if(isValidDate(to[1])&&compared(from[1],to[1])==true)
			    {
			    	w4=0;
			    	towarning.setVisible(false);
			    }
			
        	}
        });
        Desig.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        Desig.setBounds(165, 267, 340, 20);
        getContentPane().add(Desig);
        Desig.setColumns(10);
        
        JLabel lblDepartment = new JLabel("Department:");
        lblDepartment.setForeground(Color.WHITE);
        lblDepartment.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
        lblDepartment.setBounds(10, 238, 108, 16);
        getContentPane().add(lblDepartment);
        
      From = new JDateChooser();
      From.setDateFormatString("dd-MM-yyyy");
      From.setBounds(177, 153, 150, 20);
        getContentPane().add(From);
        
        To = new JDateChooser();
        To.setDateFormatString("dd-MM-yyyy");
        To.setBounds(177, 186, 150, 20);
        getContentPane().add(To);
        
        Adate = new JDateChooser();
      
      
        
        Adate.setDateFormatString("dd-MM-yyyy");
        Adate.setBounds(250, 122, 136, 20);
        getContentPane().add(Adate);
        
        Nod = new JComboBox<String>();
        Nod.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame2=null;
        	}
        });
        Nod.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        Nod.setBounds(250, 92, 44, 20);
        Nod.addItem("1");
        Nod.addItem("2");
        Nod.addItem("3");
        Nod.addItem("4");
        Nod.addItem("5");
        Nod.addItem("6");
        Nod.addItem("7");   
        Nod.addItem("8");
        Nod.addItem("9");
        Nod.addItem("10");
        Nod.addItem("11");
        Nod.addItem("12");
        Nod.addItem("13");
        Nod.addItem("14");
        Nod.addItem("15");
        Nod.addItem("16");
        Nod.addItem("17");
        Nod.addItem("18");
        getContentPane().add(Nod);
        
        phonenumberwarning = new JLabel("please enter a valid contact number!");
        phonenumberwarning.setForeground(new Color(255, 102, 102));
        phonenumberwarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        phonenumberwarning.setBounds(367, 407, 278, 14);
        
        getContentPane().add(phonenumberwarning);
        
        empidwarning = new JLabel("Please recheck your name!");
        empidwarning.setForeground(new Color(255, 102, 102));
        empidwarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        empidwarning.setBounds(648, 36, 203, 14);
        getContentPane().add(empidwarning);
        
        Adatewarning = new JLabel("Please select a valid date!");
        Adatewarning.setForeground(new Color(255, 102, 102));
        Adatewarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        Adatewarning.setBounds(412, 128, 196, 14);
        getContentPane().add(Adatewarning);
        
        fromwarning = new JLabel("Please select a valid date!");
        fromwarning.setForeground(new Color(255, 102, 102));
        fromwarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        fromwarning.setBounds(358, 155, 192, 18);
        getContentPane().add(fromwarning);
        
        towarning = new JLabel("please select a valid date!");
        towarning.setForeground(new Color(255, 102, 102));
        towarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        towarning.setBounds(355, 190, 209, 16);
        getContentPane().add(towarning);
        
        mail = new JComboBox<String>();
        mail.setBounds(441, 435, 175, 20);
        mail.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
		mail.addItem("@gmail.com");
		mail.addItem("@rediffmail.com");
		mail.addItem("@outlook.com");
		mail.addItem("@yahoo.com");
		mail.addItem("@in.com");
		mail.addItem("@live.com");
		mail.addItem("@hotmail.com");
		mail.addItem("   ");
        getContentPane().add(mail);
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					reset();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnReset.setForeground(new Color(0, 0, 0));
        btnReset.setBackground(new Color(51, 153, 255));
        btnReset.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 18));
        btnReset.setBounds(877, 32, 89, 23);
        getContentPane().add(btnReset);
        Reason= new TextArea("",10,25,TextArea.SCROLLBARS_VERTICAL_ONLY); 
        Reason.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		reason=Reason.getText();
        		if(reason.isEmpty())
        			{
        			w6=1;
        			Reasonwarning.setVisible(true);
        			}
        		else
        			{
        			w6=0;
        			Reasonwarning.setVisible(false); 
        			}
        		
        	}
        });
      
        Reason.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        Reason.setForeground(Color.BLACK);
        Reason.setFont(new Font("Arial", Font.PLAIN, 14));
        Reason.setBounds(160, 305, 390, 82);
        getContentPane().add(Reason);
        
        Address = new TextArea("",10,25,TextArea.SCROLLBARS_VERTICAL_ONLY);
        Address.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		address=Address.getText();
        		if(address.isEmpty())
        			{
        			w9=1;
        			addresswarning.setVisible(true);
        			}
        		else
        			 {
        			  w9=0;
        			  addresswarning.setVisible(false);
        			 }
        	}
        });
        Address.setFont(new Font(fontstyle, Font.PLAIN, 14));
        Address.setForeground(Color.BLACK);
        Address.setBounds(201, 484, 349, 82);
        getContentPane().add(Address);
        
        deswarning= new JLabel("please recheck your Designation!");
        deswarning.setForeground(new Color(255, 102, 102));
        deswarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        deswarning.setBounds(542, 271, 254, 14);
        getContentPane().add(deswarning);
        wadjust = new JButton("Adjust");
        wadjust.setBackground(new Color(0, 0, 0));
        wadjust.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
        wadjust.setForeground(new Color(51, 153, 255));
        wadjust.setBounds(201, 575, 90, 23);
        wadjust.addActionListener(this);
        getContentPane().add(wadjust);
        
        Reasonwarning = new JLabel("please enter some reason!");
        Reasonwarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        Reasonwarning.setForeground(new Color(255, 102, 102));
        Reasonwarning.setBounds(570, 341, 226, 16);
        getContentPane().add(Reasonwarning);
        
        emailwarning = new JLabel("please enter a valid email id!");
        emailwarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        emailwarning.setForeground(new Color(255, 102, 102));
        emailwarning.setBounds(648, 438, 209, 15);
        getContentPane().add(emailwarning);
        
        addresswarning = new JLabel("please enter a valid address!");
        addresswarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        addresswarning.setForeground(new Color(255, 102, 102));
        addresswarning.setBounds(581, 522, 215, 14);
        getContentPane().add(addresswarning);
        
        btnNewButton = new JButton("Ignore Warnings");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String message="\t\tWelcome to Before Leave";
        		lblOutput.setText(message);
        		phonenumberwarning.setVisible(false);
        	    empidwarning.setVisible(false);
        	    Adatewarning.setVisible(false);
        	    fromwarning.setVisible(false);
        	    towarning.setVisible(false);
        	    deswarning.setVisible(false);
        	    depwarning.setVisible(false);
        	    Reasonwarning.setVisible(false); 
        	    emailwarning.setVisible(false); 
        	    addresswarning.setVisible(false); 
        		btnPrint.setEnabled(true);
        		btnPrint.setVisible(true);
        	}
        });
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setForeground(new Color(255, 102, 102));
        btnNewButton.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 18));
        btnNewButton.setBounds(682, 627, 183, 23);
        getContentPane().add(btnNewButton);
        
        JButton btnFetch = new JButton("Fetch");
        btnFetch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 idnum=id.getText();
    			 idn[1]=idnum;
        		try {
        			
        	         File file = new File(idnum+"/empid.txt");
        	         Scanner scanner = new Scanner(file);
        	         while (scanner.hasNextLine()) {
        	           String str=scanner.nextLine();
        	           Empid.setText(str);
        	           
        	         }
        	         scanner.close();
        	       } catch (FileNotFoundException e1) {
        	         fwarning.setText("No details found!");
        	         fwarning.setVisible(true);
        	       }
        		try {
        			
       	         File file = new File(idnum+"/des.txt");
       	         Scanner scanner = new Scanner(file);
       	         while (scanner.hasNextLine()) {
       	           String str=scanner.nextLine();
       	           Desig.setText(str);
       	           
       	         }
       	         scanner.close();
       	       } catch (FileNotFoundException e1) {
       	         fwarning.setText("No details found!");
       	         fwarning.setVisible(true);
       	       }
        		try {
        			
       	         File file = new File(idnum+"/phone.txt");
       	         Scanner scanner = new Scanner(file);
       	         while (scanner.hasNextLine()) {
       	           String str=scanner.nextLine();
       	           Cno.setText(str);
       	           
       	         }
       	         scanner.close();
       	       } catch (FileNotFoundException e1) {
       	         fwarning.setText("No details found!");
       	         fwarning.setVisible(true);
       	       }
        		try {
        			
       	         File file = new File(idnum+"/email.txt");
       	         Scanner scanner = new Scanner(file);
       	         while (scanner.hasNextLine()) {
       	           String str=scanner.nextLine();
       	           Email.setText(str);
       	           mail.setSelectedIndex(7);
       	           if(Email.getText().length()>1)
       	        	count=0;
       	           
       	         }
       	         scanner.close();
       	       } catch (FileNotFoundException e1) {
       	         fwarning.setText("No details found!");
       	         fwarning.setVisible(true);
       	       }
        	
        		try {
        			
         	         File file = new File(idnum+"/dep.txt");
         	         Scanner scanner = new Scanner(file);
         	         while (scanner.hasNextLine()) {
         	           String str=scanner.nextLine();
         	          Dept.setText(str);
         	           mail.setSelectedIndex(7);
         	           
         	         }
         	         scanner.close();
         	       } catch (FileNotFoundException e1) {
         	         fwarning.setText("No details found!");
         	         fwarning.setVisible(true);
         	       }
        		empid=Empid.getText();
        		if(!isNumber(empid)||isChar(empid))
				{
					
				    w1=1;
					empidwarning.setVisible(true);
				}
				if(!isChar(empid))
				{
				    w1=0;
					empidwarning.setVisible(false);
				}
 
        		
        	}
        });
        btnFetch.setForeground(new Color(51, 153, 255));
        btnFetch.setBackground(new Color(0, 0, 0));
        btnFetch.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
        btnFetch.setBounds(762, 167, 89, 23);
        getContentPane().add(btnFetch);
        
        id = new JTextField();
        id.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        id.setBounds(806, 119, 136, 20);
        getContentPane().add(id);
        id.setColumns(10);
        
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		empid=Empid.getText();
        		idnum=id.getText();
        		idn[1]=idnum;
        		dep=Dept.getText();
				email=Email.getText()+mail.getSelectedItem();
				phone=Cno.getText();
				address=Address.getText();
				des=Desig.getText();
        		new File(idnum).mkdir();
        		try
        		{
        		    PrintWriter writer1 = new PrintWriter(idnum+"/empid.txt", "UTF-8");
        		    writer1.print(empid);
        		    writer1.close();
        		    PrintWriter writer2 = new PrintWriter(idnum+"/dep.txt", "UTF-8");
        		    writer2.print(dep);
        		    writer2.close();
        		    PrintWriter writer3 = new PrintWriter(idnum+"/email.txt", "UTF-8");
        		    writer3.print(email);
        		    writer3.close();
        		    PrintWriter writer4 = new PrintWriter(idnum+"/phone.txt", "UTF-8");
        		    writer4.print(phone);
        		    writer4.close();
        		    PrintWriter writer6 = new PrintWriter(idnum+"/des.txt", "UTF-8");
        		    writer6.print(des);
        		    writer6.close();
        		    
        		} catch (IOException e1) {
        		   // do something
        		}
        		
        	}
        });
        btnSave.setForeground(new Color(51, 153, 255));
        btnSave.setBackground(new Color(0, 0, 0));
        btnSave.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
        btnSave.setBounds(898, 167, 89, 23);
        getContentPane().add(btnSave);
        
        JLabel lblEmpId = new JLabel("Employee ID:");
        lblEmpId.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
        lblEmpId.setForeground(new Color(255, 255, 255));
        lblEmpId.setBounds(688, 122, 108, 14);
        getContentPane().add(lblEmpId);
        
        fwarning = new JLabel("No details found!");
        fwarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 16));
        fwarning.setForeground(new Color(255, 102, 102));
        fwarning.setBounds(816, 210, 150, 14);
        getContentPane().add(fwarning);
        
        Dept = new JTextField();
        Dept.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        Dept.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		dep=Dept.getText();
        		if(!isNumber(dep)||isChar(dep))
				{
				w10=1;
				depwarning.setVisible(true);
				}
			    if(!isChar(dep))
			     {
			    w10=0;
				depwarning.setVisible(false);
			    }
        	}
        });
        Dept.setBounds(165, 234, 137, 20);
        getContentPane().add(Dept);
        Dept.setColumns(10);
        
        depwarning = new JLabel("please enter a valid department information!");
        depwarning.setFont(new Font(fontstyle, Font.CENTER_BASELINE, 14));
        depwarning.setForeground(new Color(255, 102, 102));
        depwarning.setBounds(341, 239, 329, 14);
        getContentPane().add(depwarning);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	public void pdf() 
	{
		
		 Document document=new Document(PageSize.A4,0,10,05,10);
		 com.itextpdf.text.Font fonts= FontFactory.getFont(FontFactory.TIMES_BOLD, 12);
		 com.itextpdf.text.Font fonts0= FontFactory.getFont(FontFactory.COURIER_BOLD, 10);
		 com.itextpdf.text.Font fonts1= FontFactory.getFont(FontFactory.TIMES_BOLD, 20);
		 
		 try{
			  
			  PdfWriter.getInstance(document,new FileOutputStream("super1.pdf"));
			  document.open();
			  
			
			  Paragraph title=new Paragraph("Application For- "+leave+" Leave",fonts);
			  Paragraph ename=new Paragraph(empid,fonts0);
			  
			Image img=Image.getInstance("nri.jpg");
			 document.add(img);
				  PdfPTable table=new PdfPTable(4);
			  PdfPCell cell=new PdfPCell(title);
			  cell.setColspan(3);
			  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			  cell.setBackgroundColor(BaseColor.WHITE);
			  cell.setColspan(3);
			  table.addCell(cell);
			  table.addCell(new Paragraph("Date:"+ad,fonts));
			  table.addCell(new Paragraph("Name of the Employee:",fonts));
			  PdfPCell name=new PdfPCell(ename);
			  name.setColspan(3);
			  name.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			  table.addCell(name);
			  table.addCell(new Paragraph("Designation",fonts));
			  table.addCell(new Paragraph(des,fonts0));
			  table.addCell(new Paragraph("Department",fonts));
			  table.addCell(new Paragraph(dep,fonts0));
			  PdfPCell nodc=new PdfPCell(new Paragraph("Number of Days Applied",fonts));
			  nodc.setColspan(3);
			  table.addCell(nodc);
			  table.addCell(new Paragraph(nod,fonts0));
			  table.addCell(new Paragraph("From",fonts));
			  table.addCell(new Paragraph(from[1],fonts0));
			  table.addCell(new Paragraph("To",fonts));
			  table.addCell(new Paragraph(to[1],fonts0));
			  table.addCell(new Paragraph("Reason\n\n ",fonts));
			  PdfPCell res=new PdfPCell(new Paragraph(reason,fonts0));
			  res.setColspan(3);
			  table.addCell(res);
			  table.addCell(new Paragraph("E-mail",fonts));
			  PdfPCell eid=new PdfPCell(new Paragraph(email,fonts0));
			  eid.setColspan(3);
			  table.addCell(eid);
			  table.addCell(new Paragraph("phone number:",fonts));
			  PdfPCell phno=new PdfPCell(new Paragraph(phone,fonts0));
			  phno.setColspan(3);
			  table.addCell(phno);
			  table.addCell(new Paragraph("Address During \nLeave Period\n ",fonts));
			  PdfPCell addr=new PdfPCell(new Paragraph(address,fonts0));
			  addr.setColspan(3);
			  table.addCell(addr);
			  table.addCell(new Paragraph("Class Work  \nAdjustment particulars",fonts));
			  PdfPCell cwapc=new PdfPCell(new Paragraph("Please see overleaf",fonts0));
			  cwapc.setColspan(3);
			  table.addCell(cwapc);
			  PdfPCell Authentication=new PdfPCell(new Paragraph("\n\n\n                   Pricipal            |   Head of the Department      |Signature of the Applicant    ",fonts));
			  Authentication.setColspan(4);
			  table.addCell(Authentication);
			  table.setSpacingBefore(20f);
			  table.setSpacingAfter(5f);
			  document.add(table);
			  Paragraph para1=new Paragraph("\n         -------------------------------------------------------------------------\n                                             For Office Use Only",fonts1);
			  
			 // para1.add("\n                                                               For Office Use Only");
			  document.add(para1);
			  PdfPTable otable=new PdfPTable(4);
			  PdfPCell ocell=new PdfPCell(title);
			  ocell.setColspan(3);
			  ocell.setHorizontalAlignment(Element.ALIGN_CENTER);
			  ocell.setBackgroundColor(BaseColor.WHITE);
			  ocell.setColspan(3);
			  otable.addCell(cell);
			  otable.addCell(new Paragraph("Date:"+ad,fonts));
			  otable.addCell(new Paragraph("Name of the Employee:",fonts));
			  PdfPCell oname=new PdfPCell(ename);
			  oname.setColspan(3);
			  oname.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			  otable.addCell(name);
			  otable.addCell(new Paragraph("Designation",fonts));
			  otable.addCell(new Paragraph(des,fonts0));
			  otable.addCell(new Paragraph("Department",fonts));
			  otable.addCell(new Paragraph(dep,fonts0));
			  PdfPCell onodc=new PdfPCell(new Paragraph("Number of Days Applied",fonts));
			  onodc.setColspan(3);
			  otable.addCell(onodc);
			  otable.addCell(new Paragraph(nod,fonts0));
			  otable.addCell(new Paragraph("From",fonts));
			  otable.addCell(new Paragraph(from[1],fonts0));
			  otable.addCell(new Paragraph("To",fonts));
			  otable.addCell(new Paragraph(to[1],fonts0));
			  otable.addCell(new Paragraph("Reason\n\n ",fonts));
			  PdfPCell ores=new PdfPCell(new Paragraph(reason,fonts0));
			  ores.setColspan(3);
			  otable.addCell(ores);
			  otable.addCell(new Paragraph("E-mail",fonts));
			  PdfPCell oeid=new PdfPCell(new Paragraph(email,fonts0));
			  oeid.setColspan(3);
			  otable.addCell(oeid);
			  otable.addCell(new Paragraph("phone number:",fonts));
			  PdfPCell ophno=new PdfPCell(new Paragraph(phone,fonts0));
			  ophno.setColspan(3);
			  otable.addCell(phno);
			  otable.addCell(new Paragraph("Address During \nLeave Period\n ",fonts));
			  PdfPCell oaddr=new PdfPCell(new Paragraph(address,fonts0));
			  oaddr.setColspan(3);
			  otable.addCell(oaddr);
			  
			  otable.addCell(new Paragraph("Number of Leaves\nAvailed so far",fonts));
			  otable.addCell(new Paragraph(" ",fonts));
			  otable.addCell(new Paragraph("Balance Number\nOf Leaves",fonts));
			  otable.addCell(new Paragraph(" ",fonts));
			  PdfPCell oAuthentication=new PdfPCell(new Paragraph("\n\n\n                   Pricipal            |   Administrative Officer         |   Head of the Department      ",fonts));
			  oAuthentication.setColspan(4);
			  otable.addCell(oAuthentication);
			  otable.setSpacingBefore(5f);
			  otable.setSpacingAfter(20f);
			  document.add(otable);
			  Paragraph para2=new Paragraph("                            Class work adjustment particulars",fonts1);  
			  document.add(para2);
			  PdfPTable[] wadtable=new PdfPTable[150];
			  wadtable[0]=new PdfPTable(6);
			  wadtable[0].addCell(new Paragraph("Date",fonts));
			  wadtable[0].addCell(new Paragraph("Subject/Lab",fonts));
			  wadtable[0].addCell(new Paragraph("Year & Branch/\nSection",fonts));
			  wadtable[0].addCell(new Paragraph("Period",fonts));
			  wadtable[0].addCell(new Paragraph("Name of the\n faculty",fonts));
			  wadtable[0].addCell(new Paragraph("Signature",fonts));
			  wadtable[0].setSpacingBefore(10f);
			  document.add(wadtable[0]);
			  int i;
			  int k=0;
			  for(i=1;i<=Integer.parseInt(nod);i++)
			  {
				  int j=1;
				  while(true)
				  {
					  k++;
					  
				  wadtable[k]=new PdfPTable(6);
				  wadtable[k].addCell(new Paragraph(kdate[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(sl1[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(ybs1[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph("1",fonts0));
				  wadtable[k].addCell(new Paragraph(Nof1[i],fonts0));
				  wadtable[k].addCell(new Paragraph("",fonts0));
				if(ybs1[i]!=null||sl1[i]!=null||Nof1[i]!=null)
					  document.add(wadtable[k]); 
				 
				  k=k+1; j=j+1;
				  wadtable[k]=new PdfPTable(6);
				  wadtable[k].addCell(new Paragraph(kdate[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(sl2[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(ybs2[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph("2",fonts0));
				  wadtable[k].addCell(new Paragraph(Nof2[i],fonts0));
				  wadtable[k].addCell(new Paragraph("",fonts0));
				if(ybs2[i]!=null||sl2[i]!=null||Nof2[i]!=null)
					  document.add(wadtable[k]); 
				
				  k=k+1; j=j+1;
				  wadtable[k]=new PdfPTable(6);
				  wadtable[k].addCell(new Paragraph(kdate[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(sl3[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(ybs3[i],fonts0));  
				  wadtable[k].addCell(new Paragraph("3",fonts0));
				  wadtable[k].addCell(new Paragraph(Nof3[i],fonts0));
				  wadtable[k].addCell(new Paragraph("",fonts0));
				if(ybs3[i]!=null||sl3[i]!=null||Nof3[i]!=null)
					  document.add(wadtable[k]); 
				  k=k+1; j=j+1;
				  wadtable[k]=new PdfPTable(6);
				  wadtable[k].addCell(new Paragraph(kdate[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(sl4[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(ybs4[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph("4",fonts0));
				  wadtable[k].addCell(new Paragraph(Nof4[i],fonts0));
				  wadtable[k].addCell(new Paragraph("",fonts0));
				 if(ybs4[i]!=null||sl4[i]!=null||Nof4[i]!=null)
					  document.add(wadtable[k]); 
				  
				  k=k+1; j=j+1;
				  wadtable[k]=new PdfPTable(6);
				  wadtable[k].addCell(new Paragraph(kdate[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(sl5[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(ybs5[i],fonts0));  
				  wadtable[k].addCell(new Paragraph("5",fonts0));
				  wadtable[k].addCell(new Paragraph(Nof5[i],fonts0));
				  wadtable[k].addCell(new Paragraph("",fonts0));
				if(ybs5[i]!=null||sl5[i]!=null||Nof5[i]!=null)
					  document.add(wadtable[k]); 
				  
				  k=k+1; j=j+1;
				  wadtable[k]=new PdfPTable(6);
				  wadtable[k].addCell(new Paragraph(kdate[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(sl6[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(ybs6[i],fonts0));  
				  wadtable[k].addCell(new Paragraph("6",fonts0));
				  wadtable[k].addCell(new Paragraph(Nof6[i],fonts0));
				  wadtable[k].addCell(new Paragraph("",fonts0));
				if(ybs6[i]!=null||sl6[i]!=null||Nof6[i]!=null)
					  document.add(wadtable[k]); 
				  
				  k=k+1; j=j+1;
				  wadtable[k]=new PdfPTable(6);
				  wadtable[k].addCell(new Paragraph(kdate[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(sl7[i],fonts0)); 
				  wadtable[k].addCell(new Paragraph(ybs7[i],fonts0));  
				  wadtable[k].addCell(new Paragraph("7",fonts0));
				  wadtable[k].addCell(new Paragraph(Nof7[i],fonts0));
				  wadtable[k].addCell(new Paragraph("",fonts0));
			if(ybs7[i]!=null||sl7[i]!=null||Nof7[i]!=null)
				  document.add(wadtable[k]); 
				  
				  break;
			  }
	 } 
		
			  
			 
			
			  
			  document.close();
		   }
		 catch(Exception e)
		 {
			e.printStackTrace();  
		 }
		 
	}
    public static void main(String[] args) {
    	
   
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    n  frame = new n();
                    
                    frame.setVisible(true);
                    

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
     	
    	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == wadjust) {
            if (frame2 == null)
				try {
					from[1]=((JTextField)From.getDateEditor().getUiComponent()).getText();
					to[1]=((JTextField)To.getDateEditor().getUiComponent()).getText();
					nod=(String) Nod.getSelectedItem();
					int num=Integer.parseInt(nod);
					objt=new tabs(num);
					Toolkit tol1=Toolkit.getDefaultToolkit();
			         Dimension dim1=tol1.getScreenSize();
					objt.setSize(new Dimension(dim1.width,dim1.height));
					frame2 = objt;
					frame2.setVisible(true);
					
						
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
          
        }
        frame2.setVisible(true);

    }
}
