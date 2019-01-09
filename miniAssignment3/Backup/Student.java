package RoyalBlueProj;

import java.util.ArrayList;
import java.util.List;

public abstract class Student {

    private String name;
    private String studentID;

    public List<List<Integer>> courseHistory; //Combines both the course the student took and the grade they obtained
    public List<Course> currentCourses;

    public int minCourses;
    public int maxCourses;
    public int numberOfCourses;

    public Student(String name, String studentID){
        this.name = name;
        this.studentID = studentID;
    }

    //Methods declared as abstract so developer can implement them in their own program
    public abstract String getName();

    public abstract String getStudentID();

    //No matter what each type of student has a course history/grade history
    //So each child class will have to implement a method that adds a grade to a student
    // for a course they're enrolled in
    public abstract void addCourseToHistory(Course courseTook, int grade);

    // will add to course to current courses taking for the semester
    public abstract void addCourseToCurrent(Course enrolled);

    //Method to List all courses function

    //Method to Add semester courses to course history


    //Method to quit program
}

