package jz.cbq.hellospringboot3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author caobaoqi
 */
@RestController
@RequestMapping("/hellos")
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello SpringBoot3";
    }
}
