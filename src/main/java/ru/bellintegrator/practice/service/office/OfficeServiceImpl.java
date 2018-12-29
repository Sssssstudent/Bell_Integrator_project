package ru.bellintegrator.practice.service.office;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.office.OfficeDao;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.model.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final MapperFacade mapperFacade;
    private final OfficeDao dao;
    private final OrganizationDao orgDao;

    public OfficeServiceImpl(MapperFacade mapperFacade, OfficeDao dao, OrganizationDao orgDao) {
        this.mapperFacade = mapperFacade;
        this.dao = dao;
        this.orgDao = orgDao;
    }

    @Override
    @Transactional
    public Response save(OfficeView officeView){
        Organization organization = orgDao.getById(officeView.getOrgId());
        Office office = mapperFacade.map(officeView, Office.class);
        office.setOrganization(organization);
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
        Map<String,Object> map = new HashMap<>();
        if(Objects.nonNull(officeView)){
            map.put("orgId", officeView.getOrgId());
            map.put("name", officeView.getName());
            map.put("phone", officeView.getPhone());
            map.put("isActive", officeView.getIsActive());
        }
        List<Office> list = dao.list(map);
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
