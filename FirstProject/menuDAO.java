package FirstProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class menuDAO {

	String url = "jdbc:mysql://localhost:3306/clothes";
	String user = "root";
	String password = "12345";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList kindselect(String inputId) {
		ArrayList list = new ArrayList();
		menuDTO dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from menu where kind = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new menuDTO();
				int number = rs.getInt(1);
				String pname = rs.getString(2);
				String price = rs.getString(3);
				String image = rs.getString(4);
				String kind = rs.getString(5);
				dto.setNumber(number);
				dto.setPname(pname);
				dto.setPrice(price);
				dto.setImage(image);
				dto.setKind(kind);
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
	public void insert(menuDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql1 = "insert into menu values (null,?,?)";
			
			ps = con.prepareStatement(sql1);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPrice());
			
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
	}//insert close
	public void update(menuDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql2 = "update menu set pname = ?, price = ? where number = ?";
			
			ps = con.prepareStatement(sql2);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPrice());
			ps.setInt(3, dto.getNumber());
			
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
		
	}//update close
	public void delete(menuDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,user,password);
			
			String sql3 = "delete from menu where number = ?";
			
			ps = con.prepareStatement(sql3);
			ps.setInt(1, dto.getNumber());
			
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
	} //delete close
	public ArrayList selectlist(String inputpname) {
		ArrayList list = new ArrayList();
		menuDTO dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,user,password);
			
			String sql4 = "select * from menu where pname = ?";
			
			ps = con.prepareStatement(sql4);
			ps.setString(1, inputpname);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new menuDTO();
				String pname = rs.getString(2);
				String price = rs.getString(3);
				String image = rs.getString(4);
				dto.setPname(pname);
				dto.setPrice(price);
				dto.setImage(image);
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
	}
	public menuDTO getnumber(int number) {
		menuDTO dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,user,password);
			
			String sql4 = "select * from menu where number = ?";
			
			ps = con.prepareStatement(sql4);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new menuDTO();
				String pname = rs.getString(2);
				String price = rs.getString(3);
				String image = rs.getString(4);
				dto.setPname(pname);
				dto.setPrice(price);
				dto.setImage(image);
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
		return dto;
	}
}