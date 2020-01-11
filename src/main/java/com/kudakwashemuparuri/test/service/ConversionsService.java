package com.kudakwashemuparuri.test.service;

import org.springframework.stereotype.Service;

@Service

public class ConversionsService {
    public double convertKelvinToCelcious(Double kelvin) {

        return kelvin- 273.15F;
    }
}
