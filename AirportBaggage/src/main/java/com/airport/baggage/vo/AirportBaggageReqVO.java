package com.airport.baggage.vo;

import java.util.List;

public class AirportBaggageReqVO {
	
	 private List<BaggageReqVO> BaggageReqLst;
	 
	 public AirportBaggageReqVO(){
		 
	 }

	public List<BaggageReqVO> getBaggageReqLst() {
		return BaggageReqLst;
	}

	public void setBaggageReqLst(List<BaggageReqVO> baggageReqLst) {
		BaggageReqLst = baggageReqLst;
	}

	@Override
	public String toString() {
		return "AirportBaggageReqVO [BaggageReqLst=" + BaggageReqLst + "]";
	}
	
	
}
