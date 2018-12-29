package ru.bellintegrator.practice.dao.office;

import ru.bellintegrator.practice.model.Office;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OfficeDao {
    /**
     * получить список офисов,принадлежищих к организации, по ее id
     * @param map
     * @return
     */
     List<Office> list(Map<String,Object> map);

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
     void update(Office office);


    /**
     * сохранить новый офис
     * @param office
     */
     void save(Office office);

    /**
     * получить список всех офисов
     */
    List<Office> all();
}
