package ru.bellintegrator.practice.service.office;

import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.ResponseView;

public interface OfficeService {

    /**
     *Добавить офис в БД
     */
    ResponseView add(OfficeView officeView);

    /**
     * найти офис по id
     */
    OfficeView getOffice(Long id);
}
