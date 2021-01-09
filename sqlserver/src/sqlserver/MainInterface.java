package sqlserver;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class MainInterface {

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
					MainInterface window = new MainInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public MainInterface() {
	initialize();
}
	public void initialize() {
		frame = new JFrame("主界面");// 实例化窗体
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("查询食品信息");
		lblNewLabel.setBounds(14, 107, 112, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("添加食品信息");
		lblNewLabel_1.setBounds(14, 172, 112, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("更新食品信息");
		lblNewLabel_2.setBounds(14, 238, 106, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("删除食品信息");
		lblNewLabel_3.setBounds(249, 107, 106, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("统计食品信息");
		lblNewLabel_4.setBounds(249, 172, 106, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("销售");
		
		lblNewLabel_5.setBounds(249, 238, 106, 18);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			   new QueryClassInterface().main(null);
			    frame.dispose();
			  }
			});
		btnNewButton.setBounds(122, 103, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("添加");
		btnNewButton_1.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			   new AddInterface().main(null);
			    frame.dispose();
			  }
			});
		btnNewButton_1.setBounds(122, 168, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("更新");
		btnNewButton_2.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
				  new ModifyInformation().main(null);
				 frame.dispose();
			  }
			});
		btnNewButton_2.setBounds(122, 234, 113, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("删除");
		btnNewButton_3.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
				  new QueryClassInterface().main(null);
				    frame.dispose();
			  }
			});
		btnNewButton_3.setBounds(355, 103, 113, 27);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("统计");
		btnNewButton_4.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			   new Statisticallnformation().main(null);
			    frame.dispose();
			  }
			});
		btnNewButton_4.setBounds(355, 168, 113, 27);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("销售");
		btnNewButton_5.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
				  new SalesInterface().main(null);
				  frame.dispose();
			  }
			});
			

		btnNewButton_5.setBounds(355, 234, 113, 27);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_6 = new JLabel("----\u8BF7\u9009\u62E9\u4F60\u7684\u64CD\u4F5C----");
		lblNewLabel_6.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setBounds(135, 30, 220, 37);
		frame.getContentPane().add(lblNewLabel_6);
		frame.setLocationRelativeTo(null);//窗体居中
		
	}

}