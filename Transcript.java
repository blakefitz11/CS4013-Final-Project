import java.util.ArrayList;

public class Transcript {
    private ArrayList<Result> results;

    public Transcript() {
        this.results = new ArrayList<>();
    }

    public void addSemester(ArrayList<Result> results) {
        this.results.addAll(results);
    }

    public void createTranscript() {
        // Assuming you have a Student object to extract relevant information
        // Replace "student" with the actual reference to your Student object
        Student student = getStudent(); // Implement the logic to retrieve the Student

        // Header
        System.out.println("Name: " + student.getName() + " | ID: " + student.getId());
        System.out.println("Degree: " + student.getProgramme().getName());
        System.out.println("Semester: " + student.getCurrentSemester() +
                " | Session QCA: " + QCACalculator.calculateQCA(student.getSessionResults()) +
                " | Overall QCA: " + calculateOverallQCA());

        // Table header
        System.out.printf("%-8s%-30s%-4s%-3s\n", "CODE", "NAME", "CREDITS", "GRADE");

        // Table data
        for (Result result : results) {
            Module module = result.getModule();
            System.out.printf("%-8s%-30s%-4.2f%-3s\n", module.getCode(), module.getName(),
                    module.getCredits(), result.getGrade());
        }
    }

    private double calculateOverallQCA() {
        // Implement logic to calculate overall QCA based on all completed modules
        // You may need to access the student's completed modules and results
        // Replace "student" with the actual reference to your Student object
        Student student = getStudent(); // Implement the logic to retrieve the Student
        ArrayList<Result> completedResults = student.getModulesResults();

        return QCACalculator.calculateQCA(completedResults);
    }

    private Student getStudent() {
        // Implement logic to retrieve the Student
        // This might involve searching a list or querying a database
        // Return an actual Student object
        return null;
    }
}
