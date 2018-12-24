package ru.bellintegrator.practice.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.employee.EmployeeDao;
import ru.bellintegrator.practice.model.Employee;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.EmplView;

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

}
