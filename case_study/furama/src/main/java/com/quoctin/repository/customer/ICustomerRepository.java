package com.quoctin.repository.customer;

import com.quoctin.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "select * from customer where customer_name like :nameSearch and customer_phone like :phoneSearch and customer_type_id like :typeSearch",nativeQuery = true)
    List<Customer> search(@Param("nameSearch") String nameSearch, @Param("phoneSearch") String phoneSearch, @Param("typeSearch") String typeSearch);

//    @Query(value = "select * from customer where customer_name like :nameSearch and customer_phone like :phoneSearchand and customer_type_id like :typeSearch",nativeQuery = true")
//    Page<Customer> search(@Param("nameSearch")String nameSearch,@Param("phoneSearch") String phoneSearch,@Param("typeSearch") String typeSearch);

}
