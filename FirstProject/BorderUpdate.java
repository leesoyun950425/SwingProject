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
		getContentPane().setBackground(new Color(255, 228, 225));
		setSize(363,457);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setForeground(new Color(219, 112, 147));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(39, 26, 68, 21);
		getContentPane().add(lblNewLabel);
		
		titleText = new JTextField();
		titleText.setForeground(new Color(106, 90, 205));
		titleText.setBounds(131, 26, 152, 21);
		getContentPane().add(titleText);
		titleText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uB0B4\uC6A9");
		lblNewLabel_1.setForeground(new Color(219, 112, 147));
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(131, 57, 67, 22);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea contentText = new JTextArea();
		contentText.setForeground(new Color(106, 90, 205));
		contentText.setBackground(new Color(255, 255, 255));
		contentText.setBounds(25, 89, 294, 221);
		getContentPane().add(contentText);
		
		
		JButton btnNewButton = new JButton("¼öÁ¤¿Ï·á");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
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
		
		JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uB514 : ");
		lblNewLabel_2.setForeground(new Color(219, 112, 147));
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
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