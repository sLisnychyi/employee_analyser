package com.example.employee_analyser.repository;

import com.example.employee_analyser.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeEMRepository implements EmployeeRepository {
    private final EntityManager entityManager;

    public EmployeeEMRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee findByName(String name) {
        return entityManager.createQuery("SELECT e from Employee e where e.name=:name", Employee.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public void save(List<Employee> employees) {
        employees.forEach(entityManager::persist);
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT (id) FROM Employee", Integer.class)
                .getSingleResult();
    }

    //"SELECT name, count(*) from employee group by name"
}


