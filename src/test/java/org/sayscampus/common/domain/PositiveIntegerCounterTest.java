package org.sayscampus.common.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositiveIntegerCounterTest {

	@Test
	void givenCreated_whenIncrease_thenCountIsOne() {
		// Given
		PositiveIntegerCounter counter = new PositiveIntegerCounter();

		// When
		counter.increase();

		// Then
		assertEquals(1, counter.getCount());
	}

	@Test
	void givenCreated_whenIncreasedAndDecreased_thenCountIsZero() {
		// Given
		PositiveIntegerCounter counter = new PositiveIntegerCounter();
		counter.increase();

		// When
		counter.decrease();

		// Then
		assertEquals(0, counter.getCount());
	}

	@Test
	void givenCreated_whenDecreased_thenCountIsZero() {
		// Given
		PositiveIntegerCounter counter = new PositiveIntegerCounter();

		// When
		counter.decrease();

		// Then
		assertEquals(0, counter.getCount());
	}
}