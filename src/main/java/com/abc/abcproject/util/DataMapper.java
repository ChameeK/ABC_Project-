package com.abc.abcproject.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import com.abc.abcproject.domain.FlightDetails;
import com.abc.abcproject.dto.FlightDetailsDTO;

public class DataMapper {
	
	public static FlightDetailsDTO getFlightDetailsMapper(FlightDetails flightDetails) {
		FlightDetailsDTO flightDetailsDTO = new FlightDetailsDTO();
		flightDetailsDTO.setFlightid(flightDetails.getFlightid());
		flightDetailsDTO.setFlightNumber(flightDetails.getFlightNumber());
		flightDetailsDTO.setArrivalPort(flightDetails.getArrivalPort());
		flightDetailsDTO.setDeparturePort(flightDetails.getDeparturePort());
		flightDetailsDTO.setArrivalTime(dateFixer(flightDetails.getArrivalDate(), flightDetails.getArrivalTime()));
		flightDetailsDTO.setDepartureTime(dateFixer(flightDetails.getDepartureDate(), flightDetails.getDepartureTime()));
		return flightDetailsDTO;
	}
	
	private static LocalDateTime dateFixer(Date date, Date time){ 
		LocalDate datePart = LocalDate.parse(date.toString());
	    LocalTime timePart = LocalTime.parse(time.toString());
	    return LocalDateTime.of(datePart, timePart);		
	}
	


}
