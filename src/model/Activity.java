package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Activity {

	private Integer id;
	private String title;
	private String description;
	private Calendar dueDate;
	private String location;

	private SimpleDateFormat simpleDateFormat;
	/**
	 * 
	 * @param id
	 * @param description
	 * @param dueDate
	 * @param location
	 */


	public Activity(Integer id,String title ,String description, Calendar dueDate, String location) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.location = location;
		this.simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
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

	public void setId(Integer id) {
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


	public String convDateFormat(Calendar date){

		return simpleDateFormat.format(date.getTime());

	}
	@Override
	public String toString() {


		return "\n\tTitle: " + this.title +
				"\n\tId: " + this.id +
				"\n\tDescription: "+ this.description +
				"\n\tLocation: " + this.location +
				"\n\tDue Date: "+ convDateFormat(this.dueDate);

	}
}