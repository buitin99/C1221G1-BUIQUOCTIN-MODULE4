package com.quoctin.service.impl.contract;

import com.quoctin.model.contract.AttachService;
import com.quoctin.repository.contract.IAttachServiceRepository;
import com.quoctin.service.icontract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }
}
