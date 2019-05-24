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
import javax.swing.JCheckBox;
import java.awt.Color;

public class SelectShirt extends JFrame {
	
	private JTextField textField;
	private JTextField textField_1;
	String getId;
	
	public SelectShirt() {
		setTitle("\uC8FC\uBB38\uCC3D");
		getContentPane().setBackground(new Color(255, 228, 225));
		
		menuDAO dao = new menuDAO();
		int getnumber = jpanelshirt.number;
		menuDTO	dto = dao.getnumber(getnumber);
		String pname = dto.getPname();
		String price = dto.getPrice();
		String image = dto.getImage();
		getId = LoginMain2.inputId;
		String user = getId;
		
		ImageIcon icon1 = new ImageIcon(image);
		
		setSize(488, 379);
		getContentPane().setLayout(null);
		JLabel lb1 = new JLabel("\uC8FC\uBB38\uD558\uAE30");
		lb1.setForeground(new Color(139, 0, 0));
		lb1.setBackground(new Color(255, 255, 255));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setFont(new Font("±º∏≤", Font.BOLD, 30));
		lb1.setBounds(12, 29, 460, 43);
		getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setBounds(22, 101, 164, 88);
		lb2.setIcon(icon1);
		getContentPane().add(lb2);
		
		textField = new JTextField();
		textField.setForeground(new Color(148, 0, 211));
		textField.setBounds(198, 101, 241, 34);
		textField.setText(pname);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(148, 0, 211));
		textField_1.setColumns(10);
		textField_1.setText(price);
		textField_1.setBounds(198, 155, 241, 34);
		getContentPane().add(textField_1);
		
		JButton b2 = new JButton("∞·¡¶«œ±‚"); //»Æ¡§πˆ∆∞
		b2.setForeground(new Color(178, 34, 34));
		b2.setBackground(new Color(255, 255, 255));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				orrderDAO dao = new orrderDAO();
				orrderDTO dto = new orrderDTO();
				
				if(LoginMain2.l1.getText()==null) {
					JOptionPane.showMessageDialog(null, "∑Œ±◊¿Œ «œ∞Ì ¡÷πÆ«ÿ¡÷ººø‰!!");
				}else {
					dto.setPname(pname);
					dto.setPrice(price);
					dto.setUser(user);
					
					dao.insert(dto);
					dispose();
				}
				
			}
		});
		b2.setFont(new Font("±º∏≤", Font.BOLD, 20));
		b2.setBounds(160, 263, 150, 34);
		getContentPane().add(b2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uCE74\uB4DC");
		chckbxNewCheckBox.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 18));
		chckbxNewCheckBox.setBounds(102, 218, 115, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("\uBB34\uD1B5\uC7A5 \uC785\uAE08");
		checkBox.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 18));
		checkBox.setBounds(250, 218, 139, 23);
		getContentPane().add(checkBox);
		
		
		setVisible(true);
		
	}
}
