import java.util.List;

import com.example.todolist.todolist.todolist.Todo;
import com.example.todolist.todolist.todolist.TodoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> list() {
        return todoService.findAll();
    }

    @PostMapping
    public List<Todo> save(@RequestBody Todo todo) {
        todoService.save(todo);
        return todoService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

    @PutMapping
    public List<Todo> update(@RequestBody Todo todo) {
        todoService.save(todo);
        return todoService.findAll();
    }

}