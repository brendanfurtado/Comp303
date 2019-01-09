//Student Name: Brendan Furtado
//ID: 260737867

package com.mini3.generalizedframework;


import java.util.ArrayList;

//Stores activity object that is derived from the baseActivity
//Also keeps track of registered members E that are derived from baseMember

public class Activity<A extends baseActivity, E extends baseMember> {

    private A activityType;
    private ArrayList<E> registeredMembers;

    //Create a new activity with a member list
    public Activity(A activity){


    }

    //Makes a copy of the array of members to the local variable registered members
    public void registerMembers(ArrayList<E> members) {


    }

    public String toString() {
        return "";
    }

}