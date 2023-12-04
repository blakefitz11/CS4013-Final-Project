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
        // Replace "student" with the actual reference to your Student object
        Student student = getStudent(); 

        // Header for the Transcript the student can see
        System.out.println("Name: " + student.getName() + " | ID: " + student.getId());
        System.out.println("Degree: " + student.getProgramme().getName());
        System.out.println("Semester: " + student.getCurrentSemester() +
                " | Session QCA: " + QCACalculator.calculateQCA(student.getSessionResults()) +
                " | Overall QCA: " + calculateOverallQCA());

        // Table header
        System.out.printf("%-8s%-30s%-4s%-3s\n", "CODE", "NAME", "CREDITS", "GRADE");

        // Student result data table
        for (Result result : results) {
            Module module = result.getModule();
            System.out.printf("%-8s%-30s%-4.2f%-3s\n", module.getCode(), module.getName(),
                    module.getCredits(), result.getGrade());
        }
    }

    private double calculateOverallQCA() {
        Student student = getStudent(); 
        ArrayList<Result> completedResults = student.getModulesResults();

        return QCACalculator.calculateQCA(completedResults);
    }

    private Student getStudent() {
        // Retrieve the Student not done yet
        return null;
    }
}
