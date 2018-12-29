package ru.bellintegrator.practice.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.service.office.OfficeService;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.model.response.Response;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService){ this.officeService = officeService;}


    @PostMapping("/save")
    public Response save(@RequestBody OfficeView officeView){
        return officeService.save(officeView);
    }

    @GetMapping("/{id}")
    public OfficeView getOffice(@PathVariable("id") Long id){
        return officeService.getOffice(id);
    }

    @PostMapping("/list")
    public List<OfficeView> list(@RequestBody OfficeView officeView){return officeService.list(officeView);}

    @PostMapping("/update")
    public Response update(@RequestBody OfficeView officeView){return officeService.update(officeView);}

    @GetMapping("/list/all")
    public List<OfficeView> all(){return officeService.all();}
}
