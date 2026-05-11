using System.Collections.Generic;
using System.Text;

public class SingleChoiceQuestion : Question
{
    private List<string> availableOptions;
    private int correctOption;

    public SingleChoiceQuestion(int code, string prompt, List<string> availableOptions, int correctOption)
        : base(code, prompt)
    {
        this.availableOptions = availableOptions;
        this.correctOption = correctOption;
    }

    public List<string> AvailableOptions
    {
        get { return availableOptions; }
    }

    public int CorrectOption
    {
        get { return correctOption; }
    }

    public override string DevolverDatos()
    {
        StringBuilder toReturn = new StringBuilder();
        toReturn.AppendLine(Prompt);

        for (int i = 0; i < availableOptions.Count; i++)
        {
            toReturn.AppendLine((i + 1) + ". " + availableOptions[i]);
        }

        toReturn.Append("Ingrese su respuesta:");
        return toReturn.ToString();
    }
}