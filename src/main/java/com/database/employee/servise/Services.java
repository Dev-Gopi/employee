package com.database.employee.servise;

import com.database.employee.entity.EntityDatabase;
import com.database.employee.model.Model;

import java.util.List;

public interface Services {
    public List<EntityDatabase> getAllEmployee();

    public EntityDatabase getEmployeeById(long id);

    public  List<EntityDatabase> addEmployee(List<Model> models);

    public EntityDatabase updateEmployeeById(Model model, long id);

    public void deleteEmployeeById(long id);
}
