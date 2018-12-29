package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * работник
 */
@Entity(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     *имя
     */
    @Column(name = "first_name",length = 50, nullable = false)
    private String firstName;

    /**
     *фамилия
     */
    @Column(name = "second_name",length = 50)
    private String secondName;

    /**
     *отчество
     */
    @Column(name = "last_name",length = 50)
    private String lastName;

    /**
     *должность
     */
    @Column(length = 50)
    private String position;

    /**
     *телефон
     */
    @Column(length = 20)
    private String phone;

    /**
     *
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     *список офисов работника
     */
    @ManyToMany(mappedBy = "employees",fetch = FetchType.EAGER)
    private Set<Office> offices;

    @ManyToOne
    @JoinColumn(name = "citizenship_id")
    private Country country;

    /**
     * документ, принадлежащий работнику
     */
    @OneToOne(
            mappedBy = "employee",
            cascade = CascadeType.ALL
    )
    private DocEmployee docEmployee;


    /**
     *конструкторы
     */
    public Employee(){

    }

    /**
     *геттеры и сеттеры
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id){this.id = id;}

    public String getCitizenshipName() {
        return country.getName();
    }

    public void setCitizenshipName(String citizenshipName) {country.setName(citizenshipName);}

    public String getCitizenshipCode(){return country.getCode();}

    public void setCitizenshipCode(String citizenshipCode){country.setCode(citizenshipCode);}

    public String getDocName(){return docEmployee.getDocType().getName();}

    public void setDocName(String name){docEmployee.getDocType().setName(name);}

    public String getDocCode(){return docEmployee.getDocType().getCode();}

    public void setDocCode(String code){docEmployee.getDocType().setCode(code);}

    public Long getDocNumber(){return docEmployee.getDocNumber();}

    public void setDocNumber(Long number){docEmployee.setDocNumber(number);}

    public String getDocDate(){return docEmployee.getDocDate();}

    public void setDocDate(String date){docEmployee.setDocDate(date);}

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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


    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Set<Office> getOffices() {
        if (offices == null){
            offices = new HashSet<>();
        }
        return offices;
    }

    public void addOffices(Office office) {
        getOffices().add(office);
        office.getEmployees().add(this);
    }

    public void removeOffice(Office office){
        getOffices().remove(office);
        office.getEmployees().remove(this);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public DocEmployee getDocEmployee() {
        return docEmployee;
    }

    public void setDocEmployee(DocEmployee docEmployee) {
        this.docEmployee = docEmployee;
    }
}
