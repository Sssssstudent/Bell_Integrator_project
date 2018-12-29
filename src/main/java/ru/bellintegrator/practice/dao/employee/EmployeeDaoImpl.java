package ru.bellintegrator.practice.dao.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dao.country.CountryDao;
import ru.bellintegrator.practice.dao.docType.DocTypeDao;
import ru.bellintegrator.practice.model.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final EntityManager em;
    private final DocTypeDao docTypeDao;
    private final CountryDao countryDao;


    @Autowired
    public EmployeeDaoImpl(EntityManager em, DocTypeDao docTypeDao, CountryDao countryDao) {
        this.em = em;
        this.docTypeDao = docTypeDao;
        this.countryDao = countryDao;
    }

    @Override
    public Employee getById(Long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public List<Employee> list(Map<String,Object> map) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        List<Predicate> predicates = new LinkedList<>();

        if (Objects.nonNull(map.get("officeId"))) {
            SetJoin<Employee, Office> joinUserOffice = root.joinSet("offices");

            Office office = em.find(Office.class, map.get("officeId"));
            predicates.add(joinUserOffice.in(office));
        }
        if (Objects.nonNull(map.get("firstName"))) {
            predicates.add(builder.equal(root.get("firstName"), map.get("firstName")));
        }
        if (Objects.nonNull(map.get("secondName"))) {
            predicates.add(builder.equal(root.get("secondName"), map.get("secondName")));
        }
        if (Objects.nonNull(map.get("middleName"))) {
            predicates.add(builder.equal(root.get("middleName"), map.get("middleName")));
        }
        if (Objects.nonNull(map.get("position"))) {
            predicates.add(builder.equal(root.get("position"), map.get("position")));
        }
        if (Objects.nonNull(map.get("docCode"))) {
            predicates.add(builder.equal(root.get("employeeDocument").get("documentCatalog").get("code"),
                    map.get("docCode")));
        }
        if (Objects.nonNull(map.get("citizenshipCode"))) {
            predicates.add(builder.equal(root.get("country").get("code"), map.get("citizenshipCode")));
        }

        criteriaQuery
                .where(predicates.toArray(new Predicate[]{}))
                .select(root);
        TypedQuery<Employee> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void update(Employee employee) {
        Employee updatedEmployee = em.find(Employee.class, employee.getId());
        // обновляем updatedEmployee
        if (Objects.nonNull(updatedEmployee)) {

            if (Objects.nonNull(employee.getFirstName())) {
                updatedEmployee.setFirstName(employee.getFirstName().trim());
            }

            if (Objects.nonNull(employee.getSecondName())) {
                updatedEmployee.setSecondName(employee.getSecondName().trim());
            }

            if (Objects.nonNull(employee.getLastName())) {
                updatedEmployee.setLastName(employee.getLastName().trim());
            }

            if (Objects.nonNull(employee.getPosition())) {
                updatedEmployee.setPosition(employee.getPosition().trim());
            }

            if (Objects.nonNull(employee.getPhone())) {
                updatedEmployee.setPhone(employee.getPhone().trim());
            }
            // isIdentified
            if (Objects.nonNull(employee.getIsIdentified())) {
                updatedEmployee.setIsIdentified(employee.getIsIdentified());
            }

            // EmployeeDocument
            DocEmployee employeeDocument = employee.getDocEmployee();
            if (Objects.nonNull(employeeDocument)) {
                DocEmployee updatedEmployeeDocument = updatedEmployee.getDocEmployee();
                // Создадим новый если нет документа
                if (Objects.isNull(updatedEmployeeDocument)) {
                    updatedEmployeeDocument = new DocEmployee();
                    em.persist(updatedEmployeeDocument);
                }
                // если указан тип документа удост. личность
                DocType docType = employeeDocument.getDocType();
                if (Objects.nonNull(docType)) {
                    docType
                            = docTypeDao.getByCode(docType.getCode());
                    updatedEmployeeDocument.setDocType(docType);
                }
                // docName
                if (Objects.nonNull(employeeDocument.getDocType().getName())) {
                    updatedEmployeeDocument.getDocType().setName(employeeDocument.getDocType().getName());
                }
                // docNumber
                if (Objects.nonNull(employeeDocument.getDocNumber())) {
                    updatedEmployeeDocument.setDocNumber(employeeDocument.getDocNumber());
                }
                // docDate
                if (Objects.nonNull(employeeDocument.getDocDate())) {
                    updatedEmployeeDocument.setDocDate(employeeDocument.getDocDate());
                }
                // todo реализовать добавление документа к сотруднику
                updatedEmployeeDocument.setEmployee(updatedEmployee);
            }
            // CountryCatalog если указано гражданство через код государства
            Country country = employee.getCountry();
            if (Objects.nonNull(country)) {
                country = countryDao.getByCode(country.getCode());
                updatedEmployee.setCountry(country);
            }
            // фиксируем изменения
            em.merge(updatedEmployee);
        }
    }

    @Override
    public void save(Employee employee) {
        DocEmployee docEmployee = employee.getDocEmployee();
        if (Objects.nonNull(docEmployee)) {
            // если указан тип документа удост. личность
            DocType docType = docEmployee.getDocType();
            if (Objects.nonNull(docType)) {
                docType
                        = docTypeDao.getByCode(docType.getCode());
                docEmployee.setDocType(docType);
            }

            docEmployee.setEmployee(employee);
        }

        Country country = employee.getCountry();
        if (Objects.nonNull(country)) {
            country = countryDao.getByCode(country.getCode());
            employee.setCountry(country);
        }

        em.persist(employee);


    }

    @Override
    public List<Employee> all(){
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
}
