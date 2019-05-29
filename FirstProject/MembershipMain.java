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
		
		setTitle("회원가입 창");
		setBackground(new Color(255, 255, 224));
		setSize(407, 368);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 46, 100, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_2.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 82, 100, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호 확인");
		lblNewLabel_3.setForeground(new Color(178, 34, 34));
		lblNewLabel_3.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_3.setBounds(12, 117, 100, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("이름");
		lblNewLabel_4.setForeground(new Color(178, 34, 34));
		lblNewLabel_4.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_4.setBounds(12, 151, 100, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("전화번호");
		lblNewLabel_5.setForeground(new Color(178, 34, 34));
		lblNewLabel_5.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_5.setBounds(12, 189, 100, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("주소");
		lblNewLabel_6.setForeground(new Color(178, 34, 34));
		lblNewLabel_6.setFont(new Font("나눔고딕", Font.BOLD, 14));
		lblNewLabel_6.setBounds(12, 231, 100, 15);
		getContentPane().add(lblNewLabel_6);
		
		idText = new JTextField();
		idText.setForeground(new Color(219, 112, 147));
		idText.setFont(new Font("나눔고딕", Font.BOLD, 14));
		idText.setBounds(124, 40, 139, 21);
		getContentPane().add(idText);
		idText.setColumns(10);

		nameText = new JTextField();
		nameText.setForeground(new Color(219, 112, 147));
		nameText.setFont(new Font("나눔고딕", Font.BOLD, 14));
		nameText.setBounds(124, 145, 139, 21);
		getContentPane().add(nameText);
		nameText.setColumns(10);
		
		telText = new JTextField();
		telText.setForeground(new Color(219, 112, 147));
		telText.setFont(new Font("나눔고딕", Font.BOLD, 14));
		telText.setBounds(124, 183, 139, 21);
		getContentPane().add(telText);
		telText.setColumns(10);
		
		addrText = new JTextField();
		addrText.setForeground(new Color(219, 112, 147));
		addrText.setFont(new Font("나눔고딕", Font.BOLD, 14));
		addrText.setBounds(124, 225, 253, 21);
		getContentPane().add(addrText);
		addrText.setColumns(10);
		
		JButton b2 = new JButton("회원가입 완료");
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
					JOptionPane.showMessageDialog(null,"비밀번호가 일치하지 않습니다!!");
					
				}else if(id.equals(selid)){
					JOptionPane.showMessageDialog(null,"아이디 중복체크 해주세요!!");
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
		b2.setFont(new Font("나눔고딕", Font.BOLD, 14));
		b2.setBounds(124, 280, 119, 23);
		getContentPane().add(b2);
		
		JButton b1 = new JButton("중복확인");
		b1.setBackground(new Color(255, 228, 225));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputId = idText.getText();
				MembershipDAO dao = new MembershipDAO();
				MembershipDTO dto = dao.selectId(inputId);
				String id = dto.getId();
				
				if(inputId.equals(id)) {
					JOptionPane.showMessageDialog(null, "중복됐습니다.다시입력하세요");
				}else {
					JOptionPane.showMessageDialog(null, "사용할 수 있는 ID입니다.");
				}
				
				}
		});
		b1.setForeground(new Color(255, 105, 180));
		b1.setFont(new Font("나눔고딕", Font.BOLD, 14));
		b1.setBounds(288, 43, 100, 23);
		getContentPane().add(b1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(Color.BLACK);
		toolBar.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		toolBar.setToolTipText("회원가입");
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