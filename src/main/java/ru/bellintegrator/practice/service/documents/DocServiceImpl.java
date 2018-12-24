package ru.bellintegrator.practice.service.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.view.DocEmployeeView;

import javax.persistence.EntityManager;
import java.util.Set;

@Service
public class DocServiceImpl implements DocService {
    private final EntityManager em;

    @Autowired
    public DocServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Set<DocEmployeeView> getList() {
        return null;
    }
}
