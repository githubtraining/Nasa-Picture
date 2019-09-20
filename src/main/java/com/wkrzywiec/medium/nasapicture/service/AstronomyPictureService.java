package com.wkrzywiec.medium.nasapicture.service;

import com.wkrzywiec.medium.nasapicture.model.AstronomyPictureOfDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class AstronomyPictureService {

    @Autowired
    private RestTemplate restTemplate;
    
    LocalDate randomDate = createRandomDate(2017, 2019);    
    
    String fullUrl = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=" + randomDate;
    
    public AstronomyPictureOfDay getTodayPicture() {
        return restTemplate.getForObject(
                fullUrl,
                AstronomyPictureOfDay.class);
    }
    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 18);
        int month = createRandomIntBetween(1, 9);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
