package FirstProject;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JPanel;

public class MemberTest {
	private static JTextField textField;
	private static JTextField idText;
	private static JTextField pwTextTestU;
	private static JPasswordField pwText;
	private static JPasswordField pwTextTest;
	private static JTextField nameText;
	private static JTextField telText;
	private static JTextField addrText;
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(434,463);
		f.getContentPane().setLayout(null);
			
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(22, 10, 57, 15);
		f.getContentPane().add(lblNewLabel);
		
		idText = new JTextField();
		idText.setBounds(101, 7, 116, 21);
		f.getContentPane().add(idText);
		idText.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("중복확인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputId = idText.getText();
				MembershipDAO dao = new MembershipDAO();
				MembershipDTO dto = dao.selectId(inputId);
				String id = dto.getId();
				while(true) {
					if(inputId.equals(id)) {
						JOptionPane.showMessageDialog(null, "중복됐습니다.다시입력하세요");
						String idw = JOptionPane.showInputDialog("ID재입력");
						if(!idw.equals(id)) {
							JOptionPane.showMessageDialog(null, "성공");
							break;
						}
					}
				}
			}
		});
		btnNewButton_1.setBounds(255, 6, 97, 23);
		f.getContentPane().add(btnNewButton_1);
//		if(t1.equals(t2)) {
//			
//		}else {
//			JLabel pwLable = new JLabel("다릅니다.");
//			f.getContentPane().add(pwLable);
//		}
//		
		JLabel lblNewLabel_1 = new JLabel("비번");
		lblNewLabel_1.setBounds(22, 56, 57, 15);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("확인");
		lblNewLabel_2.setBounds(22, 81, 57, 15);
		f.getContentPane().add(lblNewLabel_2);
		
//		JPanel panel = new JPanel();
//		panel.setBounds(22, 217, 330, 179);
//		f.getContentPane().add(panel);
		
		
		
	
		pwTextTestU = new JTextField();
		pwTextTestU.setBounds(255, 53, 116, 21);
		f.getContentPane().add(pwTextTestU);
		pwTextTestU.setColumns(10);
		
		pwText = new JPasswordField();
		pwText.setBounds(101, 53, 116, 21);
		f.getContentPane().add(pwText);
		
		pwTextTest = new JPasswordField();
		pwTextTest.setBounds(101, 78, 116, 21);
		f.getContentPane().add(pwTextTest);
		
		JButton btnNewButton_2 = new JButton("비밀번호 확인");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pws = new String(pwText.getPassword()); 
				String pws2 = new String(pwTextTest.getPassword());
				if(pws2.equals(pws)) {
					pwTextTestU.setText("일치!");
				}else {
					pwTextTestU.setText("불일치!");
				}
			}
		});
		btnNewButton_2.setBounds(235, 77, 97, 23);
		f.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setBounds(12, 131, 57, 15);
		f.getContentPane().add(lblNewLabel_3);
		
		JLabel label = new JLabel("전화번호");
		label.setBounds(12, 156, 57, 15);
		f.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("주소");
		label_1.setBounds(12, 181, 57, 15);
		f.getContentPane().add(label_1);
		
		nameText = new JTextField();
		nameText.setBounds(101, 128, 116, 21);
		f.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		telText = new JTextField();
		telText.setColumns(10);
		telText.setBounds(101, 153, 116, 21);
		f.getContentPane().add(telText);
		
		addrText = new JTextField();
		addrText.setColumns(10);
		addrText.setBounds(101, 188, 116, 21);
		f.getContentPane().add(addrText);
		
		JButton btnNewButton = new JButton("회원가입 완료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MembershipDAO dao = new MembershipDAO();
				MembershipDTO dto = new MembershipDTO();
				
				String id = idText.getText();
				String pws = new String(pwText.getPassword());
				String name = nameText.getText();
				String tel = telText.getText();
				String addr = addrText.getText();
				
				dto.setId(id);
				dto.setPw(pws);
				dto.setName(name);
				dto.setTel(tel);
				dto.setAddr(addr);
				
				dao.insert(dto);
				System.exit(0);
			}
		});

		btnNewButton.setBounds(124, 315, 116, 23);
		f.getContentPane().add(btnNewButton);
		
		
		f.setVisible(true);
	
	}
}