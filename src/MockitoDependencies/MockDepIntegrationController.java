package MockitoDependencies;

public class MockDepIntegrationController {
    private final MockDepUserService mockDepUserService;

    public MockDepIntegrationController(MockDepUserService mockDepUserService) {
        this.mockDepUserService = mockDepUserService;
    }

    public User getUserEndpoint(Long id) {
        return mockDepUserService.getUserById(id);
    }
}
