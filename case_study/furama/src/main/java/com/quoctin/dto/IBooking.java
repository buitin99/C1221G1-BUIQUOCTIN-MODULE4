package com.quoctin.dto;

import com.quoctin.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface IBooking {
    String getCustomerName();
    String getContractStartDate();
    String getContractEndDate();
    String getContractDeposit();
    String getSer();
    String getTotal();

}
