package com.feedRss.Controllers;

import com.feedRss.Controllers.ManageRss.ContentRss;
import com.feedRss.Controllers.ManageRss.RssReader;
import com.feedRss.Dao.RssRepository;
import com.feedRss.Dao.UserRepository;
import com.feedRss.Models.Rss;
import com.feedRss.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flatch on 20/01/17.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"Content-Type", "token"})
@RequestMapping("/api")
public class RssController {

	@Autowired
	private RssRepository rssRepository;
	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@RequestMapping(value = "/rss", method = RequestMethod.GET)
	List<Rss> getListRss(@RequestHeader String token) {
		User user = userRepository.findByToken(token);
		List<Rss> listRss = new ArrayList<>();
		if (rssRepository.findAll().size() > 0) {
			for (String id : user.getRss()) {
				listRss.add(rssRepository.findById(id));
			}
		}
		return listRss;
	}

	@ResponseBody
	@RequestMapping(value = "/rss/{id}", method = RequestMethod.GET)
	ContentRss getFeedInRss(@PathVariable String id) {
		RssReader rssReader = new RssReader();
		return rssReader.loadRss(rssRepository.findById(id).getUrl());
	}

	@ResponseBody
	@RequestMapping(value = "/rss", method = {RequestMethod.POST, RequestMethod.OPTIONS})
	Rss addFeedInRss(@RequestBody Rss rss, @RequestHeader String token) {
		rssRepository.save(rss);
		User user = userRepository.findByToken(token);
		user.addRss(rss.getId());
		userRepository.save(user);
		return rss;
	}

	@ResponseBody
	@RequestMapping(value = "/rss/{id}", method = RequestMethod.PUT)
	String updateFeedInRss(@PathVariable String id, @RequestBody Rss newRss) {
		if (newRss != null) {
			Rss rss = rssRepository.findOne(id);
			if (newRss.getUrl() != null) {
				rss.setUrl(newRss.getUrl());
			}
			if (newRss.getTitle() != null) {
				rss.setTitle(newRss.getTitle());
			}
			if (newRss.getComment() != null) {
				rss.setComment(newRss.getComment());
			}
			rssRepository.save(rss);
			return "{ success:true }";
		}
		return "{ success:false }";
	}

	@ResponseBody
	@RequestMapping(value = "/rss/{id}", method = RequestMethod.DELETE)
	String removeFeedInRss(@PathVariable String id, @RequestHeader String token) {
		User user = userRepository.findByToken(token);
		user.removeRss(id);
		userRepository.save(user);
		return "{ success:"
				+ (rssRepository.deleteById(id) == 1 ? "true" : "false")
				+ "}";
	}

}
