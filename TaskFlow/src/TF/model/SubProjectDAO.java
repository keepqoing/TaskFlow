package TF.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubProjectDAO {
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TaskFlow?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";

	Connection conn = null;
	PreparedStatement pstmt = null;

	//전체 리스트 read
	public ArrayList<SubProjectDO> list(){
		connectDB();
		String query = "select * from SubProject";

		ArrayList<SubProjectDO> datas = new ArrayList<SubProjectDO>();

		try {
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				SubProjectDO tmp = new SubProjectDO();
				tmp.setSubpId(rs.getInt("SubpId"));
				tmp.setSubpName(rs.getString("SubpName"));
				tmp.setSubpDescript(rs.getString("SubpDescript"));
				tmp.setSubpStartDate(rs.getDate("SubpStartDate"));
				tmp.setSubpEndDate(rs.getDate("SubpEndDate"));
				tmp.setSubpState(rs.getInt("SubpState"));
				tmp.setSubpFrom(rs.getInt("SubpFrom"));
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
	
	// 한 프로젝트의 공지사항 목록 read
	public ArrayList<SubProjectDO> SubProjectList(int SubpFrom){
		connectDB();
		String query = "select * from SubProject where SubpFrom=" + Integer.toString(SubpFrom);
		ArrayList<SubProjectDO> datas = new ArrayList<SubProjectDO>();

		try {
			pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				SubProjectDO tmp = new SubProjectDO();
				tmp.setSubpId(rs.getInt("SubpId"));
				tmp.setSubpName(rs.getString("SubpName"));
				tmp.setSubpDescript(rs.getString("SubpDescript"));
				tmp.setSubpStartDate(rs.getDate("SubpStartDate"));
				tmp.setSubpEndDate(rs.getDate("SubpEndDate"));
				tmp.setSubpState(rs.getInt("SubpState"));
				tmp.setSubpFrom(rs.getInt("SubpFrom"));
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
	
	
	// 공지사항 생성
	public void createSubProject(String _SubpName, String _SubpDescript, Date _SubpStartDate, Date _SubpEndDate , int _SubpFrom) {
		connectDB();
		String query = "insert into SubProject (SubpName, SubpDescript, SubpStartDate, SubpEndDate, SubpFrom) values(?,?,?,?,?)";		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _SubpName);
			pstmt.setString(2, _SubpDescript);
			pstmt.setDate(3, _SubpStartDate);
			pstmt.setDate(4, _SubpEndDate);
			pstmt.setInt(5, _SubpFrom);

			int n = pstmt.executeUpdate();


		}catch(SQLException e) {
			e.printStackTrace();
			return;
		}finally {
			closeDB();
		}
	}


	//공지사항 read
	public SubProjectDO readSubProject(int _SubpId) {
		connectDB();
		String query = "select * from SubProject where SubpId=?";

		SubProjectDO data = new SubProjectDO();
		try {
			pstmt = conn.prepareStatement(query);				
			pstmt.setInt(1, _SubpId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
		
			data.setSubpId(rs.getInt("SubpId"));
			data.setSubpName(rs.getString("SubpName"));
			data.setSubpDescript(rs.getString("SubpDescript"));
			data.setSubpStartDate(rs.getDate("SubpStartDate"));
			data.setSubpEndDate(rs.getDate("SubpEndDate"));
			data.setSubpState(rs.getInt("SubpState"));
			data.setSubpFrom(rs.getInt("SubpFrom"));
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
	
	// 공지사항 갱신
	public void updateSubProject(String _SubpName, String _SubpDescript, Date _SubpEndDate, int _SubpState, int _SubpId) {
		connectDB();
		String query = "update SubProject set SubpName=?, SubpDescript=?, SubpEndDate=?, SubpState=? where SubpId=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _SubpName);
			pstmt.setString(2, _SubpDescript);
			pstmt.setDate(3, _SubpEndDate);
			pstmt.setInt(4, _SubpState);
			pstmt.setInt(5, _SubpId);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}
	

	public void deleteSubProject(int _SubpId) {
		connectDB();
		String query = "delete from SubProject where SubpId=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, _SubpId);

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
