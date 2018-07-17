package testPackage.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HelloController {

    @Value("${welcome.message}")
    private String message;

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String details(Map<String, Object> model) {
        model.put("message", this.message);
        return "hello";
    }
}
