package ru.bellintegrator.practice.service.organization;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.OrgView;


@Service
public class OrganizationServiceImpl implements OrganizationService {
    //private final OrganizationDao dao;

    @Override
    @Transactional
    public OrgView getOrg(Long id){return new OrgView(id);}
}
