package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;



    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "fullname", length = 50, nullable = false, unique = true)
    private String fullName;

    @Column( nullable = false, unique = true)
    private Long inn;

    @Column( nullable = false, unique = true)
    private Long kpp;

    @Column( length = 50, nullable = false)
    private String address;

    @Column( length = 50, unique = true)
    private String phone;

    @Column( name =  "is_active" )
    private Boolean isActive;

    public Organization(){

    }

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
