package pushSyetem.operation;

import pushSystem.dao.User;
import pushSystem.dao.UserDAO;

public class LoginOperation 
{
	private User user;
	
	public LoginOperation(){}
	
	public boolean login(String userName,String password)//�����˺ź�����
	{
		//System.out.println(userName);
		UserDAO uDao=new UserDAO();
		User user=uDao.findById(userName);
		/*if(!userName.equals((uDao.findById(userName)).getUserName()) ||
				!password.equals(((User)uDao.findByPassword(password).get(0)).getPassword()))
		{
			System.out.println("�û������������");//UI��ʾ������Ϣ�����ȷ����ر���ʾ����
			return false;
		}*/
		return true;//��¼�ɹ���UI�رյ�¼���棬����������
	}
	public Integer getUserPower(String userName,String password)
	{
		UserDAO uDAO = new UserDAO();
		Integer power = null;
		//System.out.println(userName);
		//System.out.println(uDAO.findById(userName).getUserName());
		
		//if(password.equals(uDAO.findById(userName).getPassword()))//�˻�������������ȷ
		{
			User user = new User();
			user = uDAO.findById(userName);
			power = user.getPower();
		}
		return power;
	}
	
}
