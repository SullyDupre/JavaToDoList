/**
  *  Description: This class creates an layout for the bottom tool bar 
  *  			and invoke the events and call methods 
  *  			when a button on the tool bar is clicked
 */ 
package cse360ToDoList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.util.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;


public class Toolbar extends JPanel implements ActionListener{
	private JButton addButton;
	private JButton saveButton;
	private JButton restoreButton;
	private JButton printButton;
	//my edit
	private TDListener TDListener;
	
	/** 
	 * This constructor: create the general layout for the bottom tool bar 
	 */
	public Toolbar()
	{
		//create buttons
		addButton = new JButton ("ADD");
		saveButton = new JButton ("SAVE");
		restoreButton = new JButton ("RESTORE");
		printButton = new JButton ("PRINT");
		
		//add listener
		addButton.addActionListener(this);
		
		//add to layout
		setLayout(new FlowLayout());
		add(addButton);
		add(saveButton);
		add(restoreButton);
		add(printButton);

		
		
	}

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
			
			//text fields
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
			
			//add to list here-----------------------------------------------------
			if (result == JOptionPane.OK_OPTION) {
				//System.out.println(descriptionField.getText());
				//edit 1 begins
				
				/*
				SimpleDateFormat dueDateForm = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat dateStartedForm = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat dateFinishedForm = new SimpleDateFormat("dd/MM/yyyy");
				
				
				try {
					Date dueDate = dueDateForm.parse(dueDateField.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				
				
				try {
					Date dateStarted = dateStartedForm.parse(dateStartedField.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					Date dateFinished =  dateFinishedForm.parse(dateFinishedField.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				String description = descriptionField.getText();
				int priority = Integer.parseInt(priorityField.getText());
				int status = Integer.parseInt(statusField.getText());
				
				
				TDElement ev = new TDElement(this, description, priority, dueDateField,
						status, dateStartedForm, dateFinishedForm);
				Edit 1 ends
				*/
				
				//edit 2 begins
				String description = descriptionField.getText();
				int priority = Integer.parseInt(priorityField.getText());
				int status = Integer.parseInt(statusField.getText());
				String dueDate = dueDateField.getText();
				String dateStarted = dateStartedField.getText();
				String dateFinished = dateFinishedField.getText();
				
				TDElement ev = new TDElement(this, description, priority, dueDate,
						status, dateStarted, dateFinished);
				
				if (TDListener != null)
				{
					TDListener.tdEventOccured(ev);
				}
				
				//edit 2 ends
			}
			
		}
		
		//save button click
		if (clicked == addButton) {
			
		}
		
		//restore button click
		if (clicked == restoreButton) {
		}
		
		//print 
		if (clicked == printButton) {
			
		}
		
	}
	
	public void setTDListener(TDListener listener) {
		this.TDListener = listener;
	} 
}
//