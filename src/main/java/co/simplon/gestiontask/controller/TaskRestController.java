package co.simplon.gestiontask.controller;

import co.simplon.gestiontask.dao.TaskRepository;
import co.simplon.gestiontask.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class TaskRestController {
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping("/")
    public String displayTasks(){
        return taskRepository.findAll().stream().map(Task::getName).collect(Collectors.joining());
    }
    @PostMapping("/addTask/{name}")
    public void postTask(@PathVariable("name") String name){
        taskRepository.save(new Task(null,name));
    }
}
