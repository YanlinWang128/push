package pushSyetem.operation;

import pushSystem.dao.User;
import pushSystem.dao.UserDAO;

public class LoginOperation 
{
	private User user;
	
	public LoginOperation(){}
	
	public boolean login(String userName,String password)//输入账号和密码
	{
		//System.out.println(userName);
		UserDAO uDao=new UserDAO();
		User user=uDao.findById(userName);
		/*if(!userName.equals((uDao.findById(userName)).getUserName()) ||
				!password.equals(((User)uDao.findByPassword(password).get(0)).getPassword()))
		{
			System.out.println("用户名或密码错误");//UI提示错误信息，点击确定后关闭提示界面
			return false;
		}*/
		return true;//登录成功，UI关闭登录界面，进入管理界面
	}
	public Integer getUserPower(String userName,String password)
	{
		UserDAO uDAO = new UserDAO();
		Integer power = null;
		//System.out.println(userName);
		//System.out.println(uDAO.findById(userName).getUserName());
		
		//if(password.equals(uDAO.findById(userName).getPassword()))//账户存在且密码正确
		{
			User user = new User();
			user = uDAO.findById(userName);
			power = user.getPower();
		}
		return power;
	}
	
}
