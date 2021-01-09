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
	private JTable table;// 定义表格
	private JTextField txtKey;//定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
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
		
        table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setAutoCreateRowSorter(true);;//设置表格自动排序
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton_5 = new JButton("统计销售量");
		btnNewButton_5.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
				  model=new DefaultTableModel(new StatisticsClass().prePage(),titles);//设置数据模型中的数据为上一页内容
					table.setModel(model);//设置表格的数据模型
				  SalesVolume();
			  }
			});
		btnNewButton_5.setForeground(Color.BLUE);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("统计销售额");
		btnNewButton_6.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
				  SalesMoney();
			  }
			});
		btnNewButton_6.setForeground(Color.BLUE);
		panel.add(btnNewButton_6);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		
		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "订单编号", "食品编号", "订单量");
		 stuInfo = new StatisticsClass().getPaegData();//获取第一页的数据
		
//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {//获取列的类型
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
		
		JButton btnNewButton_1 = new JButton("上一页");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new StatisticsClass().prePage(),titles);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("下一页");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new StatisticsClass().nextPage(),titles);//设置数据模型中的数据为下一页内容
				table.setModel(model);//设置表格的数据模型
				
			}
		});
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("每页显示：");
		panel_1.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,8,10,50});
		comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
				StatisticsClass pcl=new StatisticsClass();
				pcl.setCountPerpage(pageSize);//设置每页显示记录条数
				model=new DefaultTableModel(pcl.getPaegData(),titles);//设置数据模型 
				table.setModel(model);//设置表格数据模型
			}
		}); 
		comboBox.setSelectedIndex(1);//设置下拉框默认值
		panel_1.add(comboBox);
		
		
		btnNewButton_4 = new JButton("返回菜单");
		btnNewButton_4.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
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
				Vector row=new Vector();//定义行数据 
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
		JOptionPane.showMessageDialog(null,"\r\r                总销售量:"+"\r\n"+"                      "+sum);
   
}
public void SalesMoney(){
	 String sql="select Foodnumber,Foodsale from Ordersheet";
	  Vector<Vector> rows=new Vector<Vector>();
		DatabaseConnection db=new DatabaseConnection();
		try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
			ResultSet rs=stm.executeQuery(sql); 
			while(rs.next()) { 
				Vector row=new Vector();//定义行数据 
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
					Vector row=new Vector();//定义行数据 
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
		JOptionPane.showMessageDialog(null,"\r\r                总销售额:"+"\r\n"+"                      "+sum);
   
}
}
