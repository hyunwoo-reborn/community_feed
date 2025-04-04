package org.sayscampus.post.domain.content;

import org.sayscampus.post.domain.common.DatetimeInfo;

public abstract class Content {
	String contentText;
	final DatetimeInfo datetimeInfo;

	protected Content(String contentText) {
		checkText(contentText);
		this.contentText = contentText;
		this.datetimeInfo = new DatetimeInfo();
	}

	public void updateContent(String contentText) {
		checkText(contentText);
		this.contentText = contentText;
		this.datetimeInfo.updateEditDateTime();
	}

	protected abstract void checkText(String contentText);

	public String getContentText() {
		return contentText;
	}
}
