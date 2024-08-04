package com.example.todolist.todolist.todolist;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findAll() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );
        return todoRepository.findAll(sort);
    }

    public void delete(Long id) {
        if (id == null) {
            return;
        }

        todoRepository.deleteById(id);
    }

    public Todo findById(Long id) {
        if (id == null) {
            return null;
        }
        return todoRepository.findById(id).get();
    }
}
