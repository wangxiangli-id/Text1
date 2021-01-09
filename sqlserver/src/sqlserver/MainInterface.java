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
		frame = new JFrame("������");// ʵ��������
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��ѯʳƷ��Ϣ");
		lblNewLabel.setBounds(14, 107, 112, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("���ʳƷ��Ϣ");
		lblNewLabel_1.setBounds(14, 172, 112, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("����ʳƷ��Ϣ");
		lblNewLabel_2.setBounds(14, 238, 106, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ɾ��ʳƷ��Ϣ");
		lblNewLabel_3.setBounds(249, 107, 106, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ͳ��ʳƷ��Ϣ");
		lblNewLabel_4.setBounds(249, 172, 106, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("����");
		
		lblNewLabel_5.setBounds(249, 238, 106, 18);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
			   new QueryClassInterface().main(null);
			    frame.dispose();
			  }
			});
		btnNewButton.setBounds(122, 103, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("���");
		btnNewButton_1.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
			   new AddInterface().main(null);
			    frame.dispose();
			  }
			});
		btnNewButton_1.setBounds(122, 168, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("����");
		btnNewButton_2.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
				  new ModifyInformation().main(null);
				 frame.dispose();
			  }
			});
		btnNewButton_2.setBounds(122, 234, 113, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ɾ��");
		btnNewButton_3.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
				  new QueryClassInterface().main(null);
				    frame.dispose();
			  }
			});
		btnNewButton_3.setBounds(355, 103, 113, 27);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("ͳ��");
		btnNewButton_4.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
			   new Statisticallnformation().main(null);
			    frame.dispose();
			  }
			});
		btnNewButton_4.setBounds(355, 168, 113, 27);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("����");
		btnNewButton_5.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
				  new SalesInterface().main(null);
				  frame.dispose();
			  }
			});
			

		btnNewButton_5.setBounds(355, 234, 113, 27);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_6 = new JLabel("----\u8BF7\u9009\u62E9\u4F60\u7684\u64CD\u4F5C----");
		lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setBounds(135, 30, 220, 37);
		frame.getContentPane().add(lblNewLabel_6);
		frame.setLocationRelativeTo(null);//�������
		
	}

}