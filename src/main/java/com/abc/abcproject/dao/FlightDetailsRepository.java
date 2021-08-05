package com.abc.abcproject.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.abcproject.domain.FlightDetails;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer> {
		
	@Query("from FlightDetails a where arrivalDate between :startDate and :endDate")
	public List<FlightDetails> findByArrivalTimeAtBetween(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
	
	public List<FlightDetails> findByFlightNumberStartsWith(String rating);

}
