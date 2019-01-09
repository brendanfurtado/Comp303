//Student Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;


//Generic version of course that stores T object in the array list. this is the list of student objects

public class Course<T extends Student> { //The extends forces the user to only store Student objects

    private String semester; //W2018, F2017, ....
    private ArrayList<T> registeredObjects;

    //Create a new course with a student list
    public Course(String name, String dept, String semester){


    }

    //Copies the array of objects passed to the internal registered objects array. this should be students.
    public void registerStudents(ArrayList<T> objArray) {

    }

    public String toString() {
        return "" ;
    }

}

