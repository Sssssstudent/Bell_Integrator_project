package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * работник
 */
@Entity
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
    @Column(length = 50, nullable = false)
    private String position;

    /**
     *телефон
     */
    @Column(length = 20)
    private String phone;

    /**
     *
     */
    @Column(name = "citizenship_id")
    private Long citizenshipId;

    /**
     *
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     *список офисов работника
     */
    @ManyToMany(mappedBy = "employees")
    private Set<Office> offices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizenship_id")
    private Country country;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "empl_id")
    private DocEmployee docEmployee;

    /**
     *конструкторы
     */
    public Employee(){

    }

    public Employee(String firstName, String secondName, String lastName, String position,
                    String phone, Long citizenshipId, Boolean isIdentified) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
        this.citizenshipId = citizenshipId;
        this.isIdentified = isIdentified;
    }

    public Employee(String firstName, String position) {
        this.firstName = firstName;
        this.position = position;
        this.isIdentified = true;
    }

    /**
     *геттеры и сеттеры
     */
    public Long getId() {
        return id;
    }

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

    public Long getCitizenshipId() {
        return citizenshipId;
    }

    public void setCitizenshipId(Long citizenshipId) {
        this.citizenshipId = citizenshipId;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
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

    public DocEmployee getDocType() {
        return docEmployee;
    }

    public void setDocType(DocEmployee docEmployee) {
        this.docEmployee = docEmployee;
    }
}
