package com.lti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.core.entities.AdminDetail;
import com.lti.core.entities.FlightDetail;
import com.lti.core.entities.FlightSchedule;
import com.lti.core.entities.UserDetail;
import com.lti.core.exceptions.HrExceptions;
import com.lti.core.services.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(value="/addFlight",consumes = "APPLICATION/JSON")
	public void addFlight(@RequestBody FlightSchedule flightSchedule) throws HrExceptions{
		//System.out.println(userDetails);
			//System.out.println(flightDetails.getFlightSchedule());
		System.out.println(flightSchedule);
		adminService.addFlight(flightSchedule);
			
	
		//return true;
	}
	
	@GetMapping(value="/viewFlight",produces = "APPLICATION/JSON")
	public @ResponseBody List<FlightDetail> ViewFlights() throws HrExceptions{
		//System.out.println(userDetails);
		
			//System.out.println(passengerService.getFlights());
			return adminService.getFlights();
	}
	@PostMapping(value="/deleteFlight",consumes = "APPLICATION/JSON")
	public void deleteFlight(@RequestBody FlightDetail flightDetails) throws HrExceptions{
		//System.out.println(userDetails);
			//System.out.println(flightDetails.getFlightScheduleDetails());
			adminService.deleteFlight(flightDetails);
			
	
		//return true;
	}
	
	@PostMapping(value="/adminlogin",consumes="Application/JSON")
	public List<AdminDetail> isLogin(@RequestBody AdminDetail adminDetails){
		
	//	System.out.println(userDetails);
		List<AdminDetail> u = adminService.isValid(adminDetails);
		System.out.println(u);
		return u;
		
	}
}
