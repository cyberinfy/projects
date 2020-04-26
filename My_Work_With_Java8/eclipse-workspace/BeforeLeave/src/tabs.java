

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.FocusAdapter;
//import java.awt.event.FocusEvent;
import java.io.IOException;
//import java.util.LinkedList;
//import java.util.List;

import javax.swing.*;
import java.awt.Color;


public class tabs extends JFrame implements inter{
	/**
	 * 
	 */
	public design[] panel=new design[19];
 boolean navigate=false;
	private static final long serialVersionUID = 1L;
	public tabs(int n) throws IOException {
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.DARK_GRAY);
		int i;
		//List<design> list=new LinkedList<design>();
		
		
		
		
		getContentPane().setLayout(null);
		Toolkit tol1=Toolkit.getDefaultToolkit();
	  	Dimension dim1=tol1.getScreenSize();
	  	
	  	 
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Calibri", Font.BOLD, 14));
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setBackground(Color.DARK_GRAY);
		tabbedPane.setBounds(0, 0, dim1.width, dim1.height);
		getContentPane().add(tabbedPane);
		for(i=1;i<=n;i++)
		{
		 panel[i] = new design();
		
		 if(i==n)
		 {
			 panel[i].btnDone.setVisible(true);
			 panel[i].btnDone.setEnabled(true);
			 
		 }
		 
		 
	  	 tabbedPane.addTab("Day"+i, null, panel[i], null);
	  	panel[i].btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j;
				for(j=1;j<=n;j++)
				{
				
					if(!panel[j].sl1.getText().isEmpty())
					sl1[j]=panel[j].sl1.getText();
					if(!panel[j].ybs1.getText().isEmpty())
					ybs1[j]=panel[j].ybs1.getText();
					if(!panel[j].Nof1.getText().isEmpty())
					Nof1[j]=panel[j].Nof1.getText();
					if(!panel[j].sl2.getText().isEmpty())
					sl2[j]=panel[j].sl2.getText();
					if(!panel[j].ybs2.getText().isEmpty())
					ybs2[j]=panel[j].ybs2.getText();
					if(!panel[j].Nof2.getText().isEmpty())
					Nof2[j]=panel[j].Nof2.getText();
					if(!panel[j].sl3.getText().isEmpty())
					sl3[j]=panel[j].sl3.getText();
					if(!panel[j].ybs3.getText().isEmpty())
					ybs3[j]=panel[j].ybs3.getText();
					if(!panel[j].Nof3.getText().isEmpty())
					Nof3[j]=panel[j].Nof3.getText();
					if(!panel[j].sl4.getText().isEmpty())
					sl4[j]=panel[j].sl4.getText();
					if(!panel[j].ybs4.getText().isEmpty())
					ybs4[j]=panel[j].ybs4.getText();
					if(!panel[j].Nof4.getText().isEmpty())
					Nof4[j]=panel[j].Nof4.getText();
					if(!panel[j].sl5.getText().isEmpty())
					sl5[j]=panel[j].sl5.getText();
					if(!panel[j].ybs5.getText().isEmpty())
					ybs5[j]=panel[j].ybs5.getText();
					if(!panel[j].Nof5.getText().isEmpty())
					Nof5[j]=panel[j].Nof5.getText();
					if(!panel[j].sl6.getText().isEmpty())
					sl6[j]=panel[j].sl6.getText();
					if(!panel[j].ybs6.getText().isEmpty())
					ybs6[j]=panel[j].ybs6.getText();
					if(!panel[j].Nof6.getText().isEmpty())
					Nof6[j]=panel[j].Nof6.getText();
					if(!panel[j].sl7.getText().isEmpty())
					sl7[j]=panel[j].sl7.getText();
					if(!panel[j].ybs7.getText().isEmpty())
					ybs7[j]=panel[j].ybs7.getText();
					if(!panel[j].Nof7.getText().isEmpty())
					Nof7[j]=panel[j].Nof7.getText();
			        kdate[j]=((JTextField)panel[j].dateChooser.getDateEditor().getUiComponent()).getText();
			        
			        
				}
				navigate=true;
				dispose();
			}
			
		});
	  	
	}
   }

}