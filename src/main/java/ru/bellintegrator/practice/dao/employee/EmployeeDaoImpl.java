package ru.bellintegrator.practice.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Employee> list(Employee employee) {
        return null;
    }

    @Override
    public void update(Employee employee) {
        Employee existingEmpl = em.find(Employee.class, employee.getId());
        existingEmpl.setFirstName(employee.getFirstName());
        existingEmpl.setSecondName(employee.getSecondName());
        existingEmpl.setLastName(employee.getLastName());
        existingEmpl.setPosition(employee.getPosition());
        existingEmpl.setPhone(employee.getPhone());
        existingEmpl.setDocName(employee.getDocName());
        existingEmpl.setDocNumber(employee.getDocNumber());
        existingEmpl.setDocDate(employee.getDocDate());
        existingEmpl.setDocCode(employee.getDocCode());
        existingEmpl.setCitizenshipCode(employee.getCitizenshipCode());
        existingEmpl.setIsIdentified(employee.getIsIdentified());
    }

    @Override
    public void save(Employee employee) {
        em.persist(employee);
    }

    @Override
    public List<Employee> all(){
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
}
