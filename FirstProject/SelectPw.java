package FirstProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class SelectPw extends JFrame{
	private JTextField nameText;
	private JTextField idText;
	
	public SelectPw() {
		setTitle("비밀번호 찾기");
		getContentPane().setBackground(new Color(255, 228, 225));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_2.setBounds(32, 48, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		idText = new JTextField();
		idText.setForeground(new Color(255, 105, 180));
		idText.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		idText.setBounds(109, 45, 116, 21);
		getContentPane().add(idText);
		idText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(32, 80, 57, 15);
		getContentPane().add(lblNewLabel);
		
		nameText = new JTextField();
		nameText.setForeground(new Color(255, 105, 180));
		nameText.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		nameText.setBounds(109, 77, 116, 21);
		getContentPane().add(nameText);
		nameText.setColumns(10);
		
		JButton btnNewButton = new JButton("비밀번호 찾기");
		btnNewButton.setForeground(new Color(255, 105, 180));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inputId = idText.getText();
				String inputName = nameText.getText();
				
				MembershipDAO dao = new MembershipDAO();
				MembershipDTO dto = dao.selectPwName(inputId, inputName);
				String pw = dto.getPw();
				
				if(pw==null) {
					JOptionPane.showMessageDialog(null, "입력하신 정보는 없습니다");
				}else {
					JOptionPane.showMessageDialog(null, "찾은 비밀번호 : "+pw);
					dispose();
					LoginMain.pwText.setText(pw);
				}
			}
		});
		btnNewButton.setBounds(44, 137, 147, 23);
		getContentPane().add(btnNewButton);
		
		setSize(270,250);
		setVisible(true);
	}
}