package FirstProject;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Event;
import javax.swing.JTextField;

public class LoginMain2 extends JPanel{
private ProjectMain win2;
static String inputId;
static JLabel l1;
static JButton logoutbt;

public LoginMain2() {
	inputId = LoginMain.sessionId;
}
public LoginMain2(ProjectMain win2) {
	setBackground(new Color(255, 182, 193));
	this.win2 = win2;
	
	setLayout(null);
	
	l1 = new JLabel();
	l1.setForeground(new Color(139, 0, 0));
	l1.setFont(new Font("±¼¸²", Font.BOLD, 20));
	l1.setBounds(84, 63, 198, 24);
	add(l1);
	l1.setText(inputId);
	
	JLabel lblNewLabel = new JLabel("님의 페이지 입니다.");
	lblNewLabel.setForeground(new Color(139, 0, 0));
	lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
	lblNewLabel.setBounds(84, 91, 323, 33);
	add(lblNewLabel);
	
	JButton btnNewButton = new JButton("수정하기");
	btnNewButton.setForeground(new Color(178, 34, 34));
	btnNewButton.setBackground(new Color(255, 255, 255));
	btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			inputId = LoginMain.sessionId;
			LoginUpdate u = new LoginUpdate();
			u.idLb.setText(inputId);
		}
	});
	btnNewButton.setBounds(30, 139, 110, 34);
	add(btnNewButton);
	
	logoutbt = new JButton("로그아웃");
	logoutbt.setForeground(new Color(178, 34, 34));
	logoutbt.setBackground(new Color(255, 255, 255));
	logoutbt.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	logoutbt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			win2.change2("LoginMain");
			LoginMain2.l1.setText("");
			LoginMain.idText.setText("");
			LoginMain.pwText.setText("");
		}
	});
	logoutbt.setBounds(98, 207, 129, 34);
	add(logoutbt);
	
	JButton button = new JButton("탈퇴하기");
	button.setForeground(new Color(178, 34, 34));
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			LoginDelete d = new LoginDelete(win2);
			d.idLBel.setText(inputId);
		}
	});
	button.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	button.setBackground(new Color(255, 255, 255));
	button.setBounds(187, 139, 116, 34);
	add(button);
	
	JButton btnNewButton_1 = new JButton("게시판");
	btnNewButton_1.setForeground(new Color(178, 34, 34));
	btnNewButton_1.setBackground(new Color(255, 255, 255));
	btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			BorderMain bm = new BorderMain();
		}
	});
	btnNewButton_1.setBounds(114, 264, 97, 33);
	add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("마이페이지");
	btnNewButton_2.setForeground(new Color(178, 34, 34));
	btnNewButton_2.setBackground(new Color(255, 255, 255));
	btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MemberMy my = new MemberMy();
		}
	});
	btnNewButton_2.setBounds(98, 319, 129, 33);
	add(btnNewButton_2);
	
	JButton button_1 = new JButton("메뉴창");
	button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JFrameMain win = new JFrameMain();
			
			win.getContentPane().setLayout(null);
			
			win.setTitle("메뉴");
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
		button_1.setForeground(new Color(178, 34, 34));
		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(98, 372, 129, 33);
		add(button_1);
		
		JButton button_2 = new JButton("주문내역");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframeorserch serch = new jframeorserch();
			}
		});
		button_2.setForeground(new Color(178, 34, 34));
		button_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(98, 422, 129, 33);
		add(button_2);
		
		setVisible(true);
	}
}