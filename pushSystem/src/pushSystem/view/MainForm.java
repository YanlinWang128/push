package pushSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MainForm extends JFrame {

	private JPanel contentPane;
	//private JFrame frame=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setBackground(SystemColor.text);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("华文新魏", Font.PLAIN, 35));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm login=new LoginForm();
				login.setVisible(true);
			}
		});
		btnNewButton.setBounds(55, 164, 187, 87);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterForm register = new RegisterForm();
				register.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setFont(new Font("华文新魏", Font.PLAIN, 35));
		btnNewButton_1.setBounds(408, 164, 187, 87);
		panel.add(btnNewButton_1);
		
		JEditorPane dtrpnWelcomeUseThe = new JEditorPane();
		dtrpnWelcomeUseThe.setForeground(new Color(128, 128, 128));
		dtrpnWelcomeUseThe.setBackground(SystemColor.text);
		dtrpnWelcomeUseThe.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		dtrpnWelcomeUseThe.setText("welcome use the push system");
		dtrpnWelcomeUseThe.setBounds(14, 64, 647, 54);
		panel.add(dtrpnWelcomeUseThe);
	}
}
