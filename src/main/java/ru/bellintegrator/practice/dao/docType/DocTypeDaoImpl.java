package ru.bellintegrator.practice.dao.docType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.DocType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Repository
public class DocTypeDaoImpl implements DocTypeDao {
    private final EntityManager em;

    @Autowired
    public DocTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DocType> all() {
        TypedQuery<DocType> query = em.createQuery("SELECT d FROM DocType d", DocType.class);
        return  query.getResultList();
    }

    @Override
    public DocType getByCode(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocType> criteriaQuery = builder.createQuery(DocType.class);
        Root<DocType> root = criteriaQuery.from(DocType.class);
        List<Predicate> predicates = new LinkedList<>();
        criteriaQuery
                .where(builder.equal(root.get("code"), code))
                .select(root);
        TypedQuery<DocType> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();

    }
}

