package ru.bellintegrator.practice.model.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.model.Employee;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.view.EmplView;
import ru.bellintegrator.practice.view.OfficeView;

/**
 * Фабрика для создания MapperFactory.
 * При необходимости можно добавить кастомные мапперы
 */
@Service
public class CustomMapperFactory implements FactoryBean<MapperFactory> {
    @Override
    public MapperFactory getObject(){
        MapperFactory mapperFactory =  new DefaultMapperFactory.Builder()
                .constructorResolverStrategy(null)
                .build();
        mapperFactory.classMap(Office.class, OfficeView.class)
                .field("organization.id", "orgId")
                .byDefault()
                .register();

        mapperFactory.classMap(Employee.class, EmplView.class)
                .field("docEmployee.docNumber", "docNumber")
                .field("docEmployee.docDate", "docDate")
                .field("docEmployee.docType.name", "docName")
                .field("docEmployee.docType.code", "docCode")
                .field("country.name", "citizenshipName")
                .field("country.code", "citizenshipCode")
                .byDefault()
                .register();
        return mapperFactory;

    }

    @Override
    public Class<?> getObjectType(){return MapperFactory.class;}

    @Override
    public boolean isSingleton(){return true;}

}
