package com.airport.baggage.constent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.airport.baggage.dto.Departures;
import com.airport.baggage.dto.Vertex;

/**
 * Created by inavoulv on 7/2/2018.
 */
public class AirportBaggageConstent {
	public static final String ARRIVAL="ARRIVAL";
	public static final String BAGGAGE_CLAIM="BAGGAGE_CLAIM";
	public static List<Vertex> NODES=new ArrayList<Vertex>(
			Arrays.asList(
					new Vertex(0, "CONCOURSE_A_TICKETING"),
					new Vertex(1, "A1"),
					new Vertex(2, "A2"),
					new Vertex(3, "A3"),
					new Vertex(4, "A4"),
					new Vertex(5, "A5"),
					new Vertex(6, "A6"),
					new Vertex(7, "A7"),
					new Vertex(8, "A8"),
					new Vertex(9, "A9"),
					new Vertex(10, "A10"),
					new Vertex(11, "BAGGAGE_CLAIM")			
					));
	public static List<Departures> DEPARTURES_LIST=new ArrayList<Departures>(
			Arrays.asList(
					new Departures("UA10","A1","MIA","08:00"),
					new Departures("UA11","A1","LAX","09:00"),
					new Departures("UA12","A1","JFK","09:45"),
					new Departures("UA13","A2","JFK","08:30"),
					new Departures("UA14","A2","JFK","09:45"),
					new Departures("UA15","A2","JFK","10:00"),
					new Departures("UA16","A3","JFK","09:00"),
					new Departures("UA17","A4","MHT","09:15"),
					new Departures("UA18","A5","LAX","10:15")
					));
}
