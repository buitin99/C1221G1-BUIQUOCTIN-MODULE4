package com.quoctin.service.impl.employee;

import com.quoctin.model.employee.Position;
import com.quoctin.repository.employee.IPositionRepository;
import com.quoctin.service.iemployee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
