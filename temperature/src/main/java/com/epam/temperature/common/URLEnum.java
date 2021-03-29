package com.epam.temperature.common;

public enum URLEnum {

    GET_CHINA_URL("http://www.weather.com.cn/data/city3jdata/china.html"),
    GET_CITY_URL("http://www.weather.com.cn/data/city3jdata/provshi/"),
    GET_STATION_URL("http://www.weather.com.cn/data/city3jdata/station/"),
    GET_CERTAIN_WEATHER_URL("http://www.weather.com.cn/data/sk/"),
    SUFFIX(".html");



    private String value;
    private URLEnum(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
