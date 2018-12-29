package ru.bellintegrator.practice.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.employee.EmployeeDao;
import ru.bellintegrator.practice.dao.office.OfficeDao;
import ru.bellintegrator.practice.model.Employee;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.model.response.Response;
import ru.bellintegrator.practice.view.EmplView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao dao;
    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao dao, OfficeDao officeDao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.officeDao = officeDao;
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
        Map<String, Object> map = new HashMap<>();
        if (Objects.nonNull(emplView)) {
            map.put("officeId", emplView.getOfficeId());
            map.put("firstName", emplView.getFirstName());
            map.put("secondName", emplView.getSecondName());
            map.put("middleName", emplView.getLastName());
            map.put("position", emplView.getPosition());
            map.put("docCode", emplView.getDocCode());
            map.put("citizenshipCode", emplView.getCitizenshipCode());
        }
        List<Employee> employees = dao.list(map);
        return mapperFacade.mapAsList(employees, EmplView.class);
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
        Office office = officeDao.getOffice(emplView.getOfficeId());

        Employee employee = mapperFacade.map(emplView, Employee.class);
        dao.save(employee);
        office.addEmployee(employee);
        return new Response().setSucceess(true);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmplView> all() {
        List<Employee> list = dao.all();
        return mapperFacade.mapAsList(list, EmplView.class);
    }
}
