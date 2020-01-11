package com.kudakwashemuparuri.test.api;


import com.kudakwashemuparuri.test.service.ConversionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversions")
public class ConversionRestController {



    private final ConversionsService conversionsServise;

    public ConversionRestController(ConversionsService conversionsServise) {
        this.conversionsServise = conversionsServise;
    }

    @PostMapping("/ktoc")
    public double convertKelvinToCelcious(Double kelvin) {
        return conversionsServise.convertKelvinToCelcious(kelvin);
    }
}
