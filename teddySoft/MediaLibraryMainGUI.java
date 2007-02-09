import javax.swing.*;
import java.awt.*;


public class MediaLibraryMainGUI {
	
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
	
	public Component createComponents() {

		
		//Top Left Panel
		JPanel topleftpanel = new JPanel();
		topleftpanel.setLayout(new BoxLayout(topleftpanel, BoxLayout.PAGE_AXIS));		
		topleftpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//View Entry button 
		JButton btnView = new JButton("  View Entry ");
		btnView.setMnemonic('v'); 
		//Edit Entry button
		JButton btnEdit = new JButton("  Edit Entry  ");
		btnEdit.setMnemonic('e');
		//Delete Entry button
		JButton btnDelete = new JButton("Delete Entry");
		btnDelete.setMnemonic('d'); 	
		
		//ComboBox Panel
		JPanel combopanel = new JPanel();
		combopanel.setLayout(new BoxLayout(combopanel, BoxLayout.PAGE_AXIS));	
		combopanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Add Entries combo box
		String[] entryTypes = { "Add New Entry...", "Book", "Game", "Recipe", "Music", "Movie" };
		JComboBox entrytypeList = new JComboBox(entryTypes);
		entrytypeList.setSelectedIndex(0);
		entrytypeList.setMaximumSize(new Dimension(150, 20));

		//View Panel
		JPanel viewpanel = new JPanel();
		viewpanel.setLayout(new BoxLayout(viewpanel, BoxLayout.PAGE_AXIS));	
		viewpanel.setBorder(BorderFactory.createTitledBorder(
        "View"));
		viewpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Show All button 
		JButton btnAll = new JButton("Show All");
		//Only Books button 
		JButton btnBooks = new JButton("Only Books");
		//Only Games button 
		JButton btnGames = new JButton("Only Games");
		//Only Recipes button 
		JButton btnRecipes = new JButton("Only Recipes");	
		//Only Music button 
		JButton btnMusic = new JButton("Only Music");
		//Only Movies button 
		JButton btnMovies = new JButton("Only Movies");	
		
		//Left Panel
		JPanel leftpanel = new JPanel();
		leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.PAGE_AXIS));	
		leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);		
			

		//Table Panel
		JPanel tablepanel = new JPanel();
		tablepanel.setLayout(new BoxLayout(tablepanel, BoxLayout.PAGE_AXIS));	
		topleftpanel.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		//Table
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

		Object[][] data = {
		{"Mary", "Campione",
		"Snowboarding", new Integer(5), new Boolean(false)},
		{"Alison", "Huml",
		"Rowing", new Integer(3), new Boolean(true)},
		{"Kathy", "Walrath",
		"Knitting", new Integer(2), new Boolean(false)},
		{"Sharon", "Zakhour",
		"Speed reading", new Integer(20), new Boolean(true)},
		{"Philip", "Milne",
		"Pool", new Integer(10), new Boolean(false)}
		};
				
		JTable temptable = new JTable(data, columnNames);
		JScrollPane temptablescroll = new JScrollPane(temptable);
		temptable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		
		//Bottom Panel
		JPanel bottompanel = new JPanel();
		bottompanel.setLayout(new BoxLayout(bottompanel, BoxLayout.LINE_AXIS));	
		//topleftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);		
		
		//Exit button 
		JButton btnExit = new JButton("Exit");	
		
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
	
		
		leftpanel.add(topleftpanel, BorderLayout.PAGE_START);
		leftpanel.add(Box.createRigidArea(new Dimension(0,5)));			
		leftpanel.add(combopanel, BorderLayout.CENTER);
		leftpanel.add(Box.createRigidArea(new Dimension(0,5)));			
		leftpanel.add(viewpanel, BorderLayout.PAGE_END);
		leftpanel.add(Box.createVerticalGlue());
		
		
		tablepanel.add(temptable.getTableHeader(), BorderLayout.PAGE_START);
		tablepanel.add(temptable, BorderLayout.CENTER);
		tablepanel.add(temptablescroll);
		bottompanel.add(Box.createHorizontalGlue());
		bottompanel.add(btnExit, BorderLayout.PAGE_END);		
		
		rightpanel.add(tablepanel, BorderLayout.PAGE_START);
		rightpanel.add(Box.createRigidArea(new Dimension(0,30)));		
		rightpanel.add(bottompanel, BorderLayout.PAGE_END);
		
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
	
	private static void CreateGUI(){
		setWindowsLook();
		
		//Create and set up the window.
		JFrame frame = new JFrame("Media Library");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        MediaLibraryMainGUI app = new MediaLibraryMainGUI();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		//Display the window.
		frame.pack();
		frame.setVisible(true);
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
