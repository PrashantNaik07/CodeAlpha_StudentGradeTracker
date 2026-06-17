import java.util.ArrayList;

public class GradeTracker {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    // View Students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.printf("%-5s %-15s %-10s %-10s%n",
                "ID", "Name", "Average", "Grade");

        for (Student s : students) {
            System.out.printf("%-5d %-15s %-10.2f %-10s%n",
                    s.getId(),
                    s.getName(),
                    s.getAverage(),
                    s.getGrade());
        }
    }

    // Search
    public Student search(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    // Update Marks
    public void updateMarks(int id, String subject, double marks) {
        Student s = search(id);

        if (s != null) {
            s.setMarks(subject, marks);
            System.out.println("Marks updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Delete
    public void delete(int id) {
        Student s = search(id);

        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Rank List
    public void showRankList() {

        students.sort((a, b) ->
                Double.compare(b.getAverage(), a.getAverage()));

        System.out.println("\n===== RANK LIST =====");

        int rank = 1;

        for (Student s : students) {
            System.out.println(rank++ + ". " +
                    s.getName() +
                    " - Avg: " + String.format("%.2f", s.getAverage()) +
                    " (" + s.getGrade() + ")");
        }
    }

    // ⭐ CLASS REPORT (NEW FEATURE)

    public void classReport() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).getAverage();
        double lowest = students.get(0).getAverage();

        for (Student s : students) {

            double avg = s.getAverage();
            total += avg;

            if (avg > highest) highest = avg;
            if (avg < lowest) lowest = avg;
        }

        double classAvg = total / students.size();

        System.out.println("\n===== CLASS REPORT =====");
        System.out.println("Class Average : " + String.format("%.2f", classAvg));
        System.out.println("Highest Score : " + String.format("%.2f", highest));
        System.out.println("Lowest Score  : " + String.format("%.2f", lowest));
    }
}