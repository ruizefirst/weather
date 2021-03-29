package com.epam.temperature.pojo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Weatherinfo implements Serializable {
    private String city;
    private String cityid;
    private String temp;
    private String WD;
    private String WS;
    private String SD;
    private String AP;
    private String njd;
    private String WSE;
    private String time;
    private String sm;
    private String isRadar;
    private String Radar;
}
