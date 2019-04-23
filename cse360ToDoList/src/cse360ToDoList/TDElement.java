package cse360ToDoList;


public class TDElement {

	/**
	 * A string that will be used for the title of each element in the array
	 */
	private String description;
	
	/**
	 * An integer that will keep track of the priority of each item
	 */
	private int priority;
	
	/**
	 * A string that will be the due date of the task
	 */
	private String dueDate;

	/**
	 * An integer that says if status 0 = not started, 1 = in progress, 2 = finished
	 */
	private int status;				

	/**
	 * A string that will recognize the start and finish date assigned to each element.
	 */
	private String dateStarted;
	private String dateFinished;
	
	/**
	 * This is the default constructor
	 */
	public TDElement() {

	}

	/**
	 * This is the function that sets the status and the parameters.
	 */
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

	/**
	 * This function updates the elements in the list with a start and end date
	 * 
	 */
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

	/**
	 * THis function changes the finish date of any given element.
	 */
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

	/**
	 * This function gets the description of the element
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * This function gets the priority of any given element
	 */
	public int getPriority(){
		return priority;
	}

	/**
	 * This function gets the due date of the element
	 */
	public String getDueDate(){
		return dueDate;
	}

	/**
	 * This function gets the status of the element.
	 */
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

	/** 
	 * Function that gets the start date
	 */
	public String getDateStarted(){
		return dateStarted;
	}
	
	/**
	 * Function that gets the date that to do item is finished
	 */

	public String getDateFinished(){
		return dateFinished;
	}

	/**
	 * this function sets the description of an element.
	 */
	public void setDescription(String newDescrip){
		description = newDescrip;
	}

	/**
	 * this function sets the priority of an element.
	 */
	public void setPriority(int newPrior){
		priority = newPrior;
	}

	/**
	 * this function sets the due date of an element.
	 */
	public void setDueDate(String newDate){
		dueDate = newDate;
	}

	/**
	 * this function sets the status of an element.
	 */
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

	/**
	 * this function sets the status of an element.
	 */
	public void setStatus(int newStat){
		status = newStat;
	}

	/**
	 * this function sets the set the date started of an element.
	 */
	public void setDateStarted(String startDate){
		dateStarted = startDate;
	}

	/**
	 * this function sets the finished date of an element.
	 */
	public void setDateFinished(String finishDate){
		dateFinished = finishDate;
	}

}
