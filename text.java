package Wbb.src;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import java.awt.Canvas;
import javax.swing.Box;
import javax.swing.JTree;
import java.awt.Choice;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField;


public class text extends JFrame{
	private DefaultTableModel model = null;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					text frame = new text(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public text(Operator o){
		setBounds(700, 350, 558, 422);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u6863\u6848\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("΢���ź� Light", Font.PLAIN, 26));
		lblNewLabel.setBounds(35, 15, 344, 55);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 24));
		textField.setBounds(146, 85, 250, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u63CF\u8FF0\uFF1A");
		label.setFont(new Font("΢���ź� Light", Font.PLAIN, 26));
		label.setBounds(35, 154, 344, 55);
		getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("����", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(146, 224, 250, 45);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 23));
		btnNewButton.setBounds(188, 306, 143, 45);
		getContentPane().add(btnNewButton);
		
		this.setVisible(true);
	}
}
