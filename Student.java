package Run;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private int id;
    private String department;
    private List<Lesson> lessons;
    private static int idIlkDeger = 232608100;

    public Student(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.id = getNextId();
        this.lessons = new ArrayList<>();
    }

    private static int getNextId() {
        idIlkDeger += 10;
        return idIlkDeger;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
        lesson.addStudent(this);
    }

    public void printStudentInfo() {
        System.out.print("Öğrenci ID: " + id + " - Öğrenci: " + firstName + " " + lastName + " - Bölüm: " + department);
        for (Lesson lesson : lessons)
        { 
        	System.out.print(lesson.getName() + " "); 
        }
        
    }

    public void printLessonsList() {
        System.out.println("Öğrenci: " + firstName + " " + lastName + " - Ders Listesi:");
        for (Lesson lesson : lessons) {
            System.out.println(lesson.getName());
        }
    }
}
