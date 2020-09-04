package com.okta.developer.notes.backend

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.csrf.CsrfTokenRepository

@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .and()
                .oauth2ResourceServer()
                .jwt()

        /*
         * CSRF and CSP, this might cause problem with Docker deployment
         */
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
    }
}