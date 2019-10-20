package com.github.bogdanovmn.gowanalyze.etl.gowdb;

public class SplicedString {
	private final String str;
	private final String separator;
	private String[] components;

	public SplicedString(String str, String separator) {
		this.str = str;
		this.separator = separator;
	}

	public String componentByIndex(int fieldIndex) {
		if (components == null) {
			components = str.split(separator);
		}

		if (components.length < fieldIndex) {
			throw new ArrayIndexOutOfBoundsException(
				String.format("Where is not any field with index = %d (%s)", fieldIndex, str)
			);
		}

		return components[fieldIndex - 1];
	}
}
