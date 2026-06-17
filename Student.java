import java.util.HashMap;
import java.util.Map;

public class Student {

    private int id;
    private String name;
    private HashMap<String, Double> subjects;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;

        subjects = new HashMap<>();

        // Fixed subjects
        subjects.put("Java", 0.0);
        subjects.put("Database", 0.0);
        subjects.put("C Programming", 0.0);
        subjects.put("Operating System", 0.0);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Double> getSubjects() {
        return subjects;
    }

    public void setMarks(String subject, double marks) {
        if (subjects.containsKey(subject)) {
            subjects.put(subject, marks);
        }
    }

    public double getAverage() {
        double total = 0;

        for (double m : subjects.values()) {
            total += m;
        }

        return total / subjects.size();
    }

    public String getGrade() {
        double avg = getAverage();

        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }

    public void displaySubjects() {
        System.out.println("\n--- Subject Marks ---");
        for (Map.Entry<String, Double> e : subjects.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}