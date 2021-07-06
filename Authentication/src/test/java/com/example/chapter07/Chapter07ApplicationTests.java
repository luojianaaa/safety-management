package com.example.chapter07;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class Chapter07ApplicationTests {

    @Test
    void contextLoads() {
        //查看原始密码
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("88888888"));
    }

}
