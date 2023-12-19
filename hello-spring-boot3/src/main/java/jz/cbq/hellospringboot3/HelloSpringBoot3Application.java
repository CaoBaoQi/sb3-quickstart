package jz.cbq.hellospringboot3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Slf4j
public class HelloSpringBoot3Application {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBoot3Application.class, args);

        log.info("Hello SpringBoot3 Application run success ");
    }

    @Controller
    static class HelloController{

        @GetMapping("/sayHello")
        @ResponseBody
        public String sayHello(){
            return "Hello SpringBoot3";
        }
    }

}
