import java.util.List;
public class AssesmentItem {
    private Question question;
    private double score;

    public AssesmentItem(Question question, double score) {
        this.question = question;
        this.score = score;
    }

    public Question getQuestion() {
        return question;
    }

    public double getScore() {
        return score;
    }
}
