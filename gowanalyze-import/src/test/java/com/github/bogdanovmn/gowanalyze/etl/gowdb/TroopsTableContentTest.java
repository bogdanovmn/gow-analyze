package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TroopsTableContentTest {

	private static List<TroopTableContent> troops;

	@BeforeClass
	public static void init() {
		troops = new TroopsTableContent(
			new TestDocument("/content/troops.html").get()
		).troops();
	}

	@Test
	public void shouldParseAllTroops() {
		assertThat(
			troops.size(),
			is(5)
		);
	}

	@Test
	public void shouldParseTroopData() {
		TroopTableContent troop = troops.get(0);
		assertThat(
			troop.name(),
			is("Wolf Knight")
		);

		assertThat(
			troop.id(),
			is(6057)
		);

		assertThat(
			troop.spellCost(),
			is(8)
		);

		assertThat(
			troop.attack(),
			is(14)
		);

		assertThat(
			troop.life(),
			is(21)
		);

		assertThat(
			troop.armor(),
			is(23)
		);

		assertThat(
			troop.releaseDate(),
			is(1414490400)
		);

		assertThat(
			troop.fileBaseName(),
			is("Troop_K14_01")
		);

		assertThat(
			troop.rarity(),
			is("Rare")
		);

		assertThat(
			troop.kingdoms(),
			is(Arrays.asList("Sword's Edge", "Glacial Peaks"))
		);

		assertThat(
			troop.types(),
			is(Arrays.asList("Wargare", "Knight"))
		);

		assertThat(
			troop.colors(),
			is(Arrays.asList("yellow", "brown"))
		);

		assertThat(
			troop.spellText(),
			is("Deal [Magic + 1] true damage to an Enemy. If the Enemy is wounded, deal 6 more damage.")
		);

		assertThat(
			troop.spellName(),
			is("Hunt")
		);

		assertThat(
			troop.traits().size(),
			is(3)
		);

		assertThat(
			troop.traits().get(1).getName(),
			is("Air Spirit")
		);

		assertThat(
			troop.traits().get(1).getText(),
			is("Gain 1 Magic for each Yellow ally.")
		);
	}
}