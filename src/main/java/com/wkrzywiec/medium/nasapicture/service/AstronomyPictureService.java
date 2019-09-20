package com.wkrzywiec.medium.nasapicture.service;

import com.wkrzywiec.medium.nasapicture.model.AstronomyPictureOfDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.concurrent.*;


@Service
public class AstronomyPictureService {

    @Autowired
    private RestTemplate restTemplate;
    
    LocalDate startDate = LocalDate.of(2017, 1, 1); //start date
    long start = startDate.toEpochDay();

    LocalDate endDate = LocalDate.now(); //end date
    long end = endDate.toEpochDay();

    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    String date = simpleDateFormat.format(randomEpochDay);
    
    public AstronomyPictureOfDay getTodayPicture() {
        return restTemplate.getForObject(
                "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date="+date,
                AstronomyPictureOfDay.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
