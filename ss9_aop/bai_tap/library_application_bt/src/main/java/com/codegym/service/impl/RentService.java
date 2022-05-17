package com.codegym.service.impl;

import com.codegym.model.Rent;
import com.codegym.repository.IRentRepository;
import com.codegym.service.IRentService;
import com.codegym.utill.NotFindCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class RentService implements IRentService {

    @Autowired
    private IRentRepository iRentRepository;

    @Override
    public void save(Rent rent) {
        Long idRandom = (long) (Math.floor(Math.random() * 10000) + 99999);
        rent.setIdRent(idRandom);
        iRentRepository.save(rent);
    }

    @Override
    public Rent findById(Integer idRent) {
        return iRentRepository.findById(idRent).orElse(null);
    }

//    @Override
//    public Rent findById(Long idRent) {
//        int id = (int) (long) idRent;
//        return iRentRepository.findById(id).orElse(null);
//    }

    @Override
    public void delete(Rent rent) {
        iRentRepository.delete(rent);
    }

    @Override
    public Rent findByCode(Long idRent) throws NotFindCode {
        Rent rent = this.iRentRepository.findFirstByIdRent(idRent);
        if (rent != null) {
            return rent;
        } else {
            throw new NotFindCode();
        }
    }

    @Override
    public void remove(Rent rent) {
        iRentRepository.delete(rent);
    }

}
