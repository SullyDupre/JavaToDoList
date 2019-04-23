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
	
	private TDList list;
	private JScrollPane scrollPane;
	private JList jlist;
	private JButton editButton;
	private JButton deleteButton;
	private JButton addButton;
	private Vector listItems;
	
	private JComboBox jmonthduedate;
	private JComboBox jmonthstartdate;
	private JComboBox jmonthfinishdate;
	
	JOptionPane pane;
	
	private JComboBox jstat;
	/**
	 * constructor: create an area that display all of the to do 
	 * 				list activities and related informations
	 */
	public TextPanel(TDList argumentList, JList argumentList2, Vector argumentVector) {
		list = argumentList;
		jlist = argumentList2;
		listItems = argumentVector;

		//set up layout

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
				JLabel addTitle = new JLabel("ADD");
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
				DefaultComboBoxModel jmonthdue = new DefaultComboBoxModel();
				jmonthdue.addElement("January");
				jmonthdue.addElement("February");
				jmonthdue.addElement("March");
				jmonthdue.addElement("April");
				jmonthdue.addElement("May");
				jmonthdue.addElement("June");
				jmonthdue.addElement("July");
				jmonthdue.addElement("August");
				jmonthdue.addElement("September");
				jmonthdue.addElement("October");
				jmonthdue.addElement("November");
				jmonthdue.addElement("December");
				jmonthduedate.setModel(jmonthdue);
				
				
				DefaultComboBoxModel jmonthstart = new DefaultComboBoxModel();
				jmonthstart.addElement("January");
				jmonthstart.addElement("February");
				jmonthstart.addElement("March");
				jmonthstart.addElement("April");
				jmonthstart.addElement("May");
				jmonthstart.addElement("June");
				jmonthstart.addElement("July");
				jmonthstart.addElement("August");
				jmonthstart.addElement("September");
				jmonthstart.addElement("October");
				jmonthstart.addElement("November");
				jmonthstart.addElement("December");
				
				DefaultComboBoxModel jmonthend = new DefaultComboBoxModel();
				jmonthend.addElement("January");
				jmonthend.addElement("February");
				jmonthend.addElement("March");
				jmonthend.addElement("April");
				jmonthend.addElement("May");
				jmonthend.addElement("June");
				jmonthend.addElement("July");
				jmonthend.addElement("August");
				jmonthend.addElement("September");
				jmonthend.addElement("October");
				jmonthend.addElement("November");
				jmonthend.addElement("December");
				
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
				jmonthstartdate.setModel(jmonthstart);
				
				//declare finish date combo box
				jmonthfinishdate = new JComboBox();	
				JTextField dateFinishedDay = new JTextField(7);
				jmonthfinishdate.setModel(jmonthend);
				
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
					int check = list.insert(element);
					
					if (check == 1)
					{
						pane = new JOptionPane();
						pane.showMessageDialog(null, "Error, Duplicate Description");
					}
					else if (check == 2)
					{
						pane = new JOptionPane();
						pane.showMessageDialog(null, "Error, Duplicate Priority");
					}
					
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
				if(!jlist.isSelectionEmpty()) {
					TDElement elem = list.getElement(jlist.getSelectedIndex());
					//labels
					JLabel addTitle = new JLabel("EDIT");
					addTitle.setFont(new Font("Time New Roman", Font.BOLD, 20));
					JLabel descriptionLabel = new JLabel("Description");
					JLabel dueDateLabel = new JLabel("Due Date");
					JLabel priorityLabel = new JLabel("Priority(number)");
					JLabel statusLabel = new JLabel("Status");
					JLabel dateStartedLabel = new JLabel("Date Started");
					JLabel dateFinishedLabel = new JLabel("Date Finished");
					
					//text fields with 20 characters in each each
					JTextField descriptionField = new JTextField(20);
					descriptionField.setText(elem.getDescription());
					JTextField priorityField = new JTextField(20);
					priorityField.setText(Integer.toString(elem.getPriority()));
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
					DefaultComboBoxModel jmonthdue = new DefaultComboBoxModel();
					jmonthdue.addElement("January");
					jmonthdue.addElement("February");
					jmonthdue.addElement("March");
					jmonthdue.addElement("April");
					jmonthdue.addElement("May");
					jmonthdue.addElement("June");
					jmonthdue.addElement("July");
					jmonthdue.addElement("August");
					jmonthdue.addElement("September");
					jmonthdue.addElement("October");
					jmonthdue.addElement("November");
					jmonthdue.addElement("December");
					jmonthduedate.setModel(jmonthdue);
					
					
					DefaultComboBoxModel jmonthstart = new DefaultComboBoxModel();
					jmonthstart.addElement("January");
					jmonthstart.addElement("February");
					jmonthstart.addElement("March");
					jmonthstart.addElement("April");
					jmonthstart.addElement("May");
					jmonthstart.addElement("June");
					jmonthstart.addElement("July");
					jmonthstart.addElement("August");
					jmonthstart.addElement("September");
					jmonthstart.addElement("October");
					jmonthstart.addElement("November");
					jmonthstart.addElement("December");
					
					DefaultComboBoxModel jmonthend = new DefaultComboBoxModel();
					jmonthend.addElement("January");
					jmonthend.addElement("February");
					jmonthend.addElement("March");
					jmonthend.addElement("April");
					jmonthend.addElement("May");
					jmonthend.addElement("June");
					jmonthend.addElement("July");
					jmonthend.addElement("August");
					jmonthend.addElement("September");
					jmonthend.addElement("October");
					jmonthend.addElement("November");
					jmonthend.addElement("December");
					
					//drop down menu for status bar
					jstat = new JComboBox();
					DefaultComboBoxModel jstatusOpt = new DefaultComboBoxModel();
					jstatusOpt.addElement("Not Started");
					jstatusOpt.addElement("In Progress");
					jstatusOpt.addElement("Finished");
					jstatusOpt.setSelectedItem(elem.getStatus());
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
					jmonthstartdate.setModel(jmonthstart);
					
					//declare finish date combo box
					jmonthfinishdate = new JComboBox();	
					JTextField dateFinishedDay = new JTextField(7);
					jmonthfinishdate.setModel(jmonthend);
					
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
						list.update(element, jlist.getSelectedIndex());
						
						listItems.clear();
	
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
				
			}
			
			
			//when delete button is click
			if (clicked == deleteButton)
			{
				if(!jlist.isSelectionEmpty()) {
					list.remove(jlist.getSelectedIndex());
					listItems.clear();
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
					jlist.setSelectedValue(null, false);
				}
			}
		}
	}
	
	

}


