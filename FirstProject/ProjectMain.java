package FirstProject;
import javax.swing.JFrame;

public class ProjectMain extends JFrame{
	public ProjectMain() {
	}

	static ProjectMain win2;

	public LoginMain login1 = null;
	public LoginMain2 login2 = null;

	 public void change2(String panelName) {
			if(panelName.equals("LoginMain")) {
				getContentPane().removeAll();
				getContentPane().add(login1);
				revalidate();
				repaint();
			}else {
				getContentPane().removeAll();
				getContentPane().add(login2);
				revalidate();
				repaint();
			}
		}
	 
	 public static void main(String[] args) {
		ProjectMain win2 = new ProjectMain();
		
		win2.login1 = new LoginMain(win2);
		win2.login2 = new LoginMain2(win2);
		win2.setTitle("로그인창");
		win2.getContentPane().add(win2.login1);
		win2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win2.setSize(350, 700);
		win2.setVisible(true);
	 }
}
