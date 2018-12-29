package ru.bellintegrator.practice.controller.employee;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.model.response.Response;
import ru.bellintegrator.practice.service.employee.EmployeeService;
import ru.bellintegrator.practice.view.EmplView;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "EmployeeContoller", description = "Управление информацией об работниках")
@RestController
@RequestMapping(value = "/api/employee", produces = APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService emplService;

    @Autowired
    public EmployeeController(EmployeeService emplService){ this.emplService = emplService;}

    @GetMapping("/{id}")
    public EmplView getEmployeeById(@PathVariable("id") Long id) {
        return emplService.getEmployee(id);
    }

    @PostMapping("/list")
    public List<EmplView> list(@RequestBody EmplView emplView){return emplService.list(emplView);}

    @PostMapping("/update")
    public Response update(@RequestBody EmplView emplView){return emplService.update(emplView);}

    @PostMapping("/save")
    public Response save(@RequestBody EmplView emplView){return emplService.save(emplView);}

    @GetMapping("/list/all")
    public List<EmplView> all(){return emplService.all();}
}