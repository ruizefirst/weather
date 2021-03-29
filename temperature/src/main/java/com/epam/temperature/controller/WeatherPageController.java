package com.epam.temperature.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeatherPageController {
    @RequestMapping("areatemp")
    public ModelAndView HelloWorld(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("area");
        return mv;
    }
}
