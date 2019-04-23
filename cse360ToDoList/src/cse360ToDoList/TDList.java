package cse360ToDoList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.StandardOpenOption.*;
import java.util.*;

public class TDList {
	/**
	 * The array list that will dynamically store the contents of the ToDoList
	 */
	public ArrayList<TDElement> toDoList;
	/**
	 * 
	 * currentSortMethod = 0 for sortByPriority, csm = 1 for sortbydescription, csm = 2 for sortbydate
	 */
	public int currentSortMethod = 0;													
	
	public TDList(){
		toDoList = new ArrayList<TDElement>();
	}
	
	
	public int insert(TDElement element){														//return 0 = successful insert, 1 = duplicate description, 2 = duplicate priority
																								//insert element into the list, checks for duplicates and resorts after finishing insertion
		int duplicateStatus = checkDuplicate(element);
		
		if(duplicateStatus == 1){
			return 1;
		}
		else if(duplicateStatus == 2){
			return 2;
		}
		else{
			toDoList.add(element);
			sortByCurrentMethod();
			return 0;
		}
		
	}
	
	public void remove(int index){													//remove an element from the sorted list by array index
		toDoList.remove(index);
	}
	
	public void remove(TDElement element){											//remove an element from the sorted list by object
		toDoList.remove(element);
	}
	
	
	public TDElement getElement(int index){														//return element by index
		return toDoList.get(index);
	}
	
	public ArrayList<TDElement> getEntireList(){													//return entire sorted list
		sortByCurrentMethod();
		return toDoList;
	}
	
	
	public int getListSize(){																	//get the size of the list
		return toDoList.size();
	}
	
	public int update(TDElement element, int index){									//update element given an element and an index to update. Returns 0 for success, 1 for duplicate description, 2 for duplicate priority
		int test = checkDuplicate(element);
		if(test == 1){
			return 1;
		}
		else if(test == 2){
			return 2;
		}
		else{
			remove(index);
			insert(element);
			return 0;
		}
	}
	
	
	public int checkDuplicate(TDElement element){													//return 0 = no duplicate, 1 = duplicate description, 2 = duplicate priority
		for(int el = 0; el < toDoList.size(); el++){												//helper method to check if there is a duplicate description or priority
			TDElement currentCheck = toDoList.get(el);
			if(element.getDescription().equals(currentCheck.getDescription())){
				return 1;
			}
			if(element.getPriority() == currentCheck.getPriority()){
				return 2;
			}
		}
		return 0;
	}
	
	public void printList(){																		//debugging method to print list
		for(int el = 0; el < toDoList.size(); el++){	
			TDElement current = toDoList.get(el);
			System.out.print("Description: " + current.getDescription() + "  " + "Priority: " + current.getPriority() + "   " + "Due Date: " + current.getDueDate() + "   " + "Status   " + current.getStatus());
			System.out.println();
		}
	}
	
	
	private void sortByCurrentMethod(){															//sorts the list by the currently selected method
		if(currentSortMethod == 0){
			sortByPriority();
		}
		else if(currentSortMethod == 1){
			sortByDescription();
		}
		else{
			sortByDueDate();
		}
	}
	
	public void sortByDescription(){														//sort list by description, lexicographically 
		Collections.sort(toDoList, new DescriptionComparator());
		currentSortMethod = 1;
	}
	
	public void sortByPriority(){														//sort list by priority, numerically
		Collections.sort(toDoList, new PriorityComparator());
		currentSortMethod = 0;
	}
	
	public void sortByDueDate(){														//sort list by due date
		Collections.sort(toDoList, new DateComparator());
		currentSortMethod = 2;
	}
	
	
	public void saveFile(){																			//save to do list to text file called saveFile.txt
		String seperator = System.getProperty("line.separator");
		
		String title = "To Do List" + seperator + seperator + seperator;
		try {
			Files.write(Paths.get("./saveFile.txt"), title.getBytes());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int entry = 0; entry < getListSize(); entry++){
			TDElement element = toDoList.get(entry);
			
			String text = "Description: " + element.getDescription() + "   " + "Priority: " + element.getPriority() + "   " + 
			"Due Date: " + element.getDueDate() + "   " + "Status: " + element.getStatus() + "   " + "Date Started: " + element.getDateStarted() + "   " + 
			"Date Finished: " + element.getDateFinished() + "   " + seperator + seperator;
			
			
			try {
				Files.write(Paths.get("./saveFile.txt"), text.getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
//can I merge with master?



//comparator classes for sorting purposes

class DescriptionComparator implements Comparator<TDElement> {
	@Override
	public int compare(TDElement first, TDElement second){
		return first.getDescription().compareToIgnoreCase(second.getDescription());
	}
}

class PriorityComparator implements Comparator<TDElement> {
	@Override
	public int compare(TDElement first, TDElement second){
		if(first.getPriority() < second.getPriority()){
			return -1;
		}
		else if(first.getPriority() == second.getPriority()){
			return 0;
		}
		else{
			return 1;
		}
	}
}

class DateComparator implements Comparator<TDElement> {
	String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	@Override	
	public int compare(TDElement first, TDElement second){
		String[] splitFirst = first.getDueDate().split("\\s+");
		String[] splitSecond = second.getDueDate().split("\\s+");

		int firstMonthIndex = -1;
		int secondMonthIndex = -1;
		
		for(int firstMonth = 0; firstMonth < months.length; firstMonth++){
			if(months[firstMonth].equals(splitFirst[0])){
				firstMonthIndex = firstMonth;
			}
		}
		
		for(int secondMonth = 0; secondMonth < months.length; secondMonth++){
			if(months[secondMonth].equals(splitSecond[0])){
				secondMonthIndex = secondMonth;
			}
		}
		
		if(firstMonthIndex < secondMonthIndex){
			return -1;
		}
		else if(secondMonthIndex < firstMonthIndex){
			return 1;
		}
		else{
			int day1 = Integer.parseInt(splitFirst[1]);
			int day2 = Integer.parseInt(splitSecond[1]);
			if(day1 < day2){
				return -1;
			}
			else if(day2 < day1){
				return 1;
			}
			else{
				return 0;
			}
		}
	}
}


