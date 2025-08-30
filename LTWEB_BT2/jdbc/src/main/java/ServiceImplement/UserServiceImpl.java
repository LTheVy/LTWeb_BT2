package ServiceImplement;

import java.sql.Date;

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
	
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		userDao.insert(new User(1, email, username, fullname, password, null, 5, phone, date));
		return true;
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
}
