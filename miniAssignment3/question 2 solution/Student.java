import java.util.ArrayList;

// student is parametrized by type T which corresponds to course and E corresponds to grades
public class Student <T,E> {

    private String name;
    private String studentID;
    private char type; //F == full; P == part

    public ArrayList<T> courseHistory; //Combines both the course the student took and the grade they obtained
    public ArrayList<E> finalGrades;    // array of course/grade pairs.


    private int numRegistered = 0;

    public Student(String name, String studentID, char type){

        this.name = name;
        this.studentID = studentID;
        this.type = type;

        //Each student will have a list of courses they already took
        finalGrades = new ArrayList<E>();

        //List of courses student will currently be taking for the semester
        courseHistory = new ArrayList<T>();
    }

    // will add to course to the list if the student has not taken it already.
    public void registerCourse(T course) {

        // if parttime then don't allow more than 3
        // if fulltime then must be between 4 and 6

        // if courseAlready registered return. no duplicates allowed.

        courseHistory.add(course);
        numRegistered++;
    }


    public void addGrade(E grade){
        finalGrades.add(grade);
    }

    //Method to List all courses function

    public void listHistory(){ }

    //Will return true if the student is a full time student and false otherwise
    public boolean isFullTime() {

        return (type == 'F') ? true : false;
    }

    //Will return true if the student is a part time student and false otherwise
    public boolean isPartTime() {

        return (type == 'P') ? true : false;

    }


    public String toString(){
        return "" + name + "," + studentID;
    }

}

