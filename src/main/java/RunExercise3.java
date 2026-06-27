import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunExercise3 {
    public static void main(String[] args) {
        // 1. Initialize Spring IoC container container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Retrieve the proxy-wrapped bean out of the container
        BookService service = (BookService) context.getBean("bookService");

        System.out.println("--- Starting Execution Testing ---");
        // 3. Trigger execution to see the aspect log output automatically
        service.runService();
        System.out.println("--- End of Execution Testing ---");
    }
}