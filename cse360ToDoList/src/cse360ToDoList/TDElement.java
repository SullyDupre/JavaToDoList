package cse360ToDoList;


public class TDElement {

	private String description;
	private int priority;
	private String dueDate;

	private int status;				//status 0 = not started, 1 = in progress, 2 = finished

	private String dateStarted;
	private String dateFinished;

	public TDElement() {

	}

	public TDElement(String descrip, int prio, String due, String stat){
		description = descrip;
		priority = prio;
		dueDate = due;
		if (stat.equals("Not Started")){
			status = 0;
		}
		else if (stat.equals("In Progress")){
			status = 1;
		}
		else {
			status = 2;
		}
	}

	public TDElement(String descrip, int prio, String due, String stat, String start){
		description = descrip;
		priority = prio;
		dueDate = due;
		if (stat.equals("Not Started")){
			status = 0;
		}
		else if (stat.equals("In Progress")){
			status = 1;
		}
		else {
			status = 2;
		}
		dateStarted = start;
	}

	public TDElement(String descrip, int prio, String due, String stat, String start, String finish){
		description = descrip;
		priority = prio;
		dueDate = due;
		if (stat.equals("Not Started")){
			status = 0;
		}
		else if (stat.equals("In Progress")){
			status = 1;
		}
		else {
			status = 2;
		}
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
		if (newStat.equals("Not Started")){
			status = 0;
		}
		else if (newStat.equals("In Progress")){
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
