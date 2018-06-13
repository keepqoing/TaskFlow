package TF.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectDAO {
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TaskFlow?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";

	Connection conn = null;
	PreparedStatement pstmt = null;

	public ArrayList<ProjectDO> list(){
		connectDB();
		String query = "select * from PROJECT";

		ArrayList<ProjectDO> datas = new ArrayList<ProjectDO>();

		try {
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				ProjectDO tmp = new ProjectDO();
				tmp.setpCode(rs.getInt("pCode"));
				tmp.setpName(rs.getString("pName"));
				tmp.setpDescript(rs.getString("pDescript"));
				tmp.setpManager(rs.getString("pManager"));
				tmp.setpMember(rs.getString("pMember"));
				datas.add(tmp);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeDB();
		}
		return datas;
	}
	
	public ArrayList<ProjectDO> pjlist(String pCodeList){
		connectDB();
		String query = "select * from PROJECT where pCode in";
		System.out.println(pCodeList);
			query += "(" + pCodeList + ")";
		ArrayList<ProjectDO> datas = new ArrayList<ProjectDO>();

		try {
			pstmt = conn.prepareStatement(query);
			
			
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				ProjectDO tmp = new ProjectDO();
				tmp.setpCode(rs.getInt("pCode"));
				tmp.setpName(rs.getString("pName"));
				tmp.setpDescript(rs.getString("pDescript"));
				tmp.setpManager(rs.getString("pManager"));
				tmp.setpMember(rs.getString("pMember"));
				datas.add(tmp);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeDB();
		}
		return datas;
	}
	
	public ArrayList<Integer> codeList(){
		connectDB();
		String query = "select * from PROJECT";

		ArrayList<Integer> datas = new ArrayList<Integer>();

		try {
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				int tmp = 0;
				tmp = rs.getInt("pCode");
				
				datas.add(tmp);
			}
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeDB();
		}
		return datas;
	}
	

	public void createProject(int _pCode, String _pName, String _pDescript, String _pManager) {
		connectDB();
		String query = "insert into PROJECT (pCode, pName, pDescript, pManager) values(?,?,?,?)";		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, _pCode);
			pstmt.setString(2, _pName);
			pstmt.setString(3, _pDescript);
			pstmt.setString(4, _pManager);

			int n = pstmt.executeUpdate();


		}catch(SQLException e) {
			e.printStackTrace();
			return;
		}finally {
			closeDB();
		}
	}


	public ProjectDO getInfo(int _pCode) {
		connectDB();
		String query = "select * from PROJECT where pCode=?";

		ProjectDO data = new ProjectDO();
		try {
			pstmt = conn.prepareStatement(query);				
			pstmt.setInt(1, _pCode);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
		
			data.setpCode(rs.getInt("pCode"));
			data.setpName(rs.getString("pName"));
			data.setpDescript(rs.getString("pDescript"));
			data.setpManager(rs.getString("pManager"));
			data.setpMember(rs.getString("pMember"));
		}

		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			closeDB();
		}
		return data;
	}
	//	
	public void update(String _pName, String _pDescript, int _pCode) {
		connectDB();
		String query = "update PROJECT set pName=?, pDescript=? where pCode=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _pName);
			pstmt.setString(2, _pDescript);
			pstmt.setInt(3, _pCode);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}
	
	public void projectMemberUpdate(int _pCode, String _pMember) {
		connectDB();
		String query = "update PROJECT set pMember=? where pCode=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _pMember);
			pstmt.setInt(2, _pCode);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}
	

	public void delete(int _pCode) {
		connectDB();
		String query = "delete from PROJECT where pCode=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, _pCode);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}
	
	

	public void connectDB() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "root", "root");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeDB() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}	
}
