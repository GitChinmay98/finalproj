

package com.lti.core.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.core.entities.BankDetail;
import com.lti.core.entities.FlightDetail;
import com.lti.core.entities.FlightScheduleDetail;
import com.lti.core.entities.PassengerDetail;
import com.lti.core.entities.UserDetail;
import com.lti.core.exceptions.HrExceptions;




@Repository
public class UserDetailsImpl implements UserDetailsDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional(propagation = Propagation.REQUIRED)//REQUIRED ==> it is used to carry out the same transaction started in the service layer
	@Override
	public boolean userRegistration(UserDetail userDetails) {
		manager.persist(userDetails);
		return true;
	}

	/*@Override
	public List<FlightDetails> getFlights() throws HrExceptions {
		String query="select e from FlightDetails e join fetch e.flightScheduleDetails b where e.source='pune' and e.destination='mumbai' and b.departureDate='02-MAR-2020'";
		Query q=manager.createQuery(query);
		//System.out.println(q.getSingleResult());
		List<FlightDetails> lst=q.getResultList();
		//List<FlightDetails> u=q.getResultList();
		
		return lst;
	}
*/
	@Override
	public List<FlightDetail> getFlights(String source,String destination,LocalDate departureDate ) throws HrExceptions {
		String query="select e from FlightDetail e join fetch e.flightScheduleDetails b where e.source=:source and e.destination=:destination and b.departureDate=:departureDate";
		Query q=manager.createQuery(query);
		q.setParameter("source", source);
		q.setParameter("destination", destination);
		q.setParameter("departureDate", departureDate);
		//System.out.println(q.getSingleResult());
		List<FlightDetail> lst=q.getResultList();
		//List<FlightDetails> u=pq.getResultList();
		
		return lst;
	}
	@Override
	public List<UserDetail> isValid(UserDetail userDetails) {
		
		System.out.println(userDetails.getEmail());
		String q="select e from UserDetail e where e.email=:u and e.password=:p";
		Query qq=manager.createQuery(q);
		qq.setParameter("u", userDetails.getEmail());
		qq.setParameter("p", userDetails.getPassword());
		
		List<UserDetail> user1=qq.getResultList();
		List<UserDetail> u=new ArrayList<>();
		if(user1.isEmpty())
			return u;
		else
		return user1;
	}

@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<FlightDetail> getFlightsafterLogin(String source, String destination, LocalDate departureDate,
			String flightClass) throws HrExceptions {
		if(flightClass.equals("Economy"))
		{
			String query="select e,b.economySeats as availableSeats,b.economyPrice as price from FlightDetail e join fetch e.flightScheduleDetails b where e.source=:source and e.destination=:destination and b.departureDate=:departureDate"; 
			
			Query q=manager.createQuery(query);
			q.setParameter("source", source);
			q.setParameter("destination", destination);
			q.setParameter("departureDate", departureDate);
			System.out.println(q.getFirstResult());
			List<FlightDetail> flightDetails=q.getResultList();
			return flightDetails;
		}
		else
		{
			String query="select e,b.businessSeats as availableSeats,b.businessPrice as price from FlightDetail e join fetch e.flightScheduleDetails b where e.source=:source and e.destination=:destination and b.departureDate=:departureDate"; 
			Query q=manager.createQuery(query);
			q.setParameter("source", source);
			q.setParameter("destination", destination);
			q.setParameter("departureDate", departureDate);
			List<FlightDetail> flightDetails=q.getResultList();
			return flightDetails;
			
			
		}
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addPassenger(PassengerDetail passengerDetails) {
		manager.persist(passengerDetails);
		
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateSchedule(int newSeats1, int schedule,String flightc) {
		if(flightc.equals("Economy")){
		String q="update  FlightScheduleDetail e set e.economySeats=:newS where e.scheduleId=:sid  ";
		Query qq=manager.createQuery(q);
		qq.setParameter("newS",newSeats1);
		qq.setParameter("sid", schedule);
		int val=qq.executeUpdate();
		System.out.println(val);
		}
		else
		{
			
				String q="update  FlightScheduleDetail e set e.businessSeats=:newS where e.scheduleId=:sid  ";
				Query qq=manager.createQuery(q);
				qq.setParameter("newS",newSeats1);
				qq.setParameter("sid", schedule);
				int val=qq.executeUpdate();
				System.out.println(val);
			
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean doPayment(int price, long accNo, int userId) {
		
		System.out.println(accNo);
		try{
		String q="select e from BankDetail e where e.accNo=:acno";
		Query qq=manager.createQuery(q);
		qq.setParameter("acno",accNo);
		BankDetail bank= (BankDetail) qq.getSingleResult();
		
		System.out.println(bank.getBankBalance());
		
		}catch(Exception e){
			System.out.println("Account not found");
			return false;
			
		}
		return false;
	}

	
		
//	@Override
//	public List<FlightDetails> getFlights() throws HrExceptions {
//		// TODO Auto-generated method stub
//		String query="select e from FlightDetails e join fetch e.flightScheduleDetails b where e.flightId=501";
//		Query q=manager.createQuery(query);
//		List<FlightDetails> lst=q.getResultList();
//		//List<FlightDetails> u=q.getResultList();
//		
//		return lst;
//	}

//	@Transactional(propagation = Propagation.REQUIRED)//REQUIRED ==> it is used to carry out the same transaction started in the service layer
//	@Override
//	public boolean insertDept(Department d) throws HrException {
//		// TODO Auto-generated method stub
//	    manager.persist(d);
//		return true;
//	}
	

}
