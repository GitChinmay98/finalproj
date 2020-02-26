package com.lti.core.daos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.lti.core.entities.AdminDetail;
import com.lti.core.entities.FlightDetail;
import com.lti.core.entities.FlightScheduleDetail;
import com.lti.core.entities.UserDetail;
import com.lti.core.exceptions.HrExceptions;

public interface AdminDao {

	public void addFlight(FlightDetail flightDetails) throws HrExceptions;
	public void deleteFlight(FlightDetail flightDetails) throws HrExceptions;
	public List<FlightDetail> getFlights() throws HrExceptions;
	public List<AdminDetail> isValid(AdminDetail adminDetails);

}
