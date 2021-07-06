package com.example.chapter07.repository;

import com.example.chapter07.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by crazyStone on 2018-11-06.
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByUsername(String username);
}
