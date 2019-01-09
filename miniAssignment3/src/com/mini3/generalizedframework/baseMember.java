//Student Name: Brendan Furtado
//ID: 260737867
package com.mini3.generalizedframework;

//Will be used in the Student class
// it will forces the necessary fields that need to be implemented as part of the Member class

public abstract class baseMember {

    public String name;
    public String uniqueIdentifier;

    //Will return true if the student is a full time student and false otherwise
    public boolean isFullTime() {
        return true;
    }

    //Will return true if the student is a part time student and false otherwise
    public boolean isPartTime() {
        return true;
    }

    //Force user to implement a toString()
    public abstract String toString();

}
