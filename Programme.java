import java.util.ArrayList;

/**
 *
 */
public class Programme {
    private String name;
    private String id;
    private int semesters;
    private ArrayList<Module> modules;

    public Programme(String name, String id, int semesters){
        this.name = name;
        this.id = id;
        this.semesters = semesters;
        this.modules = new ArrayList<>();
    }
    public void addModule(Module module){
        modules.add(module);
    }

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
