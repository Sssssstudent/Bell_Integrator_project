package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
/*
    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Office> offices;
*/
    /**
     *конструктор
     */
    public Organization(){

    }

    /**
     *геттеры и сеттеры
     */
 /*   public List<Office> getOffices(){
        if (offices == null) {
            offices = new LinkedList<>();
        }
        return offices;
    }

    public void addOffice(Office office){
        getOffices().add(office);
    }

    public void removeOffice(Office office){
        getOffices().remove(office);
    }*/

    public Long getId(){return id;}

    public void setId(Long id){this.id = id; }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getFullName(){return fullName;}

    public void setFullName(String fullName){this.fullName = fullName;}

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
