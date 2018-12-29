package ru.bellintegrator.practice.view;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmplView {

    public Long id;

    @Size(max = 50)
    @NotEmpty
    public String firstName;

    @Size(max = 50)
    public String secondName;

    @Size(max = 50)
    public String lastName;

    @Size(max = 50)
    @NotEmpty
    public String position;

    @Size(max = 50)
    public String phone;

    @NotEmpty
    public Long docCode;

    @NotEmpty
    public String docName;

    @NotEmpty
    public Long docNumber;

    @NotEmpty
    public String docDate;

    @NotEmpty
    public String citizenshipName;

    @NotEmpty
    public Long citizenshipCode;

    @NotNull
    public Boolean isIdentified;

    public EmplView(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getDocCode() {
        return docCode;
    }

    public void setDocCode(Long docCode) {
        this.docCode = docCode;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Long getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Long docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public Long getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(Long citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean identefied) {
        this.isIdentified = identefied;
    }

    @Override
    public String toString(){return " id:"+id+", firstName:"+firstName+", secondName:"+secondName+", lastName:"+lastName+
            ", position:"+position+", phone:"+phone+", docCode:"+docCode+ ", docName:"+docName+", docNumber:"+docNumber+
            ", docDate:"+docDate+ ", citizenshipName" + citizenshipName + ", citizenshipCode:"+citizenshipCode+", isIdentefied:"+isIdentified+"}";}


}
