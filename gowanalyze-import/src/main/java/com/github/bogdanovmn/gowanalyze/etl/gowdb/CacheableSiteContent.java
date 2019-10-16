package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import com.github.bogdanovmn.downloadwlc.UrlContentDiskCache;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

class CacheableSiteContent {
	private final String prefix;
	private final UrlContentDiskCache cache;

	CacheableSiteContent(String prefix) {
		this.prefix = prefix;
		this.cache = new UrlContentDiskCache(this.getClass());
	}

	Document get(String url) {
		try {
			return Jsoup.parse(
				cache.getText(new URL(prefix + url))
			);
		} catch (IOException e) {
			throw new RuntimeException(
				String.format("Get page %s error: %s", url, e.getMessage())
			);
		}
	}
}
