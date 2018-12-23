package ru.bellintegrator.practice.dao.employee;

import ru.bellintegrator.practice.model.Employee;

import java.util.Set;

public interface EmployeeDao {

    /**
     * список работников(проверить Тз)
     * @return
     */
//    Set<Employee> getListOfEmployee();

    /**
     * найти сотрудника по id
     * @param emplId
     * @return
     */
    Employee getById(Long emplId);

    /**
     * обновить данные сотрудника
     * @param employee
     */
//    void update(Employee employee);

    /**
     * добавить сотрудника
     * @param employee
     */
//    void save(Employee employee);
}
