package RoyalBlueProj;

import java.util.ArrayList;

public abstract class Course {

    private String courseName;
    private ArrayList<Student> courseStudentList;

    //Create a new course with a student list
    public Course(String courseName){
        this.courseName = courseName;
        ArrayList<Student> courseStudentList = new ArrayList<Student>(); //each course will have a student list
    }

    //For each course created, there is an arraylist of the class list
    // this effectively registers students for a course
    public abstract void addStudent(Course courseName, Student studentName);

    public abstract ArrayList<Student> getCourseStudentList();
}
