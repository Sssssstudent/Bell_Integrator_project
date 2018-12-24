package ru.bellintegrator.practice.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.office.OfficeDao;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.ResponseView;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final MapperFacade mapperFacade;
    private final OfficeDao dao;

    public OfficeServiceImpl(MapperFacade mapperFacade, OfficeDao dao) {
        this.mapperFacade = mapperFacade;
        this.dao = dao;
    }

    @Override
    @Transactional
    public ResponseView add(OfficeView officeView){
        Office office = mapperFacade.map(officeView, Office.class);
        dao.save(office);
        return new ResponseView().setSucceess(true);
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView getOffice(Long id) {
        Office office = dao.getOffice(id);
        return mapperFacade.map(office, OfficeView.class);
    }
}
