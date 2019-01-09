import java.util.ArrayList;

public class Member<T extends baseMember, A extends baseActivity, O extends Outcome> {

    private T memberType;
    public ArrayList<A> activityHistory; //Combines both the course the student took and the grade they obtained
    public ArrayList<O> outcomes;    // array of course/grade pairs.


    private int numRegistered = 0;

    public Member(T member){

        memberType = member;

        //Each student will have a list of courses they already took
        outcomes = new ArrayList<O>();

        //List of courses student will currently be taking for the semester
        activityHistory = new ArrayList<A>();
    }


    // will add to course to the list if the student has not taken it already.
    public void registerActivity(A activity) {

        activityHistory.add(activity);
    }


    public void addOutcome(O outcome){
        outcomes.add(outcome);
    }

    //Method to List all courses function

    public void listHistory(){ }

    //Will return true if the student is a full time student and false otherwise
    public boolean isFullTime() {
        return true;
    }

    //Will return true if the student is a part time student and false otherwise
    public boolean isPartTime() {
        return true; 
    }


    public String toString(){
        return "";
    }

}



