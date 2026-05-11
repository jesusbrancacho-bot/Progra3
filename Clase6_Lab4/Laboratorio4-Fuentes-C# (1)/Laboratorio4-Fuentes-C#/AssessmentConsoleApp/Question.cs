public abstract class Question : IPrintable
{
    private int code;
    protected string prompt;

    public Question(int code, string prompt)
    {
        this.code = code;
        this.prompt = prompt;
    }

    public int Code
    {
        get { return code; }
    }

    public string Prompt
    {
        get { return prompt; }
    }

    public abstract string DevolverDatos();
}