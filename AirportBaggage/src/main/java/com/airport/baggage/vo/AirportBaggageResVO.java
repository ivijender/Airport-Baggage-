package com.airport.baggage.vo;

import java.util.List;

/**
 * Created by inavoulv on 7/2/2018.
 */
public class AirportBaggageResVO {

	private List<BaggageResVO> BaggageResLst;
	
	public AirportBaggageResVO() {
		
	}

	public List<BaggageResVO> getBaggageResLst() {
		return BaggageResLst;
	}

	public void setBaggageResLst(List<BaggageResVO> baggageResLst) {
		BaggageResLst = baggageResLst;
	}

	@Override
	public String toString() {
		return "AirportBaggageResVO [BaggageResLst=" + BaggageResLst + "]";
	}

}
