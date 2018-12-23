package ru.bellintegrator.practice.dao.docType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.DocType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Set;

@Repository
public class DocTypeDaoImpl implements DocTypeDao {
    private final EntityManager em;

    @Autowired
    public DocTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Set<DocType> docTypes() {
        TypedQuery<DocType> query = em.createQuery("SELECT d FROM DocType d", DocType.class);
        return (Set<DocType>) query.getResultList();
    }
}

