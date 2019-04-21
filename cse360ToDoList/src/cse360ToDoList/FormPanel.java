package cse360ToDoList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormPanel extends JPanel implements ActionListener {
	
	private JButton sort;
	private JLabel label;
	private StringListener textListener;
	
	//Label for drop down list
	private JLabel sort1;
	
	//Drop Down List
	private JComboBox sortCombo;
	
	public FormPanel()
	{
		//set the sort by scroll down
		setBorder(BorderFactory.createEtchedBorder());
		sort = new JButton ("Sort By:");
		sort.addActionListener(this);
		
		sort1 = new JLabel ("Sort by:"); 
		
		sortCombo = new JComboBox ();
		DefaultComboBoxModel sortModel = new DefaultComboBoxModel();
		sortModel.addElement("Description");
		sortModel.addElement("Due Date");
		sortModel.addElement("Priority");
		sortCombo.setModel(sortModel);
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(sort);
		
		//added label and drop down list
		panel1.add(sort1);
		panel1.add(sortCombo);
		
		//set the label
		label = new JLabel ("To Do List");
		label.setFont(new Font("Time New Roman", Font.BOLD, 20));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(label);
		
		setLayout(new GridLayout(2,1));
		add(panel2);
		add(panel1);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}