package RESTAuth.repo;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(generator = "user-id-gen")
	@GenericGenerator(name = "user-id-gen", 
		parameters = @Parameter(name = "prefix", value = "FL"), 
		strategy = "com.dxbair.services.flightbooking.domain.util.StringSequenceIdGenerator")
	private String id;
	private String departure;
	private String arrival;
	private LocalDateTime departureDate;
	private LocalDateTime arrivalDate;
	
	@ManyToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<UserBooking> bookings;

	public User() {
		super();
	}

	public User(String id, String departure, String arrival, LocalDateTime departureDate, LocalDateTime arrivalDate) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@JsonIgnore
	public Set<UserBooking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<UserBooking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", departure=" + departure + ", arrival=" + arrival + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + "]";
	}

}
