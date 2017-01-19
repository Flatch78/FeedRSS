package Controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by leo on 19/01/2017.
 */

@SpringBootApplication
public class MainLauncher {


    @RequestMapping("/helloword")
    public String home() {
        return "Hello World";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainLauncher.class, args);
    }
}
