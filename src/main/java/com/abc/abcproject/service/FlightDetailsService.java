package com.abc.abcproject.service;

import java.util.List;
import com.abc.abcproject.dto.FlightDetailsDTO;
import com.abc.abcproject.exception.NoRecordFoundException;
import com.abc.abcproject.exception.ServerErrorException;

public interface FlightDetailsService {
	
	public List<FlightDetailsDTO> flightsForToday()throws NoRecordFoundException, ServerErrorException;

	public List<FlightDetailsDTO> flightsOnAirlineCode(String airlinecode);

}
