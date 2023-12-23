package jz.cbq.customstatersb3;

import org.springframework.web.client.RestTemplate;

/**
 * RestfulTools
 *
 * @author caobaoqi
 */
public class RestfulTools {
    public String getForString(String url){
        return new RestTemplate().getForObject(url, String.class);
    }
}
