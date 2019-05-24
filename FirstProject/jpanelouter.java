package FirstProject;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jpanelouter extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	public int witch = 0;
	private JFrameMain win;
	static ArrayList kindlist;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b7;
	static String name;
	static String price;
	static ImageIcon image;
	static int number;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	
	public jpanelouter(JFrameMain win) {
		setBackground(new Color(255, 182, 193));
		this.win = win;
		setSize(850, 800);
		setLayout(null);
		
		menuDAO dao = new menuDAO();
		String type = "outer";
		kindlist = dao.kindselect(type);
		menuDTO dto = (menuDTO)kindlist.get(0);
		menuDTO dto1 = (menuDTO)kindlist.get(1);
		menuDTO dto2 = (menuDTO)kindlist.get(2);
		menuDTO dto3 = (menuDTO)kindlist.get(3);
		menuDTO dto4 = (menuDTO)kindlist.get(4);
		
		String[] pic = new String[5];
		pic[0] = dto.getImage();
		pic[1] = dto1.getImage();
		pic[2] = dto2.getImage();
		pic[3] = dto3.getImage();
		pic[4] = dto4.getImage();
		
		JLabel lb1 = new JLabel("New label");
		ImageIcon icon1 = new ImageIcon(pic[0]);
		image = icon1;
		lb1.setBounds(48, 52, 209, 104);
		add(lb1);
		lb1.setIcon(icon1);
		
		JLabel lb2 = new JLabel("New label");
		ImageIcon icon2 = new ImageIcon(pic[1]);
		image = icon2;
		lb2.setBounds(48, 187, 214, 109);
		add(lb2);
		lb2.setIcon(icon2);
		
		JLabel lb3 = new JLabel("New label");
		ImageIcon icon3 = new ImageIcon(pic[2]);
		lb3.setBounds(48, 308, 214, 95);
		add(lb3);
		lb3.setIcon(icon3);
		
		JLabel lb4 = new JLabel("New label");
		ImageIcon icon4 = new ImageIcon(pic[3]);
		lb4.setBounds(48, 425, 214, 107);
		add(lb4);
		lb4.setIcon(icon4);
		
		JLabel lb5 = new JLabel("New label");
		ImageIcon icon5 = new ImageIcon(pic[4]);
		lb5.setBounds(48, 551, 214, 95);
		add(lb5);
		lb5.setIcon(icon5);
		
		textField = new JTextField();
		textField.setForeground(new Color(178, 34, 34));
		textField.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField.setBounds(475, 52, 144, 29);
			textField.setText(dto.getPname());
		add(textField);
		textField.setColumns(10);
		textField.getText();
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(178, 34, 34));
		textField_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(475, 98, 144, 29);
			textField_1.setText(dto.getPrice() + "¿ø");
		add(textField_1);
		textField_1.getText();
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(178, 34, 34));
		textField_2.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(475, 187, 144, 29);
			textField_2.setText(dto1.getPname());
		add(textField_2);
		textField_2.setEditable(false);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(178, 34, 34));
		textField_3.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(475, 233, 144, 29);
			textField_3.setText(dto1.getPrice() + "¿ø");
		add(textField_3);
		textField_3.setEditable(false);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(178, 34, 34));
		textField_4.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(475, 314, 144, 29);
			textField_4.setText(dto2.getPname());
		add(textField_4);
		textField_4.setEditable(false);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(178, 34, 34));
		textField_5.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(475, 366, 144, 29);
			textField_5.setText(dto2.getPrice());
		add(textField_5);
		textField_5.setEditable(false);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(178, 34, 34));
		textField_6.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(475, 444, 144, 29);
			textField_6.setText(dto3.getPname());
		add(textField_6);
		textField_6.setEditable(false);
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(178, 34, 34));
		textField_7.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField_7.setColumns(10);
		textField_7.setBounds(475, 490, 144, 29);
			textField_7.setText(dto3.getPrice());
		add(textField_7);
		textField_7.setEditable(false);
		
		textField_8 = new JTextField();
		textField_8.setForeground(new Color(178, 34, 34));
		textField_8.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(475, 561, 144, 29);
			textField_8.setText(dto4.getPname());
		add(textField_8);
		textField_8.setEditable(false);
		
		textField_9 = new JTextField();
		textField_9.setForeground(new Color(178, 34, 34));
		textField_9.setFont(new Font("±¼¸²", Font.BOLD, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(475, 607, 144, 29);
			textField_9.setText(dto4.getPrice());
		add(textField_9);
		textField_9.setEditable(false);
		
		JButton b1 = new JButton("\uC120\uD0DD"); //¼±ÅÃ¹öÆ°
		b1.setForeground(new Color(178, 34, 34));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				number = 16;
				SelectOuter pay = new SelectOuter();
			}
		});
		b1.setBackground(new Color(255, 255, 255));
		b1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		b1.setBounds(704, 65, 97, 42);
		add(b1);
		
		b2 = new JButton("\uC120\uD0DD");
		b2.setForeground(new Color(178, 34, 34));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 17;
				SelectOuter pay = new SelectOuter();
			}
		});
		b2.setFont(new Font("±¼¸²", Font.BOLD, 20));
		b2.setBackground(new Color(255, 255, 255));
		b2.setBounds(704, 199, 97, 42);
		add(b2);
		
		b3 = new JButton("\uC120\uD0DD");
		b3.setForeground(new Color(178, 34, 34));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				number = 18;
				SelectOuter pay = new SelectOuter();
			}
		});
		b3.setFont(new Font("±¼¸²", Font.BOLD, 20));
		b3.setBackground(new Color(255, 255, 255));
		b3.setBounds(704, 332, 97, 42);
		add(b3);
		
		b4 = new JButton("\uC120\uD0DD");
		b4.setForeground(new Color(178, 34, 34));
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 19;
				SelectOuter pay = new SelectOuter();
			}
		});
		b4.setFont(new Font("±¼¸²", Font.BOLD, 20));
		b4.setBackground(new Color(255, 255, 255));
		b4.setBounds(704, 455, 97, 42);
		add(b4);
		
		b5 = new JButton("\uC120\uD0DD");
		b5.setForeground(new Color(178, 34, 34));
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = 20;
				SelectOuter pay = new SelectOuter();
			}
		});
		b5.setFont(new Font("±¼¸²", Font.BOLD, 20));
		b5.setBackground(new Color(255, 255, 255));
		b5.setBounds(704, 575, 97, 42);
		add(b5);
		
		b7 = new JButton("\uB4A4\uB85C"); //µÚ·Î°¡±â ¹öÆ°
		b7.setForeground(new Color(178, 34, 34));
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("jpanelMenu");
				number = 0;
			}
		});
		b7.setBackground(new Color(255, 255, 255));
		b7.setFont(new Font("±¼¸²", Font.BOLD, 20));
		b7.setBounds(345, 702, 123, 49);
		add(b7);
		
		lblNewLabel = new JLabel("\uC81C\uD488\uC774\uB984");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		lblNewLabel.setBounds(318, 52, 97, 29);
		add(lblNewLabel);
		
		label = new JLabel("\uC81C\uD488\uAC00\uACA9");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label.setBounds(318, 98, 97, 29);
		add(label);
		
		label_1 = new JLabel("\uC81C\uD488\uC774\uB984");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label_1.setBounds(318, 188, 97, 29);
		add(label_1);
		
		label_2 = new JLabel("\uC81C\uD488\uAC00\uACA9");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label_2.setBounds(318, 233, 97, 29);
		add(label_2);
		
		label_3 = new JLabel("\uC81C\uD488\uC774\uB984");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label_3.setBounds(318, 314, 97, 29);
		add(label_3);
		
		label_4 = new JLabel("\uC81C\uD488\uAC00\uACA9");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label_4.setBounds(318, 360, 97, 29);
		add(label_4);
		
		label_5 = new JLabel("\uC81C\uD488\uC774\uB984");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label_5.setBounds(318, 445, 97, 29);
		add(label_5);
		
		label_6 = new JLabel("\uC81C\uD488\uAC00\uACA9");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label_6.setBounds(318, 491, 97, 29);
		add(label_6);
		
		label_7 = new JLabel("\uC81C\uD488\uC774\uB984");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label_7.setBounds(318, 561, 97, 29);
		add(label_7);
		
		label_8 = new JLabel("\uC81C\uD488\uAC00\uACA9");
		label_8.setForeground(new Color(255, 255, 255));
		label_8.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		label_8.setBounds(318, 607, 97, 29);
		add(label_8);
		
		setVisible(true);
		
	}
}
