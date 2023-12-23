package jz.cbq.testcustomstaterrestfultools;

import jakarta.annotation.Resource;
import jz.cbq.customstatersb3.RestfulTools;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author caobaoqi
 */
@RestController
public class TestController {
    @Resource
    public RestfulTools restfulTools;

    @GetMapping("/")
    public String index(){
        return restfulTools.getForString("http://www.baidu.com");
    }
}
