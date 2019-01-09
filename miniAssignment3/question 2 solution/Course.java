import java.util.ArrayList;

public class Course<T> {


    private String name;
    private String department;
    private String semester; //W2018, F2017, ....
    private ArrayList<T> registeredObjects;

    //Create a new course with a student list
    public Course(String name, String dept, String semester){

        this.name = name;
        this.department = dept;
        this.semester = semester;
        this.registeredObjects = null;
    }

    public void registerStudents(ArrayList<T> objArray) {
        registeredObjects = objArray;
    }

    public String toString() {
        return "" + name;
    }

}

