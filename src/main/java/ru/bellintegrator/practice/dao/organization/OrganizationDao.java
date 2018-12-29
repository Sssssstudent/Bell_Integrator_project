package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.model.Organization;
import java.util.List;

public interface OrganizationDao {

    /**Получить список организации, отсортированных по параметрам name/inn/isActive
     *@return
     */
    List<Organization> getList(Organization organization);


    /**Получить организацию по id
     *@param id
     *@return
     */
    Organization getById(Long id);

    /**Сохранить организацию в БД
     *
     */
    void save(Organization organization);

    /**
     *Обновить данные об организации
     */
    void update(Organization organization);

    /**
     * Получить список всех организаций
     */
    List<Organization> all();
}
