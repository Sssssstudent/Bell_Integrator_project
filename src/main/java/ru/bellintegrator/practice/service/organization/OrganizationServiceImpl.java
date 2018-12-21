package ru.bellintegrator.practice.service.organization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OrgView;


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











    /*

    @Override
    @Transactional
    public OrgView getOrg(Long id){
        OrgView view = new OrgView();
        view.setId(id);
        view.setName("ЛондонПариж");
        view.setFullName("ЛондонПариж");
        view.setInn(1212313131L);
        view.setKpp(9090909090L);
        view.setAddress("г.Москва, ул.Островского 11Б");
        view.setPhone("+7-932-890-09-09");
        view.setActive(true);
        return view;
    }
*/
}
