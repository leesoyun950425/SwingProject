package FirstProject;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.BorderLayout;

public class JFrameMain extends JFrame{
	public JFrameMain() {
		getContentPane().setBackground(new Color(255, 182, 193));
		
	}
	
	public jpanelMenu Jpanel01 = null;
	public jpanelshirt Jpanel02 = null;
	public jpanelpants Jpanel03 = null;
	public jpanelshose Jpanel04 = null;
	public jpanelouter Jpanel05 = null;
	
	public void change(String panelName) {
	
		if(panelName.equals("jpanelMenu")) {
			getContentPane().removeAll();
			getContentPane().add(Jpanel01);
			revalidate();
			repaint();
		}else if(panelName.equals("jpanelshirt")){
			getContentPane().removeAll();
			getContentPane().add(Jpanel02);
			repaint();
			revalidate();
		}else if(panelName.equals("jpanelpants")) {
			getContentPane().removeAll();
			getContentPane().add(Jpanel03);
			repaint();
			revalidate();
		}else if(panelName.equals("jpanelshose")) {
			getContentPane().removeAll();
			getContentPane().add(Jpanel04);
			repaint();
			revalidate();
		}else {
			getContentPane().removeAll();
			getContentPane().add(Jpanel05);
			repaint();
			revalidate();
		}
		
		getContentPane().setLayout(null);
	
	}
	
	public static void main(String[] args) {
		
		JFrameMain win = new JFrameMain();
		
		win.getContentPane().setLayout(null);
		
		win.setTitle("¸Þ´ºÃ¢");
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
}	
