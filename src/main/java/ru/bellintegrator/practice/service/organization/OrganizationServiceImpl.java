package ru.bellintegrator.practice.service.organization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.model.response.Response;
import ru.bellintegrator.practice.view.OrgView;

import java.util.List;


@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final MapperFacade mapperFacade;
    private final OrganizationDao dao;

    @Autowired
    public OrganizationServiceImpl(MapperFacade mapperFacade, OrganizationDao dao){
        this.mapperFacade = mapperFacade;
        this.dao = dao;}

    @Override
    @Transactional(readOnly = true)
    public OrgView getOrg(Long id) {
        Organization organization = dao.getById(id);
        return mapperFacade.map( organization, OrgView.class);
    }

    @Override
    @Transactional
    public Response save(OrgView orgView) {
        Organization org = mapperFacade.map(orgView, Organization.class);
        dao.save(org);
        return new Response().setSucceess(true);
    }

    @Override
    @Transactional
    public Response update(OrgView orgView) {
        Organization org = mapperFacade.map(orgView, Organization.class);
        dao.update(org);
        return new Response().setSucceess(true);
    }

    @Override
    @Transactional
    public List<OrgView> getList(OrgView orgView) {
        Organization org = mapperFacade.map(orgView, Organization.class);
        List<Organization> list = dao.getList(org);
        return mapperFacade.mapAsList(list, OrgView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrgView> all() {
        return mapperFacade.mapAsList(dao.all(), OrgView.class);
    }
}
