package ru.bellintegrator.practice.dao.country;

import ru.bellintegrator.practice.model.Country;

import java.util.List;

public interface CountryDao {
    /**
     * список стран
     * @return
     */
    List<Country> all();
}
