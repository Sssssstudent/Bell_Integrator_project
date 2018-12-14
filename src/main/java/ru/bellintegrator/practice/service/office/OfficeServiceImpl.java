package ru.bellintegrator.practice.service.office;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.ResponseView;

@Service
public class OfficeServiceImpl implements OfficeService {
    //private final OfficeDao dao;

    @Override
    @Transactional
    public ResponseView add(OfficeView view){
        Office office = new Office(view.name, view.address, view.phone, true, view.id);
        return new ResponseView().setSucceess(true);
        //dao.save(office);
    }
}
