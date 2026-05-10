import java.util.Date;
import java.util.List;


//Cuando me habla de clases que representan una relación de composicion
// Relacion de 1 a muchos, ejm: casa 1 --- 1, * habitaciones

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
