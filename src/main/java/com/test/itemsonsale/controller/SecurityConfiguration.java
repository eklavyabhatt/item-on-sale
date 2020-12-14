package com.test.itemsonsale.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.okta.spring.boot.oauth.Okta;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/**")
			.authorizeRequests()
			.antMatchers("/")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.oauth2Login();

		Okta.configureResourceServer401ResponseBody(http);
	}
}
