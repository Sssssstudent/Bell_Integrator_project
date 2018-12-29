package ru.bellintegrator.practice.service.organization;


import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.model.response.Response;
import ru.bellintegrator.practice.view.OrgView;

import java.util.List;

@Validated
public interface OrganizationService {

    /**
     *получить организации по id
     */

    OrgView getOrg(Long id);

    /**
     *сохранить организацию
     */
    Response save(OrgView orgView);

    /**
     * обновить данные организации
     */
    Response update(OrgView orgView);

    /**
     * получить список организаций,отсортированных по параметрам name/inn/isActive
     */
    List<OrgView> getList(OrgView orgView);

    /**
     * получить список всех организаций
     */
    List<OrgView> all();
}
