package pushSyetem.operation;

import java.util.List;

import pushSystem.dao.Data;
import pushSystem.dao.DataDAO;
import pushSystem.dao.LabelDAO;
import pushSystem.dao.User;
import pushSystem.dao.UserDAO;

public class ManagerOperation 
{
	private User user;
	
	public ManagerOperation(){}
	
	public boolean createData(String dataName,String type,String performer, String label1,String label2,String label3) //����
	{
		DataDAO dDao=new DataDAO();
		//System.out.println(da.getName());
		if((dDao.findById(dataName))==null)
		{
			LabelDAO lDAO = new LabelDAO();
			Integer val1 = lDAO.findById(label1).getValue();
			Integer val2 = lDAO.findById(label2).getValue();
			Integer val3 = lDAO.findById(label3).getValue();
			Integer val= (val1+val2+val3)/3;
			Data data = new Data(dataName,type,performer,label1,label2,label3,val,1.0,0);
			dDao.save(data);
			return true;//�����ɹ���ʾ
		}
		return false;	
	}
	
	public boolean changeData(String dataName, String lab1,String lab2,String lab3)//�޸�
	{
		DataDAO dDAO = new DataDAO();
		Data da = dDAO.findById(dataName);
		da.setLabel1(lab1);
		da.setLabel2(lab2);
		da.setLabel3(lab3);
		dDAO.save(da);
		//String sql="update data set label1=lab1 label2=lab2 label3=lab3 where name=dataName";
		return true;//�޸ĳɹ���ʾ	
	}
	
	public boolean deleteData(String dataName)//ɾ��
	{
		DataDAO dDAO = new DataDAO();
		Data data = dDAO.findById(dataName);
		dDAO.delete(data);
		return true;//ɾ���ɹ���ʾ
	}
	public Data findData(String dataName)//����
	{
		
		DataDAO dDAO = new DataDAO();
		Data data = new Data();
		data = dDAO.findById(dataName);
		//System.out.println();
		return data;	
	}
	public List<User> findUserInfo()
	{
		UserDAO uDAO = new UserDAO();
		List<User> list = null;
		list = uDAO.findAll();
		return list;	
	}
}
