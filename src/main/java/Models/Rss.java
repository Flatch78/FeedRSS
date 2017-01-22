package Models;

import org.springframework.data.annotation.Id;
import sun.rmi.runtime.Log;

import java.util.Date;

/**
 * Created by flatch on 20/01/17.
 */
public class Rss {

	@Id
	String id;
	String title;
	String url;
	String comment;

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

//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//	public Date getCreatedDate() {
//		return createdDate;
//	}


	Rss(String url) {
		System.out.println("constructor");
		this.url = url;
	}

	Rss() { }

/*	@Override
	public String toString() {
		return String.format(
				"rss:{id:\"%s\",url:\"%s\"}",
				this.id, this.url);
	}*/
}
