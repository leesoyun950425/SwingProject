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
		setTitle("\uC544\uC774\uB514 \uCC3E\uAE30");
		getContentPane().setBackground(new Color(255, 228, 225));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblNewLabel.setBounds(23, 54, 66, 15);
		getContentPane().add(lblNewLabel);
		
		nameText = new JTextField();
		nameText.setForeground(new Color(255, 105, 180));
		nameText.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		nameText.setBounds(109, 51, 116, 21);
		getContentPane().add(nameText);
		nameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 91, 66, 15);
		getContentPane().add(lblNewLabel_1);
		
		telText = new JTextField();
		telText.setForeground(new Color(255, 105, 180));
		telText.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		telText.setBounds(109, 88, 116, 21);
		getContentPane().add(telText);
		telText.setColumns(10);
		
		JButton btnNewButton = new JButton("¾ÆÀÌµðÃ£±â");
		btnNewButton.setForeground(new Color(255, 105, 180));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputName = nameText.getText();
				String inputTel = telText.getText();
				
				MembershipDAO dao = new MembershipDAO();
				MembershipDTO dto = dao.selectIdName(inputName, inputTel);
				String id = dto.getId();
				
				if(id==null) {
					JOptionPane.showMessageDialog(null, "ÀÔ·ÂÇÏ½Å Á¤º¸´Â ¾ø½À´Ï´Ù");
				}else {
					JOptionPane.showMessageDialog(null, "Ã£Àº ¾ÆÀÌµð : "+id);
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
