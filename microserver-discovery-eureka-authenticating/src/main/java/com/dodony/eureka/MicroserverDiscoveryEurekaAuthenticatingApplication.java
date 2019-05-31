package com.dodony.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication

public class MicroserverDiscoveryEurekaAuthenticatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserverDiscoveryEurekaAuthenticatingApplication.class, args);
	}

//	@EnableWebSecurity
//	static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable();
//			super.configure(http);
//		}
//	}

}
