package com.wani.otp.configures

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
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

}