package com.github.bogdanovmn.gowanalyze.etl.gowdb;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SplicedStringTest {

	@Test
	public void shouldFindProperField() {
		SplicedString splicedString = new SplicedString("aaa_bbb_ccc", "_");

		assertThat(
			splicedString.componentByIndex(1),
			is("aaa")
		);

		assertThat(
			splicedString.componentByIndex(2),
			is("bbb")
		);

		assertThat(
			splicedString.componentByIndex(3),
			is("ccc")
		);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void shouldThrowOutOfRangeException() {
		new SplicedString("aaa_bbb_ccc", "_").componentByIndex(10);
	}
}