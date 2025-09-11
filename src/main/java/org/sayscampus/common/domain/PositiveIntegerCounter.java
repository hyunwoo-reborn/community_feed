package org.sayscampus.common.domain;

import java.util.Objects;

public class PositiveIntegerCounter {
	private int count;

	public PositiveIntegerCounter() {
		this.count = 0;
	}

	public PositiveIntegerCounter(Integer count) {
        this.count = Objects.requireNonNullElse(count, 0);
	}

	public void increase() {
		this.count++;
	}

	public void decrease() {
		if (this.count <= 0) {
			return;
		}
		this.count--;
	}

	public int getCount() {
		return count;
	}
}
