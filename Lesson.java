package Run;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private static int idCounter = 100; 
    private String name;
    private int id;
    private List<Student> students;
    private List<Grades> grades; 

    public Lesson(String name) {
        this.name = name;
        this.id = getNextId(); 
        this.students = new ArrayList<>();
        this.grades = new ArrayList<>(); 
    }

    private static int getNextId() {
        return idCounter++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printLessonInfo() {
        System.out.println("Ders: " + name + " - Ders ID: " + id);
    }

    public void printStudentsTakingLesson() {
        System.out.println("Dersi alan öğrenciler:");
        for (Student student : students) {
            System.out.println("  - " + student.getFirstName() + " " + student.getLastName());
        }
    }

    public void addGrade(Grades grade) {
        grades.add(grade);
    }

    public boolean hasGrade(Student student) {
        for (Grades grade : grades) {
            if (grade.getStudent().equals(student)) {
                return true;
            }
        }
        return false;
    }

    public void printGrades() {
        System.out.println("Ders: " + name + " - Notlar:");
        for (Grades grade : grades) {
            System.out.println("  - Öğrenci: " + grade.getStudent().getFirstName() + " " + grade.getStudent().getLastName() + ", Vize: " + grade.getvizeNot() + ", Final: " + grade.getFinalNot());
        }
    }
}
