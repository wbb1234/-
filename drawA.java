package Wbb.src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class drawA extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model = null;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					drawA frame = new drawA(6);
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
	public drawA(int se) {
		switch(se){
		case 1:
			setUser_0(1);
			break;
		case 2:
			setUser_0(2);
			break;
		case 3:
			new setUser(null);
			break;
		case 4:
			userTable();
			break;
		case 5:
			System.out.println("�����ļ� ok");
			break;
		case 6:
			fileTable();
			break;
		case 7:
			System.out.println("�޸�(����)�û��������� ok");
			break;
		}
	}
	

	private void userTable() {
		setTitle("�û��б�");
		int i = 0;
		User user;
		Enumeration<User> use = DataProcessing.getAllUser();
	    String[][] datas = new String[DataProcessing.users.size()][3];
	    while(use.hasMoreElements()) {
	    	user = use.nextElement();
	    	datas[i][0] = user.getName();
	    	datas[i][1] = user.getPassword();
	    	datas[i][2] = user.getRole();
	    	i++;
	    }
	    String[] titles = { "�û���", "����", "��ɫ"};
		model = new DefaultTableModel(datas, titles);
		table = new JTable(model);
		table.setFont(new Font("����", Font.PLAIN, 18));
		
		getContentPane().add(new JScrollPane(table));
		setBounds(700, 350, 558, 422);
		
		this.setVisible(true);
	}
	
	private void fileTable() {
		setTitle("�ļ��б�");
		int i = 0;
		Doc doc;
		Enumeration<Doc> docs = DataProcessing.getAllDocs();
	    String[][] datas = new String[DataProcessing.docs.size()][5];
	    while(docs.hasMoreElements()) {
	    	doc = docs.nextElement();
	    	datas[i][0] = doc.getID();
	    	datas[i][1] = doc.getCreator();
	    	datas[i][2] = doc.getTimestamp().toString();
	    	datas[i][3] = doc.getDescription();
	    	datas[i][4] = doc.getFilename();
	    	i++;
	    }
	    String[] titles = { "ID", "������", "ʱ��", "����", "�ļ���"};
		model = new DefaultTableModel(datas, titles);
		table = new JTable(model);
		table.setFont(new Font("����", Font.PLAIN, 18));
		
		getContentPane().add(new JScrollPane(table));
		setBounds(700, 350, 558, 422);
		
		this.setVisible(true);
	}

	public void setUser_0(int i) {
		JTextField textField;
 		setBounds(700, 350, 558, 422);
 		
 		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u64CD\u4F5C\u7528\u6237\u7684\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel.setBounds(124, 84, 309, 34);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					try {
						User user = DataProcessing.searchUser(textField.getText());
						if(user != null) {
							if(i == 1) {
								new setUser(user);
								drawA.this.setVisible(false);
							}else {
								DataProcessing.deleteUser(textField.getText());
								JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
								drawA.this.setVisible(false);
							}
							
						}
						else
							JOptionPane.showMessageDialog(null, "�޴��û���", "����", JOptionPane.WARNING_MESSAGE);
						
					} catch (SQLException e1) {
						System.out.println(e1.toString());
					}
				}
			}
		});
		textField.setBounds(134, 144, 258, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		this.setVisible(true);
	}
	
	
	class setUser extends JFrame{
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		
		public setUser(User user) {
			if(user == null)
				drawA.this.setVisible(false);
			setResizable(false);
			setBounds(700, 350, 558, 422);
			setType(Type.POPUP);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			textField = new JTextField();
			textField.setFont(new Font("����", Font.PLAIN, 20));
			textField.setForeground(Color.PINK);
			textField.setText("\u8BF7\u8F93\u5165\u65B0\u7528\u6237\u540D");
			textField.setBounds(111, 77, 327, 45);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setText("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
			textField_1.setForeground(Color.PINK);
			textField_1.setFont(new Font("����", Font.PLAIN, 20));
			textField_1.setColumns(10);
			textField_1.setBounds(111, 169, 327, 45);
			getContentPane().add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setText("\u8BF7\u8F93\u5165\u65B0\u89D2\u8272");
			textField_2.setForeground(Color.PINK);
			textField_2.setFont(new Font("����", Font.PLAIN, 20));
			textField_2.setColumns(10);
			textField_2.setBounds(111, 262, 327, 45);
			getContentPane().add(textField_2);
			
			if(user != null) {
				JLabel label = new JLabel("\u4E0D\u8F93\u4E3A\u4E0D\u6539");
				label.setForeground(Color.RED);
				label.setBounds(15, 15, 96, 21);
				getContentPane().add(label);
			}
			
			JButton btnNewButton = new JButton("\u786E\u8BA4");
			btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
			btnNewButton.setBounds(200, 331, 139, 36);
			getContentPane().add(btnNewButton);
			btnNewButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(user != null) {
						if(textField.getText() != null && !textField.getText().equals("\u8BF7\u8F93\u5165\u65B0\u7528\u6237\u540D"))
							user.setName(textField.getText());
						if(textField_1.getText() != null && !textField_1.getText().equals("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801"))
							user.setPassword(textField_1.getText());
						if(textField_2.getText() != null && !textField_2.getText().equals("\u8BF7\u8F93\u5165\u65B0\u89D2\u8272"))
							user.setRole(textField_2.getText());
						
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
					}else {
						if(textField.getText() == null || textField_1.getText() == null || textField_2.getText() == null || textField.getText().equals("\u8BF7\u8F93\u5165\u65B0\u7528\u6237\u540D") || textField_1.getText().equals("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801") || textField_2.getText().equals("\u8BF7\u8F93\u5165\u65B0\u89D2\u8272")) {
							JOptionPane.showMessageDialog(null, "����Ϊ�գ�", "����", JOptionPane.WARNING_MESSAGE);
						} else
							try {
								DataProcessing.insertUser(textField.getText(), textField_1.getText(), textField_2.getText());
								setUser.this.setVisible(false);
							} catch (SQLException e1) {
								System.out.println(e.toString());
							}
					}
				}
			});
			
			this.setVisible(true);
		}
	}
}
