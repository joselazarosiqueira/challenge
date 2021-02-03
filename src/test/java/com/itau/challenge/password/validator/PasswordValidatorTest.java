package com.itau.challenge.password.validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PasswordValidatorTest {

	@InjectMocks
	private PasswordValidator validator;

	@Test
	public void shouldReturnTrueWhenPasswordIsOk() {
		boolean result = validator.isValid("1a3B5@789");

		Assert.assertTrue(result);
	}

	@Test
	public void shouldReturnFalseWhenPasswordIsNull() {
		boolean result = validator.isValid(null);

		Assert.assertFalse(result);
	}

	@Test
	public void shouldReturnFalseWhenPasswordLengthIsLessThanNine() {
		boolean result = validator.checkMinLength("12345678");

		Assert.assertFalse(result);
	}

	@Test
	public void shouldReturnTrueWhenPasswordLengthIsFine() {
		boolean result = validator.checkMinLength("123456789");

		Assert.assertTrue(result);
	}

	@Test
	public void shouldReturnFalseWhenPasswordDoNotContainsAnyDigit() {
		boolean result = validator.containsAnyNumeric("CadBg@hjk");

		Assert.assertFalse(result);
	}

	@Test
	public void shouldReturnTrueWhenPasswordContainsOneDigit() {
		boolean result = validator.containsAnyNumeric("CadBg@hj1");

		Assert.assertTrue(result);
	}

	@Test
	public void shouldReturnFalseWhenPasswordDoNotContainsAnyLowerCase() {
		boolean result = validator.containsAnyLowerCase("CADBG@GH1");

		Assert.assertFalse(result);
	}

	@Test
	public void shouldReturnTrueWhenPasswordContainsAnyLowerCase() {
		boolean result = validator.containsAnyLowerCase("1h2");

		Assert.assertTrue(result);
	}

	@Test
	public void shouldReturnFalseWhenPasswordDoNotContainsAnyUpperCase() {
		boolean result = validator.containsAnyUpperCase("cadbg@gh1");

		Assert.assertFalse(result);
	}

	@Test
	public void shouldReturnTrueWhenPasswordContainsAnyUpperCase() {
		boolean result = validator.containsAnyUpperCase("Dbg@gh1");

		Assert.assertTrue(result);
	}

	@Test
	public void shouldReturnTrueWhenPasswordContainsAnySpecialChars() {
		boolean result = validator.containsAnySpecialChars("Dbg@gh1");

		Assert.assertTrue(result);
	}

	@Test
	public void shouldReturnFalseWhenPasswordDoNotContainsAnySpecialChars() {
		boolean result = validator.containsAnySpecialChars("Dbggh1");

		Assert.assertFalse(result);
	}

	@Test
	public void shouldReturnTrueWhenPasswordContainsDuplicatedChars() {
		boolean result = validator.containsDuplicatesChars("Dbggh1");

		Assert.assertTrue(result);
	}

	@Test
	public void shouldReturnFalseWhenPasswordDoNotContainsDuplicatedChars() {
		boolean result = validator.containsDuplicatesChars("abcde");

		Assert.assertFalse(result);
	}
}
