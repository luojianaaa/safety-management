package com.example.chapter07.config;

import com.example.chapter07.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码需要设置编译器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("lisi").password(encoder.encode("666666")).roles("common")
//                .and()
//                .withUser("李四").password(encoder.encode("88888888")).roles("vip");

//       String userSQL="select username,password,valid from t_customer where username=?";
//       String authoritySQL="select c.username,a.authority from t_customer c,t_authority a,t_customer_authority ca where ca.customer_id=c.id and ca.authority_id=a.id and c.username=?";
//        auth.jdbcAuthentication().passwordEncoder(encoder).dataSource(dataSource).usersByUsernameQuery(userSQL).authoritiesByUsernameQuery(authoritySQL);

        //使用userDetailsService进行身份认证
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }
}
