package bootstrap;

import model.Todo;
import model.TodoStatus;
import repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TodoLoader implements CommandLineRunner {
    public final TodoRepository TodoRepository;

    public TodoLoader(TodoRepository TodoRepository) {
        this.TodoRepository = TodoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTodos();
    }

    private void loadTodos() {
        if (TodoRepository.count() == 0) {
            TodoRepository.save(
                    new Todo("test","test", TodoStatus.COMPLETED)
            );
            
            TodoRepository.save(
            		new Todo("test1","test1", TodoStatus.COMPLETED)
            );
            System.out.println("Sample Todos Loaded");
        }
    }
}
