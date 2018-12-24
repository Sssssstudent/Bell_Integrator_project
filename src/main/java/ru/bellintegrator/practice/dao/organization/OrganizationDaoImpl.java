package ru.bellintegrator.practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em){ this.em = em;}

    @Override
    public Organization getById(Long id){ return em.find(Organization.class, id);}

    /**
     * Используем criteria api для проверки корректности запросов во время компиляции, и вроде можно использовать в качестве фильтра
     * @param name
     * @return
     */

    private CriteriaQuery<Organization> buildCriteria(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> person = criteria.from(Organization.class);
        criteria.where(builder.equal(person.get("name"), name));

        return criteria;
    }

}
