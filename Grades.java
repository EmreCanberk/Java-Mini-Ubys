package Run;

public class Grades {
    private Lesson lesson;
    private Student student;
    private int	vizeNot;
    private int finalNot;

    public Grades(Lesson lesson, Student student, int vizeNot, int finalNot) {
        this.lesson = lesson;
        this.student = student;
        this.vizeNot = vizeNot;
        this.finalNot = finalNot;
        student.addLesson(lesson); 
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Student getStudent() {
        return student;
    }

    public int getvizeNot() {
        return vizeNot;
    }

    public int getFinalNot() {
        return finalNot;
    }

    public void printGradeInfo() {
        System.out.println("Öğrenci: " + student.getFirstName() + " " + student.getLastName() + " - Ders: " + lesson.getName() + " - Vize: " + vizeNot + " - Final: " + finalNot);
    }
}
