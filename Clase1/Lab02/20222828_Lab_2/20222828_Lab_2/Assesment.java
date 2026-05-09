import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Assesment {
	private int durationMinutes;
	private Date startDate;
	private List<Teacher> teachers;
	private List<AssesmentItem> items;

	public Assesment(int durationMinutes, Date startDate, List<Teacher> teachers, List<AssesmentItem> items){
		this.durationMinutes = durationMinutes;
		this.startDate = startDate;
		this.teachers = teachers;
		this.items = items;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public Date getStartDate() {
		return startDate;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public List<AssesmentItem> getItems() {
		return items;
	}
}