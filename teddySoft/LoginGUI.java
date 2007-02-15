package teddySoft;
//newer
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class LoginGUI implements ActionListener {

	private String username, password = "";
	private JButton btnSignin, btnRegister, btnExit;
	private JTextField user;
	private JPasswordField pw;
	private static JFrame frame;
	private JLabel userlabel, errorlabel;
	private static UserDatabase userDB;
	
	public static UserDatabase getUserDB(){
		return userDB;
	}

	
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
		userlabel = new JLabel("Username:");
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
		
		//BottomRight Panel
		JPanel bottomrightpanel = new JPanel();
		bottomrightpanel.setLayout(new BoxLayout(bottomrightpanel, BoxLayout.LINE_AXIS));	
		bottomrightpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Register Panel
		JPanel regpanel = new JPanel();
		regpanel.setLayout(new BoxLayout(regpanel, BoxLayout.PAGE_AXIS));	
		regpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Register Label
		JLabel reglabel = new JLabel("New user? Click below to register");
		reglabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		regpanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		//Register button
		btnRegister = new JButton("Register new user");
		btnRegister.setMaximumSize(new Dimension(180, 23));
		btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegister.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnRegister.setActionCommand("Register");
		btnRegister.addActionListener(this);
		
		//ERROR
		errorlabel = new JLabel(" ");
		//errorlabel.setText("<html>"+"Sign in with your login information."+"</font></html>");
		errorlabel.setText("Enter username and password.");
		errorlabel.setVisible(true);
		//EXIT Panel
		JPanel exitpanel = new JPanel();
		exitpanel.setLayout(new BoxLayout(exitpanel, BoxLayout.PAGE_AXIS));	
		exitpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		exitpanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				
		//Exit button
		btnExit = new JButton("Exit");
		btnExit.setMaximumSize(new Dimension(80, 23));
		btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnExit.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnExit.setActionCommand("Exit");
		btnExit.addActionListener(this);
		
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
		
		regpanel.add(reglabel);
		regpanel.add(Box.createRigidArea(new Dimension(0,10)));
		regpanel.add(btnRegister);
		
		exitpanel.add(btnExit);
		bottomrightpanel.add(regpanel);
		bottomrightpanel.add(Box.createRigidArea(new Dimension(10,0)));
		bottomrightpanel.add(exitpanel);
		
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
		textpanel.add(Box.createRigidArea(new Dimension(0,5)));
		textpanel.add(errorlabel);
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
			boolean valid = secureCheck.validateKey(username, password, userDB);
			if (username.compareTo("") != 0 && 
					password.compareTo("") != 0 &&
					valid == true){
				Main.CreateGUI(userDB.getUser(username));
//				write userDB.ser
				try{
					FileOutputStream fileout = new FileOutputStream("UserDB.ser");
					ObjectOutputStream objectout = new ObjectOutputStream(fileout);
					objectout.writeObject(userDB.getUserList());
					//objectout.flush();
					objectout.close();
				}
				catch (IOException ex) {
					User test = (userDB.getUserList())[0];
					System.out.println(test.getName());
					System.out.println("User List cannot be written.");
				}
				frame.dispose();
			}
			else if(username.compareTo("") == 0) {
				//insert no username notification here
				errorlabel.setText("User field is empty");
				//errorlabel.setText("<html><font color=red>"+"User field is empty"+"</font></html>");
				errorlabel.setForeground(new Color(0xff0000));
				errorlabel.setVisible(true);
			}
			else if(password.compareTo("")==0){
				//insert no password notification here
				//errorlabel.setText("<html><font color=red>"+"Password field is empty"+"</font></html>");
				errorlabel.setText("Password field is empty");
				errorlabel.setForeground(new Color(0xff0000));
				errorlabel.setVisible(true);
			}
			else {
				//insert incorrect password, or wrong username alert here
				//errorlabel.setText("<html><font color=red>"+"No such user or wrong password"+"</font></html>");
				errorlabel.setText("No such user or wrong password");
				errorlabel.setForeground(new Color(0xff0000));
				errorlabel.setVisible(true);
			}
		}
		else if(e.getSource() == btnRegister){
			RegisterGUI.CreateGUI();
			
		}
		else if(e.getSource() == btnExit){
			System.exit(0);
		}
	}	
	
	public static void CreateGUI(){
		setWindowsLook(); //Set windows decorations
		
		//Create and set up the window.
		frame = new JFrame("Media Library");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        LoginGUI app = new LoginGUI();
        Component contents = app.mainWindowComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
		frame.pack();
		frame.setSize(640,460); // make frame 640x460
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); //centers window

	}	
	
	public static void main(String[] args){
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				//read userDB.ser
				try{
					InputStream istream = new FileInputStream("UserDB.ser");
					ObjectInput oinput = new ObjectInputStream(istream);
					User[] newList = ((User[])oinput.readObject());
					userDB = new UserDatabase(newList);
					oinput.close();
				}
				catch (IOException ex) {
					System.out.println("User List not found or not created yet.");
					userDB = new UserDatabase();
				}
				catch (ClassNotFoundException ex2){
					System.out.println("User class not found.");
				}
				CreateGUI();
			}
		});
	}
}
