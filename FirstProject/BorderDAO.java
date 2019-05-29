package FirstProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BorderDAO {
	String url = "jdbc:mysql://localhost:3306/clothes";
	String user = "root";
	String password = "12345";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public void insert(BorderDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			String sql = "insert into border values(null,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setString(3, dto.getUid());
			ps.setString(4, dto.getTdate());
			ps.setInt(5, dto.getCount());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public BorderDTO selectNum(int inputNum) {
		BorderDTO dto = new BorderDTO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			String sql = "select * from border where num = ?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, inputNum);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString(2);
				String content = rs.getString(3);
				String uid = rs.getString(4);
				String tdate = rs.getString(5);
				int count = rs.getInt(6);
				dto.setTitle(title);
				dto.setContent(content);
				dto.setUid(uid);
				dto.setTdate(tdate);;
				dto.setCount(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	
	public ArrayList selectAll() {
		ArrayList list = new ArrayList();
		BorderDTO dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			String sql = "select * from border ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new BorderDTO();
				int num = rs.getInt(1);
				String title = rs.getString(2);
				String uid = rs.getString(4);
				String tdate = rs.getString(5);
				int count = rs.getInt(6);
				dto.setNum(num);
				dto.setTitle(title);
				dto.setUid(uid);
				dto.setTdate(tdate);
				dto.setCount(count);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	public void update(BorderDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			String sql = "update border set title =?,content =? where num =?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setInt(3, dto.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}public void updatecount(BorderDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			String sql = "update border set count =? where title = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,dto.getCount());
			ps.setString(2, dto.getTitle());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void delete(BorderDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			String sql = "delete from border where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
