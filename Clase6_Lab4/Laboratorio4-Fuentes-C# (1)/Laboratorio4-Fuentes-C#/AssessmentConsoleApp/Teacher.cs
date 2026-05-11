public class Teacher
{
    private string pucpCode;
    private string firstName;
    private string lastName;

    public Teacher(string pucpCode, string firstName, string lastName)
    {
        this.pucpCode = pucpCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public string PucpCode
    {
        get { return pucpCode; }
    }

    public string FirstName
    {
        get { return firstName; }
    }

    public string LastName
    {
        get { return lastName; }
    }
}