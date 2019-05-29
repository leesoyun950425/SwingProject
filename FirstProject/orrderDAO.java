package FirstProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class orrderDAO {

	String url = "jdbc:mysql://localhost:3306/clothes";
	String user = "root";
	String password = "12345";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList shows() {
		ArrayList list = new ArrayList();
		orrderDTO dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from orrder";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new orrderDTO();
				String pname = rs.getString(2);
				String price = rs.getString(3);
				String user = rs.getString(4);
				dto.setPname(pname);
				dto.setPrice(price);
				dto.setUser(user);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}//select close
	public void insert(orrderDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			String sql1 = "insert into orrder values (null,?,?,?)";
			ps = con.prepareStatement(sql1);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPrice());
			ps.setString(3, dto.getUser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}