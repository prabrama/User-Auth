package RESTAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxbair.services.flightbooking.domain.entity.Flight;
import com.dxbair.services.flightbooking.domain.repo.FlightRepository;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public Flight getUserById(String userId) {
		return userRepo.findById(userId).orElseThrow(() -> new FlightNotFoundException(userId));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
