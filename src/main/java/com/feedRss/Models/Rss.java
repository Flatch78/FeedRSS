package com.feedRss.Models;

import org.springframework.data.annotation.Id;

/**
 * Created by flatch on 20/01/17.
 */
public class Rss {

	@Id
	private String id;

	private String title;
	private String url;
	private String comment;

	public String getId() {
			return this.id;
		}
	public void setId(String id) {
			this.id = id;
		}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


}
