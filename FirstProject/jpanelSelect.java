package FirstProject;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class jpanelSelect extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	
	String realpname;
	String realprice;
	String realimage;

	public jpanelSelect() {
		getContentPane().setBackground(new Color(255, 228, 225));
		getContentPane().setFont(new Font("굴림", Font.BOLD, 15));
		
		realpname = jpanelMenu.pname1;
		realprice = jpanelMenu.price1;
		realimage = jpanelMenu.image1;
		
		String[] pic = new String[5];
		pic[0] = realimage;
		pic[1] = realimage;
		pic[2] = realimage;
		pic[3] = realimage;
		pic[4] = realimage;
		ImageIcon icon = new ImageIcon(pic[0]);
		
		setSize(536, 437);
		
		getContentPane().setLayout(null);
		
		JLabel lb1 = new JLabel("검색결과");
		lb1.setForeground(new Color(178, 34, 34));
		lb1.setFont(new Font("굴림", Font.BOLD, 30));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setBounds(0, 10, 520, 64);
		getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setBounds(12, 102, 150, 110);
		lb2.setIcon(icon);
		getContentPane().add(lb2);
		
		textField = new JTextField();
		textField.setForeground(new Color(219, 112, 147));
		textField.setFont(new Font("굴림", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(259, 102, 226, 37);
		textField.setText(realpname);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(219, 112, 147));
		textField_1.setFont(new Font("굴림", Font.BOLD, 20));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(259, 175, 226, 37);
		textField_1.setText(realprice);
		getContentPane().add(textField_1);
		textField_1.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("제품이름");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(172, 102, 75, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("제품가격");
		label.setForeground(new Color(178, 34, 34));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBounds(172, 175, 75, 37);
		getContentPane().add(label);
		
		JButton btnNewButton = new JButton("닫기");
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton.setBounds(198, 315, 91, 55);
		getContentPane().add(btnNewButton);
		
		setVisible(true);
	}
}