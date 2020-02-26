package com.lti.core.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lti.core.entities.FlightDetail;
import com.lti.core.entities.Passenger;
import com.lti.core.entities.UserDetail;
import com.lti.core.exceptions.HrExceptions;

public interface PassengerService {

	public boolean addPassenger(Passenger passenger)  throws HrExceptions;
	public List<FlightDetail> getFlights(String source, String destination, LocalDate departureDate) throws HrExceptions;
	public List<FlightDetail> getFlightsAfterLogin(String source, String destination, LocalDate departureDate,String flightClass) throws HrExceptions;
	public List<UserDetail> isValid(UserDetail userDetails);
	public boolean register(UserDetail userDetails) throws HrExceptions;
	public boolean doPayment(int price, long accNo, int userId);
}
