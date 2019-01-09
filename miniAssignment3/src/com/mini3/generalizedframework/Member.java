//Student Name: Brendan Furtado
//ID: 260737867

package com.mini3.generalizedframework;


import java.util.ArrayList;

public class Member<T extends baseMember, A extends Activity, O extends Outcome> {

    private T memberType;
    public ArrayList<A> activityHistory; //Stores what activity a member is a part of
    public ArrayList<O> outcomes;        // What a member gets out of participating, be it grade, a certificate
    // or something else/

    private int numRegistered = 0;

    public Member(T member){


    }


    //For whatever activity A, this activity object will be added to a member's activity history list
    public boolean registerActivity(A activity) {

        return false;

    }

    //Basically related to adding a list of courses with grades, an outcome has to associate with an activity
    public boolean addOutcome(A activity){

        return false;
    }

    //Method to List all courses function
    public void listHistory(){ }



    public String toString(){
        return "";
    }

}

