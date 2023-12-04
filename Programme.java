import java.util.ArrayList;

public class Programme {
    private String name;
    private String id;
    private int semesters;
    private ArrayList<Module> modules;

/**
     * Constructor for programme takes: name, id, semesters
     * @param name
     * @param id
     * @param semesters
     */
    
    public Programme(String name, String id, int semesters){
        this.name = name;
        this.id = id;
        this.semesters = semesters;
        this.modules = new ArrayList<>();
    }

/**
     * Adds module
     * @param module
     */
    
    public void addModule(Module module){
        modules.add(module);
    }

/**
     * Returns the ith module
     * @param i
     * @return
     */
    
    public Module getModuleFromList(int i) {
        return modules.get(i);
    }

    public ArrayList<Module> getModules(){
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public String getName() {
        return name;
    }
}
