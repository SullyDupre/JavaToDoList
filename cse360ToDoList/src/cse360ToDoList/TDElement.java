package cse360ToDoList;


import java.util.Date;
import java.util.EventObject;

public class TDElement extends EventObject {

	private String description;
	private int priority;
	private String dueDate;

	private int status;				//status 0 = not started, 1 = in progress, 2 = finished

	private String dateStarted;
	private String dateFinished;

	
	
	public TDElement(Object source) {
		super(source);

	}

	public TDElement(Object source, String descrip, int prio, String due, int stat){
		super(source);
		this.description = descrip;
		this.priority = prio;
		this.dueDate = due;
		this.status = stat;
	}

	public TDElement(Object source, String descrip, int prio, String due, int stat, String start){
		super(source);
		this.description = descrip;
		this.priority = prio;
		this.dueDate = due;
		this.status = stat;
		this.dateStarted = start;
	}

	public TDElement(Object source, String descrip, int prio, String due, int stat, String start, String finish){
		super(source);
		this.description = descrip;
		this.priority = prio;
		this.dueDate = due;
		this.status = stat;
		this.dateStarted = start;
		this.dateFinished = finish;
	}

	//functions to get values
	public String getDescription(){
		return description;
	}

	public int getPriority(){
		return priority;
	}

	public String getDueDate(){
		return dueDate;
	}

	public String getStatus(){
		if (status == 0){
			return "Not Started";
		}
		else if (status == 1){
			return "In Progress";
		}
		else {
			return "Finished";
		}
	}

	public String getDateStarted(){
		return dateStarted;
	}

	public String getDateFinished(){
		return dateFinished;
	}

	//functions to set values
	public void setDescription(String newDescrip){
		description = newDescrip;
	}

	public void setPriority(int newPrior){
		priority = newPrior;
	}

	public void setDueDate(String newDate){
		dueDate = newDate;
	}

	public void setStatus(String newStat){
		if (newStat == "Not Started"){
			status = 0;
		}
		else if (newStat == "In Progress"){
			status = 1;
		}
		else {
			status = 2;
		}
	}

	public void setStatus(int newStat){
		status = newStat;
	}

	public void setDateStarted(String startDate){
		dateStarted = startDate;
	}

	public void setDateFinished(String finishDate){
		dateFinished = finishDate;
	}

}
