 /**
  *  Description: This class creates an layout for the bottom tool bar 
  *  			and invoke the events and call methods 
  *  			when a button on the tool bar is clicked
 */ 
package cse360ToDoList;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;


public class Toolbar extends JPanel implements ActionListener{
	private JButton saveButton;
	private JButton restoreButton;
	private JButton printButton;
	private TDList list;
	private Vector listItems;
	private JList jlist;
	
	/** 
	 * This constructor: create the general layout for the bottom tool bar 
	 */
	public Toolbar(TDList argumentList, JList argumentList2, Vector argumentVector)
	{
		list = argumentList;
		jlist = argumentList2;
		listItems = argumentVector;
		
		//create buttons
		saveButton = new JButton ("SAVE");
		restoreButton = new JButton ("RESTORE");
		printButton = new JButton ("PRINT");
		
		//add listener
		saveButton.addActionListener(this);
		restoreButton.addActionListener(this);
		printButton.addActionListener(this);
		
		//add to layout
		setLayout(new FlowLayout());
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
		//save button click
		if (clicked == saveButton) {
			list.saveFile();
			JOptionPane pane = new JOptionPane();
			pane.showMessageDialog(null, "File had saved");
		}
		
		//restore button click
		if (clicked == restoreButton) {
		}
		
		//print 
		if (clicked == printButton) {
			
		}
		
	}
}
//
