public class Grade {

    private String grade;
    private Course course;

    public Grade(Course course, String grade){
        this.course = course;
        this.grade = grade;
    }

    public String toString() {
        return "[Activity: " + course.toString() + "; Outcome: " + grade + "]";
    }

}
