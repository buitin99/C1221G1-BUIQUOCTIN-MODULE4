package com.quoctin.service.impl.contract;

import com.quoctin.model.contract.ContractDetail;
import com.quoctin.repository.contract.IContractDetailRepository;
import com.quoctin.service.icontract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
