package Controllers;

import Controllers.ManageRss.ContentRss;
import Controllers.ManageRss.RssReader;
import Models.Rss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by flatch on 20/01/17.
 */
@Controller
public class RssController {

	@Autowired
	RssRepository rssRepository;

/*	@ResponseBody
	@RequestMapping("/rssflux")
	public List<Rss> rssFluxList() {
		List<String> rss = rssRepository.findAll().toString();
	}*/

/*	@ResponseBody
	@RequestMapping(value = "/rss", method = RequestMethod.GET)
	ModelAndView getFeedInRss() {

		System.out.println("getFeedInRss");

		List<ContentRss> items = new ArrayList<ContentRss>();

		ContentRss content  = new ContentRss();
		content.setTitle("Spring MVC Tutorial 1");
		content.setUrl("http://www.mkyong.com/spring-mvc/tutorial-1");
		content.setSummary("Tutorial 1 summary ...");
		content.setCreatedDate(new Date());
		items.add(content);

		ContentRss content2  = new ContentRss();
		content2.setTitle("Spring MVC Tutorial 2");
		content2.setUrl("http://www.mkyong.com/spring-mvc/tutorial-2");
		content2.setSummary("Tutorial 2 summary ...");
		content2.setCreatedDate(new Date());
		items.add(content2);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("rssViewer");
		mav.addObject("feedContent", items);


		return mav;

	}*/


	@ResponseBody
	@RequestMapping(value = "/rss/{id}", method = RequestMethod.GET)
	ContentRss getFeedInRss(@PathVariable String id) {


		RssReader rssReader = new RssReader();
		ContentRss response = rssReader.loadRss(rssRepository.findById(id).getUrl());
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/listflux", method = RequestMethod.GET)
	public String rssFluxList() {
		String response = "{listflux:{";

		List<Rss> listRss = rssRepository.findAll();
		for (Rss rss : listRss) {
			System.out.println(rss.toString());
			response += rss.toString() + ",";
		}

		response += "}}";



		return response;
	}


}
