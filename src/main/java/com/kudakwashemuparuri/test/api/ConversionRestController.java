package com.kudakwashemuparuri.test.api;


import com.kudakwashemuparuri.test.dto.Celsius;
import com.kudakwashemuparuri.test.service.ConversionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversions")
public class ConversionRestController {


    @Autowired
    private final ConversionsService conversionsServise;

    public ConversionRestController(ConversionsService conversionsServise) {
        this.conversionsServise = conversionsServise;
    }


    public Celsius convertKelvinToCelcious(Double Celcius){



     }
}
