package com.lti.core.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.UserDetailsDao;
import com.lti.core.entities.FlightDetail;
import com.lti.core.entities.FlightScheduleDetail;
import com.lti.core.entities.Passenger;
import com.lti.core.entities.PassengerDetail;
import com.lti.core.entities.UserDetail;
import com.lti.core.exceptions.HrExceptions;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private UserDetailsDao userDetailsDao;
	
	
	@Override
	public boolean addPassenger(Passenger passenger) throws HrExceptions {
		UserDetail userDetails=new  UserDetail();
		PassengerDetail passengerDetails =new PassengerDetail();
		FlightScheduleDetail flightScheduleDetails=new FlightScheduleDetail();
		flightScheduleDetails.setScheduleId(passenger.getScheduleId());
		userDetails.setUserId(passenger.getUserId());
		passengerDetails.setSeatNo(passenger.getSeatNo());
		passengerDetails.setPassengerName(passenger.getPassengername());
		passengerDetails.setPassengerGender(passenger.getPassengerGender());
		passengerDetails.setPassengerAge(passenger.getPassengerAge());
		passengerDetails.setFlightClass(passenger.getFlightClass());
		passengerDetails.setFlightScheduleDetails(flightScheduleDetails);
		passengerDetails.setUserDetails(userDetails);
		List<PassengerDetail> passengerDetails2=new ArrayList<>();
		passengerDetails2.add(passengerDetails);
		userDetails.setPassengerDetails(passengerDetails2);
		userDetailsDao.addPassenger(passengerDetails);
		int newSeats=passenger.getAvailableSeats();
		int newSeats1=newSeats-1;
		int sid=passenger.getScheduleId();
		String flightc=passenger.getFlightClass();
		userDetailsDao.updateSchedule(newSeats1, sid,flightc);
		return true;
		
	}


	@Override
	public List<FlightDetail> getFlights(String source, String destination, LocalDate departureDate) throws HrExceptions {
		// TODO Auto-generated method stub
		return userDetailsDao.getFlights(source,destination,departureDate);
	}


	@Override
	public List<UserDetail> isValid(UserDetail userDetails) {
		// TODO Auto-generated method stub
		List<UserDetail> user=userDetailsDao.isValid(userDetails);
		return user;
	}


	@Override
	public List<FlightDetail> getFlightsAfterLogin(String source, String destination, LocalDate departureDate,
			String flightClass) throws HrExceptions {
		// TODO Auto-generated method stub
		return userDetailsDao.getFlightsafterLogin(source, destination, departureDate, flightClass);
	}


	@Override
	public boolean register(UserDetail userDetails) throws HrExceptions {
		// TODO Auto-generated method stub
		return userDetailsDao.userRegistration(userDetails);
	}


	@Override
	public boolean doPayment(int price, long accNo, int userId) {
		// TODO Auto-generated method stub
		return userDetailsDao.doPayment(price, accNo, userId);
	}

	
	
	
}
