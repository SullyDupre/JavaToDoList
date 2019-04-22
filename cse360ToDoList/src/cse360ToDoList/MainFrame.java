package cse360ToDoList;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame{
	
	private TextPanel textPanel;
	//private JButton btn;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private int count;
	public MainFrame()
	{
		super("CSE360Testing Main Frame");
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		count = 0;
		
		add(formPanel, BorderLayout.NORTH);
		add(toolbar, BorderLayout.SOUTH);
		add(textPanel, BorderLayout.CENTER);
		
		//add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		toolbar.setTDListener(new TDListener() {

			public void tdEventOccured(TDElement e) {
				// TODO Auto-generated method stub
				String description = e.getDescription();
				int priority = e.getPriority();
				String dueDate = e.getDueDate();
				String status = e.getStatus();
				String startDate = e.getDateStarted();
				String dateFinished = e.getDateFinished();
				count++;
				
				textPanel.addItem(description, 0);
				
			}
			
		});
		
		
	}

}