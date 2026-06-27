import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunExercise1 {
    public static void main(String[] args) {
        // 1. Initialize the Spring Context by loading applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Fetch the created bean objects from the Spring IoC Container
        BookRepository repository = (BookRepository) context.getBean("bookRepository");
        BookService service = (BookService) context.getBean("bookService");

        // 3. Trigger the methods to verify everything works flawlessly
        repository.saveData();
        service.runService();
    }
}