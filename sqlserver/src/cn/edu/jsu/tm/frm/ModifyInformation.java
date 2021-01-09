package cn.edu.jsu.tm.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.tm.dbc.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModifyInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyInformation frame = new ModifyInformation();
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
	public ModifyInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200,650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("食品编号");
		lblNewLabel.setBounds(65, 69, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("食品名称");
		lblNewLabel_1.setBounds(65, 143, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("食品单价");
		lblNewLabel_2.setBounds(65, 222, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("库存量");
		lblNewLabel_3.setBounds(338, 69, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("保质期");
		lblNewLabel_4.setBounds(338, 143, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(133, 66, 128, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 140, 128, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(133, 219, 128, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(391, 66, 137, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(391, 140, 137, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("确定修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Update();
				}
			
		});
		btnNewButton.setBounds(133, 300, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回菜单");
		btnNewButton_1.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			   new MainInterface();
			   MainInterface.main(null);
			    setVisible(false);
			  }
			});
		btnNewButton_1.setBounds(346, 300, 113, 27);
		contentPane.add(btnNewButton_1);
	}

	public void Update() {
		 String key=textField .getText().trim();//获取食品编号
		  String foodname=textField_1.getText();
		  int foodprice=Integer.parseInt(textField_2.getText().trim());
		  int number=Integer.parseInt(textField_3.getText().trim());
		  int number1=Integer.parseInt(textField_4.getText().trim());
		  Connection conn=new DatabaseConnection().getConnection();	
		  Statement state = null;
		try {
			state = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   //容器
	        String sql="update Foodsheet set Foodname="+("'"+foodname+"'")+",Foodprice="+foodprice+",storage="+number+",quality="+number1+" where id="+key;   //SQL语句
	        try {
				state.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}         //将sql语句上传至数据库执行
	        
	        try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//关闭通道
	JOptionPane.showMessageDialog(null,"修改成功");
	}
	public static boolean find(String sql) {
		DatabaseConnection db=new DatabaseConnection();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			String sql2=sql;
			ResultSet rs=stm.executeQuery(sql2); 
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block 
			e1.printStackTrace();
		}  
		// TODO Auto-generated method stub
		return false;
		}
	}
	 
