package model;
import java.util.Calendar;
public class Activity {

	private String id;
	private String description;
	private Calendar dueDate;
	private String location;

	/**
	 * 
	 * @param id
	 * @param description
	 * @param dueDate
	 * @param location
	 */


	public Activity(String id, String description, Calendar dueDate, String location) {
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}