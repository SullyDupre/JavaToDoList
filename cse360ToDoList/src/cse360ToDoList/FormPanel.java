package cse360ToDoList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormPanel extends JPanel implements ActionListener {
	
	private JButton sort;
	private JLabel label;
	private StringListener textListener;
	
	public FormPanel()
	{
		//set the sort by scroll down
		setBorder(BorderFactory.createEtchedBorder());
		sort = new JButton ("Sort By:");
		sort.addActionListener(this);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(sort);
		
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
