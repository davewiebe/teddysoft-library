	/*
	 * 	Main.java
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
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main implements ActionListener {
	private
		static String tableType = "All"; //initialized to show all media
		static JTable table;
		JButton btnView, btnEdit, btnDelete, btnAll, btnBooks, btnRecipes, btnGames,
		btnMusic, btnMovies, btnExit, btnLogOut;
		JComboBox entrytypeList;
		static User currentUser;
		static JFrame frame;
		static Object[][] data;
		static Comparable List[];
		static JScrollPane scrollPane;
		
	public boolean isCellEditable(int row, int column){
		return false;
	}
	
	public static void getTable(String type){
		int BooksTreeLength = currentUser.getDB().getBooksTree().getSize();
		int DVDTreeLength = currentUser.getDB().getDVDTree().getSize();
		int VHSTreeLength = currentUser.getDB().getVHSTree().getSize();
		int VHS_RTreeLength = currentUser.getDB().getVHS_RTree().getSize();
		
		if(type.equals("All")){
			String[] columnNames = {"Title", "Type", "Rating"};
			int partition = 0;
			
			List = currentUser.getDB().getBooksTree().getTreeElements();
			data = new Object[BooksTreeLength + DVDTreeLength + VHSTreeLength + VHS_RTreeLength][columnNames.length + 1];
			for(int i=0;i<List.length;i++){
				Books temp = (Books)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			List = currentUser.getDB().getDVDTree().getTreeElements();
			for(int i=0;i<List.length;i++){
				DVD temp = (DVD)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			List = currentUser.getDB().getVHSTree().getTreeElements();
			for(int i=0;i<List.length;i++){
				VHS temp = (VHS)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			List = currentUser.getDB().getVHS_RTree().getTreeElements();
			for(int i=0;i<List.length;i++){
				VHS_R temp = (VHS_R)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			table = new JTable(data, columnNames);
		}
		
		else if(type.equals("Books")){
			String[] columnNames = {"Title","Author","Genre", "Rating"};
			
			List = currentUser.getDB().getBooksTree().getTreeElements();
			data = new Object[BooksTreeLength][columnNames.length + 1];
			for(int i=0;i<List.length;i++){
				Books temp = (Books)List[i];
				data[i][0] = temp.getTitle();
				data[i][1] = temp.getAuthor();
				data[i][2] = temp.getGenre();
				Integer tempint = new Integer(temp.getRating());
				data[i][3] = "" + tempint;
				data[i][4] = temp; //last column contains reference to object
			}
			table = new JTable(data, columnNames);
		}
		
		else if(type.equals("Movies")){
			String[] columnNames = {"Title","Director","Year","Type", "Rating"};
			int partition = 0;
			
			List = currentUser.getDB().getDVDTree().getTreeElements();
			data = new Object[DVDTreeLength + VHSTreeLength+ VHS_RTreeLength][columnNames.length + 1];
			for(int i=0;i<List.length;i++){
				DVD temp = (DVD)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getdirector();
				data[partition+i][2] = temp.getyear();
				data[partition+i][3] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][4] = "" + tempint;
				data[partition+i][5] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			List = currentUser.getDB().getVHSTree().getTreeElements();
			for(int i=0;i<List.length;i++){
				VHS temp = (VHS)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getdirector();
				data[partition+i][2] = temp.getyear();
				data[partition+i][3] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][4] = "" + tempint;
				data[partition+i][5] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			List = currentUser.getDB().getVHS_RTree().getTreeElements();
			for(int i=0;i<List.length;i++){
				VHS_R temp = (VHS_R)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getdirector();
				data[partition+i][2] = temp.getyear();
				data[partition+i][3] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][4] = "" + tempint;
				data[partition+i][5] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			table = new JTable(data, columnNames);
		}
	}
		
	public static void refreshJTable(){
		if (frame != null)
			frame.dispose();
        
		//Create and set up the window.
		frame = new JFrame("Media Library");
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	Main.close();
            	}
        });
		
        Main app = new Main();
        Component contents = app.mainWindowComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
		frame.setSize(640,460); // make frame 640x460
		frame.setLocationRelativeTo(null); //centers window
		//frame.pack();
		frame.setVisible(true);

	}
	
	public static void close(){
		//write UserMedia.ser
		try{
			FileOutputStream fileout = new FileOutputStream(currentUser.getName() +"-MediaDB.ser");
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			objectout.writeObject(currentUser.getDB());
			objectout.flush();
			objectout.close();
		}
		catch (IOException ex) {
			System.out.println("User MediaDB cannot be written.");
		}
		//close window
		frame.dispose();
		
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
		btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//ComboBox Panel
		JPanel combopanel = new JPanel();
		combopanel.setLayout(new BoxLayout(combopanel, BoxLayout.PAGE_AXIS));	
		combopanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Add Entries combo box
		String[] entryTypes = { "Add New Entry...", "Book", "DVD", "VHS", "VHS_R"};//, "Game", "Recipe", "Music", "Movie" };
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
		getTable(tableType);
		
		//Scroll Pane
		scrollPane = new JScrollPane(table);
		
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
				
		combopanel.add(entrytypeList);

		viewpanel.add(btnAll);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		viewpanel.add(btnBooks);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		//viewpanel.add(btnGames);
		//viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		//viewpanel.add(btnRecipes);
		//viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		//viewpanel.add(btnMusic);
		//viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		viewpanel.add(btnMovies);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
	
		leftpanel.add(topleftpanel);
		leftpanel.add(Box.createRigidArea(new Dimension(0,5)));			
		leftpanel.add(combopanel);
		leftpanel.add(Box.createRigidArea(new Dimension(0,5)));			
		leftpanel.add(viewpanel);
		leftpanel.add(Box.createVerticalGlue());
		leftpanel.add(btnDelete);
		leftpanel.add(Box.createRigidArea(new Dimension(0,5)));
		
		//tablepanel.add(table.getTableHeader());
		//tablepanel.add(table);
		tablepanel.add(scrollPane);
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
		
/*		topleftpanel.setBorder(BorderFactory.createRaisedBevelBorder());
		combopanel.setBorder(BorderFactory.createRaisedBevelBorder());
		viewpanel.setBorder(BorderFactory.createRaisedBevelBorder());
		leftpanel.setBorder(BorderFactory.createRaisedBevelBorder());
		tablepanel.setBorder(BorderFactory.createRaisedBevelBorder());
		bottompanel.setBorder(BorderFactory.createRaisedBevelBorder());
		rightpanel.setBorder(BorderFactory.createRaisedBevelBorder());
		mainpanel.setBorder(BorderFactory.createRaisedBevelBorder());*/
		
		return mainpanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")){
			LoginGUI.CreateGUI();
			close();
			System.exit(0);
		}
		else if (e.getActionCommand().equals("Log Out")){
			LoginGUI.CreateGUI();
			close();
		}
		else if (e.getActionCommand().equals("All")){
			System.out.println("Show All");
			tableType = "All";
			refreshJTable();
		}
		else if (e.getActionCommand().equals("Books")){
			System.out.println("Show Books");
			tableType = "Books";
			refreshJTable();
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
			tableType = "Movies";
			refreshJTable();
		}
		//Adding a medium to the drop menu
		else if (e.getActionCommand().equals("EntryType")){
			JComboBox temp = (JComboBox)e.getSource();
			//"Book", "Game", "Recipe", "Music", "Movie"
	        if (temp.getSelectedIndex() == 1){
	        	System.out.println("Add Book");
	        	//AddBookGUI.CreateGUI(currentUser);
	        	AddEditBookGUI.CreateGUI(currentUser, (Books) null, 0);
				}
	        else if (temp.getSelectedIndex() == 2){
	        	System.out.println("Add DVD");
	        	//AddDVDGUI.CreateGUI(currentUser);
	        	AddEditDVDGUI.CreateGUI(currentUser, (DVD) null, 0);
			}
	        else if (temp.getSelectedIndex() == 3){
	        	System.out.println("Add VHS");
	        	AddEditVHSGUI.CreateGUI(currentUser, (VHS) null, 0);
	        }
	        else if (temp.getSelectedIndex() == 4){
	        	System.out.println("Add VHS_R");
	        	AddEditVHS_RGUI.CreateGUI(currentUser, (VHS_R) null, 0);
	        }
/*	        else if (temp.getSelectedIndex() == 3){
	        	System.out.println("Add Recipe");}
	        else if (temp.getSelectedIndex() == 4){
	        	System.out.println("Add Music");}
	        else if (temp.getSelectedIndex() == 5){
	        	System.out.println("Add Movie");}*/
		}
		//deleteing a medium from table
		else if (e.getActionCommand().equals("Delete")){
			String classType = "" + data[table.getSelectedRow()][table.getColumnCount()].getClass();
			//System.out.println(classType);
			if(classType.equals("class teddySoft.DVD")){
				currentUser.getDB().getDVDTree().RBTreeRemove(((DVD) data[table.getSelectedRow()][table.getColumnCount()]));
				System.out.println("Delete DVD");
				Main.refreshJTable();
			}
			else if (classType.equals("class teddySoft.Books")){
				currentUser.getDB().getBooksTree().RBTreeRemove(((Books) data[table.getSelectedRow()][table.getColumnCount()]));
				System.out.println("Delete Book");
				Main.refreshJTable();
			}
			else if (classType.equals("class teddySoft.VHS")){
				currentUser.getDB().getVHSTree().RBTreeRemove(((VHS) data[table.getSelectedRow()][table.getColumnCount()]));
				System.out.println("Delete VHS");
				Main.refreshJTable();
			}
			else if (classType.equals("class teddySoft.VHS_R")){
				currentUser.getDB().getVHS_RTree().RBTreeRemove(((VHS_R) data[table.getSelectedRow()][table.getColumnCount()]));
				System.out.println("Delete VHS_R");
				Main.refreshJTable();
			}
			
		}
		//editing a medium from table
		else if (e.getActionCommand().equals("Edit") && table.getSelectedRow() != -1){

			String classType = "" + data[table.getSelectedRow()][table.getColumnCount()].getClass();
			
			if(classType.equals("class teddySoft.DVD")){
				//System.out.println(table.getColumnCount());
				AddEditDVDGUI.CreateGUI(currentUser,(DVD) data[table.getSelectedRow()][table.getColumnCount()], 1);
			}
			else if (classType.equals("class teddySoft.Books")){
				AddEditBookGUI.CreateGUI(currentUser,(Books) data[table.getSelectedRow()][table.getColumnCount()], 1);
			}
			else if (classType.equals("class teddySoft.VHS")){
				AddEditVHSGUI.CreateGUI(currentUser,(VHS) data[table.getSelectedRow()][table.getColumnCount()], 1);
			}
			else if (classType.equals("class teddySoft.VHS_R")){
				AddEditVHS_RGUI.CreateGUI(currentUser,(VHS_R) data[table.getSelectedRow()][table.getColumnCount()], 1);
			}
			
		}
		//view a medium from table
		else if (e.getActionCommand().equals("View")){
			if(table.getSelectedRow() != -1){//if a row is selected
				String classType = "" + data[table.getSelectedRow()][table.getColumnCount()].getClass();
				if(classType.equals("class teddySoft.DVD")){
					ViewDVDGUI.CreateGUI((DVD) data[table.getSelectedRow()][table.getColumnCount()]);
				}
				else if (classType.equals("class teddySoft.Books")){
					ViewBookGUI.CreateGUI((Books) data[table.getSelectedRow()][table.getColumnCount()]);
				}
				else if (classType.equals("class teddySoft.VHS")){
					ViewVHSGUI.CreateGUI((VHS) data[table.getSelectedRow()][table.getColumnCount()]);
				}
				else if (classType.equals("class teddySoft.VHS_R")){
					ViewVHS_RGUI.CreateGUI((VHS_R) data[table.getSelectedRow()][table.getColumnCount()]);
				}
				
			}
		}
	}	
	
	public static void CreateGUI(User user){
		setWindowsLook(); //Set windows decorations
		currentUser = user;
		//read userDB.ser
		try{
			InputStream istream = new FileInputStream(currentUser.getName() +"-MediaDB.ser");
			ObjectInput oinput = new ObjectInputStream(istream);
			MediaDatabase media = (MediaDatabase)oinput.readObject();
			currentUser.setDB(media);
			oinput.close();
		}
		catch (IOException ex) {
			System.out.println("User MediaDB not found or not created yet.");
			currentUser.setDB(new MediaDatabase());
		}
		catch (ClassNotFoundException ex2){
			System.out.println("User class not found.");
		}
		
		refreshJTable();
/*		//Create and set up the window.
		frame = new JFrame("Media Library");
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	Main.close();
            	System.exit(0);
            	}
        });
		
        Main app = new Main();
        Component contents = app.mainWindowComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
		frame.pack();
		frame.setVisible(true);
		frame.setSize(640,460); // make frame 640x460
		frame.setLocationRelativeTo(null); //centers window
*/
	}	
	
}
