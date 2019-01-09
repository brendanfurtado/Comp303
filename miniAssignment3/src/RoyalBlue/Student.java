//Student Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

// Student class holds the course History as an array and the final grades for courses as an array
public class Student extends baseStudent {

    private char type; //F == full; P == part

    public ArrayList<Course> courseHistory; //Array that consists of courses a student has taken
    public ArrayList<Grade> finalGrades;    //Array of course/grade pairs.


    private int numRegistered = 0; //Keeps track of how many courses a student is in
    //NOTE: methods isFullTime and isPartTime along with this variable
    //keep track if a student is full or part time


    // Constructor that creates a student object,
    // depends on name, student Id, and what type of student you are (Full or part time)
    // in addition it creates the arraylists to hold the final grades and course history for that student

    public Student(String name, String studentID, char type){


    }


    // The method will run some checks before it adds the course to the course history.
    // 1) If the student has not taken it already.
    // 2) In addition it will check if the student is part or full time and add accordingly
    // numRegistered should be incremented to keep track of num courses

    // Method will return true of false depending on the outcome of the checks above

    public boolean registerCourse(Course course) {

        return false;
    }

    // Method takes a course/grade pair and adds it to the final grades array
    // Method checks if the student was registered for the course and adds it if so.
    // else it returns false.

    public boolean addGrade(Grade grade){

        return false;
    }



    //Method to List all courses that the student has taken
    public void listHistory(){

    }



    //Basic toString
    public String toString(){
        return "";
    }




}

