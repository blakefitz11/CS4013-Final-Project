public class Result {
    private Module module;
    private String grade;

    public Result(Module module, String grade){
        this.module = module;
        this.grade = grade;

    }
    public void addResultToStudent(Student student){
        this.module = getModule();
        this.grade = getGrade();
        student.addResult(module, grade);
    }

    public Module getModule(){
        return module;
    }
    public String getGrade() {
        return grade;
    }
}
