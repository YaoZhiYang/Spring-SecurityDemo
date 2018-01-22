package com.cisdi.security.securitydemo.javaconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * project_name: securitydemo
 * package:      com.cisdi.security.securitydemo.javaconfig
 * describe:     TODO
 *
 * @author: yaozhiyang
 * creat_date:   2018/1/22
 * creat_time:   8:39
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin-password")
                .roles("ADMIN")
                .and()
                .withUser("guest")
                .password("guest-password")
                .roles("GUEST");
    }

}