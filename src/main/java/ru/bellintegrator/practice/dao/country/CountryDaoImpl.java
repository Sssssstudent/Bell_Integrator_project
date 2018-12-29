package ru.bellintegrator.practice.dao.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {
    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Country> all() {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        return query.getResultList();
    }

    @Override
    public Country getByCode(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteriaQuery = builder.createQuery(Country.class);
        Root<Country> root = criteriaQuery.from(Country.class);
        criteriaQuery
                .where(builder.equal(root.get("code"), code.trim()))
                .select(root);
        TypedQuery<Country> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }
}
