package com.lti.core.entities;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="FLIGHT_DETAILS")
@SequenceGenerator(name = "seqDetails", sequenceName = "FLIGHT_DETAILS_SEQUENCE", allocationSize = 1, initialValue = 500)
public class FlightDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDetails")
	private int flightId;
	
	private String source;
	private String destination;
	private String carrier;
	
	
	@Transient
	private FlightSchedule flightSchedule;
	
	@JsonIgnore
	@OneToMany(mappedBy = "flightDetails", cascade = CascadeType.ALL)
	private List<FlightScheduleDetail> flightScheduleDetails;
	
	
	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}
	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}
	
	public List<FlightScheduleDetail> getFlightScheduleDetails() {
		return flightScheduleDetails;
	}
	public void setFlightScheduleDetails(List<FlightScheduleDetail> flightScheduleDetails) {
		this.flightScheduleDetails = flightScheduleDetails;
	}
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
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
	
	public FlightDetail() {
		super();
	}
	public FlightDetail(int flightId, String source, String destination, String carrier,
			List<FlightScheduleDetail> flightScheduleDetails) {
		super();
		this.flightId = flightId;
		this.source = source;
		this.destination = destination;
		this.carrier = carrier;
	
		this.flightScheduleDetails = flightScheduleDetails;
	}
//	@Override
//	public String toString() {
//		return "FlightDetails [flightId=" + flightId + ", source=" + source + ", destination=" + destination
//				+ ", carrier=" + carrier + ", duration=" + duration + "]";
//	}
	/*@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", source=" + source + ", destination=" + destination
				+ ", carrier=" + carrier + ", duration=" + duration + "]";
	}*/
}
