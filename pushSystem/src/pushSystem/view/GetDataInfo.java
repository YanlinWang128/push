package pushSystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pushSystem.dao.Data;
import pushSystem.dao.DataDAO;
import pushSystem.dao.User;


public class GetDataInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetDataInfo frame = new GetDataInfo(null, null);
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
	public GetDataInfo(String dataName,final User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DataDAO dDAO= new DataDAO();
		Data data = dDAO.findById(dataName);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  \u540D\u79F0   \uFF1A");
		lblNewLabel.setFont(new Font("华文新魏", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 13, 86, 18);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 10, 86, 24);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText(dataName);
		
		JLabel lblNewLabel_1 = new JLabel("  \u7C7B\u578B \uFF1A");
		lblNewLabel_1.setFont(new Font("华文新魏", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(214, 13, 86, 18);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(314, 10, 86, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(data.getType());
		
		JLabel lblNewLabel_2 = new JLabel("\u8868\u6F14\u8005 \uFF1A");
		lblNewLabel_2.setFont(new Font("华文新魏", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(0, 44, 86, 18);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 41, 86, 24);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(data.getPerformer());
		
		JLabel lblNewLabel_3 = new JLabel(" \u6807\u7B7E 1\uFF1A");
		lblNewLabel_3.setFont(new Font("华文新魏", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(14, 91, 84, 18);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(112, 88, 86, 24);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(data.getLabel1());
		
		JLabel lblNewLabel_4 = new JLabel(" \u6807\u7B7E2 \uFF1A");
		lblNewLabel_4.setFont(new Font("华文新魏", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(92, 125, 86, 18);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(200, 119, 86, 24);
		panel.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(data.getLabel2());
		
		JLabel lblNewLabel_5 = new JLabel(" \u6807\u7B7E3 \uFF1A");
		lblNewLabel_5.setFont(new Font("华文新魏", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(175, 156, 86, 18);
		panel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(287, 153, 86, 24);
		panel.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setText(data.getLabel3());
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("华文新魏", Font.PLAIN, 30));
		btnNewButton.setBounds(134, 187, 113, 53);
		panel.add(btnNewButton);
	}
}
