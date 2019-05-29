package FirstProject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class SelectId extends JFrame{
	private JTextField nameText;
	private JTextField telText;
	
	public SelectId() {
		setTitle("아이디 찾기");
		getContentPane().setBackground(new Color(255, 228, 225));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(23, 54, 66, 15);
		getContentPane().add(lblNewLabel);
		
		nameText = new JTextField();
		nameText.setForeground(new Color(255, 105, 180));
		nameText.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		nameText.setBounds(109, 51, 116, 21);
		getContentPane().add(nameText);
		nameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 91, 66, 15);
		getContentPane().add(lblNewLabel_1);
		
		telText = new JTextField();
		telText.setForeground(new Color(255, 105, 180));
		telText.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		telText.setBounds(109, 88, 116, 21);
		getContentPane().add(telText);
		telText.setColumns(10);
		
		JButton btnNewButton = new JButton("아이디찾기");
		btnNewButton.setForeground(new Color(255, 105, 180));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputName = nameText.getText();
				String inputTel = telText.getText();
				
				MembershipDAO dao = new MembershipDAO();
				MembershipDTO dto = dao.selectIdName(inputName, inputTel);
				String id = dto.getId();
				
				if(id==null) {
					JOptionPane.showMessageDialog(null, "입력하신 정보는 없습니다");
				}else {
					JOptionPane.showMessageDialog(null, "찾은 아이디 : "+id);
					dispose();
					LoginMain.idText.setText(id);
				}
			}
		});
		btnNewButton.setBounds(53, 134, 122, 23);
		getContentPane().add(btnNewButton);
		setSize(253,250);
		setVisible(true);
	}
}