package com.epam.temperature.controller;

import com.alibaba.fastjson.JSONObject;
import com.epam.temperature.pojo.Optional;
import com.epam.temperature.service.Itemperature;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
public class TemperatureController {

   @Resource(name="Impl")
    Itemperature itemp;

    @ResponseBody
    @RequestMapping(value = "temp",method = RequestMethod.POST)
    public Optional<Integer> getTemperature( String province,String city,String county){
        return itemp.getTemp( province, city, county);
    }

    @ResponseBody
    @RequestMapping(value = "china",method = RequestMethod.POST)
    public JSONObject getProvince(){
        return itemp.getPro();
    }

    @ResponseBody
    @RequestMapping(value = "city",method = RequestMethod.POST)
    public JSONObject getCity(String code){
        return itemp.getC(code);
    }

    @ResponseBody
    @RequestMapping(value = "station",method = RequestMethod.POST)
    public JSONObject getStation(String code){
        return itemp.getSta(code);
    }

}
