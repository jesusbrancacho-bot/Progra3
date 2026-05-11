using System;
using System.Collections.Generic;

public class QuestionManager
{
    private List<Question> questions = new List<Question>();

    public void Add(Question question)
    {
        this.questions.Add(question);
    }

    public List<Question> SelectRandomN(int n)
    {
        Random rand = new Random();
        List<Question> toReturn = new List<Question>();
        int i = 0;

        while (i < n)
        {
            Question item = questions[rand.Next(questions.Count)];
            if (!toReturn.Contains(item))
            {
                i++;
                toReturn.Add(item);
            }
        }

        return toReturn;
    }
}