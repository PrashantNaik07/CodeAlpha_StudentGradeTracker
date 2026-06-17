import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeTracker gt = new GradeTracker();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     STUDENT GRADE TRACKER");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Class Report");
            System.out.println("7. Rank List");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    Student s = new Student(id, name);

                    System.out.println("\nEnter Marks:");

                    System.out.print("Java: ");
                    s.setMarks("Java", sc.nextDouble());

                    System.out.print("Database: ");
                    s.setMarks("Database", sc.nextDouble());

                    System.out.print("C Programming: ");
                    s.setMarks("C Programming", sc.nextDouble());

                    System.out.print("Operating System: ");
                    s.setMarks("Operating System", sc.nextDouble());

                    gt.addStudent(s);
                    break;

                case 2:
                    gt.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();

                    Student found = gt.search(sid);

                    if (found != null) {
                        System.out.println("\nName: " + found.getName());
                        found.displaySubjects();
                        System.out.println("Average: " + found.getAverage());
                        System.out.println("Grade: " + found.getGrade());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:

                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();

                    Student stu = gt.search(uid);

                    if (stu != null) {

                        System.out.println("\nChoose Subject:");
                        System.out.println("1. Java");
                        System.out.println("2. Database");
                        System.out.println("3. C Programming");
                        System.out.println("4. Operating System");

                        int ch = sc.nextInt();

                        String subject = "";

                        switch (ch) {
                            case 1: subject = "Java"; break;
                            case 2: subject = "Database"; break;
                            case 3: subject = "C Programming"; break;
                            case 4: subject = "Operating System"; break;
                            default:
                                System.out.println("Invalid choice");
                        }

                        if (!subject.equals("")) {
                            System.out.print("Enter Marks: ");
                            double marks = sc.nextDouble();

                            gt.updateMarks(uid, subject, marks);
                        }

                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    gt.delete(sc.nextInt());
                    break;

                case 6:
                    gt.classReport();
                    break;

                case 7:
                    gt.showRankList();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}