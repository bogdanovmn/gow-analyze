package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import lombok.Value;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Value
class TestDocument {
	private final String fileName;

	Document get() {
		try {
			return Jsoup.parse(
				new String(
					Files.readAllBytes(
						Paths.get(
							getClass().getResource(fileName).toURI()
						)
					),
					StandardCharsets.UTF_8
				)
			);
		} catch (Exception e) {
			throw new RuntimeException(
				String.format("Read file %s error: %s", fileName, e.getMessage()),
				e
			);
		}
	}
}
