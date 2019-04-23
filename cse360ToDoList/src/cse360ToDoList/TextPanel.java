/**
 * Description: This class display all the information for the to do list 
 * 			and set up the layout of how the field look.
 */
package cse360ToDoList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
public class TextPanel extends JPanel {
	
	TDList list = new TDList();
	private JScrollPane scrollPane;
	private JList jlist;
	private JButton editButton;
	private JButton deleteButton;
	private JButton addButton;
	private Vector listItems;
	
	/**
	 * constructor: create an area that display all of the to do 
	 * 				list activities and related informations
	 */
	public TextPanel() {
		//create an array of string that contains all the info

		//set up layout
		jlist = new JList(listItems);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPane = new JScrollPane(jlist);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		
		editButton = new JButton("EDIT");
		deleteButton = new JButton("DELETE");
		addButton = new JButton ("SAVE");
		editButton.addActionListener(new ListListener());
		deleteButton.addActionListener(new ListListener());
		addButton.addActionListener(new ListListener());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(addButton);
		panel.add(editButton);
		panel.add(deleteButton);
		add(panel, BorderLayout.EAST);
	}
	

	

	/**
	 * This method is used the index of JList to use in edit and delete method
	 */
	private class ListListener implements ActionListener
	{
		/** 
		 * This method call the appropriate methods when a button is clicked
		 * @param take in an clicked event
		 */
		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton)e.getSource();
			
			//when add button is click
			if (clicked == addButton)
			{
				//labels
				JLabel addTitle = new JLabel("Add");
				addTitle.setFont(new Font("Time New Roman", Font.BOLD, 20));
				JLabel descriptionLabel = new JLabel("Description");
				JLabel dueDateLabel = new JLabel("Due Date");
				JLabel priorityLabel = new JLabel("Priority");
				JLabel statusLabel = new JLabel("Status");
				JLabel dateStartedLabel = new JLabel("Date Started");
				JLabel dateFinishedLabel = new JLabel("Date Finished");
				
				//text fields with 20 characters in each each
				JTextField descriptionField = new JTextField(20);
				JTextField dueDateField = new JTextField(20);
				JTextField priorityField = new JTextField(20);
				JTextField statusField = new JTextField(20);
				JTextField dateStartedField = new JTextField(20);
				JTextField dateFinishedField = new JTextField(20);
				
				//left panel
				JPanel leftPanel = new JPanel();
				leftPanel.setLayout(new GridLayout(6,1));
				leftPanel.add(descriptionLabel);
				leftPanel.add(dueDateLabel);
				leftPanel.add(priorityLabel);
				leftPanel.add(statusLabel);
				leftPanel.add(dateStartedLabel);
				leftPanel.add(dateFinishedLabel);
				
				//right panel
				JPanel rightPanel = new JPanel();
				rightPanel.setLayout(new GridLayout(6,1));
				rightPanel.add(descriptionField);
				rightPanel.add(dueDateField);
				rightPanel.add(priorityField);
				rightPanel.add(statusField);
				rightPanel.add(dateStartedField);
				rightPanel.add(dateFinishedField);
				
				//top panel
				JPanel topPanel = new JPanel();
				topPanel.setLayout(new FlowLayout());
				topPanel.add(addTitle);
				
				//overall panel
				JPanel allPanel = new JPanel();
				allPanel.setLayout(new BorderLayout());
				allPanel.add(topPanel, BorderLayout.NORTH);
				allPanel.add(leftPanel, BorderLayout.WEST);
				allPanel.add(rightPanel, BorderLayout.CENTER);
				
				//pop up
				int result = JOptionPane.showConfirmDialog(null, allPanel, 
			               "ADD", JOptionPane.OK_OPTION);
				
				//add to list here
				if (result == JOptionPane.OK_OPTION) {
					String des = descriptionField.getText();
					int priority = Integer.parseInt(priorityField.getText());
					String date = dueDateField.getText();
					String status = statusField.getText();
					TDElement element = new TDElement(des, priority, new Date(), 1);
					list.insert(element);
					
//					//temp
					for (int index = 0; index < list.getListSize(); index++)
					{
						TDElement element1 = list.getElement(index);
						String ele = "<html>Description: " + element1.getDescription() + "<br/>"
								+ "Due Date: " + element1.getDueDate() + "<br/>" 
								+ "Priority: "+ element1.getPriority() + "<br/>" 
								+ "Status: "+ element1.getStatus() + "<br/>" 
								+ "Date Started: " + "<br/>" 
								+ "Date Finished: " + "<br/>" 
								+ "--------------------------------------------------------</html>"; 
						 listItems.add(ele);
					}
					jlist.updateUI();
				}
			}
			//when edit button is click
			if (clicked == editButton)
			{
				
			}
			//when delete button is click
			if (clicked == deleteButton)
			{
			}
		}
	}
	
	

}


