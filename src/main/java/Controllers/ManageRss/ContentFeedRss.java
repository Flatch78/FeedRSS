package Controllers.ManageRss;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.syndication.feed.synd.SyndEntry;

import java.util.Date;

/**
 * Created by flatch on 22/01/17.
 */
public class ContentFeedRss {
	@JsonView(ViewRss.Summary.class)
	String title;
	@JsonView(ViewRss.Summary.class)
	String description;
	@JsonView(ViewRss.Summary.class)
	String author;
	@JsonView(ViewRss.Summary.class)
	String url;
	@JsonView(ViewRss.Summary.class)
	String urlImage;
	@JsonView(ViewRss.Summary.class)
	Date publishedDate;

	public static ContentFeedRss fromSyndEntry(SyndEntry feedEntry) {
		return new ContentFeedRss(feedEntry.getTitle(),
				feedEntry.getDescription().getValue(),
				feedEntry.getLink(),
				"http://blog-mastere2-rp-events.ecs-paris.com/wp-content/uploads/2014/04/poney-rose-300x224.jpg",
				feedEntry.getAuthor(),
				feedEntry.getPublishedDate());
	}

	ContentFeedRss(String title, String description,
				   String url, String urlImage,
				   String author, Date publishedDate) {
		this.title = title;
		this.description = description;
		this.url = url;
		this.urlImage = urlImage;
		this.author = author;
		this.publishedDate = publishedDate;
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

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
}
