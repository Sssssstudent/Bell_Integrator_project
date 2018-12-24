package ru.bellintegrator.practice.controller.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.service.docTypes.DocTypeService;
import ru.bellintegrator.practice.view.DocTypeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class DocTypeController {
    private final DocTypeService docTypeService;

    @Autowired
    public DocTypeController(DocTypeService docTypeService) {
        this.docTypeService = docTypeService;
    }

    @GetMapping("/docs")
    public List<DocTypeView> getListOfDocType(){return docTypeService.getList();}
}
