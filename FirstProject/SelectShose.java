package FirstProject;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectShose extends JFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	String getId;
	
	public SelectShose() {
		
		menuDAO dao = new menuDAO();
		int getnumber = jpanelshose.number;
		menuDTO	dto = dao.getnumber(getnumber);
		String pname = dto.getPname();
		String price = dto.getPrice();
		String image = dto.getImage();
		getId = LoginMain2.inputId;
		String user = getId;
		
		ImageIcon icon1 = new ImageIcon(image);
		
		setSize(500, 500);
		getContentPane().setLayout(null);
		JLabel lb1 = new JLabel("\uC8FC\uBB38\uD558\uAE30");
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setFont(new Font("굴림", Font.BOLD, 30));
		lb1.setBounds(12, 23, 460, 43);
		getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setBounds(36, 104, 150, 75);
		lb2.setIcon(icon1);
		getContentPane().add(lb2);
		
		textField = new JTextField();
		textField.setBounds(198, 101, 241, 34);
		textField.setText(pname);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText(price);
		textField_1.setBounds(198, 145, 241, 34);
		getContentPane().add(textField_1);
		
		JButton b2 = new JButton("결제하기"); //확정버튼
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				orrderDAO dao = new orrderDAO();
				orrderDTO dto = new orrderDTO();
				if(LoginMain2.l1.getText()==null) {
					JOptionPane.showMessageDialog(null, "로그인 하고 주문해주세요!!");
				}else {
					dto.setPname(pname);
					dto.setPrice(price);
					dto.setUser(user);
					
					dao.insert(dto);
					dispose();
				}
			}
		});
		b2.setFont(new Font("굴림", Font.BOLD, 20));
		b2.setBounds(181, 372, 97, 34);
		getContentPane().add(b2);
		
		
		setVisible(true);
		
	}

}
