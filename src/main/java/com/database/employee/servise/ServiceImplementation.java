package com.database.employee.servise;

import com.database.employee.entity.EntityDatabase;
import com.database.employee.model.Model;
import com.database.employee.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ServiceImplementation implements Services {
    @Autowired
    private Repository repository;
    @Override
    public List<EntityDatabase> getAllEmployee() {
        return repository.findAll();
    }

    @Override
    public EntityDatabase getEmployeeById(long id) {
        Optional<EntityDatabase> optionalModel = repository.findById(id);
        if (optionalModel.isPresent()){
            return optionalModel.get();
        }
        return null;
    }

    @Override
    public List<EntityDatabase> addEmployee(List<Model> models) {
        UUID uuid = UUID.randomUUID();
        List<EntityDatabase> collect = models.stream().map(model -> EntityDatabase
                .builder().uuid(String.valueOf(uuid)).name(model.getName())
                .age(model.getAge())
                .designation(model.getDesignation())
                .build()).collect(Collectors.toList());
        return repository.saveAll(collect);
    }

    @Override
    public EntityDatabase updateEmployeeById(Model model, long id) {
        Optional<EntityDatabase> findId = repository.findById(id);
        UUID uuid = UUID.randomUUID();
        if (findId.isPresent()){
            EntityDatabase entityDatabase1 = findId.get();
            entityDatabase1.setId(id);
            entityDatabase1.setUuid(findId.get().getUuid());
            entityDatabase1.setName(model.getName());
            entityDatabase1.setAge(model.getAge());
            entityDatabase1.setDesignation(model.getDesignation());
            return repository.save(entityDatabase1);
        }
        return null;
    }

    @Override
    public void deleteEmployeeById(long id) {
        repository.deleteById(id);
    }
}
