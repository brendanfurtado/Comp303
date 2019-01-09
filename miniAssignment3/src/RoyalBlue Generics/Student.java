//Student Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

//Student is parametrized by type T which corresponds to course and E corresponds to grades
public class Student <T extends Course,E extends Grade> extends baseStudent {  //Makes sure that user will use the T generic with a course object and E with a Grade object


    private char type; //F == full; P == part

    public ArrayList<T> courseHistory; //Combines both the course the student took and the grade they obtained
    public ArrayList<E> finalGrades;    // array of course/grade pairs.


    private int numRegistered = 0;

    public Student(String name, String studentID, char type){

    }

    // The method will run some checks before it adds the course to the course history.
    // 1) If the student has not taken it already.
    // 2) In addition it will check if the student is part or full time and add accordingly
    // numRegistered should be incremented to keep track of num courses

    // Method will return true of false depending on the outcome of the checks above
    public boolean registerCourse(T course) {
        return false;
    }


    // Method takes a course/grade pair and adds it to the final grades array
    // Method checks if the student was registered for the course and adds it if so.
    // else it returns false.
    public boolean addGrade(E grade){
        return false;
    }

    //Method to List all courses function

    public void listHistory(){ }



    public String toString(){
        return "";
    }

}

