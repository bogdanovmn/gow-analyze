package com.github.bogdanovmn.gowanalyze.etl.gowdb;


import com.github.bogdanovmn.cmdlineapp.CmdLineAppBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class App implements CommandLineRunner {
	private final TroopsImport troopsImport;

	@Autowired
	public App(TroopsImport troopsImport) {
		this.troopsImport = troopsImport;
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		new CmdLineAppBuilder(args)
			.withJarName("import")
			.withDescription("gowdb import CLI")
			.withEntryPoint(
				cmdLine -> {
					troopsImport.run();
				}
			).build().run();
	}
}
