package ru.bellintegrator.practice.service.office;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.view.OfficeView;

@Service
public class OfficeServiceImpl implements OfficeService {
    //private final OfficeDao dao;

    @Override
    @Transactional
    public void add(OfficeView view){
        Office office = new Office(view.name, view.address, view.phone, true, view.id);
        //dao.save(office);
    }


}
