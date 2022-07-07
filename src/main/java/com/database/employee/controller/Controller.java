package com.database.employee.controller;

import com.database.employee.entity.EntityDatabase;
import com.database.employee.model.Model;
import com.database.employee.servise.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {
    @Autowired
    private Services service;
    @RequestMapping("/")
    public String welcome(){
        return "Welcome to my Spring project";
    }
    @GetMapping("/get")
    public List<EntityDatabase> getAllEmployee() {
        return this.service.getAllEmployee();
    }
    @GetMapping("/get/{id}")
    public EntityDatabase getEmployeeById(@PathVariable long id) {
        return this.service.getEmployeeById(id);
    }
    @PostMapping("/add")
    public List<EntityDatabase> addEmployee(@RequestBody List<Model> models) {
        return this.service.addEmployee(models);
    }

    @PutMapping("/update/{id}")
    public EntityDatabase updateEmployee(@RequestBody Model model, @PathVariable long id) {
        return this.service.updateEmployeeById(model, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable long id) {
        try {
            this.service.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
