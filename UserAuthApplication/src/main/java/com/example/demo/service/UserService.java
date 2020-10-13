package RESTAuth.service;

import java.util.List;

import com.dxbair.services.flightbooking.domain.entity.Flight;

public interface UserService {
	
	User getUserById(String userId);

	List<User> getAllUsers();
}
