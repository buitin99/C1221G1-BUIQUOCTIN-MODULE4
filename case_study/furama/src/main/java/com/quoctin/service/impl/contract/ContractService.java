package com.quoctin.service.impl.contract;

import com.quoctin.model.contract.Contract;
import com.quoctin.repository.contract.IContractRepository;
import com.quoctin.service.icontract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAllContract() {
        return iContractRepository.findAll();
    }
}
