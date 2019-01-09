import java.util.ArrayList;

public class Activity<T extends baseActivity, E extends baseMember> {

    private T activity;
    private ArrayList<E> registeredMembers;

    //Create a new course with a student list
    public Activity(T activity){

        this.activity = activity;
        this.registeredMembers = null;
    }

    public void registerMembers(ArrayList<E> members) {
        registeredMembers = members;
    }

    public String toString() {
        return "";
    }

}

