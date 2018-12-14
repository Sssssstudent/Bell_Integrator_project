package ru.bellintegrator.practice.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmplView {
    public EmplView(Long id, String firstName, String secondName, String lastName, String position, String phone,
                    Long docCode, String docName, Long docNumber, String docDate, Long citizenshipCode, Boolean isIdentefied ){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipCode = citizenshipCode;
        this.isIdentefied =isIdentefied;
    }

    public EmplView(Long id ){
        this.id = id;
        this.firstName = "Чаплин";
        this.secondName = "Гротеск";
        this.lastName = "Павлович";
        this.position = "TeamLead";
        this.phone = "8-666-666-90-90";
        this.docCode = 21L;
        this.docName = "Паспорт РФ";
        this.docNumber = 1111111111L;
        this.docDate = "1994-09-01";
        this.citizenshipCode = 61L;
        this.isIdentefied = true;
    }

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
    public Long citizenshipCode;

    @NotNull
    public Boolean isIdentefied;

    @Override
    public String toString(){return " id:"+id+", firstName:"+firstName+", secondName:"+secondName+", lastName:"+lastName+", position:"+position+", phone:"+phone+", docCode:"+docCode+
                                        ", docName:"+docName+", docNumber:"+docNumber+", docDate:"+docDate+", citizenshipCode:"+citizenshipCode+", isIdentefied:"+isIdentefied+"}";}


}
