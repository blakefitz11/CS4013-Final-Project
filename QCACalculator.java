import java.util.ArrayList;

public class QCACalculator {
    public static double calculateQCA(ArrayList<Result> results) {
        double totalCredits = 0;
        double weightedSum = 0;

        for (Result result : results) {
            totalCredits += result.getModule().getCredits();
            double moduleCredits = 0;
            weightedSum +=  moduleCredits * gradeToNumeric(result.getGrade());
        }
        double qca = 0.00;
        if (totalCredits == 0){
            qca = 0;
        } else {
            qca = weightedSum / totalCredits;
        }
            return qca;
    }

/**
     * Takes the grade and returns their Qca equivalent
     * @param grade
     * @return
     */
    
    private static double gradeToNumeric(String grade){
        if (grade.equals("A1")){
            return 4.00;
        } else if (grade.equals("A2")){
            return 3.60;
        } else if (grade.equals("B1")){
            return 3.20;
        } else if (grade.equals("B2")){
            return 3.00;
        } else if (grade.equals("B3")){
            return 2.80;
        } else if (grade.equals("C1")){
            return 2.60;
        } else if (grade.equals("C2")){
            return 2.40;
        } else if (grade.equals("C3")){
            return 2.00;
        } else if (grade.equals("D1")){
            return 1.60;
        } else if (grade.equals("D2")){
            return 1.20;
        } else {
            return 0.00;
        }
    }
}
