package FirstProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginMain extends JPanel{
	
	private JButton jButton1;
	private ProjectMain win2;
	public MembershipDTO dto;
	
	
	static String sessionId;
	static JTextField idText;
	static JPasswordField pwText;


	public LoginMain(ProjectMain win2) {
		 this.win2 = win2;
	      setBackground(new Color(255, 182, 193));
	
	      setBounds(0, 66, 300, 559);
	      setLayout(null);
	      
	      JLabel lb1 = new JLabel("\uC544\uC774\uB514");
	      lb1.setFont(new Font("±¼¸²", Font.BOLD, 18));
	      lb1.setForeground(new Color(139, 0, 0));
	      lb1.setBounds(31, 77, 57, 15);
	      add(lb1);
	      
	      JLabel lb2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
	      lb2.setFont(new Font("±¼¸²", Font.BOLD, 18));
	      lb2.setForeground(new Color(139, 0, 0));
	      lb2.setBounds(22, 128, 76, 21);
	      add(lb2);
	      
	      
	      idText = new JTextField();
	      idText.setForeground(new Color(199, 21, 133));
	      idText.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	      idText.setBounds(133, 76, 139, 25);
	      add(idText);
	      idText.setColumns(10);
	      
	      pwText = new JPasswordField();
	      pwText.setForeground(new Color(199, 21, 133));
	      pwText.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	      pwText.setBounds(133, 130, 139, 25);
	      add(pwText);
	      
	      JButton b2 = new JButton("\uB85C\uADF8\uC778");
	      b2.setForeground(new Color(178, 34, 34));
	      b2.setBackground(new Color(255, 255, 255));
	      b2.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		String inputId = idText.getText();
	      		String inputPw = new String(pwText.getPassword());
	      		
	      		MembershipDAO dao = new MembershipDAO();
	      		MembershipDTO dto = dao.selectId(inputId);
	      		MembershipDTO dto1 = dao.selectPw(inputPw);
	      		
	      		String id = dto.getId();
	      		String pw = dto1.getPw();
	      		
	      		if(inputId.equals(id) && inputPw.equals(pw)) {
	      			win2.change2("LoginMain2");
	      			sessionId = inputId;
	      			LoginMain2 login2 = new LoginMain2();
	      			login2.l1.setText(sessionId);
	      		}else {
	      			JOptionPane.showMessageDialog(null, "¾ÆÀÌµð È¤Àº ºñ¹Ð¹øÈ£¸¦ Àß¸øÀÔ·ÂÇÏ¼Ì½À´Ï´Ù.");
	      		}
	      	}
	      });

	      b2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	      b2.setBounds(31, 189, 97, 23);
	      add(b2);
	      
	      JButton b3 = new JButton("È¸¿ø°¡ÀÔ");
	      b3.setForeground(new Color(178, 34, 34));
	      b3.setBackground(new Color(255, 255, 255));
	      b3.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            MembershipMain m1 = new MembershipMain();
	         }
	      });
	      b3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	      b3.setBounds(154, 189, 118, 23);
	      add(b3);
	      
	      JButton btnNewButton_1 = new JButton("°Ô½ÃÆÇ");
	      btnNewButton_1.setForeground(new Color(178, 34, 34));
	      btnNewButton_1.setBackground(new Color(255, 255, 255));
	      btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	      btnNewButton_1.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		BorderMain bm = new BorderMain();
	      	}
	      });
	      btnNewButton_1.setBounds(81, 302, 134, 38);
	      add(btnNewButton_1);
	      
	      JButton btnNewButton = new JButton("¾ÆÀÌµð Ã£±â");
	      btnNewButton.setForeground(new Color(178, 34, 34));
	      btnNewButton.setBackground(new Color(255, 255, 255));
	      btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	      btnNewButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		SelectId sid = new SelectId();
	      	}
	      });
	      btnNewButton.setBounds(12, 238, 124, 25);
	      add(btnNewButton);
	      
	      JButton btnNewButton_2 = new JButton("ºñ¹Ð¹øÈ£ Ã£±â");
	      btnNewButton_2.setForeground(new Color(178, 34, 34));
	      btnNewButton_2.setBackground(new Color(255, 255, 255));
	      btnNewButton_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	      btnNewButton_2.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		SelectPw spw = new SelectPw();
	      	}
	      });
	      btnNewButton_2.setBounds(154, 238, 134, 25);
	      add(btnNewButton_2);
	      
	      JButton button = new JButton("\uBA54\uB274\uCC3D");
	      button.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		JFrameMain win = new JFrameMain();
				
				win.getContentPane().setLayout(null);
				
				win.setTitle("main frame");
				win.Jpanel01 = new jpanelMenu(win);
				win.Jpanel02 = new jpanelshirt(win);
				win.Jpanel03 = new jpanelpants(win);
				win.Jpanel04 = new jpanelshose(win);
				win.Jpanel05 = new jpanelouter(win);
				
				
				win.getContentPane().add(win.Jpanel01);
				win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				win.setSize(860, 900);
				win.setVisible(true);
	      		}
	      });
	      button.setForeground(new Color(178, 34, 34));
	      button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	      button.setBackground(Color.WHITE);
	      button.setBounds(81, 375, 134, 38);
	      add(button);
	      
	    
	      
	      setVisible(true);
	}
}
