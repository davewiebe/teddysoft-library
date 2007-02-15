package teddySoft;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main implements ActionListener {
	private
		JButton btnView, btnEdit, btnDelete, btnAll, btnBooks, btnRecipes, btnGames,
		btnMusic, btnMovies, btnExit, btnLogOut;
		JComboBox entrytypeList;
		static User currentUser;
		static JFrame frame;
	
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
		//Top Left Panel
		JPanel topleftpanel = new JPanel();
		topleftpanel.setLayout(new BoxLayout(topleftpanel, BoxLayout.PAGE_AXIS));		
		topleftpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//View Entry button 
		btnView = new JButton("View Entry");
		btnView.setMnemonic('v'); 
		btnView.setMaximumSize(new Dimension(120, 23));
		btnView.setActionCommand("View");
		btnView.addActionListener(this);
		//Edit Entry button
		btnEdit = new JButton("Edit Entry");
		btnEdit.setMnemonic('e');
		btnEdit.setMaximumSize(new Dimension(120, 23));
		btnEdit.setActionCommand("Edit");
		btnEdit.addActionListener(this);
		//Delete Entry button
		btnDelete = new JButton("Delete Entry");
		btnDelete.setMnemonic('d');
		btnDelete.setMaximumSize(new Dimension(120, 23));
		btnDelete.setActionCommand("Delete");
		btnDelete.addActionListener(this);
		
		//ComboBox Panel
		JPanel combopanel = new JPanel();
		combopanel.setLayout(new BoxLayout(combopanel, BoxLayout.PAGE_AXIS));	
		combopanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Add Entries combo box
		String[] entryTypes = { "Add New Entry...", "Book", "Game", "Recipe", "Music", "Movie" };
		entrytypeList = new JComboBox(entryTypes);
		entrytypeList.setSelectedIndex(0);
		entrytypeList.setMaximumSize(new Dimension(160, 40));
		entrytypeList.setActionCommand("EntryType");
		entrytypeList.addActionListener(this);

		//View Panel
		JPanel viewpanel = new JPanel();
		viewpanel.setLayout(new BoxLayout(viewpanel, BoxLayout.PAGE_AXIS));	
		viewpanel.setBorder(BorderFactory.createTitledBorder(
        "View"));
		viewpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Show All button 
		btnAll = new JButton("Show All");
		btnAll.setMaximumSize(new Dimension(100, 23));
		btnAll.setActionCommand("All");
		btnAll.addActionListener(this);
		//Only Books button 
		btnBooks = new JButton("Only Books");
		btnBooks.setMaximumSize(new Dimension(100, 23));
		btnBooks.setActionCommand("Books");
		btnBooks.addActionListener(this);
		//Only Games button 
		btnGames = new JButton("Only Games");
		btnGames.setMaximumSize(new Dimension(100, 23));
		btnGames.setActionCommand("Games");
		btnGames.addActionListener(this);
		//Only Recipes button 
		btnRecipes = new JButton("Only Recipes");
		btnRecipes.setMaximumSize(new Dimension(100, 23));
		btnRecipes.setActionCommand("Recipes");
		btnRecipes.addActionListener(this);
		//Only Music button 
		btnMusic = new JButton("Only Music");
		btnMusic.setMaximumSize(new Dimension(100, 23));
		btnMusic.setActionCommand("Music");
		btnMusic.addActionListener(this);
		//Only Movies button 
		btnMovies = new JButton("Only Movies");
		btnMovies.setMaximumSize(new Dimension(100, 23));
		btnMovies.setActionCommand("Movies");
		btnMovies.addActionListener(this);		
		
		//Left Panel
		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.PAGE_AXIS));	
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);		
			
		//Table Panel
		JPanel tablepanel = new JPanel();
		tablepanel.setLayout(new BoxLayout(tablepanel, BoxLayout.PAGE_AXIS));	
		topleftpanel.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		//Table
		String[] columnNames = {"Title",
                "Genre",
                "Year",
                "Publisher",
                "Type"};

		Object[][] data = {
		{"ABC", "Action", new Integer(2005), " ", "Book"},
		{"AAA", "Adventure", new Integer(1983), "Publisher",  "Book"},
		{"XYZ", "Mystery", new Integer(2121), "1234",  "Book"},
		{"ZZZ", "Horror", new Integer(2000), "abc",  "Book"},
		{"ADFAF KJAFA", "Horror", new Integer(1078), "ddd",  "Book"}
		};
				
		JTable temptable = new JTable(data, columnNames);
		JScrollPane temptablescroll = new JScrollPane(temptable);
		temptable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		//Bottom Panel
		JPanel bottompanel = new JPanel();
		bottompanel.setLayout(new BoxLayout(bottompanel, BoxLayout.LINE_AXIS));	
		//topleftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);		
		
		//Logout button 
		btnExit = new JButton("Exit");
		btnExit.setMaximumSize(new Dimension(120, 23));
		btnExit.setActionCommand("Exit");
		btnExit.addActionListener(this);
		
		//Exit button 
		btnLogOut = new JButton("Log Out");
		btnLogOut.setMaximumSize(new Dimension(120, 23));
		btnLogOut.setActionCommand("Log Out");
		btnLogOut.addActionListener(this);

		//Right Panel
		JPanel rightpanel = new JPanel();
		rightpanel.setLayout(new BoxLayout(rightpanel, BoxLayout.PAGE_AXIS));	
		rightpanel.setAlignmentX(Component.RIGHT_ALIGNMENT);				
		
		topleftpanel.add(btnView);
		topleftpanel.add(Box.createRigidArea(new Dimension(0,5)));
		topleftpanel.add(btnEdit);
		topleftpanel.add(Box.createRigidArea(new Dimension(0,5)));
		topleftpanel.add(btnDelete);
		topleftpanel.add(Box.createRigidArea(new Dimension(0,5)));
		
		combopanel.add(entrytypeList);

		viewpanel.add(btnAll);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		viewpanel.add(btnBooks);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		viewpanel.add(btnGames);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		viewpanel.add(btnRecipes);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		viewpanel.add(btnMusic);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		viewpanel.add(btnMovies);
	
		leftpanel.add(topleftpanel);
		leftpanel.add(Box.createRigidArea(new Dimension(0,5)));			
		leftpanel.add(combopanel);
		leftpanel.add(Box.createRigidArea(new Dimension(0,5)));			
		leftpanel.add(viewpanel);
		leftpanel.add(Box.createVerticalGlue());
		
		tablepanel.add(temptable.getTableHeader());
		tablepanel.add(temptable);
		tablepanel.add(temptablescroll);
		bottompanel.add(Box.createHorizontalGlue());
		bottompanel.add(btnLogOut);
		bottompanel.add(btnExit);		
		
		rightpanel.add(tablepanel);
		rightpanel.add(Box.createRigidArea(new Dimension(0,30)));		
		rightpanel.add(bottompanel);
		
		//Main Panel
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.LINE_AXIS));
		
		mainpanel.add(leftpanel);
		mainpanel.add(Box.createRigidArea(new Dimension(30,0)));	
		mainpanel.add(rightpanel);
		
		mainpanel.setBorder(BorderFactory.createEmptyBorder(
                20, //top
                20, //left
                20, //bottom
                20) //right
                );	
		
//		topleftpanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		combopanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		viewpanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		leftpanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		tablepanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		bottompanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		rightpanel.setBorder(BorderFactory.createRaisedBevelBorder());
//		mainpanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		return mainpanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		//if ("disable".equals(e.getActionCommand()))
		if (e.getActionCommand().equals("Exit")){
			System.exit(0);
		}
		else if (e.getActionCommand().equals("Log Out")){
			LoginGUI.CreateGUI();
			frame.dispose();
		}
		else if (e.getActionCommand().equals("All")){
			System.out.println("Show All");
		}
		else if (e.getActionCommand().equals("Books")){
			System.out.println("Show Books");
		}
		else if (e.getActionCommand().equals("Games")){
			System.out.println("Show Games");
		}
		else if (e.getActionCommand().equals("Recipes")){
			System.out.println("Show Recipes");
		}
		else if (e.getActionCommand().equals("Music")){
			System.out.println("Show Music");
		}
		else if (e.getActionCommand().equals("Movies")){
			System.out.println("Show Movies");
		}
		else if (e.getActionCommand().equals("EntryType")){
			JComboBox temp = (JComboBox)e.getSource();
			//"Book", "Game", "Recipe", "Music", "Movie"
	        if (temp.getSelectedIndex() == 1){
	        	System.out.println("Add Book");
	        	AddBookGUI.CreateGUI(currentUser);}
	        else if (temp.getSelectedIndex() == 2){
	        	System.out.println("Add Game");}
	        else if (temp.getSelectedIndex() == 3){
	        	System.out.println("Add Recipe");}
	        else if (temp.getSelectedIndex() == 4){
	        	System.out.println("Add Music");}
	        else if (temp.getSelectedIndex() == 5){
	        	System.out.println("Add Movie");}
		}
		else if (e.getActionCommand().equals("Delete")){
			System.out.println("Delete Entry");
		}
		else if (e.getActionCommand().equals("Edit")){
			System.out.println("Edit Entry");
		}
		else if (e.getActionCommand().equals("View")){
			System.out.println("View Entry");
		}
	}	
	
	public static void CreateGUI(User user){
		setWindowsLook(); //Set windows decorations
		currentUser = user;
		//Create and set up the window.
		frame = new JFrame("Media Library");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        Main app = new Main();
        Component contents = app.mainWindowComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
		frame.pack();
		frame.setVisible(true);
		frame.setSize(640,460); // make frame 640x460
		frame.setLocationRelativeTo(null); //centers window

	}	
	
}
