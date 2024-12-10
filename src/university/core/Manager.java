package university.core;

public class Manager extends User {
    private String department;

    public Manager(String username, String password, String firstName, String lastName, String department) {
        super(username, password, firstName, lastName);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
