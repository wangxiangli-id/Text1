package cn.edu.jsu.tm.frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.edu.jsu.tm.dbc.UserStorage;
import cn.edu.jsu.tm.vo.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Register {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String ver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		User user=new User();
		UserStorage userstorage=new UserStorage();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6CE8\u518C\u8D26\u53F7");
		lblNewLabel.setBounds(68, 51, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(68, 95, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("确认密码");
		lblNewLabel_2.setBounds(68, 134, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(175, 48, 118, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 92, 118, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 131, 118, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.setForeground(new Color(0, 255, 255));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			    user.setUsername(textField.getText().trim());
			    user.setPassword(textField_1.getText().trim());
			    UserStorage.add(user);
			    JOptionPane.showMessageDialog(null,"注册成功");
				  new Login();
			   Login.main(null);
			    frame.dispose();
			  }
			});
		btnNewButton.setBounds(175, 213, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("点击产生验证码");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ver =new  VerificationCode().getCheckCode();
		btnNewButton_1.setText(ver);
			}
		});
		btnNewButton_1.setBounds(47, 165, 113, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(175, 176, 118, 24);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6B22\u8FCE\u6CE8\u518C");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_3.setForeground(new Color(0, 255, 0));
		lblNewLabel_3.setBackground(new Color(0, 255, 0));
		lblNewLabel_3.setBounds(162, 0, 159, 35);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
