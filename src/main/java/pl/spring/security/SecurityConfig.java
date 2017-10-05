package pl.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Andrzej I.
 * copyright 02.10.17.
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CostomUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/processlogin")
                .permitAll()
                .usernameParameter("user")
                .passwordParameter("pass")
                .and()
                .logout()
                .logoutUrl("/logmeout")
                .logoutSuccessUrl("/")
                .permitAll();


    }



}
