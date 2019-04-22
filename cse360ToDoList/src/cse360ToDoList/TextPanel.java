/**
 * Description: This class display all the information for the to do list 
 * 			and set up the layout of how the field look.
 */
package cse360ToDoList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class TextPanel extends JPanel implements ActionListener {
	
	private JScrollPane scrollPane;
	private JList list;
	private JButton editButton;
	private JButton deleteButton;
	
	/**
	 * constructor: create an area that display all of the to do 
	 * 				list activities and related informations
	 */
	public TextPanel() {
		//create an array of string that contains all the info
		String[] listItems = new String[5];
		for (int index = 0; index < 5; index++)
		{
			listItems[index] = "<html>Description: " + "<br/>"
					+ "Due Date: " + "<br/>" 
					+ "Priority: " + "<br/>" 
					+ "Status: " + "<br/>" 
					+ "Date Started: " + "<br/>" 
					+ "Date Finished: " + "<br/>" 
					+ "--------------------------------------------------------</html>"; 
		}
		//set up layout
		list = new JList(listItems);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListListener());
		JScrollPane scrollPane = new JScrollPane(list);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		
		editButton = new JButton("EDIT      ");
		deleteButton = new JButton("DELETE");
		editButton.addActionListener(this);
		deleteButton.addActionListener(this);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(editButton);
		panel.add(deleteButton);
		add(panel, BorderLayout.EAST);
	}
	
	/** 
	 * This method call the appropriate methods when a button is clicked
	 * @param take in an clicked event
	 */
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		//when edit button is click
		if (clicked == editButton)
		{
		}
		//when delete button is click
		if (clicked == deleteButton)
		{
		}
		
	}
	

	/**
	 * This method is used the index of JList to use in edit and delete method
	 */
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent event)
		{
			//nothing selected
			if (list.isSelectionEmpty())
			{}
			else //selected (for edit and delete)
			{}
			
		}
	}
}


