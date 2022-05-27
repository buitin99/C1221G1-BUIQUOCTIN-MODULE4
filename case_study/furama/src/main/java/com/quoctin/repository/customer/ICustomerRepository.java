package com.quoctin.repository.customer;

import com.quoctin.dto.IBooking;
import com.quoctin.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from customer where customer_name like :nameSearch and customer_phone like :phoneSearch and customer_type_id like :typeSearch and flag = 1"
            ,countQuery = "select * from customer where customer_name like :nameSearch and customer_phone like :phoneSearch and customer_type_id like :typeSearch and flag = 1"
            ,nativeQuery = true)
    Page<Customer> search(@Param("nameSearch") String nameSearch, @Param("phoneSearch") String phoneSearch, @Param("typeSearch") String typeSearch,Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update customer set flag = b'0' where customer_id like :id",nativeQuery = true)
    void updateFlag(Integer id);

    @Query(value = "select * from customer right join contract on customer.customer_id = contract.customer_id;"
            ,countQuery = "select * from customer right join contract on customer.customer_id = contract.customer_id;"
            ,nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);


    @Query(value = "select k.customer_name as customerName, h.contract_start_date as contractStartDate, h.contract_end_date as contractEndDate, h.contract_deposit as contractDeposit, group_concat(distinct dv.attach_service_name) as ser,\n" +
            " ((ct.quantity*dv.attach_service_cost) + f.service_cost ) as total\n" +
            "from contract h\n" +
            "right join customer k on k.customer_id = h.customer_id \n" +
            "inner join contract_detail ct on h.contract_id = ct.contract_id\n" +
            "inner join attach_service dv on ct.attach_service_id = dv.attach_service_id\n" +
            "join facility f on h.service_id = f.service_id  \n" +
            "group by h.contract_id",
    countQuery = "select k.customer_name as customerName, h.contract_start_date as contractStartDate, h.contract_end_date as contractEndDate, h.contract_deposit as contractDeposit, group_concat(distinct dv.attach_service_name) as ser,\n" +
            " ((ct.quantity*dv.attach_service_cost) + f.service_cost ) as total\n" +
            "from contract h\n" +
            "right join customer k on k.customer_id = h.customer_id \n" +
            "inner join contract_detail ct on h.contract_id = ct.contract_id\n" +
            "inner join attach_service dv on ct.attach_service_id = dv.attach_service_id\n" +
            "join facility f on h.service_id = f.service_id  \n" +
            "group by h.contract_id",
    nativeQuery = true)
    Page<IBooking> booking(Pageable pageable);
//    @Query(value = "select * from customer where customer_name like :nameSearch and customer_phone like :phoneSearchand and customer_type_id like :typeSearch",nativeQuery = true")
//    Page<Customer> search(@Param("nameSearch")String nameSearch,@Param("phoneSearch") String phoneSearch,@Param("typeSearch") String typeSearch);

}
