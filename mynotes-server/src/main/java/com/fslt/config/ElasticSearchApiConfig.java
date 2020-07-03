package com.fslt.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: ElasticSearchApiConfig
 * @date: 2020/7/3 10:00
 * @author: 林宗雄
 * @version: 1.0
 */
@Configuration
public class ElasticSearchApiConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("47.100.138.188", 9200, "http")));
        return client;
    }

}
