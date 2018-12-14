package ru.bellintegrator.practice.service.organization;


import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.practice.view.OrgView;

@Validated
public interface OrganizationService {

    /**
     *
     */

    OrgView getOrg(Long id);
}
