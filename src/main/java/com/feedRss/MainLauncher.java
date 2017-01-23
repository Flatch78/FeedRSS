package com.feedRss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by leo on 19/01/2017.
 */

@SpringBootApplication
public class MainLauncher {


/*
    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return "Hello mister guillaume this is a working API <3";
    }
*/

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainLauncher.class, args);
    }
}
