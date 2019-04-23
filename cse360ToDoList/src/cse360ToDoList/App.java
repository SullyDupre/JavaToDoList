package cse360ToDoList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(new Runnable() {
		
			public void run()
			{
				TDList globalList = new TDList();
				new MainFrame(globalList);
				
				
			}
		});
		
		

	}

}//