import java.util.ArrayList;

/**
 * 
 */
//Need to return a csv of non-progressers
public class Department {
    private String name;
    private ArrayList<Student> students;
    ArrayList<Student> results;
    ArrayList<Student> listOfNonProgressions;

    public void addEnrolledStudent(Student student) {
        students.add(student);
    }

    public void examBoard() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            boolean progression = progression(QCACalculator.calculateQCA(student.getSessionResults()), student.getSessionResults());
            if (progression) {
                student.toTranscript(true);
            } else {
                listOfNonProgressions.add(student);
            }
        }
    }

    public boolean progression(double qca, ArrayList<Result> results) {
        if ((qca >= 2.00) && !results.contains("F") && !results.contains("NG")) {
            return true;
        } else if (results.contains("D1") && results.contains("D2") && qca < 2.00) {
            return false;
        } else {
            return false;
        }
    }
}
