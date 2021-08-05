package com.abc.abcproject.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.abcproject.dao.FlightDetailsRepository;
import com.abc.abcproject.domain.FlightDetails;
import com.abc.abcproject.dto.FlightDetailsDTO;
import com.abc.abcproject.exception.NoRecordFoundException;
import com.abc.abcproject.exception.ServerErrorException;
import com.abc.abcproject.service.FlightDetailsService;
import com.abc.abcproject.util.DataMapper;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Override
	public List<FlightDetailsDTO> flightsForToday() throws NoRecordFoundException, ServerErrorException{
		try {
			Calendar date = Calendar.getInstance();
			date.set(Calendar.HOUR_OF_DAY, 0);
			date.set(Calendar.MINUTE, 0);
			date.set(Calendar.SECOND, 0);

			Date today = date.getTime();
			date.add(Calendar.DATE, 1);
			Date tomorrow = date.getTime();

			List<FlightDetails> flightDetails = flightDetailsRepository.findByArrivalTimeAtBetween(today, tomorrow);
			List<FlightDetailsDTO> flightDetailsDTO = new ArrayList<FlightDetailsDTO>();

			if (flightDetails!= null && flightDetails.size() > 0) 
			{
				for (FlightDetails fd : flightDetails) 
				{
					flightDetailsDTO.add(DataMapper.getFlightDetailsMapper(fd));
				}
			} 
			else 
			{
				throw new NoRecordFoundException("No record found");
			}
			return flightDetailsDTO;
		} 
		catch (Exception ex) 
		{
			throw new ServerErrorException("Server Error");
		}
	}
	
	@Override
	public List<FlightDetailsDTO> flightsOnAirlineCode(String airlinecode)
	{
		try {
			List<FlightDetails> flightDetails = flightDetailsRepository.findByFlightNumberStartsWith(airlinecode);
			List<FlightDetailsDTO> flightDetailsDTO = new ArrayList<FlightDetailsDTO>();
	
			if (flightDetails!= null && flightDetails.size() > 0) 
			{
				for (FlightDetails fd : flightDetails) 
				{
					flightDetailsDTO.add(DataMapper.getFlightDetailsMapper(fd));
				}
			} 
			else 
			{
				throw new NoRecordFoundException("No record found");
			}
			return flightDetailsDTO;
		} 
		catch (Exception ex) 
		{
			throw new ServerErrorException("Server Error");
		}
	}

}
