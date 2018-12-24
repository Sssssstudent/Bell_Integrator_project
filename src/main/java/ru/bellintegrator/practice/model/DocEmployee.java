package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity
public class DocEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(name = "doc_number", nullable = false)
    private Long docNumber;

    @Column(name = "doc_date", length = 50, nullable = false)
    private String docDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private DocType docType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private Employee employee;


    public DocEmployee(){

    }

    public DocEmployee(Long docNumber, String docDate) {
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

    public Long getId() {
        return id;
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

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

