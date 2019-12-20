package co.simplon.gestiontask.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource datasource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}tortue").roles("USER")
        .and()
        .withUser("timothe").password("{noop}laude").roles("ADMIN", "USER");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.csrf().disable();
        http.formLogin().loginPage("/login");
        http.authorizeRequests().anyRequest().authenticated();
    }
    }
