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
   private JTextField textField;
   private JFrameMain win;
   static String pname1;
   static String price1;
   static String image1;
   

   public jpanelMenu(JFrameMain win) {
      
      setBackground(new Color(255, 182, 193));
      this.win = win;
      setSize(850, 700);
      
      setLayout(null);
      
      JButton b1 = new JButton(); //상의버튼
      b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            win.change("jpanelshirt");
         }
      });
      b1.setBackground(new Color(255, 255, 255));
      b1.setForeground(new Color(178, 34, 34));
      b1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      b1.setText("상의");
      add(b1);
      b1.setBounds(58, 222, 125, 50);
      
      
      JButton b2 = new JButton(); //두번째버튼
      b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            win.change("jpanelpants");
         }
      });
      b2.setBackground(new Color(255, 255, 255));
      b2.setForeground(new Color(139, 0, 0));
      b2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      b2.setText("하의");
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
      b3.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      b3.setText("신발");
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
      b4.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      b4.setText("아우터");
      b4.setBounds(540, 222, 125, 50);
      add(b4);
      
      JLabel label = new JLabel("상품입력");
      label.setForeground(new Color(139, 0, 0));
      label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      label.setBounds(93, 171, 90, 29);
      add(label);
      
      textField = new JTextField();
      textField.setBounds(215, 174, 306, 27);
      add(textField);
      textField.setColumns(10);
      
      JButton b5 = new JButton("검색"); //검색버튼
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
      b5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      b5.setBounds(568, 176, 97, 23);
      add(b5);
      
      JLabel toplabel = new JLabel("");
      toplabel.setBounds(0, 0, 850, 112);
      ImageIcon icon = new ImageIcon("1.png");
      add(toplabel);
      toplabel.setIcon(icon);
      
      getId = LoginMain2.inputId;
      
      IdLb = new JLabel();
      IdLb.setHorizontalAlignment(SwingConstants.LEFT);
      IdLb.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      IdLb.setForeground(new Color(178, 34, 34));
      IdLb.setBounds(524, 122, 116, 29);
      add(IdLb);
      IdLb.setText(getId);
      
      JLabel lblNewLabel = new JLabel("님, 환영합니다!");
      lblNewLabel.setForeground(new Color(178, 34, 34));
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      lblNewLabel.setBounds(652, 122, 155, 29);
      add(lblNewLabel);
      
      String pic = "m1.jpg";
      JLabel mb1 = new JLabel("메인사진");
         ImageIcon icon1 = new ImageIcon(pic);
         mb1.setIcon(icon1);
      mb1.setBounds(58, 282, 607, 408);
      add(mb1);
      
      setVisible(true);
   }
}