package teddySoft;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;


public class LoginGUI implements ActionListener {

	private String username, password = "";
	private JButton btnSignin, btnRegister;
	private JTextField user;
	private JPasswordField pw;
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
		user = new JTextField(20);
		user.setMinimumSize(new Dimension(160, 20));
		user.setMaximumSize(new Dimension(160, 20));
		user.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Password
		JLabel pwlabel = new JLabel("Password:");
		pw = new JPasswordField(20);
		pw.setMinimumSize(new Dimension(160, 20));
		pw.setMaximumSize(new Dimension(160, 20));
		pw.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Signin button
		btnSignin = new JButton("Sign in");
		btnSignin.setMaximumSize(new Dimension(120, 23));
		btnSignin.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnSignin.setActionCommand("Signin");
		btnSignin.addActionListener(this);
		

		//Top Right Panel
		JPanel toprightpanel = new JPanel();
		toprightpanel.setLayout(new BoxLayout(toprightpanel, BoxLayout.LINE_AXIS));	
		toprightpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		toprightpanel.setBorder(BorderFactory.createTitledBorder(
        "Registered Users"));
		
		//Bottom Right Panel
		JPanel bottomrightpanel = new JPanel();
		bottomrightpanel.setLayout(new BoxLayout(bottomrightpanel, BoxLayout.PAGE_AXIS));	
		bottomrightpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Register Label
		JLabel reglabel = new JLabel("New user? Click below to register");
		reglabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Register button
		btnRegister = new JButton("Register new user");
		btnRegister.setMaximumSize(new Dimension(180, 23));
		btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegister.setActionCommand("Register");
		btnRegister.addActionListener(this);
		
		//Right Panel
		JPanel rightpanel = new JPanel();
		rightpanel.setLayout(new BoxLayout(rightpanel, BoxLayout.PAGE_AXIS));	
		rightpanel.setAlignmentX(Component.LEFT_ALIGNMENT);	
		
		//Left Panel
		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.PAGE_AXIS));	
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);	
		
		//Main Panel
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.LINE_AXIS));	
		mainpanel.setAlignmentX(Component.LEFT_ALIGNMENT);	
		mainpanel.setBorder(BorderFactory.createEmptyBorder(
                20, //top
                20, //left
                20, //bottom
                20) //right
                );	
		
		bottomrightpanel.add(reglabel);
		bottomrightpanel.add(Box.createRigidArea(new Dimension(0,10)));
		bottomrightpanel.add(btnRegister);
		
		labelpanel.add(Box.createRigidArea(new Dimension(0,20)));
		labelpanel.add(userlabel);
		labelpanel.add(Box.createRigidArea(new Dimension(0,5)));
		labelpanel.add(pwlabel);
		
		textpanel.add(Box.createRigidArea(new Dimension(0,20)));
		textpanel.add(user);
		textpanel.add(Box.createRigidArea(new Dimension(0,5)));
		textpanel.add(pw);
		textpanel.add(Box.createRigidArea(new Dimension(0,5)));
		textpanel.add(btnSignin);
		textpanel.add(Box.createRigidArea(new Dimension(0,20)));
		
		toprightpanel.add(Box.createRigidArea(new Dimension(15,0)));
		toprightpanel.add(labelpanel);
		toprightpanel.add(textpanel);
		toprightpanel.add(Box.createRigidArea(new Dimension(15,0)));
		
		rightpanel.add(Box.createRigidArea(new Dimension(0,80)));
		rightpanel.add(toprightpanel);
		rightpanel.add(Box.createRigidArea(new Dimension(0,20)));
		rightpanel.add(bottomrightpanel);
		rightpanel.add(Box.createVerticalGlue());
				
		leftpanel.add(Box.createRigidArea(new Dimension(300, 400)));
		
		mainpanel.add(leftpanel);
		mainpanel.add(rightpanel);
		
		return mainpanel;
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnSignin){
			username = user.getText();
			char[] temppass = pw.getPassword();
			password = new String(temppass);
			Security secureCheck = new Security();
			if (secureCheck.validateKey(username, password) == true){
				Main.CreateGUI();
				frame.dispose();
			}
			else {
				password = "";
				pw.setText("");
				//insert wrong password notification here
			}	
		}
		else if(e.getSource() == btnRegister){
			RegisterGUI.CreateGUI();
		}
	}	
	
	private static void CreateGUI(){
		setWindowsLook(); //Set windows decorations
		
		//Create and set up the window.
		frame = new JFrame("Media Library");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
        LoginGUI app = new LoginGUI();
        Component contents = app.mainWindowComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
		frame.pack();
		frame.setVisible(true);
		frame.setSize(640,460); // make frame 640x460
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
