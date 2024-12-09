package university.academics;

import java.util.Vector;

public class Course {
    private int id;
    private int credits;
    private Vector<Teacher> teachers;
    private String name;
    private TypeCourse type;
    private String prerequisite;

    public Course(int id, int credits, String name, TypeCourse type, String prerequisite) {
        this.id = id;
        this.credits = credits;
        this.teachers = new Vector<>();
        this.name = name;
        this.type = type;
        this.prerequisite = prerequisite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Vector<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
        }
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeCourse getType() {
        return type;
    }

    public void setType(TypeCourse type) {
        this.type = type;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public void addStudent(Student student) {
        System.out.println("Adding student to the course: " + student.getName());
    }

    public void removeStudent(Student student) {
        System.out.println("Removing student from the course: " + student.getName());
    }
}