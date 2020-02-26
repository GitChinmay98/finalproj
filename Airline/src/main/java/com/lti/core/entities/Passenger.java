package com.lti.core.entities;

import java.util.List;

public class Passenger {

	private int userId;
	private int scheduleId;
	
	private String passengername;
	private String passengerAge;
	private String passengerGender;
	private String seatNo;
	private String flightClass;
	private int availableSeats;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getPassengername() {
		return passengername;
	}
	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}
	public String getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Passenger() {
		super();
	}
	public Passenger(int userId, int scheduleId, String passengername, String passengerAge, String passengerGender,
			String seatNo, String flightClass, int availableSeats) {
		super();
		this.userId = userId;
		this.scheduleId = scheduleId;
		this.passengername = passengername;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
		this.seatNo = seatNo;
		this.flightClass = flightClass;
		this.availableSeats = availableSeats;
	}
	
}
