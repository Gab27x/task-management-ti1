package model;
import com.google.gson.annotations.JsonAdapter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
public class Activity implements Comparable<Activity> {

	private Integer id;
	private String title;
	private String description;
	@JsonAdapter(LocalDateAdapter.class)
	private LocalDate dueDate;
	private String location;

	private boolean priority;


	/**
	 * 
	 * @param id
	 * @param description
	 * @param dueDate
	 * @param location
	 */


	public Activity(Integer id,String title ,String description, LocalDate dueDate, String location, boolean priority) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.location = location;
		this.priority = priority;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public boolean getPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isPriority() {
		return priority;
	}

	public int compareTo(Activity other){
		return this.dueDate.compareTo(other.getDueDate());
	}




	@Override
	public String toString() {

		return "\n\tTitle: " + this.title +
				"\n\tId: " + this.id +
				"\n\tDescription: "+ this.description +
				"\n\tLocation: " + this.location +
				"\n\tDue Date: "+ this.dueDate
				+"\n\tIs prioritary: "+ this.priority;

	}


}