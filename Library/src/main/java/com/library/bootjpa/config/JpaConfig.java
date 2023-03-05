package com.library.bootjpa.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
public class JpaConfig {
	@Configuration
	@EnableJpaRepositories(basePackages = "com.library.bootjpa.repository")
	public class JPAConfig {
	}
}
