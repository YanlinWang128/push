package pushSyetem.operation;

import pushSystem.dao.User;
import pushSystem.dao.UserDAO;

public class RegisterOperation 
{
	private User user;
	
	public RegisterOperation(){}
	
	public boolean Register(String userName,String password)//输入账号和密码
	{
		UserDAO uDao=new UserDAO();
		/*if(userName!=((User)uDao.findById(userName)).getUserName())
		{
			System.out.println("用户名或密码错误");//UI提示错误信息，点击确定后关闭提示界面
			return false;
		}*/
		//UserDAO uDAO = new UserDAO();
		User user = new User(userName,password,0,0.0,0.0,0,0);
		uDao.save(user);
		return true;
	}
	public boolean judgeRepeat(String userName)//查看账户是否存在
	{
		UserDAO uDAO = new UserDAO();
		Integer power;
		if(userName == ((User)uDAO.findById(userName)).getUserName()) return true;	
		return false;
	}
	
}