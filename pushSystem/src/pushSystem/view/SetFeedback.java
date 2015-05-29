package pushSystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import pushSyetem.operation.PushOperation;
import pushSystem.dao.Data;
import pushSystem.dao.DataDAO;
import pushSystem.dao.User;


public class SetFeedback extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public double feedBack;
	//public User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetFeedback frame = new SetFeedback(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param data 
	 * @param user 
	 */
	public SetFeedback(final String dataName, final User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  \u540D\u79F0 \uFF1A");
		lblNewLabel.setFont(new Font("华文新魏", Font.PLAIN, 20));
		lblNewLabel.setBounds(95, 30, 75, 21);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(184, 30, 86, 24);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText(dataName);
		
		String text1 = "口味太轻";
		JRadioButton rdbtnNewRadioButton = new JRadioButton(text1);
		rdbtnNewRadioButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(10, 87, 157, 27);
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				feedBack = 0.8;
				System.out.println(feedBack);
			}
		});
		
		String text2 = "口味太重";
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(text2);
		rdbtnNewRadioButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(10, 128, 157, 27);
		panel.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				feedBack = 1.2;
			}
		});
		
		String text3 = "十分满意";
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(text3);
		rdbtnNewRadioButton_2.setFont(new Font("华文楷体", Font.PLAIN, 20));
		rdbtnNewRadioButton_2.setBounds(10, 171, 157, 27);
		panel.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				feedBack = 1.2;
			}
		});
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PushOperation po = new PushOperation();
				boolean i = po.setFeedbackValuation(dataName, user, feedBack);
				if(i) JOptionPane.showMessageDialog(null, "设置成功");
				setVisible(false);
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("华文新魏", Font.PLAIN, 30));
		btnNewButton.setBounds(272, 122, 113, 50);
		panel.add(btnNewButton);
	}

}
