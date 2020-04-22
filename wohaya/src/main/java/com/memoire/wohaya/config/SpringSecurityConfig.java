package com.memoire.wohaya.config;

import com.memoire.wohaya.repository.UtilisateurRepository;
import com.memoire.wohaya.security.JwtAuthenticationFilter;
import com.memoire.wohaya.security.JwtAuthorizationFilter;
import com.memoire.wohaya.security.UserPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserPrincipalDetailsService userPrincipalDetailsService;
    private final UtilisateurRepository utilisateurRepository;

    public SpringSecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService, UtilisateurRepository utilisateurRepository) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());

       /* .inMemoryAuthentication()
        .withUser("void").password(passwordEncoder().encode("admin")).roles("ADMIN")
        .and()
        .withUser("client").password(passwordEncoder().encode("client")).roles("CLIENT");*/
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //User Roles based authentification
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and()
            .addFilter(new JwtAuthenticationFilter(authenticationManager()))
            .addFilter(new JwtAuthorizationFilter(authenticationManager(), utilisateurRepository))
            .authorizeRequests()
            .antMatchers("/wohaya-api/abonnement/*")
            .hasRole("PROPRIETAIRE")
            .antMatchers(HttpMethod.POST, "/login", "/swagger-ui.html/**")
            .permitAll()
        ;
    }

    /*@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }*/

    //Any URL based authentification
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }*/

    /* http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/wohaya-api/**")
            .hasRole("PROPRIETAIRE")
            .anyRequest()
            .fullyAuthenticated()
            .and()
            .httpBasic();*/

    //Costumized URL authentification
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/wohaya-api/**")
            .fullyAuthenticated()
            .and()
            .httpBasic();
    }*/

}
