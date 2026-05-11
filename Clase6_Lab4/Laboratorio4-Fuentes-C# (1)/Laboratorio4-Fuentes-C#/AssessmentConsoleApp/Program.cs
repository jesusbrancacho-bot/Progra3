using System;
using System.Collections.Generic;

public class Program
{
    public static void Main(string[] args)
    {
        QuestionManager questionManager = new QuestionManager();

        SingleChoiceQuestion sc1 = new SingleChoiceQuestion(
            1,
            "1 + 1?",
            new List<string> { "1", "2", "11", "0" },
            2
        );

        SingleChoiceQuestion sc2 = new SingleChoiceQuestion(
            2,
            "2 * 4?",
            new List<string> { "24", "2", "8", "16" },
            3
        );

        MultipleChoiceQuestion mc1 = new MultipleChoiceQuestion(
            3,
            "is a planet?",
            new List<string> { "Earth", "Moon", "Europe", "Mars" },
            new List<int> { 1, 4 }
        );

        questionManager.Add(sc1);
        questionManager.Add(sc2);
        questionManager.Add(mc1);

        // 2. Registro de Profesores
        Teacher teacher1 = new Teacher("11111111", "Freddy", "Paz");
        Teacher teacher2 = new Teacher("22222222", "Jose", "Corcuera");

        List<Teacher> teachers = new List<Teacher>();
        teachers.Add(teacher1);
        teachers.Add(teacher2);

        // 3. Selección de preguntas para el examen y asignación de puntajes
        // Se usa AssessmentItem para vincular la pregunta con su peso específico
        List<Question> questionsSelected = questionManager.SelectRandomN(3);
        List<AssessmentItem> questionsForAssessment = new List<AssessmentItem>();

        // Ejemplo: La misma pregunta puede tener distintos puntajes en diferentes contextos
        questionsForAssessment.Add(new AssessmentItem(questionsSelected[0], 3.0));
        questionsForAssessment.Add(new AssessmentItem(questionsSelected[1], 2.5));
        questionsForAssessment.Add(new AssessmentItem(questionsSelected[2], 1.5));

        // 4. Creación del Examen (Assessment) con su metadata
        Assessment assessment = new Assessment(
            120,                  // Duración en minutos
            DateTime.Now,         // Fecha y hora de inicio
            teachers,             // Lista de profesores
            questionsForAssessment // Lista de ítems (Pregunta + Puntaje)
        );

        // 5. Ejecución de la evaluación
        AssessmentViewerConsole.Show(assessment);
    }
}
