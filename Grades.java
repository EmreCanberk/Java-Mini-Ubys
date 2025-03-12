/*package Run;
 

import java.security.PrivateKey;

	public class Grades{
		
		private int vizeGrades;
		private int finalGrades;
		private String name;
		public  String surname;
		public Grades(int vizeGrades,int finalGrades ,String name,String surname)
		{
			this.vizeGrades = vizeGrades;
			this.finalGrades = finalGrades;
			this.name = name;
			this.surname = surname;
		}
		public int getVizeGrades() {
			return vizeGrades;
		}
		public void setVizeGrades(int vizeGrades) {
			this.vizeGrades = vizeGrades;
		}
		public int getFinalGrades() {
			return finalGrades;
		}
		public void setFinalGrades(int finalGrades) {
			this.finalGrades = finalGrades;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
	
	
}
	*/

package Run;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ders bilgilerini oluştur
        Lesson lesson = new Lesson("Matematik", 101, (byte) 5);

        // Öğrenci bilgilerini al
        System.out.print("Öğrencinin adı: ");
        String name = scanner.nextLine();
        System.out.print("Öğrencinin soyadı: ");
        String surname = scanner.nextLine();

        // Vize ve final notlarını al
        System.out.print("Vize notu: ");
        int vizeGrades = scanner.nextInt();
        System.out.print("Final notu: ");
        int finalGrades = scanner.nextInt();

        // Grades nesnesi oluştur ve bilgileri ekle
        Grades grades = new Grades(vizeGrades, finalGrades, name, surname);

        // Bilgileri bastır
        System.out.println();
        grades.printGrades();

        // Dersi yazdır
        lesson.printLesson();
    }
}

class Lesson {
    private String name;
    private int id;
    private byte credit;
    private ArrayList<Grades> lessonGrades = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    public Lesson(String name, int id, byte credit) {
        this.name = name;
        this.id = id;
        this.credit = credit;
    }

    public void registerStudent(Student s) {
        students.add(s);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getCredit() {
        return credit;
    }

    public void setCredit(byte credit) {
        this.credit = credit;
    }


    public void printLesson() {
        System.out.println(this.id + "-" + this.name);
    }
}

class Grades {
    private int vizeGrades;
    private int finalGrades;
    private String name;
    public String surname;

    public Grades(int vizeGrades, int finalGrades, String name, String surname) {
        this.vizeGrades = vizeGrades;
        this.finalGrades = finalGrades;
        this.name = name;
        this.surname = surname;
    }

    public int getVizeGrades() {
        return vizeGrades;
    }

    public void setVizeGrades(int vizeGrades) {
        this.vizeGrades = vizeGrades;
    }

    public int getFinalGrades() {
        return finalGrades;
    }

    public void setFinalGrades(int finalGrades) {
        this.finalGrades = finalGrades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getAverageGrade() {
        return (vizeGrades * 0.4) + (finalGrades * 0.6);
    }

    public void printGrades() {
        System.out.println("Ad: " + name + " " + surname + ", Vize: " + vizeGrades + ", Final: " + finalGrades + ", Ortalama: " + getAverageGrade());
    }
}















