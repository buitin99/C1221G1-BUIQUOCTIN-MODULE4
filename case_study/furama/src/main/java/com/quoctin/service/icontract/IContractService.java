package com.quoctin.service.icontract;

import com.quoctin.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);
}
