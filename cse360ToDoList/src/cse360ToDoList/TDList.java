package cse360ToDoList;
import java.util.*;

public class TDList {
	
	public ArrayList<TDElement> toDoList;
	
	public TDList(){
		toDoList = new ArrayList<TDElement>();
	}
	
	
	public int insert(TDElement element){														//return 0 = successful insert, 1 = duplicate description, 2 = duplicate priority
		
		int duplicateStatus = checkDuplicate(element);
		
		if(duplicateStatus == 1){
			return 1;
		}
		else if(duplicateStatus == 2){
			return 2;
		}
		else{
			toDoList.add(element);
			return 0;
		}
		
	}
	
	public int checkDuplicate(TDElement element){													//return 0 = no duplicate, 1 = duplicate description, 2 = duplicate priority
		for(int el = 0; el < toDoList.size(); el++){
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
	
	public void printList(){
		for(int el = 0; el < toDoList.size(); el++){
			TDElement current = toDoList.get(el);
			System.out.print("Description: " + current.getDescription() + "  " + "Priority: " + current.getPriority() + "   " + "Due Date: " + current.getDueDate() + "   " + "Status   " + current.getStatus());
			System.out.println();
		}
	}
	
	
	public void sortByDescription(){
		Collections.sort(toDoList, new DescriptionComparator());
	}
	
	public void sortByPriority(){
		Collections.sort(toDoList, new PriorityComparator());
	}
	
	public void sortByDueDate(){
		Collections.sort(toDoList, new DateComparator());
	}
	
	
	
	
	
	
}

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
	@Override
	public int compare(TDElement first, TDElement second){
		return second.getDueDate().compareTo(first.getDueDate());
	}
}


