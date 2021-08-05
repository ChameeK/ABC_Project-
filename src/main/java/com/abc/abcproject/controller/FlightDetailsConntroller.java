package com.abc.abcproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abc.abcproject.dto.FlightDetailsDTO;
import com.abc.abcproject.exception.NoRecordFoundException;
import com.abc.abcproject.exception.ServerErrorException;
import com.abc.abcproject.service.FlightDetailsService;

@RestController
public class FlightDetailsConntroller {
		
	@Autowired
	private FlightDetailsService flightDetailsService;
	
	@RequestMapping(value = "/flights", method = RequestMethod.GET, produces = "application/json")
	public List<FlightDetailsDTO> flightsForToday()
	{
		return flightDetailsService.flightsForToday();
	}
	
	@RequestMapping(value = "/flights/{airlinecode}", method = RequestMethod.GET, produces = "application/json")
	public List<FlightDetailsDTO> flightsOnAirlineCode(@PathVariable String airlinecode)
	{
	
		return flightDetailsService.flightsOnAirlineCode(airlinecode);

	}
	
}
