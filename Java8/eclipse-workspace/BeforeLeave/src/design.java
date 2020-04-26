import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import com.toedter.calendar.JDateChooser;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class design extends JPanel implements inter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8679886300517958494L;
	 String leave,ad,empid,dep,des,nod,reason,email,phone,address,cwap,supe;
	 JLabel Addresswarning;
	 Date nav;
	JTextField sl1;
	JTextField ybs1;
	JTextField Nof1;
	JTextField sl2;
    JTextField ybs2;
	JTextField Nof2;
	JTextField sl3;
    JTextField ybs3;
	JTextField Nof3;
	JTextField sl4;
    JTextField ybs4;
	JTextField Nof4;
	JTextField sl5;
	JTextField ybs5;
	JTextField Nof5;
    JTextField sl6;
    JTextField ybs6;
	JTextField Nof6;
	JTextField sl7;
	JTextField ybs7;
	JTextField Nof7;
	Date da;
	int n;
	public JDateChooser dateChooser;
	public JButton btnDone;
	JLabel dwarning;
	 JLabel label_4 = new JLabel("New label");
	 private JButton btnFetch;
	 private JButton btnSave;
	 private JLabel fwarning;
	 public static boolean isValidDate() {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		    dateFormat.setLenient(false);
		    try {
		      dateFormat.parse(di[1].trim());
		    } catch (ParseException pe) {
		      return false;
		    }
		    return true;
		  }
	 public boolean compared()
		{
		 
		int a=di[1].compareTo(from[1]);
		int b=to[1].compareTo(di[1]);
		if(a<0||b<0)  return false; //System.out.println("date2 is before date1");  break;
		else if(a==0||b==0)  return true; //System.out.println("date2 and date1 equal");  break;
		else if(a>0||b>0)   return true; //System.out.println("date2 is after date1");  break;
		return false;
	    }         
	 public void checkdate() throws ParseException
	 {
			di[1]=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			
			   
			nav=dateChooser.getDate();
		
			
				
			
			if(isValidDate())
			{
				dwarning.setText("please choose a valid date!");
			    dwarning.setFont(new Font("Calibri", Font.BOLD, 14));
			    dwarning.setForeground(new Color(255, 102, 102));
			    dwarning.setBounds(273, 50, 276, 14);
			    dwarning.setVisible(true);	
			}
			else
			{
				dwarning.setVisible(false);
			}
			
			if(!compared())
			{
				dwarning.setText("please enter a valid date!");
			    dwarning.setFont(new Font("Calibri", Font.BOLD, 14));
			    dwarning.setForeground(new Color(255, 102, 102));
			    dwarning.setBounds(273, 50, 276, 14);
			    dwarning.setVisible(true);
			}
			else if(day()==1)
			{
				dwarning.setText("The selected date is a sunday!");
			    dwarning.setFont(new Font("Calibri", Font.BOLD, 14));
			    dwarning.setForeground(new Color(255, 102, 102));
			    dwarning.setBounds(273, 50, 276, 14);
			    dwarning.setVisible(true);
			}
				
			else
			{
				dwarning.setVisible(false);
			}
	 }
	  public void reset1()
	{
		    sl1.setText("");
			ybs1.setText("");
			Nof1.setText("");
			sl2.setText("");
		    ybs2.setText("");
		    Nof2.setText("");
			sl3.setText("");
		    ybs3.setText("");
			Nof3.setText("");
			sl4.setText("");
		    ybs4.setText("");
			Nof4.setText("");
			sl5.setText("");
			ybs5.setText("");
			Nof5.setText("");
		    sl6.setText("");
		    ybs6.setText("");
		    Nof6.setText("");
			sl7.setText("");
			ybs7.setText("");
			Nof7.setText("");
		
	    
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
	 public int day() throws ParseException {
		 final String NEW_FORMAT = "MMM dd yyyy";
   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
  Date d=dateFormat.parse(di[1]);
    dateFormat.applyPattern(NEW_FORMAT);
    String da=dateFormat.format(d);
    d=dateFormat.parse(da);
	Calendar cal=Calendar.getInstance();
    cal.setTime(d);
    int val = cal.get(Calendar.DAY_OF_WEEK);

     
	return val;
	 }
	public design() throws IOException{
		
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblBeforeLeave = new JLabel("Workload Adjustment");
		lblBeforeLeave.setBounds(414, 11, 187, 26);
		lblBeforeLeave.setForeground(new Color(135, 206, 250));
		lblBeforeLeave.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		add(lblBeforeLeave);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Calibri", Font.BOLD, 14));
		lblDate.setBounds(78, 47, 28, 17);
		add(lblDate);
		
		JLabel lblSubjectOrLab = new JLabel("Subject or Lab:");
		lblSubjectOrLab.setFont(new Font("Calibri", Font.BOLD, 14));
		lblSubjectOrLab.setForeground(Color.WHITE);
		lblSubjectOrLab.setBounds(140, 93, 89, 17);
		add(lblSubjectOrLab);
		
		JLabel lblYearbranchsection = new JLabel("Year &Branch/Section:");
		lblYearbranchsection.setForeground(Color.WHITE);
		lblYearbranchsection.setFont(new Font("Calibri", Font.BOLD, 14));
		lblYearbranchsection.setBounds(414, 93, 135, 17);
		add(lblYearbranchsection);
		
		JLabel lblNameOfThe = new JLabel("Name of the faculty:");
		lblNameOfThe.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNameOfThe.setForeground(Color.WHITE);
		lblNameOfThe.setBounds(648, 93, 119, 17);
		add(lblNameOfThe);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.getCalendarButton().setFont(new Font("Calibri", Font.BOLD, 14));
		dateChooser.setBounds(140, 44, 91, 20);
		add(dateChooser);
		
		sl1=new JTextField();
		sl1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
		           try {
					checkdate();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
		sl1.setFont(new Font("Calibri", Font.BOLD, 14));
		sl1.setBounds(128, 132, 196, 20);
		add(sl1);
		sl1.setColumns(10);
		ybs1 = new JTextField();
		ybs1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ybs1.setFont(new Font("Calibri", Font.BOLD, 14));
		ybs1.setBounds(414, 132, 156, 20);
		add(ybs1);
		ybs1.setColumns(10);
		
		Nof1 = new JTextField();
		Nof1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Nof1.setFont(new Font("Calibri", Font.BOLD, 14));
		Nof1.setBounds(648, 133, 291, 20);
		add(Nof1);
		Nof1.setColumns(10);
		
		JLabel lblPeriod = new JLabel("Period:");
		lblPeriod.setForeground(Color.WHITE);
		lblPeriod.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPeriod.setBounds(20, 93, 42, 17);
		add(lblPeriod);
		
		JLabel label = new JLabel("1");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(30, 131, 9, 23);
		add(label);
		
		sl2 = new JTextField();
		sl2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		sl2.setFont(new Font("Calibri", Font.BOLD, 14));
		sl2.setBounds(128, 173, 196, 20);
		add(sl2);
		sl2.setColumns(10);
		
		ybs2 = new JTextField();
		ybs2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ybs2.setFont(new Font("Calibri", Font.BOLD, 14));
		ybs2.setBounds(414, 173, 156, 20);
		add(ybs2);
		ybs2.setColumns(10);
		
		Nof2 = new JTextField();
		Nof2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Nof2.setFont(new Font("Calibri", Font.BOLD, 14));
		Nof2.setBounds(648, 173, 291, 20);
		add(Nof2);
		Nof2.setColumns(10);
		
		JLabel label_1 = new JLabel("2");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Calibri", Font.BOLD, 18));
		label_1.setBounds(30, 171, 9, 23);
		add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Calibri", Font.BOLD, 18));
		label_2.setBounds(30, 211, 9, 23);
		add(label_2);
		
		sl3 = new JTextField();
		sl3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		sl3.setFont(new Font("Calibri", Font.BOLD, 14));
		sl3.setBounds(128, 213, 196, 20);
		add(sl3);
		sl3.setColumns(10);
		
		ybs3 = new JTextField();
		ybs3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ybs3.setFont(new Font("Calibri", Font.BOLD, 14));
		ybs3.setBounds(414, 213, 156, 20);
		add(ybs3);
		ybs3.setColumns(10);
		
		Nof3 = new JTextField();
		Nof3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Nof3.setFont(new Font("Calibri", Font.BOLD, 14));
		Nof3.setBounds(648, 213, 291, 20);
		add(Nof3);
		Nof3.setColumns(10);
		
		JLabel label_3 = new JLabel("4");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Calibri", Font.BOLD, 18));
		label_3.setBounds(30, 251, 9, 23);
		add(label_3);
		
		sl4 = new JTextField();
		sl4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		sl4.setFont(new Font("Calibri", Font.BOLD, 14));
		sl4.setBounds(128, 253, 196, 20);
		add(sl4);
		sl4.setColumns(10);
		
		ybs4 = new JTextField();
		ybs4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ybs4.setFont(new Font("Calibri", Font.BOLD, 14));
		ybs4.setBounds(414, 253, 156, 20);
		add(ybs4);
		ybs4.setColumns(10);
		
		Nof4 = new JTextField();
		Nof4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Nof4.setFont(new Font("Calibri", Font.BOLD, 14));
		Nof4.setBounds(648, 253, 291, 20);
		add(Nof4);
		Nof4.setColumns(10);
		
		JLabel label_5 = new JLabel("5");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Calibri", Font.BOLD, 18));
		label_5.setBounds(30, 291, 9, 23);
		add(label_5);
		
		sl5 = new JTextField();
		sl5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		sl5.setFont(new Font("Calibri", Font.BOLD, 14));
		sl5.setBounds(128, 293, 196, 20);
		add(sl5);
		sl5.setColumns(10);
		
		ybs5 = new JTextField();
		ybs5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ybs5.setFont(new Font("Calibri", Font.BOLD, 14));
		ybs5.setBounds(414, 293, 156, 20);
		add(ybs5);
		ybs5.setColumns(10);
		
		Nof5 = new JTextField();
		Nof5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Nof5.setFont(new Font("Calibri", Font.BOLD, 14));
		Nof5.setBounds(648, 293, 291, 20);
		add(Nof5);
		Nof5.setColumns(10);
		
		JLabel label_6 = new JLabel("6");
		label_6.setFont(new Font("Calibri", Font.BOLD, 18));
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(30, 331, 9, 23);
		add(label_6);
		
		sl6 = new JTextField();
		sl6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		sl6.setFont(new Font("Calibri", Font.BOLD, 14));
		sl6.setBounds(128, 333, 196, 20);
		add(sl6);
		sl6.setColumns(10);
		
		ybs6 = new JTextField();
		ybs6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ybs6.setFont(new Font("Calibri", Font.BOLD, 14));
		ybs6.setBounds(414, 333, 156, 20);
		add(ybs6);
		ybs6.setColumns(10);
		
		Nof6 = new JTextField();
		Nof6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Nof6.setFont(new Font("Calibri", Font.BOLD, 14));
		Nof6.setBounds(648, 333, 291, 20);
		add(Nof6);
		Nof6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("7");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(30, 371, 9, 23);
		add(lblNewLabel);
		
		sl7 = new JTextField();
		sl7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		sl7.setFont(new Font("Calibri", Font.BOLD, 14));
		sl7.setBounds(128, 373, 196, 20);
		add(sl7);
		sl7.setColumns(10);
		
		ybs7 = new JTextField();
		ybs7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ybs7.setFont(new Font("Calibri", Font.BOLD, 14));
		ybs7.setBounds(414, 372, 156, 20);
		add(ybs7);
		ybs7.setColumns(10);
		
		Nof7 = new JTextField();
		Nof7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					checkdate();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Nof7.setFont(new Font("Calibri", Font.BOLD, 14));
		Nof7.setBounds(648, 373, 291, 20);
		add(Nof7);
		Nof7.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset1();
			}
		});
		btnReset.setForeground(new Color(102, 102, 255));
		btnReset.setBackground(new Color(0, 0, 0));
		btnReset.setFont(new Font("Calibri", Font.BOLD, 14));
		btnReset.setBounds(34, 593, 119, 25);
		add(btnReset);
		
		btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		btnDone.setBackground(new Color(0, 0, 0));
		btnDone.setForeground(new Color(102, 102, 255));
		btnDone.setBounds(882, 594, 109, 23);
		add(btnDone);
	    btnDone.setVisible(false);
	    btnDone.setEnabled(false);
	    
	    dwarning = new JLabel("");
	    dwarning.setFont(new Font("Calibri", Font.BOLD, 14));
	    dwarning.setForeground(new Color(255, 102, 102));
	    dwarning.setBounds(273, 50, 276, 14);
	    add(dwarning);
	    
	    btnFetch = new JButton("Fetch");
	    btnFetch.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			checkdate();
					n=day();
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	    		try {
	    		 
       	         File file = new File(idn[1]+"/"+n+"sl1.txt");
       	         Scanner scanner = new Scanner(file);
       	         while (scanner.hasNextLine()) {
       	           String str=scanner.nextLine();
       	           sl1.setText(str);
       	           
       	         }
       	         scanner.close();
       	       } catch (FileNotFoundException e1) {
       	         dwarning.setText("No details found!");
       	         dwarning.setVisible(true);
       	       }
	    		try {
		    		
	       	         File file = new File(idn[1]+"/"+n+"sl2.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           sl2.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"sl3.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           sl3.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"sl4.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           sl4.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		
	       	         File file = new File(idn[1]+"/"+n+"sl5.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           sl5.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"sl6.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           sl6.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"sl7.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           sl7.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"ybs1.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           ybs1.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		
	       	         File file = new File(idn[1]+"/"+n+"ybs2.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           ybs2.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		
	       	         File file = new File(idn[1]+"/"+n+"ybs3.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           ybs3.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"ybs4.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           ybs4.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		
	       	         File file = new File(idn[1]+"/"+n+"ybs5.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           ybs5.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"ybs6.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           ybs6.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"ybs7.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           ybs7.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"Nof1.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           Nof1.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		
	       	         File file = new File(idn[1]+"/"+n+"Nof2.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           Nof2.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"Nof3.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           Nof3.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		
	       	         File file = new File(idn[1]+"/"+n+"Nof4.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           Nof4.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		 
	       	         File file = new File(idn[1]+"/"+n+"Nof5.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           Nof5.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		
	       	         File file = new File(idn[1]+"/"+n+"Nof6.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           Nof6.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    		try {
		    		
	       	         File file = new File(idn[1]+"/"+n+"Nof7.txt");
	       	         Scanner scanner = new Scanner(file);
	       	         while (scanner.hasNextLine()) {
	       	           String str=scanner.nextLine();
	       	           Nof7.setText(str);
	       	           
	       	         }
	       	         scanner.close();
	       	       } catch (FileNotFoundException e1) {
	       	         dwarning.setText("No details found!");
	       	         dwarning.setVisible(true);
	       	       }
	    	}
	    });
	    btnFetch.setForeground(new Color(51, 153, 255));
	    btnFetch.setBackground(new Color(0, 0, 0));
	    btnFetch.setFont(new Font("Calibri", Font.BOLD, 16));
	    btnFetch.setBounds(725, 44, 89, 23);
	    add(btnFetch);
	    
	    btnSave = new JButton("Save");
	    btnSave.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try
        		{
	    			checkdate();
	    			n=day();
        		    PrintWriter writer1 = new PrintWriter(idn[1]+"/"+n+"sl1.txt", "UTF-8");
        		    writer1.print(sl1.getText());
        		    writer1.close();
        		    PrintWriter writer2 = new PrintWriter(idn[1]+"/"+n+"sl2.txt", "UTF-8");
        		    writer2.print(sl2.getText());
        		    writer2.close();
        		    PrintWriter writer3 = new PrintWriter(idn[1]+"/"+n+"sl3.txt", "UTF-8");
        		    writer3.print(sl3.getText());
        		    writer3.close();
        		    PrintWriter writer4 = new PrintWriter(idn[1]+"/"+n+"sl4.txt", "UTF-8");
        		    writer4.print(sl4.getText());
        		    writer4.close();
        		    PrintWriter writer5 = new PrintWriter(idn[1]+"/"+n+"sl5.txt", "UTF-8");
        		    writer5.print(sl5.getText());
        		    writer5.close();
        		    PrintWriter writer6 = new PrintWriter(idn[1]+"/"+n+"sl6.txt", "UTF-8");
        		    writer6.print(sl6.getText());
        		    writer6.close();
        		    PrintWriter writer7 = new PrintWriter(idn[1]+"/"+n+"sl7.txt", "UTF-8");
        		    writer7.print(sl7.getText());
        		    writer7.close();
        		    PrintWriter writer8 = new PrintWriter(idn[1]+"/"+n+"ybs1.txt", "UTF-8");
        		    writer8.print(ybs1.getText());
        		    writer8.close();
        		    PrintWriter writer9 = new PrintWriter(idn[1]+"/"+n+"ybs2.txt", "UTF-8");
        		    writer9.print(ybs2.getText());
        		    writer9.close();
        		    PrintWriter writer10 = new PrintWriter(idn[1]+"/"+n+"ybs3.txt", "UTF-8");
        		    writer10.print(ybs3.getText());
        		    writer10.close();
        		    PrintWriter writer11 = new PrintWriter(idn[1]+"/"+n+"ybs4.txt", "UTF-8");
        		    writer11.print(ybs4.getText());
        		    writer11.close();
        		    PrintWriter writer12 = new PrintWriter(idn[1]+"/"+n+"ybs5.txt", "UTF-8");
        		    writer12.print(ybs5.getText());
        		    writer12.close();
        		    PrintWriter writer13 = new PrintWriter(idn[1]+"/"+n+"ybs6.txt", "UTF-8");
        		    writer13.print(ybs6.getText());
        		    writer13.close();
        		    PrintWriter writer14 = new PrintWriter(idn[1]+"/"+n+"ybs7.txt", "UTF-8");
        		    writer14.print(ybs7.getText());
        		    writer14.close();
        		    PrintWriter writer15 = new PrintWriter(idn[1]+"/"+n+"Nof1.txt", "UTF-8");
        		    writer15.print(Nof1.getText());
        		    writer15.close();
        		    PrintWriter writer16 = new PrintWriter(idn[1]+"/"+n+"Nof2.txt", "UTF-8");
        		    writer16.print(Nof2.getText());
        		    writer16.close();
        		    PrintWriter writer17 = new PrintWriter(idn[1]+"/"+n+"Nof3.txt", "UTF-8");
        		    writer17.print(Nof3.getText());
        		    writer17.close();
        		    PrintWriter writer18 = new PrintWriter(idn[1]+"/"+n+"Nof4.txt", "UTF-8");
        		    writer18.print(Nof4.getText());
        		    writer18.close();
        		    PrintWriter writer19 = new PrintWriter(idn[1]+"/"+n+"Nof5.txt", "UTF-8");
        		    writer19.print(Nof5.getText());
        		    writer19.close();
        		    PrintWriter writer20 = new PrintWriter(idn[1]+"/"+n+"Nof6.txt", "UTF-8");
        		    writer20.print(Nof6.getText());
        		    writer20.close();
        		    PrintWriter writer21 = new PrintWriter(idn[1]+"/"+n+"Nof7.txt", "UTF-8");
        		    writer21.print(Nof7.getText());
        		    writer21.close();
        		    
        		} catch (IOException | ParseException e1) {
        		   // do something
        		}
	    	}
	    });
	    btnSave.setBackground(new Color(0, 0, 0));
	    btnSave.setForeground(new Color(51, 153, 255));
	    btnSave.setFont(new Font("Calibri", Font.BOLD, 16));
	    btnSave.setBounds(596, 44, 89, 23);
	    add(btnSave);
	    
	    fwarning = new JLabel("No details found!");
	    fwarning.setFont(new Font("Calibri", Font.BOLD, 14));
	    fwarning.setForeground(new Color(255, 102, 102));
	    fwarning.setBounds(846, 48, 145, 14);
	    fwarning.setVisible(false);
	    add(fwarning);
	    
	    
        
       
        
	}
 public static void main(String args[]) throws IOException
 {
	 design Obj=new design();
	
	 Obj.setSize(new Dimension(1024,720));
	 Obj.setVisible(true);
	 
	
	
 }
}
