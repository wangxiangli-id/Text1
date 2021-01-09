package sqlserver;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;


public class Statisticallnformation extends JFrame{

	private JPanel contentPane;
	private JFrame frame;
	private JTable table;// ������
	private JTextField txtKey;//������ҹؼ����ı���
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	private Vector<String> titles;
	private Vector<Vector> stuInfo;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statisticallnformation window = new Statisticallnformation();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Statisticallnformation() {
		initialize();
	}

private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0)); 
		setContentPane(contentPane);
		
        table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setAutoCreateRowSorter(true);;//���ñ���Զ�����
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton_5 = new JButton("ͳ��������");
		btnNewButton_5.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
				  model=new DefaultTableModel(new StatisticsClass().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
					table.setModel(model);//���ñ�������ģ��
				  SalesVolume();
			  }
			});
		btnNewButton_5.setForeground(Color.BLUE);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("ͳ�����۶�");
		btnNewButton_6.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
				  SalesMoney();
			  }
			});
		btnNewButton_6.setForeground(Color.BLUE);
		panel.add(btnNewButton_6);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		
		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "�������", "ʳƷ���", "������");
		 stuInfo = new StatisticsClass().getPaegData();//��ȡ��һҳ������
		
//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};

		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("��һҳ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new StatisticsClass().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("��һҳ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new StatisticsClass().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
				
			}
		});
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("ÿҳ��ʾ��");
		panel_1.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,8,10,50});
		comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
				StatisticsClass pcl=new StatisticsClass();
				pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼����
				model=new DefaultTableModel(pcl.getPaegData(),titles);//��������ģ�� 
				table.setModel(model);//���ñ������ģ��
			}
		}); 
		comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
		panel_1.add(comboBox);
		
		
		btnNewButton_4 = new JButton("���ز˵�");
		btnNewButton_4.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
			   new MainInterface();
			   MainInterface.main(null);
			    setVisible(false);
			  }
			});
		panel_1.add(btnNewButton_4);
	}
public void SalesVolume() {
	 String sql="select Foodsale from Ordersheet";
	  Vector<Vector> rows=new Vector<Vector>();
		DatabaseConnection db=new DatabaseConnection();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			ResultSet rs=stm.executeQuery(sql); 
			while(rs.next()) { 
				Vector row=new Vector();//���������� 
   			row.add(rs.getInt(1));
   			rows.add(row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block 
			e1.printStackTrace();
		}  
		int sum=0;
		for(int i=0;i<rows.size();i++) {
			sum=sum+(int) rows.get(i).get(0);
		}
		JOptionPane.showMessageDialog(null,"\r\r                ��������:"+"\r\n"+"                      "+sum);
   
}
public void SalesMoney(){
	 String sql="select Foodnumber,Foodsale from Ordersheet";
	  Vector<Vector> rows=new Vector<Vector>();
		DatabaseConnection db=new DatabaseConnection();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			ResultSet rs=stm.executeQuery(sql); 
			while(rs.next()) { 
				Vector row=new Vector();//���������� 
   			row.add(rs.getString(1));
   			row.add(rs.getInt(2));
   			rows.add(row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block 
			e1.printStackTrace();
		}  
		
		  Vector<Vector> rows1=new Vector<Vector>();
			DatabaseConnection db1=new DatabaseConnection();
			try(Connection conn=db1.getConnection();Statement stm=conn.createStatement();) {
				for(int i=0;i<rows.size();i++) {
					String sql1="select Foodprice from Foodsheet where id="+rows.get(i).get(0);
				ResultSet rs1=stm.executeQuery(sql1); 
				while(rs1.next()) { 
					Vector row=new Vector();//���������� 
	    			row.add(rs1.getInt(1));
	    			rows1.add(row);
				}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block 
				e1.printStackTrace();
			}  
		int sum=0;
		for(int i=0;i<rows.size();i++) {
			sum+=((int)rows.get(i).get(1)*(int)rows1.get(i).get(0));
		}
		JOptionPane.showMessageDialog(null,"\r\r                �����۶�:"+"\r\n"+"                      "+sum);
   
}
}
