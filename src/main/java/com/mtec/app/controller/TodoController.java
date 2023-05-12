package com.mtec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtec.app.controller.model.Task;
import com.mtec.app.repository.TodoRepository;

@RestController
public class TodoController {
	@Autowired
     private TodoRepository todoRepository;
	@GetMapping(value = "/")
	public String holamundo() {
		return "Hola Mundo";
	}

	@GetMapping(value = "/tasks")
	public List<Task> getTasks() {
		return todoRepository.findAll();
	}
	@PostMapping("/saveTask")
	public String saveTask(@RequestBody Task task) {
	    todoRepository.save(task);
	    return "Saved task";
	}

	@PutMapping(value="/update/{id}")
	public String updateTask(@PathVariable Long id, @RequestBody Task task) {
		Task updatedTask = todoRepository.findById(id).get();
		updatedTask.setTitle(task.getTitle());
		updatedTask.setDescripcion(task.getDescripcion());
		todoRepository.save(updatedTask);
		return "Update Task";
	}
	@DeleteMapping(value="delete/{id}")
	public String deleteTask(@PathVariable Long id) {
		Task deleteTask = todoRepository.findById(id).get();
		todoRepository.delete(deleteTask);
		return "Delete Task";
		
	}



}
