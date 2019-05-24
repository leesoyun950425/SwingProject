package FirstProject;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JToolBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MembershipMain extends JFrame{
	private JTextField idText;
	private JTextField nameText;
	private JTextField telText;
	private JTextField addrText;
	private JPasswordField pwText;
	private JPasswordField pwTextTest;
	public MembershipMain() {
		
		setTitle("ȸ������ â");
		setBackground(new Color(255, 255, 224));
		setSize(407, 368);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("���̵�");
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setFont(new Font("�������", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 46, 100, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("��й�ȣ");
		lblNewLabel_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_2.setFont(new Font("�������", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 82, 100, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("��й�ȣ Ȯ��");
		lblNewLabel_3.setForeground(new Color(178, 34, 34));
		lblNewLabel_3.setFont(new Font("�������", Font.BOLD, 14));
		lblNewLabel_3.setBounds(12, 117, 100, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("�̸�");
		lblNewLabel_4.setForeground(new Color(178, 34, 34));
		lblNewLabel_4.setFont(new Font("�������", Font.BOLD, 14));
		lblNewLabel_4.setBounds(12, 151, 100, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("��ȭ��ȣ");
		lblNewLabel_5.setForeground(new Color(178, 34, 34));
		lblNewLabel_5.setFont(new Font("�������", Font.BOLD, 14));
		lblNewLabel_5.setBounds(12, 189, 100, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("�ּ�");
		lblNewLabel_6.setForeground(new Color(178, 34, 34));
		lblNewLabel_6.setFont(new Font("�������", Font.BOLD, 14));
		lblNewLabel_6.setBounds(12, 231, 100, 15);
		getContentPane().add(lblNewLabel_6);
		
		idText = new JTextField();
		idText.setForeground(new Color(219, 112, 147));
		idText.setFont(new Font("�������", Font.BOLD, 14));
		idText.setBounds(124, 40, 139, 21);
		getContentPane().add(idText);
		idText.setColumns(10);

		nameText = new JTextField();
		nameText.setForeground(new Color(219, 112, 147));
		nameText.setFont(new Font("�������", Font.BOLD, 14));
		nameText.setBounds(124, 145, 139, 21);
		getContentPane().add(nameText);
		nameText.setColumns(10);
		
		telText = new JTextField();
		telText.setForeground(new Color(219, 112, 147));
		telText.setFont(new Font("�������", Font.BOLD, 14));
		telText.setBounds(124, 183, 139, 21);
		getContentPane().add(telText);
		telText.setColumns(10);
		
		addrText = new JTextField();
		addrText.setForeground(new Color(219, 112, 147));
		addrText.setFont(new Font("�������", Font.BOLD, 14));
		addrText.setBounds(124, 225, 253, 21);
		getContentPane().add(addrText);
		addrText.setColumns(10);
		
		JButton b2 = new JButton("ȸ������ �Ϸ�");
		b2.setBackground(new Color(255, 228, 225));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MembershipDAO dao = new MembershipDAO();
				MembershipDTO dto = new MembershipDTO();
				
				String id = idText.getText();
				String pws = new String(pwText.getPassword());
				String pws2 = new String(pwTextTest.getPassword());
				String name = nameText.getText();
				String tel = telText.getText();
				String addr = addrText.getText();
				
				dto = dao.selectId(id);
				String selid = dto.getId();
				
				if(!pws.equals(pws2)) {
					JOptionPane.showMessageDialog(null,"��й�ȣ�� ��ġ���� �ʽ��ϴ�!!");
					
				}else if(id.equals(selid)){
					JOptionPane.showMessageDialog(null,"���̵� �ߺ�üũ ���ּ���!!");
				}else {

					dto.setId(id);
					dto.setPw(pws);
					dto.setName(name);
					dto.setTel(tel);
					dto.setAddr(addr);
					dao.insert(dto);
					dispose();
				}
			}
			
		});
		b2.setForeground(new Color(255, 105, 180));
		b2.setFont(new Font("�������", Font.BOLD, 14));
		b2.setBounds(124, 280, 119, 23);
		getContentPane().add(b2);
		
		JButton b1 = new JButton("�ߺ�Ȯ��");
		b1.setBackground(new Color(255, 228, 225));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputId = idText.getText();
				MembershipDAO dao = new MembershipDAO();
				MembershipDTO dto = dao.selectId(inputId);
				String id = dto.getId();
				
				if(inputId.equals(id)) {
					JOptionPane.showMessageDialog(null, "�ߺ��ƽ��ϴ�.�ٽ��Է��ϼ���");
				}else {
					JOptionPane.showMessageDialog(null, "����� �� �ִ� ID�Դϴ�.");
				}
				
				}
		});
		b1.setForeground(new Color(255, 105, 180));
		b1.setFont(new Font("�������", Font.BOLD, 14));
		b1.setBounds(288, 43, 100, 23);
		getContentPane().add(b1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(Color.BLACK);
		toolBar.setFont(new Font("���� ���", Font.BOLD, 17));
		toolBar.setToolTipText("ȸ������");
		toolBar.setBackground(new Color(219, 112, 147));
		toolBar.setBounds(0, 0, 400, 21);
		getContentPane().add(toolBar);
		
		pwText = new JPasswordField();
		pwText.setForeground(new Color(219, 112, 147));
		pwText.setBounds(124, 79, 139, 21);
		getContentPane().add(pwText);
		
		pwTextTest = new JPasswordField();
		pwTextTest.setForeground(new Color(219, 112, 147));
		pwTextTest.setBounds(124, 114, 139, 21);
		getContentPane().add(pwTextTest);
	
		setVisible(true);
	}
}