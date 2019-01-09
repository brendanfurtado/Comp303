public class Grade<T> {

    private String grade;
    private T course;

    public Grade(T course, String grade){
        this.course = course;
        this.grade = grade;
    }

    public String toString() {
        return "[Activity: " + course.toString() + "; Outcome: " + grade + "]";
    }

}


