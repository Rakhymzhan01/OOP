package university.core;

public class Student extends User {
    private String faculty;

    public Student(String username, String password, String firstName, String lastName, String faculty) {
        super(username, password, firstName, lastName);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }
}
