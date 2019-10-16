package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import lombok.Value;
import org.jsoup.nodes.Document;

import java.util.List;
import java.util.stream.Collectors;

@Value
class TroopsTableContent {
	private final Document html;

	List<TroopTableContent> troops() {
		return html.select("table[id=troopTable] tr[id^=troop]").stream()
			.map(TroopTableContent::new)
			.collect(Collectors.toList());
	}
}
