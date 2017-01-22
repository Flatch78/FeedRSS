package Controllers.ManageRss;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.FeedFetcher;
import com.sun.syndication.fetcher.FetcherException;
import com.sun.syndication.fetcher.FetcherListener;
import com.sun.syndication.fetcher.impl.FeedFetcherCache;
import com.sun.syndication.fetcher.impl.HashMapFeedInfoCache;
import com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;
import com.sun.syndication.io.FeedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by flatch on 22/01/17.
 */
public class RssReader implements MessageSource {
	private static Logger logger = LoggerFactory.getLogger(RssReader.class);
	private FeedFetcherCache feedInfoCache;
	private FeedFetcher feedFetcher;
	private FetcherListener fetcherListener;


	private SyndFeed obtainFeedItems(String url) {
		SyndFeed feed = null;
		try {
			feed = feedFetcher.retrieveFeed(new URL(url));
		} catch (IOException e) {
			logger.error("IO Problem while retrieving feed", e);
		} catch (FeedException e) {
			logger.error("Feed Problem while retrieving feed", e);
		} catch (FetcherException e) {
			logger.error("Fetcher Problem while retrieving feed", e);
		}
		return feed;
	}

	public void afterPropertiesSet() throws Exception {
		feedInfoCache = HashMapFeedInfoCache.getInstance();
		feedFetcher = new HttpURLFeedFetcher(feedInfoCache);
		if (fetcherListener != null) {
			feedFetcher.addFetcherEventListener(fetcherListener);
		}
	}

	public void setFetcherListener(FetcherListener fetcherListener) {
		this.fetcherListener = fetcherListener;
	}

	public ContentRss loadRss(String url) {
		try {
			afterPropertiesSet();
		} catch (Exception e) {
			logger.error("afterPropertiesSet Problem while retrieving feed", e);
		}
		String response = "";
		logger.info("Url: " + url);
		SyndFeed syndFeed = obtainFeedItems(url);

		syndFeed.getModules();

//		MessageBuilder.withPayload(feed)
//				.setHeader("feedid", "gridshore").build();

		ContentRss contentRss = ContentRss.fromSyndEntry(syndFeed);
		List<ContentFeedRss> feedrss = new ArrayList<ContentFeedRss>();
		List<SyndEntry> entries = syndFeed.getEntries();
		for (SyndEntry entry : entries) {
			feedrss.add(ContentFeedRss.fromSyndEntry(entry));
		}
		contentRss.setFeedrss(feedrss);

		return contentRss;
	}


	@Override
	public String getMessage(String s, Object[] objects, String s1, Locale locale) {
		return null;
	}

	@Override
	public String getMessage(String s, Object[] objects, Locale locale) throws NoSuchMessageException {
		return null;
	}

	@Override
	public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale) throws NoSuchMessageException {
		return null;
	}
}