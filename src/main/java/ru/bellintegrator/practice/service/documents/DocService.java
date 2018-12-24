package ru.bellintegrator.practice.service.documents;

import ru.bellintegrator.practice.model.DocEmployee;
import ru.bellintegrator.practice.view.DocEmployeeView;

import java.util.Set;

public interface DocService {
    /**
     *
     */
    Set<DocEmployeeView> getList();
}
