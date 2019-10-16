package com.github.bogdanovmn.gowanalyze.model.common;

import com.github.bogdanovmn.common.spring.jpa.EntityRepositoryMapFactory;
import com.github.bogdanovmn.gowanalyze.model.entity.UserRole;
import com.github.bogdanovmn.gowanalyze.model.entity.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.github.bogdanovmn.common.spring")
class RepositoryMapConfig {
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Bean
	EntityRepositoryMapFactory entityRepositoryMapFactory() {
		return new EntityRepositoryMapFactory.Builder()
			.map(UserRole.class,  userRoleRepository)
			.build();
	}
}
