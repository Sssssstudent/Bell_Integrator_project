package ru.bellintegrator.practice.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DocTypeView {
    /**
     * id в таблице документов
     */
    private Long id;

    /**
     * тип документа
     */
    @Size(max = 50)
    @NotEmpty
    private String name;

    /**
     * код документа
     */
    @Size(max = 2)
    @NotEmpty
    private String code;

    public DocTypeView(){

    }

    public DocTypeView(@Size(max = 50) @NotEmpty String name, @Size(max = 2) @NotEmpty String code) {
        this.name = name;
        this.code = code;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";type" + name + ";code" + code + "}";
    }
}
