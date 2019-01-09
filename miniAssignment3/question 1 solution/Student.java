import java.util.ArrayList;

public class Student {

    private String name;
    private String studentID;
    private char type; //F == full; P == part

    public ArrayList<Course> courseHistory; //Combines both the course the student took and the grade they obtained
    public ArrayList<Grade> finalGrades;    // array of course/grade pairs.


    private int numRegistered = 0;

    public Student(String name, String studentID, char type){

        this.name = name;
        this.studentID = studentID;
        this.type = type;

        //Each student will have a list of courses they already took
        finalGrades = new ArrayList<Grade>();

        //List of courses student will currently be taking for the semester
        courseHistory = new ArrayList<Course>();
    }


    // will add to course to the list if the student has not taken it already.
    public void registerCourse(String name, String department, String semester) {

        // if parttime then don't allow more than 3
        // if fulltime then must be between 4 and 6

        // if courseAlready registered return. no duplicates allowed.

        Course c = new Course(name, department, semester);
        courseHistory.add(c);
        numRegistered++;
    }


    public void addGrade(Course course, String grade){
        Grade newGrade = new Grade(course, grade);
        finalGrades.add(newGrade);
    }



    //Method to List all courses function

    public void listHistory(){

        String list = "";
        for (Grade current : courseHistory) {
            list += " " + current;
        }

        System.out.println(list);
    }


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


    //Method to quit program


}

