package jz.cbq.hellospringboot3;

import jz.cbq.hellospringboot3.spring.server.BaseApp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class HelloSpringBoot3Application extends BaseApp {

    public static void main(String[] args) {
        run(HelloSpringBoot3Application.class, args);

        log.info("HelloSpringBoot3Application run successful ");
    }

}
