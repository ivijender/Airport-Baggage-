package com.airport.baggage.dto;

/**
 * Created by inavoulv on 7/2/2018.
 */
public class Departures {

	private String flightId;
	private String flightGate;
	private String destination;
	private String flightTime;
	
	
	public Departures(String flightId, String flightGate, String destination, String flightTime) {
		super();
		this.flightId = flightId;
		this.flightGate = flightGate;
		this.destination = destination;
		this.flightTime = flightTime;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getFlightGate() {
		return flightGate;
	}
	public void setFlightGate(String flightGate) {
		this.flightGate = flightGate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	@Override
	public String toString() {
		return "Departures [flightId=" + flightId + ", flightGate=" + flightGate + ", destination=" + destination
				+ ", flightTime=" + flightTime + "]";
	}
	
	
	
}
