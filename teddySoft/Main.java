	/*
	 * 	Main.java
	 * 	
	 * 	Written by Frankie Yan
	 * 	Edited by David Wiebe and Jordan McMillan
	 * 
	 * 	Team TeddySoft is:
	 * 	David Wiebe
	 * 	Frankie Yan
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
	private static String tableType = "All"; //initialized to show all media
	private static JTable table;
	private JButton btnView, btnEdit, btnDelete, btnAll, btnBooks, btnRecipes, btnGames,
		btnMusic, btnMovies, btnExit, btnLogOut, btnSearch;
	private static JComboBox entrytypeList, searchtypeList;
	private static JTextField searchfield;
	private static User currentUser;
	private static JFrame frame;
	private static Object[][] data;
	private static Comparable List[]; //array of comparable objects
	private static JScrollPane scrollPane;
	private static Component contents;
	private static boolean showSearchResultsFlag = false; //initialize to not show search results
		
	public static User getCurrentUser(){
		return currentUser;
	}
	
	public static void readData(){
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
	}
	
	//POST: Writes currentUser's media database to a serializable file
	public static void writeData(){
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
	}
	
	public static void search(int mediaType, String textFeild){
		//mediaTypes All, Book, DVD, Recipe, VHS, VHS_R, Video Game

		int BooksTreeLength = currentUser.getDB().getBooksTree().getSize();
		int DVDTreeLength = currentUser.getDB().getDVDTree().getSize();
		int VHSTreeLength = currentUser.getDB().getVHSTree().getSize();
		int VHS_RTreeLength = currentUser.getDB().getVHS_RTree().getSize();
		int VideoGameTreeLength = currentUser.getDB().getVideoGameTree().getSize();
		int RecipeTreeLength = currentUser.getDB().getRecipeTree().getSize();

		if(mediaType==0){ //all
			int partition = 0;
			String[] columnNames = {"Title", "Type", "Rating"};
			int count=-1; //counts how many elements in List are not equal to null pointers
			data = new Object[BooksTreeLength + DVDTreeLength + VHSTreeLength + VHS_RTreeLength + VideoGameTreeLength + RecipeTreeLength][columnNames.length + 1];
			
			List = currentUser.getDB().getBooksTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			for(int i=0;(i<count);i++){
				Books temp = (Books)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition+count;
			
			count=-1; //counts how many elements in List are not equal to null pointers
			List = currentUser.getDB().getDVDTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			for(int i=0;(i<count);i++){
				DVD temp = (DVD)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition+count;
			
			count=-1; //counts how many elements in List are not equal to null pointers
			List = currentUser.getDB().getRecipeTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			for(int i=0;(i<count);i++){
				Recipe temp = (Recipe)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition+count;
			
			count=-1; //counts how many elements in List are not equal to null pointers
			List = currentUser.getDB().getVHSTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			for(int i=0;(i<count);i++){
				VHS temp = (VHS)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition+count;
			
			count=-1; //counts how many elements in List are not equal to null pointers
			List = currentUser.getDB().getVHS_RTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			for(int i=0;(i<count);i++){
				VHS_R temp = (VHS_R)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition+count;
			
			count=-1; //counts how many elements in List are not equal to null pointers
			List = currentUser.getDB().getVideoGameTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			for(int i=0;(i<count);i++){
				VideoGame temp = (VideoGame)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition+count;
			
			count = -1;
			while(count+1<data.length && data[count+1][3]!=null) count++;
			count++;
			Object[][] dataShortened = new Object[count][columnNames.length + 1];
			for(int i=0;(i<count);i++){
				dataShortened[i][0]=data[i][0];
				dataShortened[i][1]=data[i][1];
				dataShortened[i][2]=data[i][2];
				dataShortened[i][3]=data[i][3];
			}
			table = new JTable(dataShortened, columnNames);

		}
		else if(mediaType==1){ //Books
			int count=-1; //counts how many elements in List are not equal to null pointers
			String[] columnNames = {"Title","Author","Genre", "Rating"};
			List = currentUser.getDB().getBooksTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			data = new Object[count][columnNames.length + 1];
			for(int i=0;(i<count);i++){
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
		else if(mediaType==2){ //DVD
			int count=-1; //counts how many elements in List are not equal to null pointers
			String[] columnNames = {"Title","Director","Year","Content", "Rating"};
			//List = new Comparable[currentUser.getDB().getDVDTree().getSize()];
			List = currentUser.getDB().getDVDTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			data = new Object[count][columnNames.length + 1];
			System.out.println(List.length+" "+count);
			for(int i=0;(i<count);i++){
				DVD temp = (DVD)List[i];
				data[i][0] = temp.getTitle();
				data[i][1] = temp.getdirector();
				data[i][2] = temp.getyear();
				data[i][3] = temp.getContentRated();
				Integer tempint = new Integer(temp.getRating());
				data[i][4] = "" + tempint;
				data[i][5] = temp; //last column contains reference to object
			}
			table = new JTable(data, columnNames);
		}
		else if(mediaType==3){ //Recipe
			int count=-1; //counts how many elements in List are not equal to null pointers
			String[] columnNames = {"Title","Rating"};
			List = currentUser.getDB().getRecipeTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			data = new Object[count][columnNames.length + 1];
			for(int i=0;(i<count);i++){
				Recipe temp = (Recipe)List[i];
				data[i][0] = temp.getTitle();
				Integer tempint = new Integer(temp.getRating());
				data[i][1] = "" + tempint;
				data[i][2] = temp; //last column contains reference to object
			}
			table = new JTable(data, columnNames);
		}
		else if(mediaType==4){ //VHS
			int count=-1; //counts how many elements in List are not equal to null pointers
			String[] columnNames = {"Title","Director","Year","Content", "Rating"};
			List = currentUser.getDB().getVHSTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			data = new Object[count][columnNames.length + 1];
			for(int i=0;(i<count);i++){
				VHS temp = (VHS)List[i];
				data[i][0] = temp.getTitle();
				data[i][1] = temp.getdirector();
				data[i][2] = temp.getyear();
				data[i][3] = temp.getContentRated();
				Integer tempint = new Integer(temp.getRating());
				data[i][4] = "" + tempint;
				data[i][5] = temp; //last column contains reference to object
			}
			table = new JTable(data, columnNames);
		}
		else if(mediaType==5){ //VHS_R
			int count=-1; //counts how many elements in List are not equal to null pointers
			String[] columnNames = {"Title","Director","Year","Content", "Rating"};
			List = currentUser.getDB().getVHS_RTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			data = new Object[count][columnNames.length + 1];
			for(int i=0;(i<count);i++){
				VHS_R temp = (VHS_R)List[i];
				data[i][0] = temp.getTitle();
				data[i][1] = temp.getdirector();
				data[i][2] = temp.getyear();
				data[i][3] = temp.getContentRated();
				Integer tempint = new Integer(temp.getRating());
				data[i][4] = "" + tempint;
				data[i][5] = temp; //last column contains reference to object
			}
			table = new JTable(data, columnNames);
		}
		else if(mediaType==6){ //VideoGame
			int count=-1; //counts how many elements in List are not equal to null pointers
			String[] columnNames = {"Title","Platform","Max Players", "Rating"};
			List = currentUser.getDB().getVideoGameTree().searchTreeElements(textFeild);
			while(count+1<List.length && List[count+1]!=null) count++; //while next element is not null or end of list, increment count
			count++; //zero based indexing correction
			data = new Object[count][columnNames.length + 1];
			for(int i=0;(i<count);i++){
				VideoGame temp = (VideoGame)List[i];
				data[i][0] = temp.getTitle();
				data[i][1] = temp.getPlatform();
				data[i][2] = temp.getMaxPlayers();
				Integer tempint = new Integer(temp.getRating());
				data[i][3] = "" + tempint;
				data[i][4] = temp; //last column contains reference to object
			}
			table = new JTable(data, columnNames);
		}
	}
	
	//PRE: A String with data "All", "Books", "Movies", "Video Games", or "Recipies"
	//POST: JTable object is altered to include selected information from currentUser's database
	public static void getTable(String type){
		int BooksTreeLength = currentUser.getDB().getBooksTree().getSize();
		int DVDTreeLength = currentUser.getDB().getDVDTree().getSize();
		int VHSTreeLength = currentUser.getDB().getVHSTree().getSize();
		int VHS_RTreeLength = currentUser.getDB().getVHS_RTree().getSize();
		int VideoGameTreeLength = currentUser.getDB().getVideoGameTree().getSize();
		int RecipeTreeLength = currentUser.getDB().getRecipeTree().getSize();
		
		if(type.equals("All")){ //create table of all objects
			String[] columnNames = {"Title", "Type", "Rating"};
			int partition = 0; //keeps track of how many rows of the Jtable are already occupied with data
			
			//Add book ojects to Table
			List = currentUser.getDB().getBooksTree().getTreeElements();
			data = new Object[BooksTreeLength + DVDTreeLength + VHSTreeLength + VHS_RTreeLength + VideoGameTreeLength + RecipeTreeLength][columnNames.length + 1];
			for(int i=0;i<List.length;i++){
				Books temp = (Books)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			//Add DVD objects to table
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
			
			//Add VHS objects to table
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
			
			//Add VHS_R objects to table
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
			
			//Add Video Game objects to table
			List = currentUser.getDB().getVideoGameTree().getTreeElements();
			for(int i=0;i<List.length;i++){
				VideoGame temp = (VideoGame)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			//Add Recipe objects to table
			List = currentUser.getDB().getRecipeTree().getTreeElements();
			for(int i=0;i<List.length;i++){
				Recipe temp = (Recipe)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getType();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][2] = "" + tempint;
				data[partition+i][3] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			table = new JTable(data, columnNames);
		}
		
		else if(type.equals("Books")){ //create table of books
			String[] columnNames = {"Title","Author","Genre", "Rating"};
			//Add book objects to table
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
		
		else if(type.equals("Movies")){ //create table of DVDs, VHSs, and VHS_Rs
			String[] columnNames = {"Title","Director","Year","Content", "Rating"};
			int partition = 0; //keeps track of how many rows of the Jtable are already occupied with data
			
			//Add DVD objects to table
			List = currentUser.getDB().getDVDTree().getTreeElements();
			data = new Object[DVDTreeLength + VHSTreeLength+ VHS_RTreeLength][columnNames.length + 1];
			for(int i=0;i<List.length;i++){
				DVD temp = (DVD)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getdirector();
				data[partition+i][2] = temp.getyear();
				data[partition+i][3] = temp.getContentRated();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][4] = "" + tempint;
				data[partition+i][5] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			//Add VHS objects to table
			List = currentUser.getDB().getVHSTree().getTreeElements();
			for(int i=0;i<List.length;i++){
				VHS temp = (VHS)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getdirector();
				data[partition+i][2] = temp.getyear();
				data[partition+i][3] = temp.getContentRated();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][4] = "" + tempint;
				data[partition+i][5] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			//Add VHS_R objects to table
			List = currentUser.getDB().getVHS_RTree().getTreeElements();
			for(int i=0;i<List.length;i++){
				VHS_R temp = (VHS_R)List[i];
				data[partition+i][0] = temp.getTitle();
				data[partition+i][1] = temp.getdirector();
				data[partition+i][2] = temp.getyear();
				data[partition+i][3] = temp.getContentRated();
				Integer tempint = new Integer(temp.getRating());
				data[partition+i][4] = "" + tempint;
				data[partition+i][5] = temp; //last column contains reference to object
			}
			partition = partition + List.length;
			
			table = new JTable(data, columnNames);
		}
		
		else if(type.equals("Video Games")){ //create a table of VideoGame objects
			String[] columnNames = {"Title","Platform","Max Players", "Rating"};
			
			//Add VideoGame objects to table
			List = currentUser.getDB().getVideoGameTree().getTreeElements();
			data = new Object[VideoGameTreeLength][columnNames.length + 1];
			for(int i=0;i<List.length;i++){
				VideoGame temp = (VideoGame)List[i];
				data[i][0] = temp.getTitle();
				data[i][1] = temp.getPlatform();
				data[i][2] = temp.getMaxPlayers();
				Integer tempint = new Integer(temp.getRating());
				data[i][3] = "" + tempint;
				data[i][4] = temp; //last column contains reference to object
			}
			table = new JTable(data, columnNames);
		}
		
		else if(type.equals("Recipies")){ //create table of Recipe objects
			String[] columnNames = {"Title","Rating"};
			
			//Add Recipe objects to table
			List = currentUser.getDB().getRecipeTree().getTreeElements();
			data = new Object[RecipeTreeLength][columnNames.length + 1];
			for(int i=0;i<List.length;i++){
				Recipe temp = (Recipe)List[i];
				data[i][0] = temp.getTitle();
				Integer tempint = new Integer(temp.getRating());
				data[i][1] = "" + tempint;
				data[i][2] = temp; //last column contains reference to object
			}
			table = new JTable(data, columnNames);
		}
		
	}
	
	//POST: Creates Main Window with a Table that displays current data in currentUser's media database
	public static void refreshJTable(){
	/*	if (frame != null)
			frame.dispose();
		
        Main app = new Main();
        contents = app.mainWindowComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
        frame.setSize(640,460); // make frame 640x460
        frame.pack();
		frame.setLocationRelativeTo(null); //centers window
		frame.setVisible(true);*/
		
		frame.getContentPane().setVisible(false);
		frame.getContentPane().removeAll();
        Main app = new Main();
        contents = app.mainWindowComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);
		frame.getContentPane().setVisible(true);

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
		String[] entryTypes = { "Add New Entry...", "Book", "DVD", "Recipe", "VHS", "VHS_R", "Video Game"};//, "Game", "Recipe", "Music", "Movie" };
		entrytypeList = new JComboBox(entryTypes);
		entrytypeList.setSelectedIndex(0);
		entrytypeList.setMaximumSize(new Dimension(160, 40));
		entrytypeList.setActionCommand("EntryType");
		entrytypeList.addActionListener(this);

		//Search combo box
		String[] searchTypes = { "All", "Book", "DVD", "Recipe", "VHS", "VHS_R", "Video Game"};//, "Music" };
		searchtypeList = new JComboBox(searchTypes);
		searchtypeList.setSelectedIndex(0);
		searchtypeList.setMaximumSize(new Dimension(100, 40));
		searchtypeList.setActionCommand("SearchType");
		searchtypeList.addActionListener(this);
		
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
		//tablepanel.setAlignmentX(Component.LEFT_ALIGNMENT);	
		
		//Table
		if(!showSearchResultsFlag) //if we do not want to display search results
			getTable(tableType);
		else
			showSearchResultsFlag = false;
		
		//Scroll Pane
		scrollPane = new JScrollPane(table);
		
		//Bottom Panel
		JPanel bottompanel = new JPanel();
		bottompanel.setLayout(new BoxLayout(bottompanel, BoxLayout.LINE_AXIS));	
		//topleftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);		
		
		//Search Panel
		JPanel searchpanel = new JPanel();
		searchpanel.setLayout(new BoxLayout(searchpanel, BoxLayout.LINE_AXIS));	
		//searchpanel.setAlignmentX(Component.LEFT_ALIGNMENT);	
		
		//Search field
		searchfield = new JTextField(40);
		searchfield.setMinimumSize(new Dimension(120, 20));
		searchfield.setMaximumSize(new Dimension(120, 20));	
		
		//Search button 
		btnSearch = new JButton("Search");
		btnSearch.setMaximumSize(new Dimension(80, 23));
		btnSearch.setActionCommand("Search");
		btnSearch.addActionListener(this);		
		
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
		viewpanel.add(btnGames);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
		viewpanel.add(btnRecipes);
		viewpanel.add(Box.createRigidArea(new Dimension(0,5)));
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
		
		searchpanel.add(searchtypeList);
		searchpanel.add(Box.createRigidArea(new Dimension(5,0)));
		searchpanel.add(searchfield);
		searchpanel.add(Box.createRigidArea(new Dimension(5,0)));
		searchpanel.add(btnSearch);
		searchpanel.add(Box.createHorizontalGlue());
		
		bottompanel.add(Box.createHorizontalGlue());
		bottompanel.add(btnLogOut);
		bottompanel.add(Box.createRigidArea(new Dimension(5,0)));
		bottompanel.add(btnExit);		
		
		rightpanel.add(tablepanel);
		rightpanel.add(Box.createRigidArea(new Dimension(0,10)));	
		rightpanel.add(searchpanel);
		rightpanel.add(Box.createRigidArea(new Dimension(0,10)));
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
			
		return mainpanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")){
			LoginGUI.CreateGUI();
			frame.dispose();
			System.exit(0);
		}
		else if (e.getActionCommand().equals("Log Out")){
			LoginGUI.CreateGUI();
			frame.dispose();
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
			tableType = "Video Games";
			refreshJTable();
		}
		else if (e.getActionCommand().equals("Recipes")){
			System.out.println("Show Recipes");
			tableType = "Recipies";
			refreshJTable();
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
	        	AddEditBookGUI.CreateGUI(currentUser, (Books) null, 0);
				}
	        else if (temp.getSelectedIndex() == 2){
	        	System.out.println("Add DVD");
	        	AddEditDVDGUI.CreateGUI(currentUser, (DVD) null, 0);
			}
	        else if (temp.getSelectedIndex() == 3){
	        	System.out.println("Add Recipe");
	        	AddEditRecipeGUI.CreateGUI(currentUser, (Recipe) null, 0);
			}
	        else if (temp.getSelectedIndex() == 4){
	        	System.out.println("Add VHS");
	        	AddEditVHSGUI.CreateGUI(currentUser, (VHS) null, 0);
	        }
	        else if (temp.getSelectedIndex() == 5){
	        	System.out.println("Add VHS_R");
	        	AddEditVHS_RGUI.CreateGUI(currentUser, (VHS_R) null, 0);
	        }
	        else if (temp.getSelectedIndex() == 6){
	        	System.out.println("Add Video Game");
	        	AddEditVideoGameGUI.CreateGUI(currentUser, (VideoGame) null, 0);
	        }
/*	        
	        else if (temp.getSelectedIndex() == 7){
	        	System.out.println("Add Music");}
*/
		}
		//Search for an item
		else if (e.getActionCommand().equals("Search")){
			String textFeild = searchfield.getText(); //get text in search feild
			if(textFeild != ""){
				search(searchtypeList.getSelectedIndex(), textFeild);
				showSearchResultsFlag = true; //want the table to display our results found in search()
				refreshJTable();
			}
		}
		//deleting a medium from table
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
			else if (classType.equals("class teddySoft.VideoGame")){
				currentUser.getDB().getVideoGameTree().RBTreeRemove(((VideoGame) data[table.getSelectedRow()][table.getColumnCount()]));
				System.out.println("Delete VideoGame");
				Main.refreshJTable();
			}
			else if (classType.equals("class teddySoft.Recipe")){
				currentUser.getDB().getRecipeTree().RBTreeRemove(((Recipe) data[table.getSelectedRow()][table.getColumnCount()]));
				System.out.println("Delete Recipe");
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
			else if (classType.equals("class teddySoft.VideoGame")){
				AddEditVideoGameGUI.CreateGUI(currentUser,(VideoGame) data[table.getSelectedRow()][table.getColumnCount()], 1);
			}
			else if (classType.equals("class teddySoft.Recipe")){
				AddEditRecipeGUI.CreateGUI(currentUser,(Recipe) data[table.getSelectedRow()][table.getColumnCount()], 1);
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
				else if (classType.equals("class teddySoft.VideoGame")){
					ViewVideoGameGUI.CreateGUI((VideoGame) data[table.getSelectedRow()][table.getColumnCount()]);
				}
				else if (classType.equals("class teddySoft.Recipe")){
					ViewRecipeGUI.CreateGUI((Recipe) data[table.getSelectedRow()][table.getColumnCount()]);
				}
				
			}
		}
	}	
	
	public static void CreateGUI(User user){
		setWindowsLook(); //Set windows decorations
		currentUser = user;
		
		Main.readData(); //read users serialized data
		
		//Create and set up the window.
		frame = new JFrame("Media Library");
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {//add Window closing handler
            public void windowClosing(WindowEvent e) {
            	frame.dispose();
            	}
        });
		
        Main app = new Main();
        contents = app.mainWindowComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
        frame.setSize(640,460); // make frame 640x460
        frame.pack();
		frame.setLocationRelativeTo(null); //centers window
		frame.setVisible(true);

	}	
	
}
