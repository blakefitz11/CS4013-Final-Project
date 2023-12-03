/**
 * Faculty should be able to submit results for their modules each year/semester.
 */
public class Faculty extends Result {
    public Faculty(Module module, String grade, Student student) {
        super(module, grade);
        super.addResultToStudent(student);
    }
}
