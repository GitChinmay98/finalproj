package com.lti.core.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.AdminDao;
import com.lti.core.entities.AdminDetail;
import com.lti.core.entities.FlightDetail;
import com.lti.core.entities.FlightSchedule;
import com.lti.core.entities.FlightScheduleDetail;
import com.lti.core.exceptions.HrExceptions;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao admindao;

	@Override
	public void addFlight(FlightSchedule flightSchedule) throws HrExceptions {
		FlightDetail fd1=new FlightDetail();
		fd1.setSource(flightSchedule.getSource());
		fd1.setDestination(flightSchedule.getDestination());
		fd1.setCarrier(flightSchedule.getCarrier());
		List<FlightScheduleDetail> fd = new ArrayList<>();
		
		//LocalDate start = LocalDate.of(fs.getScheduledStartDate().getYear(),fs.getScheduledStartDate().getMonth(),fs.getScheduledStartDate().getDate());
		LocalDate start = flightSchedule.getScheduledStartDate(); 
		LocalDate end = start.plusMonths(flightSchedule.getDurationInMonths());
		
		
		long daysBetween = ChronoUnit.DAYS.between(start,end);
		
		for(long l = 0; l < daysBetween; l++) {
			FlightScheduleDetail fsd = new FlightScheduleDetail();
			start = start.plusDays(1);
			fsd.setDepartureDate(start);
			fsd.setArrival(flightSchedule.getArrival());
			fsd.setDeparture(flightSchedule.getDeparture());
			fsd.setBusinessSeats(flightSchedule.getBusinessSeats());
			LocalTime at=flightSchedule.getArrival();
			LocalTime dt=flightSchedule.getDeparture();
			int timeBetween=at.getHour()-dt.getHour();
			fsd.setDuration(timeBetween);
			fsd.setEconomySeats(flightSchedule.getEconomySeats());
			fsd.setBusinessPrice(flightSchedule.getBusinessPrice());
			fsd.setEconomyPrice(flightSchedule.getEconomyPrice());
			fsd.setFlightDetails(fd1);
			fd.add(fsd);
		}
		fd1.setFlightScheduleDetails(fd);
		
		admindao.addFlight(fd1);
		
	}

	@Override
	public void deleteFlight(FlightDetail flightDetails) throws HrExceptions {
		// TODO Auto-generated method stub
		LocalDate ddate=null;
		LocalTime departure=null;
		
		String source=flightDetails.getSource();
		System.out.println(source);
		String destination=flightDetails.getDestination();
		
		FlightSchedule fs=flightDetails.getFlightSchedule();
		List<FlightScheduleDetail> fsd=new ArrayList<>();
		
		FlightScheduleDetail fsd1=new FlightScheduleDetail();
		System.out.println(fs.getDepartureDateinFlightSchedule());
		fsd1.setDepartureDate(fs.getDepartureDateinFlightSchedule());
		fsd1.setDeparture(fs.getDeparture());
//		List<FlightScheduleDetails> fsd= flightDetails.getFlightScheduleDetails();
//		for(FlightScheduleDetails fsd1:fsd){
//		ddate=fsd1.getDepartureDate();
//		departure=fsd1.getDeparture();}
//		String Carrier =flightDetails.getCarrier();
		fsd.add(fsd1);
		flightDetails.setFlightScheduleDetails(fsd);
		admindao.deleteFlight(flightDetails);
		
		
		
		
		
		
	}

	@Override
	public List<FlightDetail> getFlights() throws HrExceptions {
		// TODO Auto-generated method stub
		return admindao.getFlights();
	}

	@Override
	public List<AdminDetail> isValid(AdminDetail adminDetails) {
		// TODO Auto-generated method stub
		return admindao.isValid(adminDetails);
	}

}
