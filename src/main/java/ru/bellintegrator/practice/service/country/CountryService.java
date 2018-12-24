package ru.bellintegrator.practice.service.country;

import ru.bellintegrator.practice.view.CountryView;

import java.util.List;

public interface CountryService {
    /**
     * получить список стран
     */
    List<CountryView> getList();
}
