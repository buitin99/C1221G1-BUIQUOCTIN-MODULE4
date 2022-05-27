package com.quoctin.service.icontract;

import com.quoctin.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    List<Contract> findAllContract();
}
