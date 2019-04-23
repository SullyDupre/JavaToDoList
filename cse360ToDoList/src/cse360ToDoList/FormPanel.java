package cse360ToDoList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class FormPanel extends JPanel implements ActionListener {
	
	private JButton sort;
	private JLabel label;
	private StringListener textListener;
	private TDList list;
	private Vector listItems;
	private JList jlist;
	private JLabel sort1;
	private JComboBox sortCombo;
	
	public FormPanel(TDList argumentList, JList argumentList2, Vector argumentVector)
	{
		//set the sort by scroll down
		list = argumentList;
		jlist = argumentList2;
		listItems = argumentVector;
		setBorder(BorderFactory.createEtchedBorder());
		sort = new JButton ("Sort:");
		sort.addActionListener(this);
		
		sort1 = new JLabel ("Sort by:"); 
		
		sortCombo = new JComboBox ();
		DefaultComboBoxModel sortModel = new DefaultComboBoxModel();
		sortModel.addElement("Priority");
		sortModel.addElement("Description");
		sortModel.addElement("Due Date");
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
		if (sortCombo.getSelectedItem().equals("Priority"))
		{
			list.sortByPriority();
			update();
		}
		if (sortCombo.getSelectedItem().equals("Description"))
		{
			list.sortByDescription();
			update();
		}
		if (sortCombo.getSelectedItem().equals("Due Date"))
		{
			list.sortByDueDate();
			update();
		}
	}
	
	private void update()
	{
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
	}
}
