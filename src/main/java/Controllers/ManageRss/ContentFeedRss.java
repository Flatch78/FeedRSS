package Controllers.ManageRss;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.syndication.feed.synd.SyndEnclosureImpl;
import com.sun.syndication.feed.synd.SyndEntry;

import java.util.Date;
import java.util.List;

/**
 * Created by flatch on 22/01/17.
 */
public class ContentFeedRss {
	@JsonView(ViewRss.Summary.class)
	private String title;
	@JsonView(ViewRss.Summary.class)
	private String description;
	@JsonView(ViewRss.Summary.class)
	private String author;
	@JsonView(ViewRss.Summary.class)
	private String url;
	@JsonView(ViewRss.Summary.class)
	private String urlImage;
	@JsonView(ViewRss.Summary.class)
	private Date publishedDate;

	public static ContentFeedRss fromSyndEntry(SyndEntry feedEntry) {
		String imageUrl = null;
		List<SyndEnclosureImpl> enclosures =
				(List) feedEntry.getEnclosures();
		if (enclosures != null){
			for (SyndEnclosureImpl enclosure : enclosures){
				if (enclosure != null){
					imageUrl = enclosure.getUrl();
					break;
				}
			}
		}
		return new ContentFeedRss(feedEntry.getTitle(),
				feedEntry.getDescription().getValue(),
				feedEntry.getLink(),
				imageUrl,
				feedEntry.getAuthor(),
				feedEntry.getPublishedDate());
	}

	public ContentFeedRss(String title, String description,
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

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getUrlImage() {
		return urlImage;
	}
}
