package FirstProject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.NClob;
import java.awt.Font;

public class jframeorserch extends JFrame{
   static JTable table;
   static DefaultTableModel model;
   static int num ;
   static int su;
   static String title;
   static int numInput;
   int nRow,nColumn;
   String cRow,cColumn;
   Object cValue;

   public jframeorserch() {
      setTitle("주문내역조회창");
      Dimension dim = new Dimension(500,500);
      
      setLocation(100,200);
      setPreferredSize(dim);      
      
      String sub[] = {"제품이름","가격","주문자"};
      
      model = new DefaultTableModel(sub,0);
      orrderDAO dao = new orrderDAO();
      ArrayList list = dao.shows();
      
      for (int i = 0; i < list.size(); i++) {
         orrderDTO dto = (orrderDTO)list.get(i);
         model.addRow(new Object[] {dto.getPname(),dto.getPrice(),dto.getUser()});
      }
      table = new JTable(model);
      table.setForeground(new Color(178, 34, 34));
      table.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      table.setBackground(new Color(255, 228, 225));
      table.setBorder(new LineBorder(new Color(65, 105, 225)));
      table.setBounds(23, 360, 349, -338);
      
      JScrollPane scroll = new JScrollPane(table);
      table.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            table = (JTable)e.getComponent();
            model = (DefaultTableModel)table.getModel();
            
            nRow = table.getSelectedRow();
            nColumn = table.getSelectedColumn();
            
            cRow = table.getColumnName(nColumn);
            cValue = model.getValueAt(nRow, nColumn);
            num = (int) table.getValueAt(table.getSelectedRow(), 0);
          }
      });
      
      JButton btnNewButton_2 = new JButton("종료"); //종료
      btnNewButton_2.setBackground(new Color(255, 255, 255));
      btnNewButton_2.setForeground(new Color(178, 34, 34));
      btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      btnNewButton_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
         }
      });
      btnNewButton_2.setBounds(151, 385, 97, 23);
      getContentPane().add(btnNewButton_2);
      
      getContentPane().add(scroll);
      setSize(420, 510);
      setVisible(true);
   }
}