package com.shakhawat.springbootjteproduction.todo;

public record ToDo(
        long id,
        String title,
        String description,
        boolean done
) {}
