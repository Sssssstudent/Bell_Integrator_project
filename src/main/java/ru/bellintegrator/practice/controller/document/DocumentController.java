package ru.bellintegrator.practice.controller.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.model.DocEmployee;
import ru.bellintegrator.practice.service.documents.DocService;
import ru.bellintegrator.practice.view.DocEmployeeView;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/docs", produces = APPLICATION_JSON_VALUE)
public class DocumentController {
    private final DocService docService;

    @Autowired
    public DocumentController(DocService docService) {
        this.docService = docService;
    }

    @GetMapping("/")
    public Set<DocEmployeeView> getListOfDoc(){return docService.getList();}
}
