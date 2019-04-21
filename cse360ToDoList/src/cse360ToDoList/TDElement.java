package cse360ToDoList;


import java.util.Date;

public class TDElement {

	private String description;
	private int priority;
	private Date dueDate;

	private int status;				//status 0 = not started, 1 = in progress, 2 = finished

	private Date dateStarted;
	private Date dateFinished;

	public TDElement() {

	}

	public TDElement(String descrip, int prio, Date due, int stat){
		description = descrip;
		priority = prio;
		dueDate = due;
		status = stat;
	}

	public TDElement(String descrip, int prio, Date due, int stat, Date start){
		description = descrip;
		priority = prio;
		dueDate = due;
		status = stat;
		dateStarted = start;
	}

	public TDElement(String descrip, int prio, Date due, int stat, Date start, Date finish){
		description = descrip;
		priority = prio;
		dueDate = due;
		status = stat;
		dateStarted = start;
		dateFinished = finish;
	}

	//functions to get values
	public String getDescription(){
		return description;
	}

	public int getPriority(){
		return priority;
	}

	public Date getDueDate(){
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

	public Date getDateStarted(){
		return dateStarted;
	}

	public Date getDateFinished(){
		return dateFinished;
	}

	//functions to set values
	public void setDescription(String newDescrip){
		description = newDescrip;
	}

	public void setPriority(int newPrior){
		priority = newPrior;
	}

	public void setDueDate(Date newDate){
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

	public void setDateStarted(Date startDate){
		dateStarted = startDate;
	}

	public void setDateFinished(Date finishDate){
		dateFinished = finishDate;
	}

}
