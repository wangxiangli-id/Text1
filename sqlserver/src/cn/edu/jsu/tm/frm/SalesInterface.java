package cn.edu.jsu.tm.frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.tm.dbc.DatabaseConnection;
import cn.edu.jsu.tm.dbc.OrderStorage;
import cn.edu.jsu.tm.vo.OrderClass;

import javax.swing.JButton;
import java.awt.Color;

public class SalesInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesInterface window = new SalesInterface();
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
	public SalesInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		OrderClass order=new OrderClass();
		OrderStorage orderStorage=new OrderStorage();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("--\u751F\u6210\u8BA2\u5355\u5E76\u51FA\u552E\u98DF\u54C1--");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel.setBounds(108, 0, 186, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BA2\u5355\u7F16\u53F7");
		lblNewLabel_1.setBounds(87, 56, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u98DF\u54C1\u7F16\u53F7");
		lblNewLabel_2.setBounds(87, 107, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u51FA\u552E\u6570\u91CF");
		lblNewLabel_3.setBounds(87, 162, 72, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(187, 53, 107, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 104, 107, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 159, 107, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("出售");
		btnNewButton.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			    order.setOrdernumber(textField.getText());
			    order.setFoodnumber(textField_1.getText());
			    order.setFoodsale(Integer.parseInt(textField_2.getText()));
			    orderStorage.add(order);
			    QuantityChange(textField_1.getText(),Integer.parseInt(textField_2.getText()));
			    JOptionPane.showMessageDialog(null,"出售成功");
			  }
			});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(70, 213, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回主菜单");
		btnNewButton_1.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			   new MainInterface().main(null);
			    frame.dispose();
			  }
			});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(242, 213, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		frame.setLocationRelativeTo(null);
	}
	
	public void QuantityChange(String id,int number) {
		 String sql="select storage from Foodsheet where id="+id;
		  Vector<Vector> rows=new Vector<Vector>();
			DatabaseConnection db=new DatabaseConnection();
			try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
				ResultSet rs=stm.executeQuery(sql); 
				while(rs.next()) { 
					Vector row=new Vector();//定义行数据 
	    			row.add(rs.getInt(1));
	    			rows.add(row);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block 
				e1.printStackTrace();
			}  
			int foodnum=(int)rows.get(0).get(0)-number;
			 Connection conn=new DatabaseConnection().getConnection();	
			  Statement state = null;
			try {
				state = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   //容器
		        String sql2="update Foodsheet set storage="+foodnum+" where id="+id;   //SQL语句
		        try {
					state.executeUpdate(sql2);
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
	}
}
