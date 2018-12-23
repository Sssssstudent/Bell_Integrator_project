package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     *название страны
     */
    @Column(length = 50,nullable = false)
    private String name;

    /**
     *код страны
     */
    @Column(length = 50, nullable = false)
    private String code;

    /**
     *конструкторы
     */
    public Country(){

    }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     *геттеры и сеттеры
     */
    public Long getId() {
        return id;
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
}
