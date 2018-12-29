package ru.bellintegrator.practice.controller.organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.response.Response;
import ru.bellintegrator.practice.model.response.Result;
import ru.bellintegrator.practice.service.organization.OrganizationService;
import ru.bellintegrator.practice.view.OrgView;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService orgService;

    @Autowired
    public OrganizationController(OrganizationService orgService){ this.orgService = orgService;}

    @PostMapping("/list")
    public List<OrgView> getList(@RequestBody OrgView org){
        return orgService.getList(org);
    }

    @GetMapping("/{id}")
    public OrgView orgById(@PathVariable("id") Long orgId){
        return orgService.getOrg(orgId);
    }

    @PostMapping("/update")
    public Response update(@RequestBody OrgView org){
        return  orgService.update(org);
    }

    @PostMapping("/save")
    public Response save( @RequestBody OrgView org){
        return orgService.save(org);
    }

    @GetMapping("/list/all")
    public List<OrgView> all(){return orgService.all();}


}
