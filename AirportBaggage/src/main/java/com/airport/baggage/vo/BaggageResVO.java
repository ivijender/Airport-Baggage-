package com.airport.baggage.vo;

/**
 * Created by inavoulv on 7/2/2018.
 */
public class BaggageResVO {

	private String id;
	private String bagPath;
	private int timeTravel;
	private String message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTimeTravel() {
		return timeTravel;
	}

	public void setTimeTravel(int timeTravel) {
		this.timeTravel = timeTravel;
	}

	public String getBagPath() {
		return bagPath;
	}

	public void setBagPath(String bagPath) {
		this.bagPath = bagPath;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BaggageResVO [id=" + id + ", bagPath=" + bagPath + ", timeTravel=" + timeTravel + ", message=" + message
				+ "]";
	}

}
