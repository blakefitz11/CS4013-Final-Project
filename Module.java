import java.util.ArrayList;
/**
 *
 */
public class Module {
    private String name;
    private String code;
    private double credits;
    private ArrayList<Student> enrolledStudents;

    public Module(String name, String code, double credits){
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
    }

/**
     * This will add the enrolled Students 
     * @param student
     */
    
    public void addEnrolledStudent(Student student){
        enrolledStudents.add(student);
    }

    //GETTERS:
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public double getCredits() {
        return credits;
    }
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}
