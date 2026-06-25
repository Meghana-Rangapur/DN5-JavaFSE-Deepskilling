package MockitoAdvanced;

public class Service {
    private final Repository repository;

    // Constructor Injection
    public Service(Repository repository) {
        this.repository = repository;
    }

    public String processData() {
        String rawData = repository.getData();
        return "Processed " + rawData;
    }
}
