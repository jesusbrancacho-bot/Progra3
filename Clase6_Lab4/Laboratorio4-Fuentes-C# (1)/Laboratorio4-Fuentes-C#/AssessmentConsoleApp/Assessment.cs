using System;
using System.Collections.Generic;

public class Assessment
{
    private int durationInMinutes;
    private DateTime startDate;
    private List<Teacher> teachers;
    private List<AssessmentItem> assessmentItems;
    private double finalScore;

    public Assessment(int durationInMinutes, DateTime startDate, List<Teacher> teachers, List<AssessmentItem> assessmentItems)
    {
        this.durationInMinutes = durationInMinutes;
        this.startDate = startDate;
        this.teachers = teachers;
        this.assessmentItems = assessmentItems;
    }

    public int DurationInMinutes
    {
        get { return durationInMinutes; }
    }

    public DateTime StartDate
    {
        get { return startDate; }
    }

    public List<Teacher> Teachers
    {
        get { return teachers; }
    }

    public List<AssessmentItem> AssessmentItems
    {
        get { return assessmentItems; }
    }
}