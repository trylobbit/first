package com.kasia.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration

@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select mail,password,enabled from user where mail = ?")
                .authoritiesByUsernameQuery("select u.mail, r.role from user u inner join user_role ur on(u.id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.mail=?")
                .dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //wszyscy maja dostep nawet niezalogowani
                .antMatchers("/", "/base", "/login", "/map", "/result", "/range").permitAll()
                //tylko admin ma dostep
                .antMatchers("/add-product", "/admin/**").hasAuthority("ADMIN")
                //uzytkownicy zalogowani maja dostep
                .antMatchers("/base", "/user/**").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                //strona logowania
                .formLogin().loginPage("/login")
                //przekierowanie po zalogowaniu
                .successForwardUrl("/home")
                .usernameParameter("mailAdress")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }

//    @Bean
//    public Role role(){
//        Role role = new Role();
//        role.setId(33);
//        role.setRole("admin");
//        role.setUsers(Collections.emptySet());
//        return role;
//    }
}