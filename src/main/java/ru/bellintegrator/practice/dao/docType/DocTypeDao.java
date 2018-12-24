package ru.bellintegrator.practice.dao.docType;

import ru.bellintegrator.practice.model.DocType;

import java.util.List;
import java.util.Set;

public interface DocTypeDao {
    /**
     * вывести список всех типов документов
     * @return
     */
    List<DocType> all();
}
