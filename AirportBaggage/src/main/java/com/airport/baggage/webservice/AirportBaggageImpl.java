package com.airport.baggage.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airport.baggage.constent.AirportBaggageConstent;
import com.airport.baggage.dto.Departures;
import com.airport.baggage.service.AirportBaggageProcess;
import com.airport.baggage.vo.AirportBaggageReqVO;
import com.airport.baggage.vo.AirportBaggageResVO;
import com.airport.baggage.vo.BaggageReqVO;
import com.airport.baggage.vo.BaggageResVO;

/**
 * Created by inavoulv on 7/2/2018.
 */
@RestController()
@RequestMapping("/airport")
public class AirportBaggageImpl {

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Pizza Hut";
	}

	@RequestMapping(value = "/baggage", method = RequestMethod.POST)
	public AirportBaggageResVO newOrder(@RequestBody AirportBaggageReqVO airportBaggageReq) {
		AirportBaggageProcess airportBaggageProcess = new AirportBaggageProcess();
		AirportBaggageResVO airportBaggageResVO = new AirportBaggageResVO();
		List<BaggageResVO> bagLst = new ArrayList<BaggageResVO>();
		
		//Bag list Format
		for (BaggageReqVO baggageReqLst : airportBaggageReq.getBaggageReqLst()) {
			BaggageResVO baggageResVO = airportBaggageProcess.processAirportBaggage(baggageReqLst.getBagNumber(),
					baggageReqLst.getEntryPoint(), baggageReqLst.getFlightId());
			bagLst.add(baggageResVO);
		}
		airportBaggageResVO.setBaggageResLst(bagLst);
		return airportBaggageResVO;
	}
}
