package ru.bellintegrator.practice.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Офис
 */
@Entity(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Наименование офиса
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * Адрес офиса
     */
    @Column(name = "address", length = 50)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(name = "phone", length = 50)
    private String phone;

    /**
     * Действительность
     */
    @Column(name = "is_active")
    private Boolean isActive;
/*

    @Column(name = "org_id", nullable = false)
    private Long orgId;
*/
    /**
     *список работников в офисе
     */
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "Office_Employee",
            joinColumns = @JoinColumn(name = "office_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<Employee> employees;

    /**
     * организация, которой принадлежит офис
     */
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "org_id")
    private Organization organization;

    /**
     *конструкторы
     */
    public Office() {

    }

    /**
     *геттеры и сеттеры
     */
    public Long getId() { return id; }

    public void setId(Long id){this.id = id;}

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

    public Long getOrgId() {
        return organization.getId();
    }

    public void setOrgId(Long orgId) {
        organization.setId(orgId);
    }

    public Set<Employee> getEmployees(){
        if (employees == null){
            employees = new HashSet<>();
        }
        return employees;
    }

    public void addEmployee(Employee employee){
        getEmployees().add(employee);
        employee.getOffices().add(this);
    }

    public void removeEmployee(Employee employee){
        getEmployees().remove(employee);
        employee.getOffices().remove(this);
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}