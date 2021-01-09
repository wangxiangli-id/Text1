package cn.edu.jsu.tm.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.tm.dbc.FoodStorage;
import cn.edu.jsu.tm.vo.FoodClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInterface frame = new AddInterface();
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
	public AddInterface() {
		FoodClass food=new FoodClass();
		FoodStorage foodStorage=new FoodStorage();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 400);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("食品编号");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 71, 72, 18);
		frame.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("食品名称");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(57, 149, 72, 18);
		frame.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("食品单价");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(57, 230, 72, 18);
		frame.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(159, 68, 117, 24);
		frame.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 146, 117, 24);
		frame.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 227, 117, 24);
		frame.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("库存量");
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(341, 71, 72, 18);
		frame.add(lblNewLabel_3);
		
		
		JLabel lblNewLabel_5 = new JLabel("保质期");
		lblNewLabel_5.setFont(new Font("黑体", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(341, 159, 72, 18);
		frame.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(442, 68, 117, 24);
		frame.add(textField_3);
		textField_3.setColumns(10);
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(442, 156, 117, 24);
		frame.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			    food.setId(Integer.parseInt(textField.getText()));
			    food.setFoodname(textField_1.getText().trim());
			    food.setFoodprice(Integer.parseInt(textField_2.getText()));
			    food.setStorage(Integer.parseInt(textField_3.getText()));
			   food.setQuality(Integer.parseInt(textField_5.getText()));
			    foodStorage.add(food);
			    JOptionPane.showMessageDialog(null,"增加成功");
			  }
			});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(163, 297, 113, 27);
		frame.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回主菜单");
		btnNewButton_1.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			   new MainInterface();
			   MainInterface.main(null);
			    setVisible(false);
			  }
			});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 16));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(341, 297, 134, 27);
		frame.add(btnNewButton_1);
		
		
		
		
	}
}
