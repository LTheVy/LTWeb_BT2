package ServiceImplement;

import DAOImplement.UserDaoImpl;
import Model.User;
import Service.UserService;

public class UserServiceImpl implements UserService{
	
	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
		return user;
		}
		return null;
	}

	@Override
	public User get(String username) {
		return userDao.get(username);
	}
	
	UserDaoImpl userDao = new UserDaoImpl();
}
