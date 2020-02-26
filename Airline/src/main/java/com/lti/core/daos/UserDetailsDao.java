package com.lti.core.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.lti.core.entities.FlightDetail;
import com.lti.core.entities.PassengerDetail;
import com.lti.core.entities.UserDetail;
import com.lti.core.exceptions.HrExceptions;

public interface UserDetailsDao {

	public boolean userRegistration(UserDetail userDetails) throws HrExceptions;
	public List<FlightDetail> getFlights(String source,String destination,LocalDate departureDate) throws HrExceptions;
	public List<UserDetail> isValid(UserDetail userDetails);
	public List<FlightDetail> getFlightsafterLogin(String source,String destination,LocalDate departureDate,String flightClass) throws HrExceptions;
	public void addPassenger(PassengerDetail passengerDetails);
	public void updateSchedule(int newSeats1, int schedule, String flightc);
	
	public boolean doPayment(int price, long accNo, int userId);
}
