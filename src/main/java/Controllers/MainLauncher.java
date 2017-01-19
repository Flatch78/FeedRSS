package Controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by leo on 19/01/2017.
 */

@Controller
@SpringBootApplication
public class MainLauncher {

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        return "Hello mister guillaume this is a working API <3";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainLauncher.class, args);
    }
}
