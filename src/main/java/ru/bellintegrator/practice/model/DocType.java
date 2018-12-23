package ru.bellintegrator.practice.model;

import javax.persistence.*;

public class DocType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Column(length = 50, nullable = false)
    private String type;

    @Column(length = 2, nullable = false)
    private String code;

    public DocType(){

    }

    public DocType(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
