package com.github.bogdanovmn.gowanalyze.cli.etl;


import com.github.bogdanovmn.cmdlineapp.CmdLineAppBuilder;

public class App {
	public static void main(String[] args) throws Exception {
		new CmdLineAppBuilder(args)
			.withJarName("import")
			.withDescription("")
//			.withArg("option-name", "option descr")
			.withEntryPoint(
				cmdLine -> {

				}
			).build().run();
	}
}
