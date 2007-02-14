package teddySoft;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterGUI implements ActionListener {
	private JButton btnReg;
	private JPasswordField pw, rpw;
	private JTextField username;
	private static JFrame frame;
	
	
	public static void setWindowsLook(){
	    try{
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    // Set System L&F
	    }catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }catch (ClassNotFoundException e){
	       // handle exception
	    }catch (InstantiationException e){
	       // handle exception
	    }catch (IllegalAccessException e){
	       // handle exception
	    }		
	}	
	
	private Component mainWindowComponents() {
		//Label Panel
		JPanel labelpanel = new JPanel();
		labelpanel.setLayout(new BoxLayout(labelpanel, BoxLayout.PAGE_AXIS));	
		labelpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		labelpanel.setAlignmentY(Component.TOP_ALIGNMENT);
		
		//Text Panel
		JPanel textpanel = new JPanel();
		textpanel.setLayout(new BoxLayout(textpanel, BoxLayout.PAGE_AXIS));	
		textpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		textpanel.setAlignmentY(Component.TOP_ALIGNMENT);
		
		//Username
		JLabel userlabel = new JLabel("Username:");
		username = new JTextField(20);
		username.setMinimumSize(new Dimension(160, 20));
		username.setMaximumSize(new Dimension(160, 20));
		username.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Password
		JLabel pwlabel = new JLabel("Password:");
		pw = new JPasswordField(20);
		pw.setMinimumSize(new Dimension(160, 20));
		pw.setMaximumSize(new Dimension(160, 20));
		pw.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Repeat Password
		JLabel rpwlabel = new JLabel("Repeat password:");
		rpw = new JPasswordField(20);
		rpw.setMinimumSize(new Dimension(160, 20));
		rpw.setMaximumSize(new Dimension(160, 20));
		rpw.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Top Panel
		JPanel toppanel = new JPanel();
		toppanel.setLayout(new BoxLayout(toppanel, BoxLayout.LINE_AXIS));	
		toppanel.setAlignmentX(Component.LEFT_ALIGNMENT);	

/*		
		//---unless distinguishing between male and female becomes necessary
		// we dont need this here----
		//Radio button Panel
		JPanel radiopanel = new JPanel();
		radiopanel.setLayout(new BoxLayout(radiopanel, BoxLayout.PAGE_AXIS));	
		radiopanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		radiopanel.setAlignmentY(Component.TOP_ALIGNMENT);
		radiopanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		
		//---unless distinguishing between male and female becomes necessary
		// we dont need this here----
		//Radio Buttons
	    JRadioButton maleButton = new JRadioButton("Male");
	    maleButton.setActionCommand("Male");
	    maleButton.addActionListener(this);
	    maleButton.setSelected(true);

	    JRadioButton femaleButton = new JRadioButton("Female");
	    femaleButton.setActionCommand("Female");
	    femaleButton.addActionListener(this);
	    
	    ButtonGroup gendergroup = new ButtonGroup();
	    gendergroup.add(maleButton);
	    gendergroup.add(femaleButton);
*/
	    //Register panel
		JPanel regpanel = new JPanel();
		regpanel.setLayout(new BoxLayout(regpanel, BoxLayout.LINE_AXIS));	
		regpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	    
		//Register button
		btnReg = new JButton("Register");
		btnReg.setMaximumSize(new Dimension(120, 23));
		btnReg.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnReg.setActionCommand("Register");
		btnReg.addActionListener(this);
			
		//Main Panel
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.PAGE_AXIS));	
		mainpanel.setAlignmentX(Component.CENTER_ALIGNMENT);	
		mainpanel.setBorder(BorderFactory.createTitledBorder(
        "Registered New User"));

		labelpanel.add(userlabel);
		labelpanel.add(Box.createRigidArea(new Dimension(0,15)));
		labelpanel.add(pwlabel);
		labelpanel.add(Box.createRigidArea(new Dimension(0,15)));
		labelpanel.add(rpwlabel);
		
		textpanel.add(username);
		textpanel.add(Box.createRigidArea(new Dimension(0,10)));
		textpanel.add(pw);
		textpanel.add(Box.createRigidArea(new Dimension(0,10)));
		textpanel.add(rpw);
		
		toppanel.add(Box.createRigidArea(new Dimension(5,0)));
		toppanel.add(labelpanel);
		toppanel.add(textpanel);
		labelpanel.add(Box.createRigidArea(new Dimension(5,0)));
		
		//radiopanel.add(maleButton);
		//radiopanel.add(femaleButton);
		
		regpanel.add(Box.createHorizontalGlue());
		regpanel.add(btnReg);
		regpanel.add(Box.createRigidArea(new Dimension(5,0)));
		
		mainpanel.add(Box.createRigidArea(new Dimension(0,30)));
		mainpanel.add(toppanel);
		mainpanel.add(Box.createRigidArea(new Dimension(0,10)));
		//mainpanel.add(radiopanel);
		mainpanel.add(Box.createRigidArea(new Dimension(0,10)));
		mainpanel.add(regpanel);
		mainpanel.add(Box.createRigidArea(new Dimension(0,58)));	
		return mainpanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnReg){
			String password1 = "";
			String password2 = "";
			char[] temppass1 = pw.getPassword();
			for (int i = 0; i< temppass1.length; i++){
				password1 += temppass1[i]; 
			}
			char[] temppass2 = rpw.getPassword();
			for (int i = 0; i< temppass2.length; i++){
				password2 += temppass2[i]; 
			}
			if (password1.compareTo(password2) == 0 && username.getText().compareTo("") != 0 && password1.compareTo("") != 0){
				//UserDatabase.addUser(user.getText(), password1));
				
				UserDatabase.addUser(username.getText(), password1);
				System.out.println(username.getText() + " added");
				frame.dispose();
			}
			else{
				System.out.println("no good man,");
			}
		}
	}	
	
	public static void CreateGUI(){
		setWindowsLook(); //Set windows decorations
		
		//Create and set up the window.
		frame = new JFrame("Register New User");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
        RegisterGUI app = new RegisterGUI();
        Component contents = app.mainWindowComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
		frame.pack();
		frame.setVisible(true);
		frame.setSize(290,280); // make frame 640x460
		frame.setLocationRelativeTo(null); //centers window

	}	
	
	public static void main(String[] args){
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				CreateGUI();
			}
		});
	}
}
