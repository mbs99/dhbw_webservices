package de.dhbw.swaggerdemo;

import org.springframework.web.bind.annotation.*;

@RestController
public class SwaggerDemoController {

    @PostMapping("/api/hello")
    public String postHello(@RequestBody SwaggerDemoDto body) {
        return "Hello," + body.getName();
    }

    @GetMapping("/api/hello")
    public String getHello(@RequestParam("name") String name) {
        return "Hello," + name;
    }
}
