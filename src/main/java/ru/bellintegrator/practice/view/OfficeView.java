package ru.bellintegrator.practice.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class OfficeView {
    public OfficeView(){

    }

    public OfficeView(Long id, String name, String address, String phone, Boolean isActive){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Long id;

    @Size(max = 50)
    @NotEmpty
    public String name;

    @Size(max = 50)
    @NotEmpty
    public String address;

    @Size(max = 50)
    @NotEmpty
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
        isActive = active;
    }

    @Override
    public String toString(){return " {id:" + id + ", name:" + name + ", address:" + address + ", phone:" + phone + ", isActive:" + isActive + "}";}

}
