package ru.bellintegrator.practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.response.ApiErrorResponse;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em){ this.em = em;}

    @Override
    public Organization getById(Long id){
        return em.find(Organization.class, id);
    }

    @Override
    public List<Organization> getList(Organization organization)  {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);
        Root<Organization> root =  criteriaQuery.from(Organization.class);
        List<Predicate> predicates = new LinkedList<>();

        if(Objects.nonNull(organization.getName())){
            predicates.add(builder.equal(root.get("name"),organization.getName()));
        }
        if(Objects.nonNull(organization.getInn())){
            predicates.add(builder.equal(root.get("inn"),organization.getInn()));
        }
        if (Objects.nonNull(organization.getIsActive())){
            predicates.add(builder.equal(root.get("isActive"),organization.getIsActive()));
        }
        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[]{})));
        TypedQuery<Organization> list = em.createQuery(criteriaQuery);
        return list.getResultList();
    }


    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void update(Organization organization) {
        Organization existingOrg = em.find(Organization.class, organization.getId());
        existingOrg.setName(organization.getName());
        existingOrg.setFullName(organization.getFullName());
        existingOrg.setInn(organization.getInn());
        existingOrg.setKpp(organization.getKpp());
        existingOrg.setAddress(organization.getAddress());
        existingOrg.setPhone(organization.getPhone());
        existingOrg.setIsActive(true);
    }

    @Override
    public List<Organization> all() {
        return em.createQuery("SELECT o FROM Organization o", Organization.class).getResultList();
    }
}
