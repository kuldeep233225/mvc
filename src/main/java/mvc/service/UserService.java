package mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.UserDao;
import mvc.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDaw;
	public int createUser (User user)
	{
		return this.userDaw.saveUser(user);
	}
}
