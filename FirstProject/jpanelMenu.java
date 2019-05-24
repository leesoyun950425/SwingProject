package FirstProject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class jpanelMenu extends JPanel{
	String getId;
	static JLabel IdLb;
	
	public class eventThread extends Thread{
		
		int x;
		int y;
		ImageIcon icon;
		JLabel eventlabel;
		
		public eventThread(int x, int y) {
			this.x = 281;
			this.y = 211;
			FlowLayout flow = new FlowLayout();
			ImageIcon icon = new ImageIcon();
			setLayout(flow);
			eventlabel = new JLabel();
			eventlabel.setIcon(icon);
			eventlabel.setBounds(281, 211, 607, 328);
			add(eventlabel);
		}
		@Override
		public void run() {
			String[] pic = {"1.png","2.png","3.png"};
			for (int i = 0; i < pic.length; i++) {
				try {
					Thread.sleep(3000);
					ImageIcon icon = new ImageIcon(pic[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	private JTextField textField;
	private JFrameMain win;
	static String pname1;
	static String price1;
	static String image1;
	

	public jpanelMenu(JFrameMain win) {
		
		eventThread event = new eventThread(607,328);
		
		event.start();
		
		setBackground(new Color(255, 182, 193));
		this.win = win;
		setSize(850, 700);
		
		setLayout(null);
		
		JButton b1 = new JButton(); //»óÀÇ¹öÆ°
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("jpanelshirt");
			}
		});
		b1.setBackground(new Color(255, 255, 255));
		b1.setForeground(new Color(178, 34, 34));
		b1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		b1.setText("\uC0C1\uC758");
		add(b1);
		b1.setBounds(58, 222, 125, 50);
		
		
		JButton b2 = new JButton(); //ÇÏÀÇ¹öÆ°
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("jpanelpants");
			}
		});
		b2.setBackground(new Color(255, 255, 255));
		b2.setForeground(new Color(139, 0, 0));
		b2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		b2.setText("\uD558\uC758");
		b2.setBounds(215, 222, 125, 50);
		add(b2);
		
		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("jpanelshose");
			}
		});
		b3.setBackground(new Color(255, 255, 255));
		b3.setForeground(new Color(165, 42, 42));
		b3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		b3.setText("\uC2E0\uBC1C");
		b3.setBounds(375, 222, 125, 50);
		add(b3);
		
		JButton b4 = new JButton();
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("jpanelouter");
			}
		});
		b4.setBackground(new Color(255, 255, 255));
		b4.setForeground(new Color(199, 21, 133));
		b4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		b4.setText("\uC544\uC6B0\uD130");
		b4.setBounds(540, 222, 125, 50);
		add(b4);
		
		JLabel label = new JLabel("\uC0C1\uD488\uC785\uB825");
		label.setForeground(new Color(139, 0, 0));
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		label.setBounds(93, 171, 90, 29);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(215, 174, 306, 27);
		add(textField);
		textField.setColumns(10);
		
		JButton b5 = new JButton("\uAC80\uC0C9"); //°Ë»ö¹öÆ°
		b5.setForeground(new Color(255, 0, 0));
		b5.setBackground(new Color(255, 255, 255));
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = textField.getText();
				menuDAO dao = new menuDAO();
				ArrayList select = dao.selectlist(input);
				menuDTO dto = (menuDTO)select.get(0);
				String pname = dto.getPname();
				String price = dto.getPrice();
				String image = dto.getImage();
				System.out.println(image);
				pname1 = pname;
				price1 = price;
				image1 = image;
				
				jpanelSelect selectresult = new jpanelSelect();
			}
		});
		b5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		b5.setBounds(568, 176, 97, 23);
		add(b5);
		
		JLabel eventlabel = new JLabel("New label");
		eventlabel.setBounds(58, 282, 749, 376);
		add(eventlabel);
		
		JLabel toplabel = new JLabel("");
		toplabel.setBounds(0, 0, 850, 112);
		ImageIcon icon = new ImageIcon("1.png");
		add(toplabel);
		toplabel.setIcon(icon);
		
		getId = LoginMain2.inputId;
		
		IdLb = new JLabel();
		IdLb.setHorizontalAlignment(SwingConstants.LEFT);
		IdLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		IdLb.setForeground(new Color(178, 34, 34));
		IdLb.setBounds(524, 122, 116, 29);
		add(IdLb);
		IdLb.setText(getId);
		
		JLabel lblNewLabel = new JLabel("\uB2D8, \uD658\uC601\uD569\uB2C8\uB2E4!");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblNewLabel.setBounds(652, 122, 155, 29);
		add(lblNewLabel);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		jpanelMenu menu = new jpanelMenu(null);
	}
}
