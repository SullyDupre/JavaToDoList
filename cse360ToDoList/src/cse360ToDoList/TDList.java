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
	
}
