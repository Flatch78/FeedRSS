package com.epitech;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by flatch on 07/01/17.
 */
@RestController
public class RssController {

    @RequestMapping("/rss")
    public String rss(String test) {
        return ("RSS path worked !");
    }

}
