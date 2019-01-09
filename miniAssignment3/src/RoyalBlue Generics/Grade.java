//Student Name: Brendan Furtado
//ID: 260737867

// Stores the course and grade pair however grade is stored as a genetic object.
// This allows the user to associate any object with the grade

public class Grade<T extends Course> { //The extends forces the user to only store Course objects

    private String grade;
    private T course;

    public Grade(T course, String grade){

    }

    public String toString() {
        return "";
    }

}

