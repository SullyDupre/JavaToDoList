package cse360ToDoList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;


public class MainFrame extends JFrame{
	
	/**
	 * The panel that will store all the elements in the array list
	 */
	private TextPanel textPanel;
	
	/**
	 * This is the list that will store the elements
	 */
	private JList jlist;
	
	/**
	 * Define the vector that will store the list items.
	 */
	private Vector listItems;


	//private JButton btn;
	/**
	 * The toolbar that will hold the different functionalities like sort and store and save
	 */
	private Toolbar toolbar;
	
	/**
	 * This will form the panel
	 */
	private FormPanel formPanel;
	
	/**
	 * This is the list of the items that will need to be stored
	 */
	public TDList list;
	
	/**
	 * THis is the default constructor for the list of items that will be needed
	 * Also sets up the layout of the panels.
	 */
	public MainFrame(TDList list)
	{
		super("CSE360 To Do List");

		
		listItems = new Vector();
		for (int index = 0; index < listItems.size(); index++)
		{
			String ele = "<html>Description: " + "<br/>"
					+ "Due Date: " + "<br/>" 
					+ "Priority: " + "<br/>" 
					+ "Status: " + "<br/>" 
					+ "Date Started: " + "<br/>" 
					+ "Date Finished: " + "<br/>" 
					+ "--------------------------------------------------------</html>"; 
			 listItems.set(index, ele);
		}
		//set up layout
		jlist = new JList(listItems);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar(list, jlist, listItems);
		textPanel = new TextPanel(list, jlist, listItems);
		formPanel = new FormPanel(list, jlist, listItems);
		
		add(formPanel, BorderLayout.NORTH);
		add(toolbar, BorderLayout.SOUTH);
		add(textPanel, BorderLayout.CENTER);
		//add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
