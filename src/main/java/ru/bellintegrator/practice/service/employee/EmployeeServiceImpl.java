package ru.bellintegrator.practice.service.employee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.view.EmplView;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //private final EmployeeDao dao;

    @Override
    @Transactional
    public EmplView getEmpl(Long id){
        EmplView view = new EmplView();
        view.setId(id);
        view.setFirstName("Чаплин");
        view.setSecondName("Гротеск");
        view.setLastName("Павлович");
        view.setPosition("TeamLead");
        view.setPhone("8-666-666-90-90");
        view.setDocCode(21L);
        view.setDocName("Паспорт РФ");
        view.setDocNumber(1111111111L);
        view.setDocDate("1994-09-01");
        view.setCitizenshipCode(61L);
        view.setIdentefied(true);
        return view;
    }

}
