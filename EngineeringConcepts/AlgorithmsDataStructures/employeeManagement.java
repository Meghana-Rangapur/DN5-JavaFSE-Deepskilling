class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    // Constructor
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Display employee details
    public void display() {
        System.out.println("ID: " + employeeId + ", Name: " + name +
                ", Position: " + position + ", Salary: " + salary);
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int count; // number of employees currently stored

    // Constructor
    public EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add employee
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count] = emp;
            count++;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse employees
    public void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employee records found.");
            return;
        }

        System.out.println("Employee Records:");
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete employee by ID
    public void deleteEmployee(int employeeId) {
        int index = -1;

        // Find employee index
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        // Shift elements left
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee deleted successfully.");
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        // Add employees
        ems.addEmployee(new Employee(101, "Megha", "Developer", 50000));
        ems.addEmployee(new Employee(102, "Rahul", "Manager", 70000));
        ems.addEmployee(new Employee(103, "Ananya", "Tester", 45000));

        // Traverse employees
        System.out.println("\nAll Employees:");
        ems.traverseEmployees();

        // Search employee
        System.out.println("\nSearching for Employee ID 102:");
        Employee emp = ems.searchEmployee(102);
        if (emp != null) {
            emp.display();
        } else {
            System.out.println("Employee not found.");
        }

        // Delete employee
        System.out.println("\nDeleting Employee ID 102:");
        ems.deleteEmployee(102);

        // Traverse again after deletion
        System.out.println("\nEmployees after deletion:");
        ems.traverseEmployees();
    }
}