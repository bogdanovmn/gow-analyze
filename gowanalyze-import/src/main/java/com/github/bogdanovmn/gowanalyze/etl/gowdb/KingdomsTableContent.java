package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import lombok.AllArgsConstructor;
import org.jsoup.nodes.Document;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
class KingdomsTableContent {
	private final Document html;

	List<KingdomTableContent> kingdoms() {
		return html.select("table[id=troopTable] tr[id^=kingdom]").stream()
			.map(KingdomTableContent::new)
			.collect(Collectors.toList());
	}
}
