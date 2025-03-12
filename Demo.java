package Run;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Lesson> lessons = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        int tercih = -1;

        while (tercih != 8) {
            System.out.println("İşleminizi seçiniz:");
            System.out.println("1- Öğrenci Ekleme:");
            System.out.println("2- Ders Ekleme:");
            System.out.println("3- Öğrenci Listesi:");
            System.out.println("4- Ders Listesi:");
            System.out.println("5- Öğrenciye Ders Ekleme:");
            System.out.println("6- Not Girimi:");
            System.out.println("7- Dersi Alan Öğrencileri Listele:");
            System.out.println("8- Koddan Çıkış:");

            tercih = scanner.nextInt();
            scanner.nextLine(); 

            switch (tercih) {
                case 1:
                    System.out.println("Öğrenci Adı: ");
                    String firstName = scanner.nextLine(); 
                    System.out.println("Öğrenci Soyadı: "); 
                    String lastName = scanner.nextLine();
                    System.out.println("Öğrenci Bölümü: ");
                    String department = scanner.nextLine(); 
                    Student newStudent = new Student(firstName, lastName, department); 
                    students.add(newStudent);
                    System.out.println("Yeni öğrenci eklendi: " + firstName + " " + lastName); 
                    break;
                case 2:
                    System.out.println("Ders Adı: ");
                    String lessonName = scanner.nextLine(); 
                    Lesson newLesson = new Lesson(lessonName); 
                    lessons.add(newLesson); 
                    System.out.println("ders eklendi: " + lessonName);
                    break;
                case 3:
                    System.out.println("\n------- Öğrenci Listesi -------");
                    for (Student student : students) {
                        student.printStudentInfo();
                    }
                    break;
                case 4:
                    System.out.println("\n-------- Ders Listesi ---------");
                    for (Lesson lesson : lessons) {
                        lesson.printLessonInfo();
                    }
                    break;
                case 5:
                    System.out.println("\n--------- Öğrenci Seçimi ve Ders Ekleme ---------");
                    System.out.println("Öğrenci Listesi:");
                    for (int j = 0; j < students.size(); j++) {
                        System.out.println((j + 1) + " " + students.get(j).getFirstName() + " " + students.get(j).getLastName());
                    }
                    System.out.println("Bir öğrenci seçin(numarasıyla yazınız): ");
                    int studentIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (studentIndex >= 0 && studentIndex < students.size()) {
                        Student secilenStudent = students.get(studentIndex);

                        System.out.println("Ders Listesi: ");
                        List<Lesson> degerLessons = new ArrayList<>(lessons);
                        degerLessons.removeAll(secilenStudent.getLessons());

                        for (int m = 0; m < degerLessons.size(); m++) {
                            System.out.println((m + 1) + " " + degerLessons.get(m).getName());
                        }
                        System.out.println("Bir ders seçiniz: ");
                        int lessonIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (lessonIndex >= 0 && lessonIndex < degerLessons.size()) {
                            Lesson secilenLesson = degerLessons.get(lessonIndex);
                            secilenStudent.addLesson(secilenLesson);
                            System.out.println("öğrenci (" + secilenStudent.getFirstName() + ") derse (" + secilenLesson.getName() + ") eklendi.");
                        } else {
                            System.out.println("hatalı komut.");
                        }
                    } else {
                        System.out.println("hatalı komut.");
                    }
                    break;
               
                case 6:
                    System.out.println("\n--------- Not Girimi ---------");
                    System.out.println("Öğrenci Listesi:");
                    for (int k = 0; k < students.size(); k++) {
                        System.out.println((k + 1) + " " + students.get(k).getFirstName() + " " + students.get(k).getLastName());
                    }
                    System.out.println("Bir öğrenci seçin:");
                    int studentIndexForNot = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (studentIndexForNot >= 0 && studentIndexForNot < students.size()) {
                        Student secilenStudentForNot = students.get(studentIndexForNot);
                        System.out.println("Ders Listesi:");
                        for (int l = 0; l < secilenStudentForNot.getLessons().size(); l++) {
                            System.out.println((l + 1) + ". " + secilenStudentForNot.getLessons().get(l).getName());
                        }
                        System.out.println("Bir ders seçin:");
                        int lessonIndexForNot = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (lessonIndexForNot >= 0 && lessonIndexForNot < secilenStudentForNot.getLessons().size()) {
                            Lesson secilenLessonForNot = secilenStudentForNot.getLessons().get(lessonIndexForNot);

                            if (!secilenLessonForNot.hasGrade(secilenStudentForNot)) 
                            { 
                                System.out.println("Vize notunu girin: ");
                                int vizeNot = scanner.nextInt();
                                System.out.println("Final notunu girin: ");
                                int finalNot = scanner.nextInt();
                                scanner.nextLine();

                                Grades grade = new Grades(secilenLessonForNot, secilenStudentForNot, vizeNot, finalNot);
                                secilenLessonForNot.addGrade(grade); 
                                grade.printGradeInfo();
                            }
                            else 
                            {
                                System.out.println("Bu ders için daha önce not girilmiş.");
                            }
                        } 
                        else
                        {
                            System.out.println("hatalı.");
                        }
                    } 
                    else 
                    {
                        System.out.println("hatalı.");
                    }
                    break;

                  
                case 7: System.out.println("\n---------- Dersi Alan Öğrencileri Listele ----------");
                System.out.println("Ders Listesi:");
                for (int i = 0; i < lessons.size(); i++) 
                {
                	System.out.println((i + 1) + " " + lessons.get(i).getName());
                	} 
                System.out.println("Bir ders seçin:"); 
                int lessonIndexSıra = scanner.nextInt() - 1; 
                scanner.nextLine();
              
                if (lessonIndexSıra >= 0 && lessonIndexSıra < lessons.size())     
                { 
                	Lesson secilenLessonToDisplay = lessons.get(lessonIndexSıra);
                	secilenLessonToDisplay.printStudentsTakingLesson(); 
                }
                else { 
                	System.out.println("hatali.");
                	} 
                break;
  
                case 8:
                    System.out.println("çıkış yapılıyor....");
                    break;
           
            }
            System.out.println();
        }

        scanner.close();
    }
}



