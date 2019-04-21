package cse360ToDoList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Toolbar extends JPanel implements ActionListener{
	private JButton add;
	private JButton save;
	private JButton restore;
	private JButton print;
	
	public Toolbar()
	{
		add = new JButton ("ADD");
		save = new JButton ("SAVE");
		restore = new JButton ("RESTORE");
		print = new JButton ("PRINT");
		
		setLayout(new FlowLayout());
		add(add);
		add(save);
		add(restore);
		add(print);

		
		
	}

	
	public void actionPerformed(ActionEvent e) {		
	}
}