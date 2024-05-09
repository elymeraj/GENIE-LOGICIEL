package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {

	@Test
	public void testConverter() {
		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
		assertThat(RomanConverter.getRomanFromNumber(1), equalTo("I"));
		assertThat(RomanConverter.getRomanFromNumber(9), equalTo("IX"));
		assertThat(RomanConverter.getRomanFromNumber(40), equalTo("XL"));
		assertThat(RomanConverter.getRomanFromNumber(90), equalTo("XC"));
		assertThat(RomanConverter.getRomanFromNumber(400), equalTo("CD"));
		assertThat(RomanConverter.getRomanFromNumber(900), equalTo("CM"));
		assertThat(RomanConverter.getRomanFromNumber(1954), equalTo("MCMLIV"));
		assertThat(RomanConverter.getRomanFromNumber(3999), equalTo("MMMCMXCIX"));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));

		assertThat(RomanConverter.getNumberFromRoman("IV"), equalTo(4));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IIII")), instanceOf(IllegalArgumentException.class));
		assertThat(RomanConverter.getNumberFromRoman("IX"), equalTo(9));
		assertThat(RomanConverter.getNumberFromRoman("XL"), equalTo(40));
		assertThat(RomanConverter.getNumberFromRoman("XC"), equalTo(90));
		assertThat(RomanConverter.getNumberFromRoman("CD"), equalTo(400));
		assertThat(RomanConverter.getNumberFromRoman("CM"), equalTo(900));
		assertThat(RomanConverter.getNumberFromRoman("MCMLIV"), equalTo(1954));
		assertThat(RomanConverter.getNumberFromRoman("MMMCMXCIX"), equalTo(3999));
		assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("MMMM")), instanceOf(IllegalArgumentException.class));
	}

	//Help you to handle exception. :-)
	public static Throwable exceptionOf(Callable<?> callable) {
		try {
			callable.call();
			return null;
		} catch (Throwable t) {
			return t;
		}
	}
}