package pushSystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pushSyetem.operation.ManagerOperation;
import pushSyetem.operation.PushOperation;
import pushSystem.dao.Data;
import pushSystem.dao.User;
import pushSystem.dao.UserDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class ManagerForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	public int flag;
	public String dataName;
	public String type;
	public String performer;
	public String label1;
	public String label2;
	public String label3;
	public Data data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerForm frame = new ManagerForm(null);
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
	public ManagerForm(final User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458 \uFF1A");
		label.setFont(new Font("华文新魏", Font.PLAIN, 20));
		label.setBounds(28, 54, 96, 18);
		
		textField = new JTextField();
		textField.setBounds(126, 52, 116, 24);
		textField.setColumns(10);
		textField.setText(user.getUserName());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(43, 109, 840, 233);
		
		tabbedPane.setToolTipText("\u987E\u5BA2\u4FE1\u606F");
		
		JButton button = new JButton("\u786E\u5B9A");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("管理推送数据", null, panel_1, null);
		
		JLabel label_6 = new JLabel("  \u540D\u79F0  \uFF1A ");
		label_6.setFont(new Font("华文楷体", Font.PLAIN, 20));
		label_6.setBounds(23, 8, 91, 18);
		
		textField_8 = new JTextField();
		textField_8.setBounds(119, 5, 86, 24);
		textField_8.setColumns(10);
		dataName = textField_8.getText();
		
		JLabel label_7 = new JLabel("  \u6807\u7B7E3   : ");
		label_7.setFont(new Font("华文楷体", Font.PLAIN, 20));
		label_7.setBounds(517, 74, 93, 18);
		
		textField_9 = new JTextField();
		textField_9.setBounds(624, 71, 86, 24);
		textField_9.setColumns(10);
		
		
		JLabel label_8 = new JLabel(" \u6807\u7B7E1 \uFF1A");
		label_8.setFont(new Font("华文楷体", Font.PLAIN, 20));
		label_8.setBounds(23, 74, 85, 18);
		
		textField_10 = new JTextField();
		textField_10.setBounds(119, 71, 86, 24);
		textField_10.setColumns(10);
		
		
		JLabel label_9 = new JLabel("  \u7C7B\u578B  \uFF1A");
		label_9.setFont(new Font("华文楷体", Font.PLAIN, 20));
		label_9.setBounds(267, 8, 83, 18);
		
		textField_11 = new JTextField();
		textField_11.setBounds(365, 5, 86, 24);
		textField_11.setColumns(10);
		
		
		JLabel label_10 = new JLabel("  \u8868\u6F14\u8005 \uFF1A");
		label_10.setFont(new Font("华文楷体", Font.PLAIN, 20));
		label_10.setBounds(517, 11, 104, 18);
		
		textField_12 = new JTextField();
		textField_12.setBounds(624, 5, 86, 24);
		textField_12.setColumns(10);
		
		
		JLabel label_11 = new JLabel(" \u6807\u7B7E2 \uFF1A");
		label_11.setFont(new Font("华文楷体", Font.PLAIN, 20));
		label_11.setBounds(267, 74, 84, 18);
		
		textField_13 = new JTextField();
		textField_13.setBounds(365, 71, 86, 24);
		textField_13.setColumns(10);
		
		
		panel_1.setLayout(null);
		panel_1.add(label_6);
		panel_1.add(textField_8);
		panel_1.add(label_9);
		panel_1.add(textField_11);
		panel_1.add(label_7);
		panel_1.add(textField_9);
		panel_1.add(label_10);
		panel_1.add(textField_12);
		panel_1.add(label_8);
		panel_1.add(textField_10);
		panel_1.add(label_11);
		panel_1.add(textField_13);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u67E5\u627E\u63A8\u9001\u6570\u636E");
		rdbtnNewRadioButton.setFont(new Font("华文行楷", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(225, 121, 157, 27);
		panel_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				flag = 1;
			}
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u589E\u52A0\u63A8\u9001\u6570\u636E");
		rdbtnNewRadioButton_1.setFont(new Font("华文行楷", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(225, 153, 157, 27);
		panel_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				flag = 2;
			}
		});
		
		final ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u4FEE\u6539\u63A8\u9001\u6570\u636E");
		rdbtnNewRadioButton_2.setFont(new Font("华文行楷", Font.PLAIN, 20));
		rdbtnNewRadioButton_2.setBounds(411, 121, 157, 27);
		panel_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				flag = 3;
			}
		});
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u5220\u9664\u63A8\u9001\u6570\u636E");
		rdbtnNewRadioButton_3.setFont(new Font("华文行楷", Font.PLAIN, 20));
		rdbtnNewRadioButton_3.setBounds(411, 153, 157, 27);
		panel_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				flag = 4;
			}
		});
		
		final ButtonGroup bg1 = new ButtonGroup();
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerOperation mo = new ManagerOperation();
				String dataName = textField_8.getText();
				boolean i;
				//System.out.println("OK");
				if(flag==1)//case 1查找， case 2增添， case 3修改， case 4删除
				{
					//System.out.println();
					data = mo.findData(dataName);
					//System.out.println(data.getType());
					textField_11.setText(data.getType());
					textField_12.setText(data.getPerformer());
					textField_10.setText(data.getLabel1());
					textField_13.setText(data.getLabel2());
					textField_9.setText(data.getLabel3());
					flag=0;
				}
				if(flag==2)
				{
					System.out.println("OK");
					System.out.println(dataName);
					type = textField_11.getText();
					performer = textField_12.getText();
					label1 = textField_10.getText();
					label2 = textField_13.getText();
					label3 = textField_9.getText();
					i = mo.createData(dataName, type, performer, label1, label2, label3);
					if(i) JOptionPane.showMessageDialog(null, "增添成功");
					flag=0;
					//System.out.println("增添");
				}
				if(flag==3)
				{
						data = mo.findData(dataName);
						textField_11.setText(data.getType());
						textField_12.setText(data.getPerformer());
						textField_10.setText(data.getLabel1());
						textField_13.setText(data.getLabel2());
						textField_9.setText(data.getLabel3());
						label1 = textField_10.getText();
						label2 = textField_13.getText();
						label3 = textField_9.getText();
						i = mo.changeData(dataName, label1, label2, label3);
						if(i) JOptionPane.showMessageDialog(null, "修改成功");
						//System.out.println("修改");
				}
				if(flag==4)
				{
						data = mo.findData(dataName);
						textField_11.setText(data.getType());
						textField_12.setText(data.getPerformer());
						textField_10.setText(data.getLabel1());
						textField_13.setText(data.getLabel2());
						textField_9.setText(data.getLabel3());
						i = mo.deleteData(dataName);
						if(i) JOptionPane.showMessageDialog(null, "删除成功");
						//System.out.println("删除");
						
				}
				if(flag==0) 
				{
					JOptionPane.showMessageDialog(null, "没有选定操作");
				}
				bg.clearSelection();
				bg1.clearSelection();
			}
			
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("华文新魏", Font.PLAIN, 30));
		btnNewButton.setBounds(624, 126, 113, 54);
		panel_1.add(btnNewButton);
		JPanel pan1 = new JPanel();
		tabbedPane.addTab("查看用户信息",pan1);
		
		

				
		String[] titles11 = { "账户名","密码","用户估值","推送次数","权限"};//定义数组表示标题
        Object[][] userInfo11 = new Object[10][5];
        pan1.setLayout(null);
        
        JTable table_1 = new JTable(userInfo11,titles11);//读取所有用户信息
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(0, 0, 835, 201);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		UserDAO uDAO = new UserDAO();
		User u = new User();
		List<User> list = uDAO.findAll();
		Object[][] gData = new String[20][4];
		int i=0;
		for(i=0;i<list.size();i++)
		{
			u =  list.get(i);
			System.out.println(u.getUserName());
			gData[i][0] = u.getUserName();
			System.out.println(gData[i][0]);
			gData[i][1] = String.valueOf(u.getUserValuation());
			gData[i][2] = String.valueOf(u.getPushTime());
			Integer power = u.getPower();
			System.out.println(power);
			if(power == 0) gData[i][3] = "0";
			if(power == 1) gData[i][3] = "1";
			System.out.println(gData[i][2]);
		}
		table_1.setModel(new DefaultTableModel(gData,new String[] {"用户名","用户估值","推送次数","权限"})
		);
		
		pan1.add(scrollPane);
		panel.setLayout(null);
		panel.add(label);
		panel.add(textField);
		panel.add(tabbedPane);
	}
}
