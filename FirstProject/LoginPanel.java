package FirstProject;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class LoginPanel extends JPanel{

	public LoginPanel() {
		setBackground(Color.BLACK);
		
		setSize(246, 900);
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 107, 222, 29);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC8FC\uBB38\uB0B4\uC5ED");
		btnNewButton.setBounds(12, 239, 97, 23);
		add(btnNewButton);
		
		JButton button = new JButton("\uB85C\uADF8\uC544\uC6C3");
		button.setBounds(137, 239, 97, 23);
		add(button);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome!!! \uBE70\uBE70\uBE60 \uBE60\uB77C\uBE70\uBE60\u266C");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 146, 222, 57);
		add(lblNewLabel_1);
		
		
		
		setVisible(true);
		
	}
}
