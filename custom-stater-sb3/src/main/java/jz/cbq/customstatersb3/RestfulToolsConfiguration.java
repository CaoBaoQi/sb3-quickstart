package jz.cbq.customstatersb3;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestfulToolsConfiguration
 *
 * @author caobaoqi
 */
@Configuration
@ConditionalOnClass({RestTemplate.class})
public class RestfulToolsConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "cbq.restful.tools.enable",havingValue = "true",matchIfMissing = false)
    public RestfulTools restfulTools(){
        return new RestfulTools();
    }
}
