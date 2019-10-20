package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class KingdomTableContent {
	private final Element html;

	int id() {
		return Integer.parseInt(
			new SplicedString(html.attr("id"), "_").componentByIndex(2)
		);
	}

	String name() {
		return html.select("td:eq(0)").text();
	}

	String masteryColor() {
		return html.select("td:eq(1)").text();
	}

	String skill() {
		return html.select("td:eq(2)").text();
	}

	String traitStone() {
		return new SplicedString(
			html.select("td:eq(3)").attr("data-text"),
			"-"
		).componentByIndex(2);
	}

	int tributeGold() {
		return Integer.parseInt(
			html.select("td:eq(4)").text()
		);
	}

	int tributeGlory() {
		return Integer.parseInt(
			html.select("td:eq(5)").text()
		);
	}

	int tributeSouls() {
		return Integer.parseInt(
			html.select("td:eq(6)").text()
		);
	}

	List<ColorComponent> bannerColors() {
		List<ColorComponent> result = new ArrayList<>(3);
		List<String> colors = new ArrayList<>(3);
		List<Integer> amount = new ArrayList<>(3);
		for (Element img : html.select("td:eq(8) span[class=banner-colors] img")) {
			colors.add(
				capitalize(
					new SplicedString(
						new SplicedString(img.attr("src"), "_").componentByIndex(2),
						"\\."
					).componentByIndex(1)
				)
			);
		}
		for (Element spanWithAmount : html.select("td:eq(8) span[class=banner-colors] span")) {
			amount.add(
				Integer.parseInt(
					spanWithAmount.text()
				)
			);
		}

		for (int i = 0; i < colors.size(); i++) {
			result.add(
				ColorComponent.builder()
					.color(colors.get(i))
					.amount(amount.get(i))
				.build()
			);
		}

		return result;
	}

	private String capitalize(String value) {
		return value.substring(0,1).toUpperCase() + value.substring(1).toLowerCase();
	}

	@Value
	@Builder
	static class ColorComponent {
		private final String color;
		private final int amount;
	}
}
