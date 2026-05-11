public class AssessmentItem
{
    private Question question;
    private double score;

    public AssessmentItem(Question question, double score)
    {
        this.question = question;
        this.score = score;
    }

    public Question Question
    {
        get { return question; }
    }

    public double Score
    {
        get { return score; }
    }
}