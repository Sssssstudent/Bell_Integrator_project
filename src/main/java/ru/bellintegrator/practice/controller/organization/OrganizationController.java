package ru.bellintegrator.practice.controller.organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.organization.OrganizationService;
import ru.bellintegrator.practice.view.OrgView;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationContoller", description = "Управление информацией об организациях")
@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService orgService;

    @Autowired
    public OrganizationController(OrganizationService orgService){ this.orgService = orgService;}

    @ApiOperation(value = "Найти организацию по id", httpMethod = "GET")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public String orgById(@PathVariable("id") Long orgId){
        return "{data:" + orgService.getOrg(orgId).toString() + "}";
    }
}
