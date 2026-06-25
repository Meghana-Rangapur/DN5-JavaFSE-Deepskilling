package MockitoExercises;

public class MyService {


    private final ExternalAPI api;

    // Dependency Injection: Pass the API interface into the constructor
    public MyService(ExternalAPI api) {
        this.api = api;
    }

    public String fetchData() {
        // Interacting with dependency
        return String.valueOf(api.getData());
    }

    public void process(String payload) {
        api.processData(payload);
    }

    public void runWorkflow() {
        // Simulates an ordered workflow execution
        api.executeAction("Step 1");
        api.executeAction("Step 2");
    }
}
