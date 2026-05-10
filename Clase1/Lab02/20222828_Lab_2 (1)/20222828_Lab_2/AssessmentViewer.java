
public class AssessmentViewer {
    public static void show(Assessment assessment) {
        System.out.println("Profesores del curso.");
        for (Teacher teacher : assessment.getTeachers()) {
            System.out.println(teacher.devolverDatos());
        }

        System.out.println();
        System.out.println("Fecha de inicio: " + assessment.getStartDate());
        System.out.println("Duración: " + assessment.getDurationMinutes() + " minutos");
        System.out.println();

        System.out.println("Preguntas del examen:");
        System.out.println("----------------------");

        for (AssessmentItem item : assessment.getItems()) {
            System.out.println("Puntaje: " + item.getScore());
            System.out.println(item.getQuestion().devolverDatos());
        }
    }

}
