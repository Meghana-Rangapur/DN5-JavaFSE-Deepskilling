import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunExercise5 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("--- Requesting Bean 1 ---");
        BookService service1 = (BookService) context.getBean("bookService");
        service1.runService();

        System.out.println("\n--- Requesting Bean 2 ---");
        BookService service2 = (BookService) context.getBean("bookService");
        service2.runService();

        // Verify if they point to the exact same memory location
        System.out.println("\nAre both service instances identical? " + (service1 == service2));
    }
}