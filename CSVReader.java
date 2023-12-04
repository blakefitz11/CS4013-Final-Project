import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader implements AutoCloseable {
    private String filePath;
    private BufferedReader reader;

    public CSVReader(String filePath) throws IOException {
        this.filePath = filePath;
        this.reader = new BufferedReader(new FileReader(filePath));
    }

    public String[] readNext() throws IOException {
        if (reader != null && reader.ready()) {
            String line = reader.readLine();
            if (line != null) {
                return line.split(",");
            }
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public static void main(String[] args) {
        // Assuming you have CSV files named "programmes.csv", "students.csv", "faculty.csv", "modules.csv"
        readModules("modules.csv");
        readProgrammes("programmes.csv");
        readStudents("students.csv");
        readFaculty("faculty.csv");
    }

    public static void readModules(String filename) {
        try (CSVReader reader = new CSVReader(filename)) {
            String[] headers = reader.readNext(); 
            if (headers != null) {
                String[] line;
                while ((line = reader.readNext()) != null) {
                    String name = line[0];
                    String code = line[1];
                    double credits = Double.parseDouble(line[2]);

                    Module module = new Module(name, code, credits);
                    // Process or store the created module as needed
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace(); 
        }
    }

    private static void readProgrammes(String filename) {
        try (CSVReader reader = new CSVReader(filename)) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                // Assuming the CSV structure is: name, id, semesters
                String name = line[0];
                String id = line[1];
                int semesters = Integer.parseInt(line[2]);

                Programme programme = new Programme(name, id, semesters);
                // Process or store the created programme as needed
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readStudents(String filename) {
        try (CSVReader reader = new CSVReader(filename)) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                // Assuming the CSV structure is: name, id, email, programName, currentSemester, departmentName
                String name = line[0];
                String id = line[1];
                String email = line[2];
                String programName = line[3];
                int currentSemester = Integer.parseInt(line[4]);
                String departmentName = line[5];

                // Retrieve the corresponding Programme and Department objects
                Programme program = getProgramByName(programName);
                Department department = getDepartmentByName(departmentName);

                Student student = new Student(name, id, email, program, currentSemester, department);
                // Process or store the created student as needed
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFaculty(String filename) {
        try (CSVReader reader = new CSVReader(filename)) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                // Assuming the CSV structure is: moduleName, grade, studentName
                String moduleName = line[0];
                String grade = line[1];
                String studentName = line[2];

                // Retrieve the corresponding Module and Student objects
                Module module = getModuleByName(moduleName);
                Student student = getStudentByName(studentName);

                Faculty faculty = new Faculty(module, grade, student);
                // Process or store the created faculty as needed
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Programme getProgramByName(String programName) {
        // Implement code to retrieve a Programme by name
        // This might involve searching a list
        return null;
    }

    private static Department getDepartmentByName(String departmentName) {
        // Implement code to retrieve a Department by name
        // This might involve searching a list
        return null;
    }

    private static Module getModuleByName(String moduleName) {
        // Implement code to retrieve a Module by name
        // This might involve searching a list
        return null;
    }

    private static Student getStudentByName(String studentName) {
        // Implement code to retrieve a Student by name
        // This might involve searching a list
        return null;
    }
}
