import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunExercise2 {
    public static void main(String[] args) {
        // 1. Initialize the Spring context container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Retrieve ONLY the bookService bean. 
        // We do not manually request bookRepository anymore because Spring handles the wiring!
        BookService service = (BookService) context.getBean("bookService");

        // 3. Execute the service method to verify the injection works
        service.runService();
    }
}