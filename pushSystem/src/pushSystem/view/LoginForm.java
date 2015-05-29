package pushSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import pushSyetem.operation.LoginOperation;
import pushSystem.dao.User;
import pushSystem.dao.UserDAO;


public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public  String userName;
	public  String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setFont(new Font("华文楷体", Font.BOLD, 30));
		lblNewLabel.setBounds(43, 73, 134, 44);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(208, 73, 158, 39);
		contentPane.add(textField);
		textField.setColumns(10);

		
		
		
		JLabel lblNewLabel_1 = new JLabel("  \u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBackground(SystemColor.info);
		lblNewLabel_1.setFont(new Font("华文楷体", Font.BOLD, 30));
		lblNewLabel_1.setBounds(56, 130, 121, 55);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(208, 141, 158, 39);
		contentPane.add(passwordField);

		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName = textField.getText();
				password = String.valueOf(passwordField.getPassword());
				LoginOperation log = new LoginOperation();
				UserDAO uDAO = new UserDAO();
				Integer power = log.getUserPower(userName, password);
				User user = uDAO.findById(userName);
				//System.out.println(password);
				if(log.login(userName, password)==true && power == 0)
				{
					PushForm push = new PushForm(user);
					push.setVisible(true);
				}
				if(log.login(userName, password)==true && power == 1)
				{
					ManagerForm mana = new ManagerForm(user);
					mana.setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("华文新魏", Font.PLAIN, 35));
		btnNewButton.setBounds(424, 248, 149, 69);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u53BB\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterForm reg = new RegisterForm();
				reg.setVisible(true);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("华文新魏", Font.PLAIN, 35));
		button.setBackground(UIManager.getColor("Button.background"));
		button.setBounds(234, 248, 149, 69);
		contentPane.add(button);
	}

}
