package pushSyetem.operation;

import pushSystem.dao.User;
import pushSystem.dao.UserDAO;

public class RegisterOperation 
{
	private User user;
	
	public RegisterOperation(){}
	
	public boolean Register(String userName,String password)//�����˺ź�����
	{
		UserDAO uDao=new UserDAO();
		/*if(userName!=((User)uDao.findById(userName)).getUserName())
		{
			System.out.println("�û������������");//UI��ʾ������Ϣ�����ȷ����ر���ʾ����
			return false;
		}*/
		//UserDAO uDAO = new UserDAO();
		User user = new User(userName,password,0,0.0,0.0,0,0);
		uDao.save(user);
		return true;
	}
	public boolean judgeRepeat(String userName)//�鿴�˻��Ƿ����
	{
		UserDAO uDAO = new UserDAO();
		Integer power;
		if(userName == ((User)uDAO.findById(userName)).getUserName()) return true;	
		return false;
	}
	
}