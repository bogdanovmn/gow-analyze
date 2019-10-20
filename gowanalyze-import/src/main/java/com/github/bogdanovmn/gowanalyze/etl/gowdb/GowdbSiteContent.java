package com.github.bogdanovmn.gowanalyze.etl.gowdb;

class GowdbSiteContent extends CacheableSiteContent {

	GowdbSiteContent(String prefix) {
		super(prefix);
	}

	TroopsTableContent troopsTablePage() {
		return new TroopsTableContent(
			get("/trooptable")
		);
	}

	KingdomsTableContent kingdomsTablePage() {
		return new KingdomsTableContent(
			get("/kingdomtable")
		);
	}
}
