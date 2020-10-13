package RESTAuth.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class RestAuthController {

	@Autowired
	private UserService UserService;
	
	private static final Logger logger = LoggerFactory.getLogger(RestAuthController.class);
	
	@GetMapping
	public @ResponseBody List<User> getAllUsers() {
		return UserService.getAllUsers();
	}
	
	@GetMapping("/{user-id}")
	public @ResponseBody User getUserById(@PathVariable("user-id") String userId) {
		return UserService.getUserById(userId);
	}
}
