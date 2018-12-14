package ru.bellintegrator.practice.service.employee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.view.EmplView;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //private final EmployeeDao dao;

    @Override
    @Transactional
    public EmplView getEmpl(Long id){return new EmplView(id);}

}
