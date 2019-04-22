package cse360ToDoList;

import java.util.EventListener;

public interface TDListener extends EventListener {
	public void tdEventOccured(TDElement e);
}
