package com.wani.otp.configures

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
@EnableWebSecurity
@Order(1)
//@EnableGlobalMethodSecurity(securedEnabled = true)
class WebSecurityConfiguration(
    private val userDetailsService: UserDetailsService
) : WebSecurityConfigurerAdapter() {


    override fun configure(auth: AuthenticationManagerBuilder?) {

        super.configure(auth)
    }

    override fun configure(web: WebSecurity) {
        web.ignoring()
            .mvcMatchers("/i18n/**")
            .mvcMatchers("/static/**")
            .mvcMatchers("/css/**")
            .mvcMatchers("/js/**")
            .mvcMatchers("/images/**")
    }

    override fun configure(http: HttpSecurity) {

        http.cors().and()
            .csrf().disable()
        http.headers().frameOptions().sameOrigin()
            .and()
            .authorizeRequests().antMatchers("/login", "/", "/prelogin", "/mfactor", "/purelogin")
            .permitAll()
            .and()
            .formLogin().loginPage("/login")
            .and()
            .logout().logoutUrl("/logout")
            .invalidateHttpSession(false)
            .permitAll()
            .and().authorizeRequests().anyRequest().authenticated()
        super.configure(http)
    }
}