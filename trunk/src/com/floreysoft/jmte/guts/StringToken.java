package com.floreysoft.jmte.guts;

public class StringToken extends Token {
	protected String value;

	public StringToken(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
