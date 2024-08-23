package data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GDadmin extends JFrame {
	
	final String header[] = {"Mã sách", "Tên sách", "Tên tác giả", "Nhà xuất bản", "Số lượng"};
    final DefaultTableModel tb = new DefaultTableModel(header,0);
    
    final String header1[] = {"Mã độc giả", "Tên độc giả", "Số điện thôại", "Email"};
    final DefaultTableModel tb1 = new DefaultTableModel(header1,0);
    
    final String header2[] = {"Mã phiếu mượn", "Mã độc giả", "Mã sách", "Ngày mượn","Ngày trả", "Số lượng"};
    final DefaultTableModel tb2 = new DefaultTableModel(header2,0);
    
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField txtYyyymmdd;
	private JTextField txtYyyymmdd_1;
	private JTable table_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table_2;
	private JTextField textField_17;
	
	Connect cn = new Connect();
	ResultSet rs;
	DefaultTableModel tbn = new DefaultTableModel();
	Connection conn;
	
	public void loadBang() {
		try {
			conn = cn.getConnection();
			int number;
			Vector row;
			String sql = "Select * From SACH";
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			number = meta.getColumnCount();
			tb.setRowCount(0);
			while (rs.next()) {
				row = new Vector();
				for(int i =1; i<=number; i++)
					row.addElement(rs.getString(i));
				tb.addRow(row);
				table.setModel(tb);
			}
			st.close();
			rs.close();
			conn.close();
		}catch(Exception e) {
			
		}
		
	}
	public void loadBang1() {
		try {
			conn = cn.getConnection();
			int number;
			Vector row;
			String sql = "Select * From KHACH_HANG";
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			number = meta.getColumnCount();
			tb1.setRowCount(0);
			while (rs.next()) {
				row = new Vector();
				for(int i =1; i<=number; i++)
					row.addElement(rs.getString(i));
				tb1.addRow(row);
				table_2.setModel(tb1);
			}
			st.close();
			rs.close();
			conn.close();
		}catch(Exception e) {
			
		}
		
	}
	public void loadBang2() {
		try {
			conn = cn.getConnection();
			int number;
			Vector row;
			String sql = "Select * From PHIEU_MUON";
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
			ResultSetMetaData meta = rs.getMetaData();
			number = meta.getColumnCount();
			tb2.setRowCount(0);
			while (rs.next()) {
				row = new Vector();
				for(int i =1; i<=number; i++)
					row.addElement(rs.getString(i));
				tb2.addRow(row);
				table_1.setModel(tb2);
			}
			st.close();
			rs.close();
			conn.close();
		}catch(Exception e) {
			
		}
		
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDadmin frame = new GDadmin();
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
	public GDadmin() {
		

		setTitle("QUẢN LÝ THƯ VIỆN");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GDadmin.class.getResource("/image/H.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 10, 871, 418);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("S\u00E1ch", new ImageIcon(GDadmin.class.getResource("/image/D.png")), panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Statement st = null;
				ResultSet rs = null;
				Connection conn = cn.getConnection();
				String[] headers = {"Mã sách","Tên sách","Tên tác giả","Nhà xuất bản","Số lượng"};
				DefaultTableModel tblModel = new DefaultTableModel(headers, 0);
				try {
					String sql = "SELECT * FROM SACH";
					if (textField.getText().length() > 0) {
						   sql = sql + " where Ten_Sach like '%" + textField.getText() + "%' or Ten_Tac_gia like '%" + textField.getText() + "%' or Nha_xb like '%" + textField.getText()+"%'" ;
						 }
						 st = conn.createStatement(); 
						 rs = st.executeQuery(sql);
						 Vector data = null;
						 tblModel.setRowCount(0);

						 if (rs.isBeforeFirst() == false) {
						  JOptionPane.showMessageDialog(null, "Không tìm thấy!", "Empty", JOptionPane.WARNING_MESSAGE);
						  return;
						 }
						 while (rs.next()) {
						   data = new Vector();
						   data.add(rs.getString("Ma_Sach"));
						   data.add(rs.getString("Ten_Sach"));
						   data.add(rs.getString("Ten_Tac_gia"));
						   data.add(rs.getString("Nha_xb"));
						   data.add(rs.getInt("So_luong"));
						   tblModel.addRow(data);
						 }
						 table.setModel(tblModel);
						} catch (Exception ex) {
						  ex.printStackTrace();
						} finally {
						  try {
						    if (conn != null) {
						      conn.close();
						    }
						    if (st != null) {
						     st.close();
						    }
						    if (rs != null) {
						     rs.close();
						    }
						   
						}catch(Exception ex) {
					ex.printStackTrace();
					}
						}
			}
		});
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(282, 10, 340, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhập Tên sách (Tên tác giả, Nhà xuất bản)");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(306, 47, 279, 23);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 80, 846, 2);
		panel.add(separator);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = table.getSelectedRow();
				if(x>=0) {
					textField_1.setText(table.getValueAt(x, 0) + "");
					textField_2.setText(table.getValueAt(x, 1) + "");
					textField_3.setText(table.getValueAt(x, 2) + "");
					textField_4.setText(table.getValueAt(x, 3) + "");
					textField_10.setText(table.getValueAt(x, 4) + "");
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "Tên tác giả", "Nhà xuất bản", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setPreferredWidth(167);
		table.getColumnModel().getColumn(2).setPreferredWidth(191);
		table.getColumnModel().getColumn(3).setPreferredWidth(135);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 113, 452, 227);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Danh s\u00E1ch S\u00E1ch");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 90, 122, 23);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(568, 117, 155, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(568, 166, 155, 31);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(568, 217, 155, 31);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(568, 268, 155, 31);
		panel.add(textField_4);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 s\u00E1ch");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(475, 120, 83, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("T\u00EAn s\u00E1ch");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(475, 166, 83, 28);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nh\u00E0 Xu\u1EA5t b\u1EA3n");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(472, 217, 97, 28);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("T\u00EAn T\u00E1c gi\u1EA3");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(475, 268, 83, 28);
		panel.add(lblNewLabel_2_3);
		
		JButton btnNewButton_1 = new JButton("Th\u00EAm");
		btnNewButton_1.setIcon(new ImageIcon(GDadmin.class.getResource("/image/L.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = cn.getConnection();
				try {
					if(textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("") || textField_10.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Cần nhập đủ dữ liệu!", "Empty", JOptionPane.WARNING_MESSAGE);	
					} else {
						StringBuffer sb = new StringBuffer();
						String sql_check_pk = "Select Ma_Sach From SACH Where Ma_Sach = '"+textField_1.getText()+"'";
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery(sql_check_pk);
						if(rs.next()) {
							sb.append("Mã sách đã tồn tại!");
						}
						if(sb.length()>0) {
							JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại!", "Empty", JOptionPane.WARNING_MESSAGE);
						}
						else {
							String sql = "Insert into SACH values('"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"','"+textField_10.getText()+"')";
							st = conn.createStatement();
							int kq = st.executeUpdate(sql);
							if(kq>0) {
								JOptionPane.showMessageDialog(null, "Thêm thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_10.setText("");
								loadBang();
								}
						}					
					}
					conn.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Thêm thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(733, 118, 105, 32);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("S\u1EEDa");
		btnNewButton_1_1.setIcon(new ImageIcon(GDadmin.class.getResource("/image/K.png")));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = cn.getConnection();
					PreparedStatement comm = conn.prepareStatement("Update SACH set Ten_Sach=?, Ten_Tac_gia=?, Nha_xb=?, So_luong=? Where Ma_Sach=?");
					comm.setString(5, textField_1.getText());
					comm.setString(1, textField_2.getText());
					comm.setString(2, textField_3.getText());
					comm.setString(3, textField_4.getText());
					comm.setString(4, textField_10.getText());
					
					int ck = comm.executeUpdate();
					if (ck>0) {
						JOptionPane.showMessageDialog(null, "Sửa thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
						
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_10.setText("");
						
						tbn.setRowCount(0);
						loadBang();
					}
					conn.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Sửa thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(733, 164, 105, 32);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("X\u00F3a");
		btnNewButton_1_2.setIcon(new ImageIcon(GDadmin.class.getResource("/image/J.png")));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = cn.getConnection();
					PreparedStatement comm = conn.prepareStatement("Delete SACH Where Ma_Sach=?");
					comm.setString(1, table.getValueAt(table.getSelectedRow(), 0).toString());
					if (JOptionPane.showConfirmDialog(null, "Xóa sách?", "Cho phép xóa sách",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
						comm.executeUpdate();
						
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_10.setText("");
						
						tbn.setRowCount(0);
						loadBang();
					}
					conn.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1_2.setBounds(733, 215, 105, 32);
		panel.add(btnNewButton_1_2);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(568, 320, 155, 31);
		panel.add(textField_10);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_2_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_3_2.setBounds(475, 320, 83, 28);
		panel.add(lblNewLabel_2_3_2);
		
		JButton btnNewButton_3 = new JButton("Thoát");
		btnNewButton_3.setIcon(new ImageIcon(GDadmin.class.getResource("/image/I.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_3.setBounds(733, 267, 105, 31);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_11 = new JLabel("Tìm kiếm");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(212, 10, 60, 31);
		panel.add(lblNewLabel_11);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Độc giả", new ImageIcon(GDadmin.class.getResource("/image/C.png")), panel_1, null);
		panel_1.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Statement st = null;
				ResultSet rs = null;
				Connection conn = cn.getConnection();
				String[] headers = {"Mã độc giả", "Tên độc giả", "Số điện thôại", "Email"};
				DefaultTableModel tblModel = new DefaultTableModel(headers, 0);
				try {
					String sql = "SELECT * FROM KHACH_HANG";
					if (textField_5.getText().length() > 0) {
						   sql = sql + " where Ten_Khach_hang like '%" + textField_5.getText()+ "%'" ;
						 }
						 st = conn.createStatement(); 
						 rs = st.executeQuery(sql);
						 Vector data = null;
						 tblModel.setRowCount(0);

						 if (rs.isBeforeFirst() == false) {
						  JOptionPane.showMessageDialog(null, "Không tìm thấy!", "Empty", JOptionPane.WARNING_MESSAGE);
						  return;
						 }
						 while (rs.next()) {
						   data = new Vector();
						   data.add(rs.getString("Ma_Khach_hang"));
						   data.add(rs.getString("Ten_Khach_hang"));
						   data.add(rs.getString("Phone"));
						   data.add(rs.getString("Email"));
						   tblModel.addRow(data);
						 }
						 table_2.setModel(tblModel);
						} catch (Exception ex) {
						  ex.printStackTrace();
						} finally {
						  try {
						    if (conn != null) {
						      conn.close();
						    }
						    if (st != null) {
						     st.close();
						    }
						    if (rs != null) {
						     rs.close();
						    }
						   
						}catch(Exception ex) {
					ex.printStackTrace();
					}
						}
			}
		});
		textField_5.setBounds(280, 10, 303, 33);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập Tên Độc giả\r\n");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(363, 55, 121, 20);
		panel_1.add(lblNewLabel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 73, 824, 2);
		panel_1.add(separator_1);
		
		JButton btnNewButton_6 = new JButton("Thêm");
		btnNewButton_6.setIcon(new ImageIcon(GDadmin.class.getResource("/image/L.png")));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = cn.getConnection();
				try {
					if(textField_6.getText().equals("") || textField_7.getText().equals("") || textField_8.getText().equals("") || textField_9.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Cần nhập đủ dữ liệu!", "Empty", JOptionPane.WARNING_MESSAGE);	
					} else {
						StringBuffer sb = new StringBuffer();
						String sql_check_pk = "Select Ma_Khach_hang From KHACH_HANG Where Ma_Khach_hang = '"+textField_6.getText()+"'";
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery(sql_check_pk);
						if(rs.next()) {
							sb.append("Mã khách hàng đã tồn tại!");
						}
						if(sb.length()>0) {
							JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại!", "Empty", JOptionPane.WARNING_MESSAGE);
						}
						else {
							String sql = "Insert into KHACH_HANG values('"+textField_6.getText()+"','"+textField_7.getText()+"','"+textField_8.getText()+"','"+textField_9.getText()+"')";
							st = conn.createStatement();
							int kq = st.executeUpdate(sql);
							if(kq>0) {
								JOptionPane.showMessageDialog(null, "Thêm thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
								textField_6.setText("");
								textField_7.setText("");
								textField_8.setText("");
								textField_9.setText("");
								
								loadBang1();
							}
						}
					}
					conn.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Thêm thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_6.setBounds(506, 288, 112, 33);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("Sửa");
		btnNewButton_6_1.setIcon(new ImageIcon(GDadmin.class.getResource("/image/K.png")));
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = cn.getConnection();
					PreparedStatement comm = conn.prepareStatement("Update KHACH_HANG set Ten_Khach_hang=?, Phone=?, Email=? Where Ma_Khach_hang=?");
					comm.setString(4, textField_6.getText());
					comm.setString(1, textField_7.getText());
					comm.setString(2, textField_8.getText());
					comm.setString(3, textField_9.getText());
					
					int ck = comm.executeUpdate();
					if (ck>0) {
						JOptionPane.showMessageDialog(null, "Sửa thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
						
						textField_6.setText("");
						textField_7.setText("");
						textField_8.setText("");
						textField_9.setText("");
						
						tbn.setRowCount(0);
						loadBang1();
					}
					conn.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Sửa thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_6_1.setBounds(628, 288, 112, 33);
		panel_1.add(btnNewButton_6_1);
		
		JButton btnNewButton_6_2 = new JButton("Xóa");
		btnNewButton_6_2.setIcon(new ImageIcon(GDadmin.class.getResource("/image/J.png")));
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = cn.getConnection();
					PreparedStatement comm = conn.prepareStatement("Delete KHACH_HANG Where Ma_Khach_hang=?");
					comm.setString(1, table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
					if (JOptionPane.showConfirmDialog(null, "Xóa độc giả?", "Cho phép xóa độc giả",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
						comm.executeUpdate();
						
						textField_6.setText("");
						textField_7.setText("");
						textField_8.setText("");
						textField_9.setText("");
						
						tbn.setRowCount(0);
						loadBang1();
					}
					conn.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_6_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_6_2.setBounds(750, 288, 112, 33);
		panel_1.add(btnNewButton_6_2);
		
		JButton btnNewButton_6_3 = new JButton("Thoát");
		btnNewButton_6_3.setIcon(new ImageIcon(GDadmin.class.getResource("/image/I.png")));
		btnNewButton_6_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_6_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_6_3.setBounds(628, 331, 112, 33);
		panel_1.add(btnNewButton_6_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(628, 92, 228, 27);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(628, 129, 228, 27);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(628, 166, 228, 27);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(628, 203, 228, 27);
		panel_1.add(textField_9);
		
		JLabel lblNewLabel_7 = new JLabel("Mã Độc giả");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(506, 92, 112, 27);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Tên Độc giả");
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(506, 129, 112, 27);
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Email");
		lblNewLabel_7_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_2.setBounds(506, 202, 112, 27);
		panel_1.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("Số điện thoại");
		lblNewLabel_7_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7_3.setBounds(506, 165, 112, 27);
		panel_1.add(lblNewLabel_7_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(32, 113, 452, 230);
		panel_1.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = table_2.getSelectedRow();
				if(x>=0) {
					textField_6.setText(table_2.getValueAt(x, 0) + "");
					textField_7.setText(table_2.getValueAt(x, 1) + "");
					textField_8.setText(table_2.getValueAt(x, 2) + "");
					textField_9.setText(table_2.getValueAt(x, 3) + "");
				}
			}
		});
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0110\u1ED9c gi\u1EA3", "T\u00EAn \u0110\u1ED9c gi\u1EA3", "Số điện thoại", "Email"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(91);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(172);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(176);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(164);
		table_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_8 = new JLabel("Danh sách Độc giả");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(32, 83, 140, 20);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_12 = new JLabel("Tìm kiếm");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_12.setBounds(191, 10, 79, 33);
		panel_1.add(lblNewLabel_12);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Phi\u1EBFu m\u01B0\u1EE3n", new ImageIcon(GDadmin.class.getResource("/image/E.png")), panel_2, null);
		panel_2.setLayout(null);
		
		textField_11 = new JTextField();
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Statement st = null;
				ResultSet rs = null;
				Connection conn = cn.getConnection();
				String[] headers = {"Mã phiếu mượn", "Mã độc giả", "Mã sách", "Ngày mượn","Ngày trả", "Số lượng"};
				DefaultTableModel tblModel = new DefaultTableModel(headers, 0);
				try {
					String sql = "SELECT * FROM PHIEU_MUON";
					if (textField_11.getText().length() > 0) {
						sql = sql + " where Ma_Phieu_muon like '%" + textField_11.getText() + "%' or Ma_Khach_hang like '%" + textField_11.getText() + "%' or Ma_Sach like '%" + textField_11.getText()+"%'" ;
						 }
						 st = conn.createStatement(); 
						 rs = st.executeQuery(sql);
						 Vector data = null;
						 tblModel.setRowCount(0);

						 if (rs.isBeforeFirst() == false) {
						  JOptionPane.showMessageDialog(null, "Không tìm thấy!", "Empty", JOptionPane.WARNING_MESSAGE);
						  return;
						 }
						 while (rs.next()) {
						   data = new Vector();
						   data.add(rs.getString("Ma_Phieu_muon"));
						   data.add(rs.getString("Ma_Khach_hang"));
						   data.add(rs.getString("Ma_Sach"));
						   data.add(rs.getDate("Ngay_muon"));
						   data.add(rs.getDate("Ngaytra"));
						   data.add(rs.getInt("So_luong"));
						   
						   tblModel.addRow(data);
						 }
						 table_1.setModel(tblModel);
						} catch (Exception ex) {
						  ex.printStackTrace();
						} finally {
						  try {
						    if (conn != null) {
						      conn.close();
						    }
						    if (st != null) {
						     st.close();
						    }
						    if (rs != null) {
						     rs.close();
						    }
						   
						}catch(Exception ex) {
					ex.printStackTrace();
					}
						}
			}
		});
		textField_11.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_11.setBounds(29, 22, 323, 28);
		panel_2.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_12.setColumns(10);
		textField_12.setBounds(194, 91, 223, 28);
		panel_2.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_13.setColumns(10);
		textField_13.setBounds(194, 129, 223, 28);
		panel_2.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_14.setColumns(10);
		textField_14.setBounds(194, 167, 223, 28);
		panel_2.add(textField_14);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtYyyymmdd.setText("");
			}
		});
		txtYyyymmdd.setText("YYYY/MM/DD");
		txtYyyymmdd.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		txtYyyymmdd.setColumns(10);
		txtYyyymmdd.setBounds(194, 205, 223, 28);
		panel_2.add(txtYyyymmdd);
		
		txtYyyymmdd_1 = new JTextField();
		txtYyyymmdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtYyyymmdd_1.setText("");
			}
		});
		txtYyyymmdd_1.setText("YYYY/MM/DD");
		txtYyyymmdd_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		txtYyyymmdd_1.setColumns(10);
		txtYyyymmdd_1.setBounds(194, 244, 223, 28);
		panel_2.add(txtYyyymmdd_1);
		
		JLabel lblNewLabel_6 = new JLabel("Mã Phiếu mượn");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(29, 91, 145, 28);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Nhập Mã Phiếu mượn ( Mã Độc giả, Mã Sách)");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6_1.setBounds(29, 53, 298, 28);
		panel_2.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Mã Độc giả");
		lblNewLabel_6_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_2.setBounds(29, 129, 145, 28);
		panel_2.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("Mã Sách");
		lblNewLabel_6_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_3.setBounds(29, 167, 145, 28);
		panel_2.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("Ngày mượn");
		lblNewLabel_6_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_4.setBounds(29, 205, 145, 28);
		panel_2.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("Ngày trả");
		lblNewLabel_6_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_5.setBounds(29, 243, 145, 28);
		panel_2.add(lblNewLabel_6_5);
		
		JButton btnNewButton_5 = new JButton("Thêm");
		btnNewButton_5.setIcon(new ImageIcon(GDadmin.class.getResource("/image/L.png")));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = cn.getConnection();
				try {
					if(textField_12.getText().equals("") || textField_13.getText().equals("") || textField_14.getText().equals("") || txtYyyymmdd.getText().equals("") || txtYyyymmdd_1.getText().equals("") || textField_17.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Cần nhập đủ dữ liệu!", "Empty", JOptionPane.WARNING_MESSAGE);	
					} else {
						StringBuffer sb = new StringBuffer();
						String sql_check_pk = "Select Ma_Phieu_muon From PHIEU_MUON Where Ma_Phieu_muon = '"+textField_12.getText()+"'";
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery(sql_check_pk);
						if(rs.next()) {
							sb.append("Mã phiếu đã tồn tại!");
						}
						if(sb.length()>0) {
							JOptionPane.showMessageDialog(null, "Mã phiếu đã tồn tại!", "Empty", JOptionPane.WARNING_MESSAGE);
						}
						else {
							String sql = "Insert into PHIEU_MUON values('"+textField_12.getText()+"','"+textField_13.getText()+"','"+textField_14.getText()+"','"+txtYyyymmdd.getText()+"','"+txtYyyymmdd.getText()+"','"+textField_17.getText()+"')";
							st = conn.createStatement();
							int kq = st.executeUpdate(sql);
							if(kq>0) {
								JOptionPane.showMessageDialog(null, "Thêm thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
								textField_12.setText("");
								textField_13.setText("");
								textField_14.setText("");
								txtYyyymmdd.setText("");
								txtYyyymmdd_1.setText("");
								textField_17.setText("");
								
								loadBang2();
							}
						}
					}
					conn.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Thêm thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_5.setBounds(304, 282, 113, 34);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Sửa");
		btnNewButton_5_1.setIcon(new ImageIcon(GDadmin.class.getResource("/image/K.png")));
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = cn.getConnection();
					PreparedStatement comm = conn.prepareStatement("Update PHIEU_MUON set Ma_Khach_hang=?, Ma_Sach=?, Ngay_muon=?, Ngaytra=?, So_luong=? Where Ma_Phieu_muon=?");
					comm.setString(6, textField_12.getText());
					comm.setString(1, textField_13.getText());
					comm.setString(2, textField_14.getText());
					comm.setString(3, txtYyyymmdd.getText());
					comm.setString(4, txtYyyymmdd_1.getText());
					comm.setString(5, textField_17.getText());
					
					int ck = comm.executeUpdate();
					if (ck>0) {
						JOptionPane.showMessageDialog(null, "Sửa thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
		
						textField_12.setText("");
						textField_13.setText("");
						textField_14.setText("");
						txtYyyymmdd.setText("");
						txtYyyymmdd_1.setText("");
						textField_17.setText("");	
						
						tbn.setRowCount(0);
						loadBang2();
						
					}				
					conn.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Sửa thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_5_1.setBounds(39, 325, 109, 34);
		panel_2.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("Xóa");
		btnNewButton_5_2.setIcon(new ImageIcon(GDadmin.class.getResource("/image/J.png")));
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = cn.getConnection();
					PreparedStatement comm = conn.prepareStatement("Delete PHIEU_MUON Where Ma_Phieu_muon=?");
					comm.setString(1, table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
					if (JOptionPane.showConfirmDialog(null, "Xóa phiếu?", "Cho phép xóa phiếu",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
						comm.executeUpdate();
						
						textField_12.setText("");
						textField_13.setText("");
						textField_14.setText("");
						txtYyyymmdd.setText("");
						txtYyyymmdd_1.setText("");
						textField_17.setText("");	
						
						tbn.setRowCount(0);
						loadBang2();
					}
					conn.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại", "Failed", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_5_2.setBounds(158, 325, 109, 34);
		panel_2.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_3 = new JButton("Thoát");
		btnNewButton_5_3.setIcon(new ImageIcon(GDadmin.class.getResource("/image/I.png")));
		btnNewButton_5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_5_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_5_3.setBounds(277, 326, 109, 34);
		panel_2.add(btnNewButton_5_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(430, 60, 426, 302);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = table_1.getSelectedRow();
				if(x>=0) {
					textField_12.setText(table_1.getValueAt(x, 0) + "");
					textField_13.setText(table_1.getValueAt(x, 1) + "");
					textField_14.setText(table_1.getValueAt(x, 2) + "");
					txtYyyymmdd.setText(table_1.getValueAt(x, 3) + "");
					txtYyyymmdd_1.setText(table_1.getValueAt(x, 4) + "");
					textField_17.setText(table_1.getValueAt(x, 5) + "");
				}
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 phi\u1EBFu m\u01B0\u1EE3n", "M\u00E3 \u0110\u1ED9c gi\u1EA3", "M\u00E3 S\u00E1ch", "Ng\u00E0y m\u01B0\u1EE3n", "Ng\u00E0y tr\u1EA3", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(123);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_6_5_1 = new JLabel("Số lượng mượn");
		lblNewLabel_6_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6_5_1.setBounds(29, 281, 145, 28);
		panel_2.add(lblNewLabel_6_5_1);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_17.setColumns(10);
		textField_17.setBounds(194, 287, 109, 28);
		panel_2.add(textField_17);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 79, 407, 2);
		panel_2.add(separator_2);
		
		JLabel lblNewLabel_13 = new JLabel("Tìm kiếm");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_13.setBounds(362, 22, 67, 28);
		panel_2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_10 = new JLabel("QUẢN LÝ THƯ VIỆN");
		lblNewLabel_10.setForeground(Color.BLUE);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_10.setBounds(487, 10, 329, 37);
		contentPane.add(lblNewLabel_10);
	    
		loadBang();
		loadBang1();
		loadBang2();
	}
}