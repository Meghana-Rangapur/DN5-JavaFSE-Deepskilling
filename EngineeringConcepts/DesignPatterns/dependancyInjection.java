// Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Concrete Repository (Data layer)
class CustomerRepositoryImpl implements CustomerRepository {

    public String findCustomerById(int id) {
        return "Customer with ID " + id + " found: Megha";
    }
}

// Service Class (Business logic)
class CustomerService {

    private CustomerRepository repository;

    // Constructor Injection (Dependency Injection)
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void showCustomer(int id) {
        String customer = repository.findCustomerById(id);
        System.out.println(customer);
    }
}

// Test Class
public class DependencyInjectionExample {
    public static void main(String[] args) {

        // Create dependency
        CustomerRepository repo = new CustomerRepositoryImpl();

        // Inject dependency into service
        CustomerService service = new CustomerService(repo);

        // Use service
        service.showCustomer(101);
    }
}