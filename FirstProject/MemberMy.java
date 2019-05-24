package FirstProject;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class MemberMy extends JFrame{
	
	public MemberMy(){
		getContentPane().setBackground(new Color(255, 228, 225));
		
		setTitle("����������");
		getContentPane().setLayout(null);
		
		JTextArea memberlist = new JTextArea();
		memberlist.setBackground(new Color(255, 228, 225));
		memberlist.setForeground(new Color(178, 34, 34));
		memberlist.setFont(new Font("���� ���", Font.BOLD, 20));
		memberlist.setBounds(12, 20, 238, 225);
		getContentPane().add(memberlist);
		
		String id = LoginMain2.inputId;
		
		MembershipDAO dao = new MembershipDAO();
		MembershipDTO dto = dao.select(id);
		
		String Uid = dto.getId();
		String name = dto.getName();
		String tel =dto.getTel();
		String addr = dto.getAddr();
		
		memberlist.append("���̵� : " +Uid+"\n");
		memberlist.append("----------------------------"+"\n");
		memberlist.append("�̸� : " +name+"\n");
		memberlist.append("----------------------------"+"\n");
		memberlist.append("��ȭ��ȣ : " +tel+"\n");
		memberlist.append("----------------------------"+"\n");
		memberlist.append("�ּ� : "+ addr+"\n");
		memberlist.append("----------------------------"+"\n");
		
		
		memberlist.setEditable(false);
		setSize(275, 297);
		
		
		setVisible(true);
		
	}
}
