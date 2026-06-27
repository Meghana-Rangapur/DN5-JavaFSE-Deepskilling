import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunExercise7 {
    public static void main(String[] args) {
        // 1. Initialize Spring context container (reads the component-scan from applicationContext.xml)
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Retrieve the BookService bean
        BookService service = (BookService) context.getBean("bookService");

        // 3. Run the service method to see which injection method Spring used automatically
        System.out.println("--- Testing Exercise 7 Injection ---");
        service.runService();
    }
}