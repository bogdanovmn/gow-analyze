package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import org.jsoup.nodes.Element;

import java.util.List;

class GowdbSiteContent extends CacheableSiteContent {

	GowdbSiteContent(String prefix) {
		super(prefix);
	}

	TroopsTableContent troopsTablePage() {
		return new TroopsTableContent(
			get("/trooptable")
		);
	}

	List<Element> troops() {
		return null;
	}
}
