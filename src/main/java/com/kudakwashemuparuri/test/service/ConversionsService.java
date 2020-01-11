package com.kudakwashemuparuri.test.service;

import org.springframework.stereotype.Service;

@Service

public class ConversionsService {
    public double convertKelvinToCelcious(Double kelvin) {

        return kelvin - 273.15F;
    }


    public double convertCelciusToKelvin(Double celcious) {

        return celcious + 273.15F;
    }

    public double milesTokm(double distanceInMiles) {
        return distanceInMiles * 1.60934;
    }

    public double kmTomiles(double distanceInKm) {
        return distanceInKm * 0.621371;
    }

}
