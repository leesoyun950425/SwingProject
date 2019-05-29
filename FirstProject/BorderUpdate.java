package FirstProject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class BorderUpdate extends JFrame{
	private JTextField titleText;
	int numUp;
	
	public BorderUpdate() {
		setTitle("게시판 수정하기");
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(363,457);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("제목");
		lblNewLabel.setForeground(new Color(219, 112, 147));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(39, 26, 68, 21);
		getContentPane().add(lblNewLabel);
		
		titleText = new JTextField();
		titleText.setForeground(new Color(106, 90, 205));
		titleText.setBounds(131, 26, 152, 21);
		getContentPane().add(titleText);
		titleText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("내용");
		lblNewLabel_1.setForeground(new Color(219, 112, 147));
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(131, 57, 67, 22);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea contentText = new JTextArea();
		contentText.setForeground(new Color(106, 90, 205));
		contentText.setBackground(new Color(255, 255, 255));
		contentText.setBounds(25, 89, 294, 221);
		getContentPane().add(contentText);
		
		
		JButton btnNewButton = new JButton("수정완료");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorderDAO dao = new BorderDAO();
				BorderDTO dto = new BorderDTO();
				String title = titleText.getText();
				String content = contentText.getText();
				numUp = BorderMain.num;
				
				dto.setTitle(title);
				dto.setContent(content);
				dto.setNum(numUp);
				dao.update(dto);
				dispose();
			}
		});
		btnNewButton.setBounds(113, 363, 110, 30);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("아이디 : ");
		lblNewLabel_2.setForeground(new Color(219, 112, 147));
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_2.setBounds(57, 323, 86, 30);
		getContentPane().add(lblNewLabel_2);
		
		String uid = LoginMain2.inputId;
		JLabel uidLb = new JLabel();
		uidLb.setForeground(new Color(106, 90, 205));
		uidLb.setBounds(143, 320, 110, 33);
		getContentPane().add(uidLb);
		uidLb.setText(uid);
		
		setVisible(true);
	}
}