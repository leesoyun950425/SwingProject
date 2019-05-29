package FirstProject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BorderWrite extends JFrame{
	
	private JTextField titleText;
	
	String inputBId;
	JTable tablewrite;
	DefaultTableModel modelInsert;
	
	public BorderWrite() {
		getContentPane().setBackground(new Color(255, 228, 225));
		setTitle("게시판");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<<<제목>>>");
		lblNewLabel.setForeground(new Color(219, 112, 147));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblNewLabel.setBounds(17, 41, 161, 28);
		getContentPane().add(lblNewLabel);
		
		titleText = new JTextField();
		titleText.setForeground(new Color(255, 105, 180));
		titleText.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		titleText.setBounds(195, 42, 238, 33);
		getContentPane().add(titleText);
		titleText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("<<<<<내용>>>>>");
		lblNewLabel_1.setForeground(new Color(219, 112, 147));
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1.setBounds(108, 95, 223, 31);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea contentText = new JTextArea();
		contentText.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		contentText.setForeground(new Color(255, 105, 180));
		contentText.setBounds(30, 150, 369, 206);
		getContentPane().add(contentText);
		
		inputBId = LoginMain2.inputId;
		
		JLabel IdLb = new JLabel();
		IdLb.setForeground(new Color(219, 112, 147));
		IdLb.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		IdLb.setBounds(184, 366, 106, 42);
		getContentPane().add(IdLb);
		IdLb.setText(inputBId);
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		
		String today = year+"-"+month+"-"+day;
		
		JButton btnNewButton = new JButton("입력");
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorderDAO dao = new BorderDAO();
				BorderDTO dto = new BorderDTO();
				ArrayList list = dao.selectAll();
				BorderDTO dto2 = (BorderDTO)list.get(0);
				
				int num = BorderMain.numInput+1;
				String title = titleText.getText();
				String content = contentText.getText();
				String uid = IdLb.getText();
				String tdate = today;
				int count = 0;
				dto2.setNum(num);
				dto.setTitle(title);
				dto.setContent(content);
				dto.setUid(uid);
				dto.setTdate(tdate);
				dto.setCount(count);
				dao.insert(dto);
					
				modelInsert = BorderMain.model;
				tablewrite = new JTable(modelInsert);
				modelInsert.addRow(new Object[] {num,title,uid,tdate,count});
				dispose();
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		btnNewButton.setBounds(140, 453, 129, 29);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("아이디 :");
		lblNewLabel_2.setForeground(new Color(219, 112, 147));
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel_2.setBounds(63, 375, 129, 33);
		getContentPane().add(lblNewLabel_2);
		
		setSize(468,567);
		setVisible(true);
	}
}