//Student Name: Brendan Furtado
//ID: 260737867

package com.mini3.generalizedframework;


public class Outcome<T extends baseOutcome, E extends Activity> { //By extending baseOutcome we force the object to represent a String

    private T outcomeType;
    private E activity;

    //A certain outcome will be associated with an activity
    //Example for students, a course (activity) is associated with a grade (outcome) of the course
    public Outcome(T outcome, E activity){


    }

    public String toString() {
        return "";
    }

}



