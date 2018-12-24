package ru.bellintegrator.practice.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Employee;

import javax.persistence.EntityManager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final EntityManager em;

    @Autowired
    public EmployeeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Employee getById(Long id) {
        return em.find(Employee.class, id);
    }
}
