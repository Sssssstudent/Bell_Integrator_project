package ru.bellintegrator.practice.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class OfficeView {
    public OfficeView(){

    }

    public OfficeView(Long id){
        this.id = id;
        name = "Gogo";
        address = "ул.Красного Знамени 50";
        phone = "8-980-980-33-33";
        isActive = true;
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

    @Override
    public String toString(){return " {id:" + id + ", name:" + name + ", address:" + address + ", phone:" + phone + ", isActive:" + isActive + "}";}

}
