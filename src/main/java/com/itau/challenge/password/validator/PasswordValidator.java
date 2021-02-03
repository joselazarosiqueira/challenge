package com.itau.challenge.password.validator;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

import static java.lang.String.valueOf;
import static org.apache.commons.lang3.StringUtils.*;

@Component
public class PasswordValidator {

	public static final String SPECIAL_CHARS = "!@#$%^&*()-+";

	public static final String NUMBERS = "0123456789";

	public boolean isValid(String password) {
		return checkMinLength(password)
				&& containsAnyNumeric(password)
				&& containsAnyLowerCase(password)
				&& containsAnyUpperCase(password)
				&& containsAnySpecialChars(password)
				&& !containsDuplicatesChars(password);
	}

	public boolean checkMinLength(String password) {
		return isNotEmpty(password) && length(password) >= 9;
	}

	public boolean containsAnyNumeric(String password) {
		return containsAny(password, NUMBERS);
	}

	public boolean containsAnyLowerCase(String password) {
		return isNotEmpty(password) && IntStream.range(0, password.length())
				.anyMatch(i -> Character.isLowerCase(password.charAt(i)));
	}

	public boolean containsAnyUpperCase(String password) {
		return isNotEmpty(password) && IntStream.range(0, password.length())
				.anyMatch(i -> Character.isUpperCase(password.charAt(i)));
	}

	public boolean containsAnySpecialChars(String password) {
		return isNotEmpty(password) && IntStream.range(0, password.length())
				.anyMatch(i -> SPECIAL_CHARS.contains(valueOf(password.charAt(i))));
	}

	public boolean containsDuplicatesChars(String password) {
		return isNotEmpty(password) && IntStream.range(0, password.length())
				.anyMatch(i -> IntStream.range(i + 1, password.length())
						.anyMatch(j -> password.charAt(i) == password.charAt(j)));
	}
}