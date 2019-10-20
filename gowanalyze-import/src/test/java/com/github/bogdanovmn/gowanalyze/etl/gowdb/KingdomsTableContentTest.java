package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KingdomsTableContentTest {
	private static List<KingdomTableContent> kingdoms;

	@BeforeClass
	public static void init() {
		kingdoms = new KingdomsTableContent(
			new TestDocument("/content/kingdoms.html").get()
		).kingdoms();
	}

	@Test
	public void shouldParseAllTroops() {
		assertThat(
			kingdoms.size(),
			is(2)
		);
	}

	@Test
	public void shouldParseKingdomData() {
		KingdomTableContent kingdom = kingdoms.get(0);
		assertThat(
			kingdom.name(),
			is("Adana")
		);

		assertThat(
			kingdom.id(),
			is(3001)
		);

		assertThat(
			kingdom.masteryColor(),
			is("Yellow")
		);

		assertThat(
			kingdom.skill(),
			is("Armor")
		);

		assertThat(
			kingdom.traitStone(),
			is("Arcane Storm")
		);

		assertThat(
			kingdom.tributeGold(),
			is(175)
		);

		assertThat(
			kingdom.tributeSouls(),
			is(4)
		);

		assertThat(
			kingdom.tributeGlory(),
			is(2)
		);

		assertThat(
			kingdom.bannerColors().size(),
			is(2)
		);
	}

	@Test
	public void shouldParseKingdomBanner() {
		KingdomTableContent kingdom = kingdoms.get(0);
		assertThat(
			kingdom.bannerColors().get(0).getColor(),
			is("Red")
		);

		assertThat(
			kingdom.bannerColors().get(0).getAmount(),
			is(1)
		);
	}

	@Test
	public void shouldParseKingdomDelveBanner() {
		KingdomTableContent delveKingdom = kingdoms.get(1);
		assertThat(
			delveKingdom.bannerColors().size(),
			is(3)
		);

		assertThat(
			delveKingdom.bannerColors().get(0).getColor(),
			is("Green")
		);

		assertThat(
			delveKingdom.bannerColors().get(0).getAmount(),
			is(2)
		);

		assertThat(
			delveKingdom.bannerColors().get(2).getColor(),
			is("Brown")
		);

		assertThat(
			delveKingdom.bannerColors().get(2).getAmount(),
			is(-1)
		);
	}
}