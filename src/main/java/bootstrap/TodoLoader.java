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
                    Todo.builder()
                            .title("Go to market")
                            .description("Buy eggs from market")
                            .TodoStatus(TodoStatus.NOT_COMPLETED)
                            .build() ; 
                    new Todo("Go to market", "Buy eggs from market", TodoStatus.NOT_COMPLETED)
            );
            
            TodoRepository.save(
                    Todo.builder()
                            .title("Go to school")
                            .description("Complete assignments")
                            .TodoStatus(TodoStatus.NOT_COMPLETED)
                            .build()
            );
            System.out.println("Sample Todos Loaded");
        }
    }
}
