package com.kudakwashemuparuri.test.api;


import com.kudakwashemuparuri.test.service.ConversionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversions")
public class ConversionRestController {


    // Service Injection
    private final ConversionsService conversionsServise;

    public ConversionRestController(ConversionsService conversionsServise) {
        this.conversionsServise = conversionsServise;
    }


    // method convert to Celcius Controller Method
    @PostMapping("/ktoc")
    public double convertKelvinToCelcious(@RequestParam Double kelvin) {
        return conversionsServise.convertKelvinToCelcious(kelvin);
    }


    //method convert to kelvins

    @PostMapping("/ktoc")
    public double convertCelciusToKelvin(@RequestParam Double celcius) {
        return conversionsServise.convertCelciusToKelvin(celcius);
    }

    @PostMapping("/mtok")
    public double convertMilesToKm(Double miles) {
        return conversionsServise.milesTokm(miles);
    }

    @PostMapping("/kTom")
    public double kmTomiles(Double km) {
        return conversionsServise.kmTomiles(km);
    }


}
