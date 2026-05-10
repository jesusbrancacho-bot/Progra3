import java.util.Date;
import java.util.List;


class Assessment {
	private int durationMinutes;
	private Date startDate;
	private List<Teacher> teachers;
	private List<AssessmentItem> items;

	public Assessment(int durationMinutes, Date startDate, List<Teacher> teachers, List<AssessmentItem> items){
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

	public List<AssessmentItem> getItems() {
		return items;
	}
}