package pushSystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import pushSyetem.operation.RegisterOperation;


public class RegisterForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public String userName;
	public String password;
	public String rePassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(158, 48, 148, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("         \u5BC6\u7801");
		lblNewLabel.setFont(new Font("华文楷体", Font.BOLD, 20));
		lblNewLabel.setBounds(44, 122, 100, 40);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 124, 148, 40);
		contentPane.add(passwordField);
		
		
		JLabel label_1 = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801");
		label_1.setFont(new Font("华文楷体", Font.BOLD, 20));
		label_1.setBounds(14, 185, 126, 40);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(81, 43, 63, 47);
		contentPane.add(lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(158, 185, 148, 40);
		contentPane.add(passwordField_1);
		
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName = textField.getText();
				password = String.valueOf(passwordField.getPassword());
				rePassword = String.valueOf(passwordField_1.getPassword());
				RegisterOperation reg = new RegisterOperation();
				if(password.equals(rePassword))
				{
					if(reg.Register(userName, password)) JOptionPane.showMessageDialog(null, "注册成功");
					
				}
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("华文新魏", Font.PLAIN, 35));
		btnNewButton.setBounds(450, 250, 136, 66);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u53BB\u767B\u9646");
		button.setBackground(UIManager.getColor("Button.background"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm log = new LoginForm();
				log.setVisible(true)	;
			}
		});
		button.setFont(new Font("华文新魏", Font.PLAIN, 35));
		button.setBounds(268, 250, 153, 66);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B\u8BE5\u8D26\u6237\u662F\u5426\u53EF\u7528");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName = textField.getText();
				RegisterOperation reg = new RegisterOperation();
				if(reg.judgeRepeat(userName)) JOptionPane.showMessageDialog(null, "此账户名已存在！");

			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setFont(new Font("华文新魏", Font.PLAIN, 25));
		btnNewButton_1.setBounds(356, 55, 257, 33);
		contentPane.add(btnNewButton_1);
	}

}
