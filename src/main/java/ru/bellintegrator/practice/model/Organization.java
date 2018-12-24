package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * сокращенное имя организации
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     *полное имя организации
     */
    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    /**
     *инн
     */
    @Column( nullable = false)
    private Long inn;

    /**
     *кпп
     */
    @Column( nullable = false)
    private Long kpp;

    /**
     *адресс
     */
    @Column( length = 50, nullable = false)
    private String address;

    /**
     *телефон
     */
    @Column( length = 50)
    private String phone;

    /**
     *
     */
    @Column( name =  "is_active" )
    private Boolean isActive;

    /**
     *список офисов,принадлежащих данной организации
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "org_id")
    public Set<Office> offices;


    /**
     *конструкторы
     */
    public Organization(){

    }
/*
    public Organization(String name, String fullName, Long inn, Long kpp,
                        String address, String phone, Boolean isActive){
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Organization(Long id, String name, String fullName,
                        Long inn, Long kpp, String address, String phone,
                        Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }*/


    /**
     *геттеры и сеттеры
     */
    public Set<Office> getOffices(){
        if (offices == null) {
            offices = new HashSet<>();
        }
        return offices;
    }

    public void addOffice(Office office){
        getOffices().add(office);
    }

    public void removeOffice(Office office){
        getOffices().remove(office);
    }

    public Long getId(){return id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getFullname(){return fullName;}

    public void setFullname(String fullName){this.fullName = fullName;}

    public Long getInn(){return inn;}

    public void setInn(Long inn){this.inn = inn;}

    public Long getKpp(){return kpp;}

    public void setKpp(Long kpp){this.kpp = kpp;}

    public String getAddress(){return address;}

    public void setAddress(String address){this.address = address;}

    public String getPhone(){return phone;}

    public void setPhone(String phone){this.phone = phone;}

    public Boolean getIsActive(){return isActive;}

    public void setIsActive(Boolean isActive){this.isActive = isActive;}

}
