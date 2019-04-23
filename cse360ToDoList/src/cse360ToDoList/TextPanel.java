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
	
	private JComboBox jmonthduedate;
	private JComboBox jmonthstartdate;
	private JComboBox jmonthfinishdate;
	
	private JComboBox jstat;
	/**
	 * constructor: create an area that display all of the to do 
	 * 				list activities and related informations
	 */
	public TextPanel() {
		//create an array of string that contains all the info
//		listItems = new String[list.getListSize()];
//		for (int index = 0; index < list.getListSize(); index++)
//		{
//			TDElement element = list.getElement(index);
//			listItems[index] = "<html>Description: " + element.getDescription() + "<br/>"
//					+ "Due Date: " + element.getDueDate() + "<br/>" 
//					+ "Priority: "+ element.getPriority() + "<br/>" 
//					+ "Status: "+ element.getStatus() + "<br/>" 
//					+ "Date Started: " + "<br/>" 
//					+ "Date Finished: " + "<br/>" 
//					+ "--------------------------------------------------------</html>"; 
//		}
		
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

		JScrollPane scrollPane = new JScrollPane(jlist);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		
		editButton = new JButton("EDIT");
		deleteButton = new JButton("DELETE");
		addButton = new JButton ("ADD");
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
				JLabel priorityLabel = new JLabel("Priority(number)");
				JLabel statusLabel = new JLabel("Status");
				JLabel dateStartedLabel = new JLabel("Date Started");
				JLabel dateFinishedLabel = new JLabel("Date Finished");
				
				//text fields with 20 characters in each each
				JTextField descriptionField = new JTextField(20);
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

				//drop down menu for the months
				jmonthduedate = new JComboBox();
				DefaultComboBoxModel jmonth = new DefaultComboBoxModel();
				jmonth.addElement("January");
				jmonth.addElement("February");
				jmonth.addElement("March");
				jmonth.addElement("April");
				jmonth.addElement("May");
				jmonth.addElement("June");
				jmonth.addElement("July");
				jmonth.addElement("August");
				jmonth.addElement("September");
				jmonth.addElement("October");
				jmonth.addElement("November");
				jmonth.addElement("December");
				jmonthduedate.setModel(jmonth);
				
				//drop down menu for status bar
				jstat = new JComboBox();
				DefaultComboBoxModel jstatusOpt = new DefaultComboBoxModel();
				jstatusOpt.addElement("Not Started");
				jstatusOpt.addElement("In Progress");
				jstatusOpt.addElement("Finished");
				jstat.setModel(jstatusOpt);
				
				JPanel dueDate = new JPanel();
				JPanel startDate = new JPanel();
				JPanel finishDate = new JPanel();
				
				dueDate.setLayout(new FlowLayout());
				startDate.setLayout(new FlowLayout());
				finishDate.setLayout(new FlowLayout());
				
				//JTextField dueDateMonth = new JTextField(7);
				JTextField dueDateDay = new JTextField(7);
				
				
				
				
				//declare start date combo box
				jmonthstartdate = new JComboBox();
				JTextField dateStartedDay = new JTextField(7);
				jmonthstartdate.setModel(jmonth);
				
				//declare finish date combo box
				jmonthfinishdate = new JComboBox();	
				JTextField dateFinishedDay = new JTextField(7);
				jmonthfinishdate.setModel(jmonth);
				
				//add due date
				rightPanel.add(dueDate);
				dueDate.add(jmonthduedate);
				dueDate.add(dueDateDay);
				
				//add status
				rightPanel.add(priorityField);
				rightPanel.add(jstat);
				
				//add start date
				rightPanel.add(startDate);
				startDate.add(jmonthstartdate);
				startDate.add(dateStartedDay);
				
				//add finish date
				rightPanel.add(finishDate);
				finishDate.add(jmonthfinishdate);
				finishDate.add(dateFinishedDay);
				
				
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
					String date = jmonthduedate.getSelectedItem() + " " + dueDateDay.getText();
					String status = (String) jstat.getSelectedItem();
					String StartDate = jmonthstartdate.getSelectedItem() + " " + dateStartedDay.getText();
					String FinishDate = jmonthfinishdate.getSelectedItem() + " " + dateFinishedDay.getText();
					
					TDElement element = new TDElement(des, priority, date, status, StartDate, FinishDate);
					list.insert(element);
					
					listItems.clear();
//					//temp
					for (int index = 0; index < list.getListSize(); index++)
					{
						TDElement element1 = list.getElement(index);
						String ele = "<html>Description: " + element1.getDescription() + "<br/>"
								+ "Due Date: " + element1.getDueDate() + "<br/>" 
								+ "Priority: "+ element1.getPriority() + "<br/>" 
								+ "Status: "+ element1.getStatus() + "<br/>" 
								+ "Date Started: " + element1.getDateStarted() +"<br/>" 
								+ "Date Finished: " + element1.getDateFinished() +  "<br/>" 
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
				list.remove(jlist.getSelectedIndex());
				if(!jlist.isSelectionEmpty())
					listItems.clear();
//				//temp
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
	}
	
	

}


