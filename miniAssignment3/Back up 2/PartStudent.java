
import java.util.ArrayList;
import java.util.List;

public class PartStudent extends Student {

    public PartStudent(String name, String studentID){

        super(name, studentID);
        minCourses = 1;
        maxCourses = 3;
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
