package ru.bellintegrator.practice.service.office;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.office.OfficeDao;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.model.response.Response;

import java.util.List;

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
    public Response save(OfficeView officeView){
        Office office = mapperFacade.map(officeView, Office.class);
        dao.save(office);
        return new Response().setSucceess(true);
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView getOffice(Long id) {
        Office office = dao.getOffice(id);
        return mapperFacade.map(office, OfficeView.class);
    }

    @Override
    @Transactional
    public List<OfficeView> list(OfficeView officeView) {
        Office office = mapperFacade.map(officeView, Office.class);
        List<Office> list = dao.list(office);
        return mapperFacade.mapAsList(list, OfficeView.class);
    }

    @Override
    @Transactional
    public Response update(OfficeView officeView) {
        Office office = mapperFacade.map(officeView, Office.class);
        dao.update(office);
        return new Response().setSucceess(true);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> all() {
        List<Office> list = dao.all();
        return mapperFacade.mapAsList(list,OfficeView.class);
    }
}
