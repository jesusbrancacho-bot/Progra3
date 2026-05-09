import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		QuestionManager questionManager = new QuestionManager();

		SingleChoiceQuestion sc1 = new SingleChoiceQuestion(
				1, "1 + 1?", List.of("1", "2", "11", "0"), 2
		);

		SingleChoiceQuestion sc2 = new SingleChoiceQuestion(
				2, "2*4?", List.of("24", "2", "8", "16"), 3
		);

		MultipleChoiceQuestion mc1 = new MultipleChoiceQuestion(
				3, "is a planet?",
				List.of("Earth", "Moon", "Europe", "Mars"),
				List.of(1, 4)
		);

		questionManager.add(sc1);
		questionManager.add(sc2);
		questionManager.add(mc1);

		Teacher teacher1 = new Teacher("11111111", "Freddy", "Paz");
		Teacher teacher2 = new Teacher("22222222", "Jose", "Corcuera");

		List<Teacher> teachers = new ArrayList<>();
		teachers.add(teacher1);
		teachers.add(teacher2);

		List<Question> questionsSelected = questionManager.selectRandomN(3);

		List<AssesmentItem> items = new ArrayList<>();

		items.add(new AssesmentItem(questionsSelected.get(0), 2));
		items.add(new AssesmentItem(questionsSelected.get(1), 5));
		items.add(new AssesmentItem(questionsSelected.get(2), 3));

		Assesment assessment = new Assesment(
				120,
				new Date(),
				teachers,
				items
		);

		AsessmentViewer.show(assessment);
	}
}