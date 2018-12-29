package ru.bellintegrator.practice.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.employee.EmployeeDao;
import ru.bellintegrator.practice.model.Employee;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.model.response.Response;
import ru.bellintegrator.practice.view.EmplView;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public EmplView getEmployee(Long id){
        Employee employee = dao.getById(id);
        return mapperFacade.map(employee, EmplView.class);
    }

    @Override
    @Transactional
    public List<EmplView> list(EmplView emplView) {
        Employee employee = mapperFacade.map(emplView, Employee.class);
        List<Employee> list = dao.list(employee);
        return mapperFacade.mapAsList(list, EmplView.class);
    }

    @Override
    @Transactional
    public Response update(EmplView emplView) {
        Employee employee = mapperFacade.map(emplView,Employee.class);
        dao.update(employee);
        return new Response().setSucceess(true);
    }

    @Override
    @Transactional
    public Response save(EmplView emplView) {
        Employee employee = mapperFacade.map(emplView, Employee.class);
        dao.save(employee);
        return new Response().setSucceess(true);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmplView> all() {
        List<Employee> list = dao.all();
        return mapperFacade.mapAsList(list, EmplView.class);
    }
}
