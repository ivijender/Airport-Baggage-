package com.airport.baggage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by inavoulv on 7/2/2018.
 */
@ComponentScan("com.airport")
@SpringBootApplication
public class AirportBaggageMain {
	 public static void main(String[] args) {
	        SpringApplication.run(AirportBaggageMain.class, args);
	    }
}
