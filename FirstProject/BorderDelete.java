package FirstProject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorderDelete extends JFrame{
	
	public BorderDelete() {
		
		setSize(241, 179);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("삭제하시겠습까?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 32, 169, 41);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("네.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorderDAO dao = new BorderDAO();
				BorderDTO dto = new BorderDTO();
				int numDel = BorderMain.num;
				dto.setNum(numDel);
				dao.delete(dto);
				dispose();
			}
		});
		btnNewButton.setBounds(30, 90, 63, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("아니요.");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(105, 90, 97, 23);
		getContentPane().add(btnNewButton_1);
		setVisible(true);
		
	}
}