package RoyalBlueProj;

import java.util.ArrayList;
import java.util.List;

public class FullStudent extends Student {


    public FullStudent(String name, String studentID){

        super(name, studentID);
        minCourses = 4;
        maxCourses = 6;
        numberOfCourses = 0;

        //Each student will have a list of courses they already took
        courseHistory = new ArrayList<List<Integer>>();

        //List of courses student will currently be taking for the semester
        currentCourses = new ArrayList<Course>();
    }



    public String getName() {
        return null;
    }


    public String getStudentID() {
        return null;
    }

    public void addCourseToHistory(Course courseHistory, int grade) {

    }

    public void addCourseToCurrent(Course enrolled) {

    }




}
