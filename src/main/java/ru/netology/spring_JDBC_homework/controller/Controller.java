package ru.netology.spring_JDBC_homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.spring_JDBC_homework.repository.MyRepository;

@RestController
public class Controller {

    private MyRepository repository;

    public Controller(MyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public String getProduct(@RequestParam("name") String name) {
        return repository.getProductName(name);
    }
}
