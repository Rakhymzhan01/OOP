package university.core;

import java.util.List; // For List usage
import java.util.ArrayList; // If needed for List initialization
import java.util.Scanner; // For user input
import java.io.Writer; // For writing files
import java.io.FileWriter; // For file writing
import java.io.IOException; // For handling IO exceptions
import university.academics.Grade; // For Grade class
import university.academics.Attendance; // For Attendance class (if defined)
import university.utils.FileHandler; // For FileHandler class
import com.google.gson.reflect.TypeToken; // For TypeToken with Gson


public class Teacher extends User {
    private String subject;

    public Teacher(String username, String password, String firstName, String lastName, String subject) {
        super(username, password, firstName, lastName);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    public void viewAttendance() {
        List<Attendance> attendanceList = FileHandler.loadFromFile("src/university/data/attendance.json",
                new TypeToken<List<Attendance>>() {}.getType());

        System.out.println("\nAttendance for your courses:");
        for (Attendance attendance : attendanceList) {
            if (attendance.getCourse().equals(subject)) {
                System.out.println("- " + attendance.getStudent() + ": " + attendance.getStatus());
            }
        }
    }

    public void assignGrades() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        System.out.print("Enter student username: ");
        String studentUsername = scanner.nextLine();

        System.out.print("Enter First Attestation grade: ");
        int firstAtt = scanner.nextInt();

        System.out.print("Enter Second Attestation grade: ");
        int secondAtt = scanner.nextInt();

        System.out.print("Enter Final Exam grade: ");
        int finalExam = scanner.nextInt();

        Grade grade = new Grade(studentUsername, courseId, firstAtt, secondAtt, finalExam);

        List<Grade> grades = FileHandler.loadFromFile("src/university/data/grades.json",
                new TypeToken<List<Grade>>() {}.getType());
        grades.add(grade);
        FileHandler.saveToFile(grades, "src/university/data/grades.json");

        System.out.println("Grades assigned successfully!");
    }


}
