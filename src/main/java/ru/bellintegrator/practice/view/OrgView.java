package ru.bellintegrator.practice.view;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
@Getter
@Setter
*/
public class OrgView {

    public OrgView(){}

    public OrgView(Long id, String name, String fullName, Long inn, Long kpp, String address, String phone){
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        isActive = true;
    }

    public Long id;

    @Size(max=50)
    @NotEmpty

    public String name;

    @Size(max = 50)
    @NotEmpty

    public String fullName;

    @NotNull

    public Long inn;

    @NotNull

    public Long kpp;

    @Size(max = 50)
    @NotNull

    public String address;

    @Size(max = 50)

    public String phone;


    public Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getKpp() {
        return kpp;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString(){return " {id:" + id + ", name:" + name + ", fullName:" + fullName + ", inn:" + inn + ", kpp:" + kpp + ", address:" + address + ", phone:" + phone + ", isActive:" + isActive + "}";}

}
