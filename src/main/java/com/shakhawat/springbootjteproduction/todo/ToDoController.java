package com.shakhawat.springbootjteproduction.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ToDoController {

    @GetMapping("/")
    public String getTodos(Model model) {
        ToDo[] todos = new ToDo[]{
                new ToDo(1L, "Task 1", "Description 1", false),
                new ToDo(2L, "Task 2", "Description 2", true),
                new ToDo(3L, "Task 3", "Description 3", false),
                new ToDo(4L, "Task 4", "Description 4", true)
        };

        List<ToDo> todoList = List.of(todos);

        model.addAttribute("todos", todoList);
        model.addAttribute("pageTitle", "To Do List");

        return "index";
    }

}
