package pushSystem.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pushSyetem.operation.PushOperation;
import pushSystem.dao.Data;
import pushSystem.dao.User;
import pushSystem.dao.UserDAO;


public class PushForm extends JFrame {
	

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	public List<Data> list;
	public Data data;
	public String[][] gData;
	//public String userName = user.getUserName();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PushForm frame = new PushForm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param user 
	 */
	public PushForm(final User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		 String[] titles11 = { "名称","类型","表演者","标签1","标签2","标签3","反馈值","准确次数"};//定义数组表示标题
	     Object[][] userInfo11 = new Object[6][8];
	        
	    // DefaultTableModel model = new DefaultTableModel(gData,new String[] {"名称","类型","表演者","标签1","标签2","标签3","反馈值","准确次数"});

	     table_1 = new JTable();
		 JScrollPane scrollPane_1 = new JScrollPane(table_1);
		 scrollPane_1.setBounds(85, 105, 679, 181);
		 table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		 
		 PushOperation po = new PushOperation();
		 gData = new String[5][8];
		/* int i=0;
		 for(i=0;i<list.size();i++)
			{
				gData[i][0] = list.get(i).getName();
				gData[i][1] = list.get(i).getType();
				gData[i][2] = list.get(i).getPerformer();
				gData[i][3] = list.get(i).getLabel1();
				gData[i][4] = list.get(i).getLabel2();
				gData[i][5] = list.get(i).getLabel2();
				gData[i][6] = list.get(i).getLabel3();
				gData[i][7] = list.get(i).getAccurateTime().toString();
			}*/
		table_1.setModel(new DefaultTableModel(gData,new String[] {"名称","类型","表演者","标签1","标签2","标签3","反馈值","准确次数"}));
		
     
		JButton button = new JButton("\u63A8\u9001");
		button.setBackground(UIManager.getColor("Button.background"));
		button.setBounds(501, 3, 106, 35);
		button.setFont(new Font("华文新魏", Font.PLAIN, 25));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PushOperation po = new PushOperation();
				//System.out.println(user.getUserName());
				list = po.push(user);
				gData = new String[5][8];
				//System.out.println(list.get(0).getName());
				int i=0;
				for(i=0;i<list.size();i++)
				{
					System.out.println(i);
					System.out.println(list.get(0).getName());
					gData[i][0] = list.get(i).getName();
					gData[i][1] = list.get(i).getType();
					gData[i][2] = list.get(i).getPerformer();
					gData[i][3] = list.get(i).getLabel1();
					gData[i][4] = list.get(i).getLabel2();
					gData[i][5] = list.get(i).getLabel2();
					gData[i][6] = list.get(i).getLabel3();
					gData[i][7] = list.get(i).getAccurateTime().toString();
				}
				//System.out.println(list.get(0).getName());
				//System.out.println(i);
				table_1.setModel(new DefaultTableModel(gData,new String[] {"名称","类型","表演者","标签1","标签2","标签3","反馈值","准确次数"})
				);
		
			}
		});
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setBounds(975, 205, 63, 27);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.setBounds(1095, 205, 63, 27);
		
		final JButton button_3 = new JButton("\u9000\u51FA");
		button_3.setBackground(UIManager.getColor("Button.background"));
		button_3.setBounds(501, 57, 106, 35);
		button_3.setFont(new Font("华文新魏", Font.PLAIN, 25));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//关闭当前页
				PushOperation po = new PushOperation();
				po.Quit(user, list);
				
			}
		});
		
//////////////////////////////
        
		contentPane.setLayout(null);
		contentPane.add(button);
		contentPane.add(button_3);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(scrollPane_1);
		//int[] index = PushForm.table.getSelectedRows();//
		
		JButton btnNewButton = new JButton("\u8BBE\u7F6E\u53CD\u9988");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("华文新魏", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataName = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
				SetFeedback fb = new SetFeedback(dataName,user);
				fb.setVisible(true);
			}
		});
		btnNewButton.setBounds(300, 3, 139, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("  \u7528\u6237 \uFF1A");
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 8, 98, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(101, 10, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(user.getUserName());
		
		JLabel lblNewLabel_1 = new JLabel(" \u63A8\u9001\u6B21\u6570\uFF1A");
		lblNewLabel_1.setFont(new Font("华文行楷", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(0, 55, 139, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 53, 63, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		String pt = user.getPushTime().toString();
		textField_1.setText(pt);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B\u8BE5\u6570\u636E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataName = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
				GetDataInfo gdi = new GetDataInfo(dataName,user);
				gdi.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setFont(new Font("华文新魏", Font.PLAIN, 25));
		btnNewButton_1.setBounds(288, 57, 162, 33);
		contentPane.add(btnNewButton_1);
	}
}