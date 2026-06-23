class Task {
    int taskId;
    String taskName;
    String status;
    Task next;   // reference to next node

    // Constructor
    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    // Display task details
    public void display() {
        System.out.println("Task ID: " + taskId +
                ", Task Name: " + taskName +
                ", Status: " + status);
    }
}

class TaskManagementSystem {
    private Task head;   // first node of linked list

    // Add task at end
    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);

        // If list is empty
        if (head == null) {
            head = newTask;
            System.out.println("Task added successfully.");
            return;
        }

        // Traverse to last node
        Task temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newTask;
        System.out.println("Task added successfully.");
    }

    // Search task by ID
    public Task searchTask(int taskId) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == taskId) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    // Traverse all tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        System.out.println("Task List:");
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    // Delete task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        // If first node is the task to delete
        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task temp = head;

        // Find the node before the one to delete
        while (temp.next != null && temp.next.taskId != taskId) {
            temp = temp.next;
        }

        // If task not found
        if (temp.next == null) {
            System.out.println("Task not found.");
            return;
        }

        // Delete node
        temp.next = temp.next.next;
        System.out.println("Task deleted successfully.");
    }
}

public class TaskManagementDemo {
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        // Add tasks
        tms.addTask(1, "Complete Assignment", "Pending");
        tms.addTask(2, "Prepare Presentation", "In Progress");
        tms.addTask(3, "Attend Meeting", "Completed");

        // Traverse tasks
        System.out.println("\nAll Tasks:");
        tms.traverseTasks();

        // Search task
        System.out.println("\nSearching for Task ID 2:");
        Task found = tms.searchTask(2);
        if (found != null) {
            found.display();
        } else {
            System.out.println("Task not found.");
        }

        // Delete task
        System.out.println("\nDeleting Task ID 2:");
        tms.deleteTask(2);

        // Traverse after deletion
        System.out.println("\nTasks after deletion:");
        tms.traverseTasks();
    }
}