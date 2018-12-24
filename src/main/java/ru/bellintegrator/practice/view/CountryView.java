package ru.bellintegrator.practice.view;

import javax.validation.constraints.Size;

public class CountryView {
    private Long id;

    /**
     * имя страны
     */
    @Size(max = 50)
    private String name;

    /**
     * код страны
     */
    @Size(max = 50)
    private Long code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name" + name + ";code" + code + "}";
    }
}
