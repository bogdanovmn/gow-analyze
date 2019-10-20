package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import com.github.bogdanovmn.gowanalyze.model.entity.KingdomRepository;
import com.github.bogdanovmn.gowanalyze.model.entity.TroopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class TroopsImport {
	@Autowired
	private KingdomRepository kingdomRepository;
	@Autowired
	private TroopRepository troopRepository;

	@Transactional(rollbackFor = Exception.class)
	public void run() {
		GowdbSiteContent siteContent = new GowdbSiteContent("http://gowdb.com");

		importKingdoms(siteContent);

		importTroops(siteContent);
	}

	private void importKingdoms(GowdbSiteContent siteContent) {
		for (KingdomTableContent kingdomsTableContent : siteContent.kingdomsTablePage().kingdoms()) {

		}
	}

	private void importTroops(GowdbSiteContent siteContent) {
		for (TroopTableContent troopTableContent : siteContent.troopsTablePage().troops()) {

		}
	}
}
