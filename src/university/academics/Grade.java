package university.academics;

public class Grade {
    private String student; // Username of the student
    private String course; // Course ID
    private int firstAttestation; // Marks for the first attestation
    private int secondAttestation; // Marks for the second attestation
    private int finalExam; // Marks for the final exam

    // Constructor
    public Grade(String student, String course, int firstAttestation, int secondAttestation, int finalExam) {
        this.student = student;
        this.course = course;
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalExam = finalExam;
    }

    // Getters
    public String getStudent() {
        return student;
    }

    public String getCourse() {
        return course;
    }

    public int getFirstAttestation() {
        return firstAttestation;
    }

    public int getSecondAttestation() {
        return secondAttestation;
    }

    public int getFinalExam() {
        return finalExam;
    }

    // Setters
    public void setStudent(String student) {
        this.student = student;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setFirstAttestation(int firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    public void setSecondAttestation(int secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }

    // Override toString for display purposes
    @Override
    public String toString() {
        return "Course: " + course +
                ", First Attestation: " + firstAttestation +
                ", Second Attestation: " + secondAttestation +
                ", Final Exam: " + finalExam;
    }
}
