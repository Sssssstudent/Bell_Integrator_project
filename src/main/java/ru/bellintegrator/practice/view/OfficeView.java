package ru.bellintegrator.practice.view;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeView {

    public Long id;

    public Long orgId;

    @Size(max = 50)
   // @NotEmpty
    public String name;

    @Size(max = 50)
    //@NotEmpty
    public String address;

    @Size(max = 50)
   // @NotEmpty
    public String phone;

    public Boolean isActive;

    public OfficeView(){

    }

    public OfficeView(Long id, Long orgId, String name, String address, String phone, Boolean isActive){
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString(){return " {id:" + id + ", name:" + name + ", address:" + address + ", phone:" + phone + ", isActive:" + isActive + "}";}

}
