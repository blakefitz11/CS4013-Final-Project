import java.util.ArrayList;

/**
 * Store student results (grades in modules each semester) and should perform QCA calculations per
 * semester/year/programme (and others as deemed necessary) for the different types of programmes available in UL
 */
public class Student {
    private String name;
    private String id;
    private String email;
    private Programme programme;
    private ArrayList<Module> completedModules;
    private ArrayList<Module> currentModules;
    private int currentSemester;
    private Transcript personalTranscript;
    private final double CREDITS_PER_SEMESTER = 30.00;
    private ArrayList<Result> moduleResults;
    private ArrayList<Result> sessionResults;
    private ArrayList<Result> firstYearResults;
    private ArrayList<Result> finalResultsForQCA;
    private Department department;

    public Student(String name, String id, String email, Programme programme, int currentSemester, Department department){
        this.name = name;
        this.id = id;
        this.email = email;
        this.programme = programme;
        this.currentSemester = currentSemester;
        this.moduleResults = new ArrayList<>();
        this.department = department;
        completedModules();
        currentModules();
        enrollInModules();
        currentSessionResults();
        firstYearResults();
        finalResultsForQCA();
        enrollInDepartment();
        this.personalTranscript = new Transcript();
    }

    //Enrolls the student into the department
    private void enrollInDepartment(){
        department.addEnrolledStudent(this);
    }

    //Enrolls the student into all modules that they've completed and are completing.
    private void enrollInModules() {
        for(int n = 0; n < completedModules.size(); n++){
            Module module = completedModules.get(n);
            module.addEnrolledStudent(this);
        }
        for(int m =0; m < currentModules.size(); m++) {
            Module module = currentModules.get(m);
            module.addEnrolledStudent(this);
        }
    }

    //Generates an arrayList of the completedModules by the Student.
    private void completedModules(){
        currentSemester--;
        double completedCredits = currentSemester * CREDITS_PER_SEMESTER;
        double credits = 0;
        int i = 0;
        while (credits < completedCredits){
            Module module = programme.getModuleFromList(i);
            credits += module.getCredits();
            completedModules.add(programme.getModuleFromList(i));
            i++;
        }
    }

    // Generates an arrayList of the currentModules being examined.
    private void currentModules() {
        ArrayList<Module> modulesLeft = new ArrayList<>(programme.getModules());
        modulesLeft.removeAll(completedModules);

        double credits = 0;
        int k = 0;
        while (credits < CREDITS_PER_SEMESTER && k < modulesLeft.size()) {
            Module module = modulesLeft.get(k);
            credits += module.getCredits();
            currentModules.add(module);
            k++;
        }
    }

    //Adds results to the result list.
    public void addResult(Module module, String grade){
        Result result = new Result(module, grade);
        moduleResults.add(result);
    }

    //Generates an arrayList of the results from the current session
    public void currentSessionResults(){
        for (Result result : moduleResults){
            Module module = result.getModule();
            if (currentModules.contains(module)){
                sessionResults.add(result);
            }
        }
    }

    //Generates an arrayList of the results achieved in first year.
    public void firstYearResults(){
        double FIRST_YEAR_CREDITS = 2 * CREDITS_PER_SEMESTER;
        double credits = 0;
        int l = 0;
        while (credits < FIRST_YEAR_CREDITS){
            Result result = moduleResults.get(l);
            credits += result.getModule().getCredits();
            firstYearResults.add(moduleResults.get(l));
            l++;
        }
    }

    //Generate the final results for QCA
    public void finalResultsForQCA(){
        ArrayList<Result> resultsLeft = moduleResults;
        resultsLeft.removeAll(firstYearResults);
        finalResultsForQCA = resultsLeft;
    }

    public void toTranscript(boolean progression) {
        if (progression) {
            personalTranscript.addSemester(sessionResults);
        }
    }


    //GETTERS:
    public ArrayList<Module> getCompletedModules() {
        return completedModules;
    }
    public String getName() {
        return name;
    }
    public Programme getProgramme() {
        return programme;
    }
    public String getEmail() {
        return email;
    }
    public String getId() {
        return id;
    }
    public ArrayList<Result> getSessionResults(){
        return sessionResults;
    }


    public int getCurrentSemester() {
        return currentSemester;
    }

    public ArrayList<Result> getModulesResults() {
        return moduleResults;
    }
}
