package com.feedRss.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
/**
 * Created by edouard on 26/01/17.
 */

@RestController
public class MyErrorController implements ErrorController {
    private static final String PATH = "/error";

    private boolean debug = false;

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
        return new ErrorJson(response.getStatus(), getErrorAttributes(request, debug));
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    public class ErrorJson {

        public Integer status;
        public String error;
        public String message;
        public String timeStamp;
        public String trace;
        public String path;

        public ErrorJson(int status, Map<String, Object> errorAttributes) {
            this.status = status;
            this.error = (String) errorAttributes.get("error");
            this.message = (String) errorAttributes.get("message");
            this.timeStamp = errorAttributes.get("timestamp").toString();
            this.trace = (String) errorAttributes.get("trace");
            this.path = (String) errorAttributes.get("path");
        }

    }
}