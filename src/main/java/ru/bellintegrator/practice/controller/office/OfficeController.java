package ru.bellintegrator.practice.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.office.OfficeService;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.ResponseView;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeContoller", description = "Управление информацией об офисах")
@RestController
@RequestMapping(value = "/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService){ this.officeService = officeService;}

    @ApiOperation(value = "Добавить офис", httpMethod = "POST")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public ResponseView addOffice(@RequestBody OfficeView office){
        officeService.add(office);
        return new ResponseView();
    }
}
