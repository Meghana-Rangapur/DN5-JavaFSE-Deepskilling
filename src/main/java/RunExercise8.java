import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunExercise8 {
    public static void main(String[] args) {
        // 1. Load context configuration configurations
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Fetch the monitored BookService bean
        BookService service = (BookService) context.getBean("bookService");

        System.out.println("--- Starting Aspect Validation Test ---");
        // 3. Invoke operations to verify interception rules trigger seamlessly
        service.runService();
        System.out.println("--- End of Aspect Validation Test ---");
    }
}