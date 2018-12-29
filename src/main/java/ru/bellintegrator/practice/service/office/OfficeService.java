package ru.bellintegrator.practice.service.office;

import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.model.response.Response;

import java.util.List;

public interface OfficeService {

    /**
     *Добавить офис в БД
     */
    Response save(OfficeView officeView);

    /**
     * найти офис по id
     */
    OfficeView getOffice(Long id);

    /**
     * Получить список офисов, принадлежащих конкретной организации, который можно отсортировать по name/phone/isActive
     */
    List<OfficeView> list(OfficeView officeView);

    /**
     * Обновить информацию об офисе
     */
    Response update(OfficeView officeView);

    /**
     * получить список всех офисов
     */
    List<OfficeView> all();
}
