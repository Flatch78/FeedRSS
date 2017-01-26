package com.feedRss.Controllers.ManageRss;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.syndication.feed.synd.SyndFeed;

import java.util.List;

/**
 * Created by flatch on 22/01/17.
 */


public class ContentRss {

	@JsonView(ViewRss.Summary.class)
	private String title;
	@JsonView(ViewRss.Summary.class)
	private String url;
	@JsonView(ViewRss.Summary.class)
	private String author;
	@JsonView(ViewRss.Summary.class)
	private String description;
	@JsonView(ViewRss.Summary.class)
	private String titleImage;
	@JsonView(ViewRss.Summary.class)
	private String urlImage;

	@JsonView(ViewRss.Summary.class)
	List<ContentFeedRss> feedrss;

	public static ContentRss fromSyndEntry(SyndFeed syndFeed) {
		return new ContentRss(syndFeed.getTitle(),
				syndFeed.getUri(),
				syndFeed.getAuthor(),
				syndFeed.getDescription(),
				syndFeed.getImage().getTitle(),
				syndFeed.getImage().getUrl());

	}

	private ContentRss(String title, String url, String author,
			   String description,
			   String titleImage, String urlImage) {
		this.title = title;
		this.url = url;
		this.author = author;
		this.description = description;
		this.titleImage = titleImage;
		this.urlImage = urlImage;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitleImage() {
		return titleImage;
	}

	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public List<ContentFeedRss> getFeedrss() {
		return feedrss;
	}

	public void setFeedrss(List<ContentFeedRss> feedrss) {
		this.feedrss = feedrss;
	}
}
