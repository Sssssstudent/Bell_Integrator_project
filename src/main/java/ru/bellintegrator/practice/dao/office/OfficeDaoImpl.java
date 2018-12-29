package ru.bellintegrator.practice.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository
public class OfficeDaoImpl implements OfficeDao {
    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em){
        this.em =em;
    }

    @Override
    public List<Office> list(Map<String,Object> filter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);
        Root<Office> rootOffice = criteriaQuery.from(Office.class);
        List<Predicate> predicates = new LinkedList<>();

        if(Objects.nonNull(filter.get("orgId"))){
            predicates.add(builder.equal(rootOffice.get("organization").get("id"),filter.get("orgId")));
        }
        if(Objects.nonNull(filter.get("name"))){
            predicates.add(builder.equal(rootOffice.get("name"),filter.get("name")));
        }
        if(Objects.nonNull(filter.get("phone"))){
            predicates.add(builder.equal(rootOffice.get("phone"),filter.get("phone")));
        }
        if(Objects.nonNull(filter.get("isActive"))){
            predicates.add(builder.equal(rootOffice.get("isActive"),filter.get("isActive")));
        }
        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[]{})));
        TypedQuery<Office> list = em.createQuery(criteriaQuery);
        return list.getResultList();

    }

    @Override
    public void update(Office office) {
        Office existingOffice = em.find(Office.class, office.getId());
        existingOffice.setName(office.getName());
        existingOffice.setAddress(office.getAddress());
        existingOffice.setPhone(office.getPhone());
        existingOffice.setIsActive(true);
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }

    @Override
    public Office getOffice(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public List<Office> all() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }
}
