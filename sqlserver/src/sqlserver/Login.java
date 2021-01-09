package sqlserver;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.Color;

public class Login {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String ver;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Login window = new  Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(56, 54, 72, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(56, 103, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(142, 51, 125, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(142, 100, 125, 24);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBounds(43, 181, 113, 27);
		btnNewButton.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
				  btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(checkInput()) {
							String username=textField_4.getText();
							String password=textField_5.getText();
							login(username,password);
							textField_4.setText(null);        
							textField_5.setText(null);
						    frame.dispose();
							}
			  		  }
					});
			  }
			});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Register();
			Register.main(null);
			frame.dispose();
			}
		});
		btnNewButton_1.setBounds(231, 181, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(158, 0, 113, 31);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(286, 54, 113, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(286, 103, 113, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
	}

public static void login(String username,String password) {
	DatabaseConnection db=new DatabaseConnection();
	try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
		String sql="select * from Manageusers where Username="+username+"and Password="+password;
		ResultSet rs=stm.executeQuery(sql);
		if(rs.next()) { 
			new MainInterface();
		    MainInterface.main(null);
		    try {
				new Textdao().In(rs.getString(1));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "欢迎回来，管理员"+rs.getInt(1));
		}
		else {
			JOptionPane.showMessageDialog(null, "输入账号或密码错误");
			frame.dispose();
			new Login().main(null);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}  
}

public boolean checkInput() {
	  if(textField_4.getText().length()==0) {//获取成绩输入框的内容长度
		  lblNewLabel_3.setText("账号不能为空");//设置警告信息
		  textField_4.requestFocus();//成绩输入框获取焦点 
	    return false;
	  }else if(!textField_4.getText().matches("\\d+")) {//正则匹配整数
		  lblNewLabel_3.setText("账号错误");
		  textField_4.requestFocus();//成绩输入框获取焦点
		  textField_4.selectAll();//全选当中的内容
	    return false;
	  } lblNewLabel_3.setText("");
	  
	  if(textField_5.getText().length()==0) {
		  lblNewLabel_4.setText("密码不能为空"); 
		  textField_5.requestFocus();
		  return false; 
	  }lblNewLabel_4.setText("");
	  return true;  
}
}