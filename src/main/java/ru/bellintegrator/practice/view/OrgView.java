package ru.bellintegrator.practice.view;



import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrgView {

    //@NotNull
    public Long id;

    @Size(max = 50)
    @NotNull
    private String name;

    @Size(max = 50)
    //@NotNull
    private String fullName;

    //@NotNull
    private Long inn;

    //@NotNull
    private Long kpp;

    @Size(max = 50)
    //@NotNull
    private String address;

    @Size(max = 50)
    private String phone;

    private Boolean isActive;

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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        this.isActive = active;
    }

    @Override
    public String toString(){return " {id:" + id + ", name:" + name + ", fullName:" + fullName + ", inn:" + inn + ", kpp:" + kpp + ", address:" + address + ", phone:" + phone + ", isActive:" + isActive + "}";}

}
