package at.va.todos.todos.controler;

import at.va.todos.todos.model.Todo;
import at.va.todos.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/todos/post")
    public Todo postTask(@Valid @RequestBody Todo todo) {
        return todoRepository.save(todo);
    }


    @DeleteMapping(value = "/todos/remove/{id}")
    public ResponseEntity deleteTask(@PathVariable(value = "id") Integer id) {
        todoRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/todos/put/{id}")
    public ResponseEntity changeTask(@PathVariable(value = "id") Integer id) {
        Todo todo = todoRepository.getOne(id);
        todoRepository.getOne(id).setTaskDone(!todoRepository.getOne(id).getTaskDone());
        todoRepository.save(todoRepository.getOne(id));
        return new ResponseEntity(HttpStatus.OK);
    }

}
