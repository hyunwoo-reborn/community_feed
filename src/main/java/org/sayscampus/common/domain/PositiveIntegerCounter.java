package org.sayscampus.common.domain;

import org.sayscampus.user.domain.User;

public class PositiveIntegerCounter {
	private int count;

	public PositiveIntegerCounter() {
		this.count = 0;
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

}
