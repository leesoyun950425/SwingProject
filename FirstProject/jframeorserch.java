package FirstProject;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;
import java.awt.Color;

public class jframeorserch extends JFrame{

	public jframeorserch () {
		getContentPane().setBackground(Color.PINK);
		
		setSize(500, 500);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uBB38\uB0B4\uC5ED \uD655\uC778");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 484, 73);
		getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 228, 225));
		textArea.setForeground(new Color(178, 34, 34));
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		
		orrderDAO dao = new orrderDAO();
		ArrayList list = dao.shows();

		for (int i = 0; i < list.size(); i++) {
			orrderDTO dto = (orrderDTO)list.get(i);
			String pname = dto.getPname();
			String price = dto.getPrice();
			String user = dto.getUser();
			textArea.append("제품이름 : " + pname + ", 가격 : " + price + ", 주문자 : " + user + "\n");
		}
		
		textArea.setBounds(10, 83, 462, 340);
		textArea.setEditable(false);
		getContentPane().add(textArea);
		
		setTitle("주문내역 확인");
		
		setVisible(true);
	}
}
