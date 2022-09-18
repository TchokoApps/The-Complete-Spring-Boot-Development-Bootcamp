package com.tchokoapps.springboot.easyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123456")
                .roles("USER")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123456")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("password")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("password")
//                .roles("USER", "ADMIN")
//                .and()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .ignoringAntMatchers("saveMsg")
                .and()
                .authorizeRequests()
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/holidays/**").permitAll()
                .mvcMatchers("/contact").permitAll()
                .mvcMatchers("/saveMsg").permitAll()
                .mvcMatchers("/courses").permitAll()
                .mvcMatchers("/about").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/dashboard").authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
                .and().httpBasic();

//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .mvcMatchers("/home").permitAll()
//                .mvcMatchers("/holidays/**").permitAll()
//                .mvcMatchers("/contact").permitAll()
//                .mvcMatchers("/saveMsg").permitAll()
//                .mvcMatchers("/courses").permitAll()
//                .mvcMatchers("/about").permitAll()
//                .mvcMatchers("/login").permitAll()
//                .mvcMatchers("/dashboard").authenticated()
//                .and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
//                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
//                .and().httpBasic();


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();

//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                    .anyRequest()
//                    .denyAll()
//                    .and()
//                    .formLogin()
//                    .and()
//                    .httpBasic();
    }
}
