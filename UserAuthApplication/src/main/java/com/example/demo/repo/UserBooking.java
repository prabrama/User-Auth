package RESTAuth.repo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class UserBooking {

	@Id
	@GeneratedValue(generator = "User-id-gen")
	@GenericGenerator(name = "User-id-gen", parameters = @Parameter(name = "prefix", value = "FB"), strategy = "com.dxbair.services.flightbooking.domain.util.StringSequenceIdGenerator")
	private String id;

	@ManyToOne
	private Passenger passenger;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "user_booking", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "usersBooking [id=" + id + ", passenger=" + passenger + "]";
	}

}
