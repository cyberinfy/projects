
import java.awt.Dimension;
import java.awt.EventQueue;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;




import javax.swing.JLabel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


public class Openning extends JFrame implements ActionListener {
	Clip clip;
    private static final long serialVersionUID = 8679886300517958494L;

    public JButton btnOpenBeforeleave;
    public n frame2 = null;
    public void close()
    {
           WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
           Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    } 

    void playSound(String soundFile) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File f = new File("./" + soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
        clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }
    public Openning() {
    
    	
    	getContentPane().setBackground(new Color(0, 0, 0));
    	 btnOpenBeforeleave = new JButton("Open");
         btnOpenBeforeleave.setBackground(new Color(0, 0, 0));
         btnOpenBeforeleave.setFont(new Font("Calibri", Font.PLAIN, 32));
         btnOpenBeforeleave.setForeground(new Color(51, 204, 255));
         btnOpenBeforeleave.setBounds(368, 337, 111, 43);
         btnOpenBeforeleave.addActionListener(this);
       
         getContentPane().add(btnOpenBeforeleave);
    	JLabel bg = new JLabel("");
        bg .setBounds(271, 212, 300, 300);
        
     
        //frame1 stuff
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit tol1=Toolkit.getDefaultToolkit();
        Dimension dim1=tol1.getScreenSize();
        setSize(dim1.width,dim1.height);
        getContentPane().setLayout(null);
        Image img=new ImageIcon(this.getClass().getResource("/background.gif")).getImage();
        bg.setIcon(new ImageIcon(img));
        getContentPane().add(bg);
        
        JLabel TITLE = new JLabel(" ");
        TITLE.setBounds(598, 178, 486, 334);
        Image pic=new ImageIcon(this.getClass().getResource("/text.gif")).getImage();
        TITLE.setIcon(new ImageIcon(pic));
        getContentPane().add(TITLE);
        setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), btnOpenBeforeleave, bg}));
                //create button
               
      
                
    }

    public static void main(String[] args) {
    	 
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	//music();
                	
                    Openning  frame = new Openning();
                    frame.playSound("mus.wav");
                    Toolkit tol1=Toolkit.getDefaultToolkit();
			         Dimension dim1=tol1.getScreenSize();
                    frame.setVisible(true);
                    frame.setSize(dim1.width,dim1.height);
                    

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOpenBeforeleave) {
            if (frame2 == null)
				try {
					n Obj=new n();
					Obj.checkEmpid();
					Toolkit tol1=Toolkit.getDefaultToolkit();
			         Dimension dim1=tol1.getScreenSize();
					Obj.setSize(new Dimension(dim1.width,dim1.height));
					close();
					frame2 = Obj;
					frame2.setVisible(true);
					clip.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
          
        }

    }

}
