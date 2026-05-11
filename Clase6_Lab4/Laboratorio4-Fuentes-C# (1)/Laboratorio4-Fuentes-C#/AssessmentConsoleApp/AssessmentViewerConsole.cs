using System;
using System.Collections.Generic;

public class AssessmentViewerConsole
{
    private AssessmentViewerConsole()
    {
    }

    public static void Show(Assessment assessment)
    {
        Console.WriteLine("Inicio de examen ================");
        Console.WriteLine("Duracion: " + assessment.DurationInMinutes + " minutos");
        Console.WriteLine("Fecha Hora Inicio: " + assessment.StartDate.ToString("dd/MM/yyyy hh:mm"));
        Console.WriteLine();

        List<AssessmentItem> assessmentItemList = assessment.AssessmentItems;
        for (int i = 0; i < assessmentItemList.Count; i++)
        {
            AssessmentItem assessmentItem = assessmentItemList[i];
            Question question = assessmentItem.Question;
            Console.WriteLine("Pregunta " + (i + 1) + ") " + question.DevolverDatos());
            Console.WriteLine();
        }
    }
}