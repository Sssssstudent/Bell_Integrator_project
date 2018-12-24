package ru.bellintegrator.practice.service.docTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.docType.DocTypeDao;
import ru.bellintegrator.practice.model.DocType;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.DocTypeView;

import java.util.List;

@Service
public class DocTypeServiceImpl implements DocTypeService {
    private final DocTypeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public DocTypeServiceImpl(DocTypeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocTypeView> getList() {
        List<DocType> list = dao.all();
        return mapperFacade.mapAsList(list, DocTypeView.class);
    }
}
