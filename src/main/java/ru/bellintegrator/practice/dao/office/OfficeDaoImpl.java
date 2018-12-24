package ru.bellintegrator.practice.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityManager;
import java.util.Set;

@Repository
public class OfficeDaoImpl implements OfficeDao {
    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em){
        this.em =em;
    }

    @Override
    public Set<Office> getListOfOffices(Long orgId) {
        Organization orgOfOffices = em.find(Organization.class, orgId);
        Set<Office> offices = orgOfOffices.getOffices();
        return offices;
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }

    @Override
    public Office getOffice(Long id) {
        return em.find(Office.class, id);
    }
}
