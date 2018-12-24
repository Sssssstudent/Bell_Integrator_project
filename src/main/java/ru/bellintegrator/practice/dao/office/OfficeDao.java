package ru.bellintegrator.practice.dao.office;

import ru.bellintegrator.practice.model.Office;

import java.util.Set;

public interface OfficeDao {
    /**
     * получить список офисов,принадлежищих к организации, по ее id
     * @param orgId
     * @return
     */
    Set<Office> getListOfOffices(Long orgId);

    /**
     * получить офис по его id
     * @param id
     * @return
     */
     Office getOffice(Long id);

    /**
     * обновить данные офиса
     * @param office
     */
//    void update(Office office);


    /**
     * сохранить новый офис
     * @param office
     */
     void save(Office office);
}
