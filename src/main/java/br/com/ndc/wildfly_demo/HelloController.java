package br.com.ndc.wildfly_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello(final String name) {
        if (name != null) {
            return "Hello, " + name;
        }
        return "Hello world";
    }

    @GetMapping("bye")
    public String bye() {
        return "bye";
    }
}
