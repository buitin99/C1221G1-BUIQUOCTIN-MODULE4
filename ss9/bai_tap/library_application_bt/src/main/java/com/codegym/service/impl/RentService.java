package com.codegym.service.impl;

import com.codegym.model.Rent;
import com.codegym.repository.IRentRepository;
import com.codegym.service.IRentService;
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
        Long idRandom = (long)(Math.floor( Math.random()*10000) + 99999);
        rent.setIdRent(idRandom);
        iRentRepository.save(rent);
    }


    @Override
    public Optional<Rent> findById(Integer id) {
        Optional<Rent> rentCode = this.iRentRepository.findById(id);
        if(id != null){
            return rentCode;
        }
        return rentCode;
    }

    @Override
    public void delete(Rent rent) {
        this.iRentRepository.delete(rent);
    }


}
