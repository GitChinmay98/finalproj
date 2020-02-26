package com.lti.core.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FlightSchedule {

	private String source;
	private String destination;
	private String carrier;
	
	private LocalDate scheduledStartDate;
	private int durationInMonths;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime arrival;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime departure;
	private int economySeats;
	private int economyPrice;
	private int businessSeats;
	private int businessPrice;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate departureDateinFlightSchedule;
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public LocalDate getDepartureDateinFlightSchedule() {
		return departureDateinFlightSchedule;
	}
	public void setDepartureDateinFlightSchedule(LocalDate departureDateinFlightSchedule) {
		this.departureDateinFlightSchedule = departureDateinFlightSchedule;
	}
	public LocalDate getScheduledStartDate() {
		return scheduledStartDate;
	}
	public void setScheduledStartDate(LocalDate scheduledStartDate) {
		this.scheduledStartDate = scheduledStartDate;
	}
	public int getDurationInMonths() {
		return durationInMonths;
	}
	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
	public LocalTime getArrival() {
		return arrival;
	}
	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}
	public LocalTime getDeparture() {
		return departure;
	}
	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}
	public int getEconomySeats() {
		return economySeats;
	}
	public void setEconomySeats(int economySeats) {
		this.economySeats = economySeats;
	}
	public int getEconomyPrice() {
		return economyPrice;
	}
	public void setEconomyPrice(int economyPrice) {
		this.economyPrice = economyPrice;
	}
	public int getBusinessSeats() {
		return businessSeats;
	}
	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}
	public int getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(int businessPrice) {
		this.businessPrice = businessPrice;
	}
	@Override
	public String toString() {
		return "FlightSchedule [arrival=" + arrival + ", departure=" + departure + "]";
	}
}
