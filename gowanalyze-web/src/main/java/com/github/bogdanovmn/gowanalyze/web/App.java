package com.github.bogdanovmn.gowanalyze.web;

import com.github.bogdanovmn.common.spring.menu.MenuConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.github.bogdanovmn.gowanalyze.model")
@EntityScan(basePackages = "com.github.bogdanovmn.gowanalyze.model")
@ComponentScan(basePackages = {
	"com.github.bogdanovmn.gowanalyze.web",
	"com.github.bogdanovmn.gowanalyze.model.common"
})
@EnableConfigurationProperties({
	MenuConfiguration.class
})
@EnableTransactionManagement
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

