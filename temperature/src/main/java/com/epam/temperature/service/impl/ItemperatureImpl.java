package com.epam.temperature.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.epam.temperature.common.URLEnum;
import com.epam.temperature.pojo.Optional;
import com.epam.temperature.pojo.Weatherinfo;
import com.epam.temperature.service.Itemperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("Impl")
public class ItemperatureImpl implements Itemperature {
    @Autowired
    RestTemplate restTemplate;
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Override
    public Optional<Integer> getTemp(String province, String city, String county) {
        Optional<Integer> optional = new Optional<Integer>();
        String url = URLEnum.GET_CERTAIN_WEATHER_URL.getValue();
        url = url+province+city.trim()+county.trim()+URLEnum.SUFFIX.getValue();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        JSONObject json = JSONObject.parseObject(responseEntity.getBody());
        optional.setTemp(json.getObject("weatherinfo", Weatherinfo.class).getTemp());
        return optional;
    }

    @Override
    public JSONObject getPro() {
        String url = URLEnum.GET_CHINA_URL.getValue();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        JSONObject json = JSONObject.parseObject(responseEntity.getBody());
        return json;
    }

    @Override
    public JSONObject getC(String code) {
        String url = URLEnum.GET_CITY_URL.getValue()+code+URLEnum.SUFFIX.getValue();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        JSONObject json = JSONObject.parseObject(responseEntity.getBody());
        return json;
    }

    @Override
    public JSONObject getSta(String code) {
        String url = URLEnum.GET_STATION_URL.getValue()+code+URLEnum.SUFFIX.getValue();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        JSONObject json = JSONObject.parseObject(responseEntity.getBody());
        return json;
    }
}
