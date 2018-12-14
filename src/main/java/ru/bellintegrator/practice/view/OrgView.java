package ru.bellintegrator.practice.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrgView {

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

    public OrgView(Long id){
        this.id = id;
        name = "ЛондонПариж";
        fullName = "ЛондонПариж";
        inn = 1212313131L;
        kpp = 9090909090L;
        address = "г.Москва, ул.Островского 11Б";
        phone = "+7-932-890-09-09";
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

    @Override
    public String toString(){return " {id:" + id + ", name:" + name + ", fullName:" + fullName + ", inn:" + inn + ", kpp:" + kpp + ", address:" + address + ", phone:" + phone + ", isActive:" + isActive + "}";}

}
