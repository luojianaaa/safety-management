package com.example.chapter07.service;

import com.example.chapter07.domain.Authority;
import com.example.chapter07.domain.Customer;
import com.example.chapter07.repository.AuthorityRepository;
import com.example.chapter07.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    //业务控制：使用唯一用户名查询用户信息
    public Customer getCustomer(String username) {
        return customerRepository.findByUsername(username);
    }

    //业务控制：使用唯一用户名查询用户权限
    public List<Authority> getCustomerAuthority(String username){
        return authorityRepository.findAuthoritiesByUsername(username);
    }
}
