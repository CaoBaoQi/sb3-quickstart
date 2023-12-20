package jz.cbq.hellospringboot3.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * HelloRunner
 *
 * @author caobaoqi
 */
@Slf4j
@Component
public class HelloRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Hello I am HelloRunner !");
    }
}
