package RESTAuth.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dxbair.services.flightbooking.domain.entity.User;

@Transactional
public interface UserRepository extends JpaRepository<User, String> {
	
	List<User> findByDepartureAndDepartureDateGreaterThan(String departure, LocalDateTime departureDate);
}
