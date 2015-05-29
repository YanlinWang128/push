package pushSyetem.operation;

import pushSystem.dao.User;
import pushSystem.dao.UserDAO;

public class text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		User user = new User("aaaa","123456",0);
		dao.save(user);
	}

}
