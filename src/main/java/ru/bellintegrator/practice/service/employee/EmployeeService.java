package ru.bellintegrator.practice.service.employee;

import ru.bellintegrator.practice.model.response.Response;
import ru.bellintegrator.practice.view.EmplView;

import java.util.List;

public interface EmployeeService {
    /**
     *найти работника по id
     */
    EmplView getEmployee(Long id);

    /**
     *список всех работников, отсортированный по офису и т.д.
     */
    List<EmplView> list(EmplView emplView);

    /**
     * обновить информацию о работнике
     */
    Response update(EmplView emplView);

    /**
     * добавить работника
     */
    Response save(EmplView emplView);

    /**
     * список всех работников
     */
    List<EmplView> all();

}
