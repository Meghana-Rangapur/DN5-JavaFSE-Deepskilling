// Model Class
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// View Class
class StudentView {
    public void displayStudentDetails(String name, int id, String grade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------");
    }
}

// Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Update data
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    // Get data
    public String getStudentName() {
        return model.getName();
    }

    public int getStudentId() {
        return model.getId();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    // Display data
    public void updateView() {
        view.displayStudentDetails(
            model.getName(),
            model.getId(),
            model.getGrade()
        );
    }
}

// Test Class
public class MVCPatternExample {
    public static void main(String[] args) {

        // Create Model
        Student student = new Student("Megha", 101, "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Show initial data
        controller.updateView();

        // Update data using controller
        controller.setStudentName("Ananya");
        controller.setStudentGrade("A+");

        // Show updated data
        controller.updateView();
    }
}