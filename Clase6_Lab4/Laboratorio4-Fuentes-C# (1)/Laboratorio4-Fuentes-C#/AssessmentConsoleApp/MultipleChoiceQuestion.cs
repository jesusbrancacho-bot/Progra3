using System.Collections.Generic;

public class MultipleChoiceQuestion : Question
{
    private List<string> availableOptions;
    private List<int> correctOptions;

    public MultipleChoiceQuestion(int code, string prompt, List<string> availableOptions, List<int> correctOptions)
        : base(code, prompt)
    {
        this.availableOptions = availableOptions;
        this.correctOptions = correctOptions;
    }

    public List<string> AvailableOptions
    {
        get { return availableOptions; }
    }

    public override string DevolverDatos()
    {
        string toReturn = Prompt + "\n";
        for (int i = 0; i < availableOptions.Count; i++)
        {
            toReturn += (i + 1) + ". " + availableOptions[i] + "\n";
        }
        toReturn += "Seleccione las opciones de su respuesta: ";
        return toReturn;
    }
}