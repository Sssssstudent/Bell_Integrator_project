package ru.bellintegrator.practice.controller.employee;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.employee.EmployeeService;
import ru.bellintegrator.practice.view.EmplView;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "EmployeeContoller", description = "Управление информацией об работниках")
@RestController
@RequestMapping(value = "/employee", produces = APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService emplService;

    @Autowired
    public EmployeeController(EmployeeService emplService){ this.emplService = emplService;}

    @ApiOperation(value = "Получить работника по id", httpMethod = "GET")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public EmplView getEmployeeById(@PathVariable("id") Long id) {
        return emplService.getEmployee(id);
    }
}