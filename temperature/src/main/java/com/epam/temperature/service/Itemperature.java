package com.epam.temperature.service;

import com.alibaba.fastjson.JSONObject;
import com.epam.temperature.pojo.Optional;

public interface Itemperature {
    Optional<Integer> getTemp(String province,String city,String county);
    JSONObject getPro();
    JSONObject getC(String code);
    JSONObject getSta(String code);
}
