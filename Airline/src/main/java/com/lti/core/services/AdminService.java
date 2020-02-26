package com.lti.core.services;

import java.util.List;

import com.lti.core.entities.AdminDetail;
import com.lti.core.entities.FlightDetail;
import com.lti.core.entities.FlightSchedule;
import com.lti.core.exceptions.HrExceptions;

public interface AdminService {

	public void addFlight(FlightSchedule flightSchedule) throws HrExceptions;
	public void deleteFlight(FlightDetail flightDetails) throws HrExceptions;
	public List<FlightDetail> getFlights() throws HrExceptions;
	public List<AdminDetail> isValid(AdminDetail adminDetails);
}
