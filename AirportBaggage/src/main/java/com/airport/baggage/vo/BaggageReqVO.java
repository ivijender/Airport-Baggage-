package com.airport.baggage.vo;

public class BaggageReqVO {
	private String bagNumber;
	private String entryPoint;
	private String flightId;
	
	public BaggageReqVO(String bagNumber, String entryPoint, String flightId) {
		super();
		this.bagNumber = bagNumber;
		this.entryPoint = entryPoint;
		this.flightId = flightId;
	}
	public BaggageReqVO(){
		
	}
	public String getBagNumber() {
		return bagNumber;
	}
	public void setBagNumber(String bagNumber) {
		this.bagNumber = bagNumber;
	}
	public String getEntryPoint() {
		return entryPoint;
	}
	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	@Override
	public String toString() {
		return "BaggageReqVO [bagNumber=" + bagNumber + ", entryPoint=" + entryPoint + ", flightId=" + flightId + "]";
	}
	
	
}
