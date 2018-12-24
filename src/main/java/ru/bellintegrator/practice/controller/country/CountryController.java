package ru.bellintegrator.practice.controller.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.country.CountryService;
import ru.bellintegrator.practice.service.docTypes.DocTypeService;
import ru.bellintegrator.practice.view.CountryView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<CountryView> getListOfCountries(){
        return countryService.getList();
    }

}
