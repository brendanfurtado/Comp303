import java.util.ArrayList;

public class Course <> {

    private String name;
    private String department;
    private String semester; //W2018, F2017, ....
    private ArrayList<Student> students;

    //Create a new course with a student list
    public Course(String name, String dept, String semester){

        this.name = name;
        this.department = dept;
        this.semester = semester;
        this.students = null;
    }

    public void registerStudents(ArrayList<Student> studentArray) {
        students = studentArray;
    }

    public String toString() {
        return "" + name;
    }

}
