	/*
	 * 	ViewBookGUI.java
	 * 	
	 * 	Written by Frankie Yan
	 * 	Edited by David Wiebe and Jordan McMillan
	 * 
	 * 	Team TeddySoft is:
	 * 	David Wiebe
	 *  Frankie Yan
	 * 	Jordan McMillan
	 * 	Lisa Chen
	 */

package teddySoft;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBookGUI implements ActionListener {
	private JButton btnClose;
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
		//Genre LABEL Panel
		JPanel genrepanel = new JPanel();
		genrepanel.setLayout(new BoxLayout(genrepanel, BoxLayout.PAGE_AXIS));	
		genrepanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		genrepanel.setAlignmentY(Component.TOP_ALIGNMENT);
		
		//Genre LABEL
		JLabel genre = new JLabel("Genre: " + "Children's");
		//genrelabel.setMinimumSize(new Dimension(240, 20));
		//genrelabel.setMaximumSize(new Dimension(240, 20));
		//genrelabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Information Panel: title, author, edition, pubDate, pubLocation, isbn
		JPanel infopanel = new JPanel();
		infopanel.setLayout(new BoxLayout(infopanel, BoxLayout.LINE_AXIS));	
		infopanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		infopanel.setAlignmentY(Component.TOP_ALIGNMENT);
		infopanel.setBorder(BorderFactory.createTitledBorder(
        "Book Information"));
		
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
		
		//Title
		JLabel titlelabel = new JLabel("Title:");
		JLabel title = new JLabel("Title");
		title.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Author
		JLabel authorlabel = new JLabel("Author:");
		JLabel author = new JLabel("Author");
		author.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Edition
		JLabel editionlabel = new JLabel("Edition:");
		JLabel edition = new JLabel("Edition");
		edition.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Date
		JLabel datelabel = new JLabel("Publishing date:");
		JLabel date = new JLabel("2007");
		date.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Location
		JLabel placelabel = new JLabel("Publishing place:");
		JLabel place = new JLabel("Place");
		place.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//ISBN
		JLabel isbnlabel = new JLabel("ISBN number:");
		JLabel isbn = new JLabel("9999999999999");
		isbn.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		//Rating Panel
		JPanel ratepanel = new JPanel();
		ratepanel.setLayout(new BoxLayout(ratepanel, BoxLayout.PAGE_AXIS));	
		ratepanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		ratepanel.setAlignmentY(Component.TOP_ALIGNMENT);
		ratepanel.setBorder(BorderFactory.createTitledBorder(
        "Rating"));
		
		//Mid Panel
		JPanel midpanel = new JPanel();
		midpanel.setLayout(new BoxLayout(midpanel, BoxLayout.LINE_AXIS));	
		midpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		midpanel.setAlignmentY(Component.TOP_ALIGNMENT);
				
		//Radio Buttons
	    JRadioButton oneButton = new JRadioButton("1 Star");
	    oneButton.setActionCommand("One");
	    oneButton.addActionListener(this);

	    JRadioButton twoButton = new JRadioButton("2 Stars");
	    oneButton.setActionCommand("Two");
	    oneButton.addActionListener(this);
	    
	    JRadioButton threeButton = new JRadioButton("3 Stars");
	    oneButton.setActionCommand("Three");
	    oneButton.addActionListener(this);
	    
	    JRadioButton fourButton = new JRadioButton("4 Stars");
	    oneButton.setActionCommand("Four");
	    oneButton.addActionListener(this);
	    
	    JRadioButton fiveButton = new JRadioButton("5 Stars");
	    oneButton.setActionCommand("Five");
	    oneButton.addActionListener(this);
	    
	    //Check for Rating
	    oneButton.setEnabled(false);
	    twoButton.setEnabled(false);
	    threeButton.setEnabled(false);
	    fourButton.setSelected(true);
	    fiveButton.setEnabled(false);
	    
	    
	    ButtonGroup ratinggroup = new ButtonGroup();
	    ratinggroup.add(oneButton);
	    ratinggroup.add(twoButton);
	    ratinggroup.add(threeButton);
	    ratinggroup.add(fourButton);
	    ratinggroup.add(fiveButton);
		
		//Description Panel
		JPanel descpanel = new JPanel();
		descpanel.setLayout(new BoxLayout(descpanel, BoxLayout.PAGE_AXIS));	
		descpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		descpanel.setAlignmentY(Component.TOP_ALIGNMENT);
		descpanel.setBorder(BorderFactory.createTitledBorder(
        "Description"));
		
		JTextArea description = new JTextArea(4, 20);
		description.setLineWrap(true);
		JScrollPane descscroll = new JScrollPane(description);
		
		//Review Panel
		JPanel revpanel = new JPanel();
		revpanel.setLayout(new BoxLayout(revpanel, BoxLayout.PAGE_AXIS));	
		revpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		revpanel.setAlignmentY(Component.TOP_ALIGNMENT);	
		revpanel.setBorder(BorderFactory.createTitledBorder(
        "Review"));
				
		JTextArea review = new JTextArea(4, 20);
		review.setLineWrap(true);
		JScrollPane reviewscroll = new JScrollPane(review);
				
		//Button panel
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.LINE_AXIS));	
		buttonpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		buttonpanel.setAlignmentY(Component.TOP_ALIGNMENT);	
		
		btnClose = new JButton("Close");
		btnClose.setMaximumSize(new Dimension(120, 23));
		btnClose.setAlignmentX(Component.LEFT_ALIGNMENT);
		btnClose.setActionCommand("Close");
		btnClose.addActionListener(this);
		
		//Main Panel
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.PAGE_AXIS));	
		mainpanel.setAlignmentX(Component.LEFT_ALIGNMENT);	
		mainpanel.setBorder(BorderFactory.createEmptyBorder(
                20, //top
                20, //left
                20, //bottom
                20) //right
                );	


		genrepanel.add(genre);
		
		labelpanel.add(titlelabel);
		labelpanel.add(Box.createRigidArea(new Dimension(0,10)));
		labelpanel.add(authorlabel);
		labelpanel.add(Box.createRigidArea(new Dimension(0,10)));
		labelpanel.add(editionlabel);
		labelpanel.add(Box.createRigidArea(new Dimension(0,10)));
		labelpanel.add(datelabel);
		labelpanel.add(Box.createRigidArea(new Dimension(0,10)));
		labelpanel.add(placelabel);
		labelpanel.add(Box.createRigidArea(new Dimension(0,10)));
		labelpanel.add(isbnlabel);
		
		textpanel.add(title);
		textpanel.add(Box.createRigidArea(new Dimension(0,10)));
		textpanel.add(author);
		textpanel.add(Box.createRigidArea(new Dimension(0,10)));
		textpanel.add(edition);
		textpanel.add(Box.createRigidArea(new Dimension(0,10)));
		textpanel.add(date);
		textpanel.add(Box.createRigidArea(new Dimension(0,10)));
		textpanel.add(place);
		textpanel.add(Box.createRigidArea(new Dimension(0,10)));
		textpanel.add(isbn);
		infopanel.add(labelpanel);
		infopanel.add(Box.createRigidArea(new Dimension(5,0)));
		infopanel.add(textpanel);
		infopanel.add(Box.createHorizontalGlue());
				
		ratepanel.add(oneButton);
		ratepanel.add(twoButton);
		ratepanel.add(threeButton);
		ratepanel.add(fourButton);
		ratepanel.add(fiveButton);
		
		midpanel.add(infopanel);
		midpanel.add(ratepanel);
		
		descpanel.add(descscroll);
				
		revpanel.add(reviewscroll);
				
		buttonpanel.add(Box.createHorizontalGlue());
		buttonpanel.add(btnClose);
		
		mainpanel.add(genrepanel);
		mainpanel.add(Box.createRigidArea(new Dimension(0,10)));
		mainpanel.add(midpanel);
		mainpanel.add(Box.createRigidArea(new Dimension(0,10)));
		mainpanel.add(descpanel);
		mainpanel.add(Box.createRigidArea(new Dimension(0,10)));
		mainpanel.add(revpanel);
		mainpanel.add(Box.createRigidArea(new Dimension(0,10)));
		mainpanel.add(buttonpanel);
		
		return mainpanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnClose){
			frame.dispose();
		}
	}	
	
	public static void CreateGUI(){
		setWindowsLook(); //Set windows decorations
		
		//Create and set up the window.
		frame = new JFrame("View Book");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
        ViewBookGUI app = new ViewBookGUI();
        Component contents = app.mainWindowComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
        frame.pack();
        frame.setSize(460,520); // make frame 640x460
		frame.setVisible(true);
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
