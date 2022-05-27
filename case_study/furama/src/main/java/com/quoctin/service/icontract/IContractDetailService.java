package com.quoctin.service.icontract;

import com.quoctin.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    void save(ContractDetail contractDetail);
}
