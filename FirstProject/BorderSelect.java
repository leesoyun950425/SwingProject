package FirstProject;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class BorderSelect extends JFrame{
	static JLabel conLb;
	int inputNum;
	String userid;
	static String uid1;
	
	public BorderSelect() {
		setTitle("게시판");
		getContentPane().setBackground(new Color(255, 228, 225));
		
		inputNum = BorderMain.num;
		userid = LoginMain2.inputId;

		BorderDAO dao = new BorderDAO();
		BorderDTO dto1 = dao.selectNum(inputNum);
		
		String title1 = dto1.getTitle();
		String content1 = dto1.getContent();
		uid1 = dto1.getUid();
		
		setSize(363,457);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<<제목>>");
		lblNewLabel.setForeground(new Color(219, 112, 147));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 23, 97, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel titleLb = new JLabel();
		titleLb.setForeground(new Color(106, 90, 205));
		titleLb.setHorizontalAlignment(SwingConstants.CENTER);
		titleLb.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		titleLb.setBounds(119, 23, 145, 23);
		getContentPane().add(titleLb);
		titleLb.setText(title1);
		
		
		JLabel lblNewLabel_2 = new JLabel("<<<내용>>>");
		lblNewLabel_2.setForeground(new Color(219, 112, 147));
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(98, 48, 138, 23);
		getContentPane().add(lblNewLabel_2);
		
		conLb = new JLabel();
		conLb.setBackground(new Color(255, 255, 255));
		conLb.setForeground(new Color(106, 90, 205));
		conLb.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		conLb.setHorizontalAlignment(SwingConstants.CENTER);
		conLb.setBounds(22, 81, 296, 210);
		getContentPane().add(conLb);
		conLb.setText(content1);
		
		JLabel lblNewLabel_4 = new JLabel("아이디 :");
		lblNewLabel_4.setForeground(new Color(219, 112, 147));
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_4.setBounds(61, 319, 72, 23);
		getContentPane().add(lblNewLabel_4);
		
		JLabel idLb = new JLabel();
		idLb.setHorizontalAlignment(SwingConstants.CENTER);
		idLb.setForeground(new Color(106, 90, 205));
		idLb.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		idLb.setBounds(145, 319, 102, 23);
		getContentPane().add(idLb);
		idLb.setText(uid1);
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!uid1.equals(userid)) {
					JOptionPane.showMessageDialog(null, "본인이 작성한 게시물만 수정가능합니다!!");
				}else {
					BorderUpdate bu = new BorderUpdate();
					dispose();
				}
			}
		});
		btnNewButton.setBounds(50, 364, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("삭제");
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!uid1.equals(userid)) {
					JOptionPane.showMessageDialog(null, "본인이 작성한 게시물만 삭제가능합니다!!");
				}else {
					BorderDelete bd = new BorderDelete();
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(186, 364, 97, 23);
		getContentPane().add(btnNewButton_1);
		setVisible(true);
	}
}