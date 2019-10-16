package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jsoup.nodes.Element;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
class TroopTableContent {
	private final Element html;

	String name() {
		return html.attr("data-name");
	}

	List<String> colors() {
		return Arrays.asList(html.attr("data-colors").split(" "));
	}

	List<String> types() {
		return Arrays.asList(
			html.select("td:eq(3)").text().split("-"));
	}

	String fileBaseName() {
		return html.attr("data-filebase");
	}

	int id() {
		return Integer.parseInt(
			html.attr("data-id")
		);
	}

	String rarity() {
		return html.select("td[class^=rarity]").text();
	}

	List<String> kingdoms() {
		return Arrays.asList(
			html.select("td:eq(2)").text().split("/")
		);
	}

	int spellCost() {
		return Integer.parseInt(
			html.select("td:eq(4)").text()
		);
	}

	int attack() {
		return Integer.parseInt(
			html.select("td:eq(10)").text()
		);
	}

	int life() {
		return Integer.parseInt(
			html.select("td:eq(11)").text()
		);
	}

	int armor() {
		return Integer.parseInt(
			html.select("td:eq(12)").text()
		);
	}

	int releaseDate() {
		return Integer.parseInt(
			Arrays.asList(
				html.select("td:eq(9)").attr("data-text").split(" ")
			).get(0)
		);
	}

	String spellText() {
		return spell().attr("title");
	}

	String spellName() {
		return spell().text();
	}

	List<Trait> traits() {
		return html.select("td:eq(8) span[class^=trait]").stream()
			.map(tr -> Trait.builder()
					.name(tr.text())
					.text(tr.attr("title"))
				.build()
			).collect(Collectors.toList());
	}

	private Element spell() {
		return html.select("td:eq(6) span").first();
	}

	@Value
	@Builder
	static class Trait {
		private final String name;
		private final String text;
	}
}
