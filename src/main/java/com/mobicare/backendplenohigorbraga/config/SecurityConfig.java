package com.mobicare.backendplenohigorbraga.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;
	
	private static final String[] PUBLIC_MATCHES = {
		"/h2-console/**"
	};
	
	private static final String[] PUBLIC_MATCHES_GET = {
			"/colaboradores/**",
			"/setores/**"
		};
	
	private static final String[] PUBLIC_MATCHES_POST = {
			"/colaboradores",
			"/setores/**"
		};
	
	private static final String[] PUBLIC_MATCHES_DELETE = {
			"/colaboradores/**",
			"/setores/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, PUBLIC_MATCHES_POST).permitAll()
		.antMatchers(HttpMethod.GET, PUBLIC_MATCHES_GET).permitAll()
		.antMatchers(HttpMethod.DELETE, PUBLIC_MATCHES_DELETE).permitAll()
		.antMatchers(PUBLIC_MATCHES).permitAll()
		.anyRequest().authenticated();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration =  new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
}
