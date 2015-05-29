package pushSyetem.operation;

import java.util.ArrayList;
import java.util.List;

import pushSystem.dao.Data;
import pushSystem.dao.DataDAO;
import pushSystem.dao.User;
import pushSystem.dao.UserDAO;

public class PushOperation 
{
	private User user;
	
	public PushOperation(){}
	
	public Integer getUserPushTime(User user)
	{
		UserDAO uDAO = new UserDAO();
		Integer pushTime;
		pushTime = user.getPushTime();
		return pushTime;
	}
	public String getUserName(User user)
	{
		UserDAO uDAO = new UserDAO();
		String userName;
		userName = user.getUserName();
		return userName;
	}
	public Data getData(String dataName)//查看数据
	{
		DataDAO dDAO = new DataDAO();
		Data data = dDAO.findById(dataName);
		return data;
	}
	public Data getPushData(Integer valuation,String type)
	{
		List<Data> list = null;
		Data data = new Data();
		DataDAO dDao = new DataDAO();
		//System.out.println(dDao.findByType(type).get(0));
		list = dDao.findByType(type);
		//System.out.println(valuation);
		for(int i = 1;i <= 5;i++)
		{
			//System.out.println(valuation);
			if(type.equals("film"))
			{
				for(int j = 0;j<4;j++)
				{
					data = list.get(j);
					//System.out.println(data.getName());
					//System.out.println(data.getDataValuation());
					int v = data.getDataValuation();
					if(valuation == v) 
					{
						//System.out.println(data.getDataValuation());
						return data;
					}
				}
			}
			else
			{
				for(int j = 0;j<8;j++)
				{
					data = list.get(j);
					System.out.println(data.getName());
					System.out.println(data.getDataValuation());
					int v = data.getDataValuation();
					if(valuation == v) 
					{
						//System.out.println(data.getDataValuation());
						return data;
					}
				}
			}
			valuation = valuation - 1;
		}
		return null;
	}
	public List<Data> push(User user)//推送数据
	{
		List<Data> list = new ArrayList<Data>();
		Data data = new Data();
		if(user.getPushTime()==0)
		{
			//System.out.println("ok");
			Data data1 = getPushData(50, "music");
			//System.out.println(data.getName());
			list.add(0, data1);	
			Data data2 = getPushData(80, "music");
			list.add(1, data2);
			Data data3 = getPushData(60, "book");
			list.add(2, data3);
			Data data4 = getPushData(80, "book");
			list.add(3, data4);
			Data data5 = getPushData(80, "film");
			list.add(4, data5);
		}
		else
		{
			data = getPushData(user.getUserValuation(), "music");
			list.add(0, data);		
			data = getPushData(user.getUserValuation(), "music");
			list.add(1, data);
			data = getPushData(user.getUserValuation(), "book");
			list.add(2, data);
			data = getPushData(user.getUserValuation(), "book");
			list.add(3, data);
			data = getPushData(user.getUserValuation(), "film");
			list.add(4, data);
		}
		return list;
	}
	public boolean setFeedbackValuation(String dataName,User user,double feedbackValua)//修改单个反馈值
	{
		double valua = 0.0;	
		DataDAO dDAO = new DataDAO();
		Data d = dDAO.findById(dataName);
		d.setFeedbackValua(feedbackValua);;
		dDAO.save(d);
		//String sql = "update data set feedbackValua=valua where name=dataName";
		return true;//修改成功提示信息
	}
	public void changeFeedbackValuation(List<Data> dlist,User user)//把每个数据的反馈值传进来,修改用户反馈总值
	{
		double fbv = 0.0;
		DataDAO dDAO = new DataDAO();
		for(int i=0;i<dlist.size();i++)
		{
			String name = dlist.get(i).getName();
			Data data = dDAO.findById(name);
			double fbn = data.getFeedbackValua();
			fbv = fbv+fbn;
		}
		fbv = fbv/dlist.size();
		String name = user.getUserName();
		UserDAO uDAO = new UserDAO();
		User u = uDAO.findById(name);
		u.setFeedbackValuation(fbv);
		uDAO.save(u);
		//String sql = "update user set feedbackValuation=fbv where dataName =name";
	}
	public void setUserValuation(List<Data> list,User user)//修改用户估值
	{
		Integer sum = null;
		DataDAO dDAO = new DataDAO();
		for(int i=0;i<list.size();i++)
		{
			Data data = dDAO.findById(list.get(i).getName());
			Integer val = data.getDataValuation();
			sum = sum + val;
		}
		UserDAO uDAO = new UserDAO();
		User u = uDAO.findById(user.getUserName());
		sum = sum / list.size();
		sum = (int) (sum*u.getFeedbackValuation());
		u.setUserValuation(sum);
		uDAO.save(u);
		//String sql = "update user set userValuation=sum where userName =name";
		
	}
	
	public void Quit(User user,List<Data> list)
	{
		changeFeedbackValuation(list,user);
		setUserValuation(list,user);
		int i = 0;
		DataDAO dDAO = new DataDAO();
		for(i=0;i<list.size();i++)
		{
			Data da = dDAO.findById(list.get(i).getName());
			da.setFeedbackValua(1.0);
			dDAO.save(da);
		}
		
		//String sql = "update data set feedbackValuation=1.0 where dataName =?";
	}
}
