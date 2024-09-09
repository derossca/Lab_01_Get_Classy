import java.util.Calendar;

public class Person {
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    /**
     * constructor for instance variables
     * @param IDNum
     * @param firstName
     * @param lastName
     * @param title
     * @param YOB
     */
    public Person(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    /**
     * Get a String which contains the first and last name of the Person
     * @return a String of the Person's first and last name
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Get a String which contains the title and last name of the Person
     * @return a String of the Person's title and last name
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Get a String which contains the age of the person
     * make calendar instance
     * get current year
     * age is the current year minus their year of birth
     * @return a String of the person's age
     */
    public String getAge(){
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int age = currentYear - YOB;
        return String.valueOf(age);
    }

    //***NEED HELP with top and bottom***

    /**
     * Get a String which determines the age of the person
     * @param  int of current year
     * @return a String of the Person's age
     */
    public String getAge(int currentYear){
        int age = currentYear - YOB;
        return String.valueOf(age);
    }

    /**
     * Get a String which contains the entire CSVDataRecord
     * @return a String of the Person's ID, first name, last name, title, and year of birth
     */
    public String toCSVDataRecord() {
        return this.IDNum + "," + this.firstName + "," + this.lastName + "," + this.title + "," + this.YOB;
    }

    /**
     * Returns the data of a person in JSON format
     * @return data in JSON format
     */
    public String toJSONRecord() {
        String retString = "";
        char DQ = '\u0022'; //Assign the double quote char to a variable for readability
        retString = "{" + DQ + "IDNum" + DQ + ":" + DQ + IDNum + DQ + "," +
                DQ + "firstName" + DQ + ":" + DQ + firstName + DQ + "," +
                DQ + "lastName" + DQ + ":" + DQ + lastName + DQ + "," +
                DQ + "title" + DQ + ":" + DQ + title + DQ + "," +
                DQ + "YOB" + DQ + ":" + DQ + YOB + DQ + "}";

        return retString;
    }

    /**
     * Returns a string of record in XML format
     * @return Person record in XML format
     */
    public String toXMLRecord() {
        String retString = "";
        retString = "<person>";
        retString += "<IDNum>" + this.IDNum + "</IDNum>";
        retString += "<firstName>" + this.firstName + "</firstName>";
        retString += "<lastName>" + this.lastName + "</lastName>";
        retString += "<title>" + this.title + "</title>";
        retString += "<YOB>" + this.YOB + "</YOB>";
        retString += "</person>";

        return retString;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
}
