package TF.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeDAO {
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TaskFlow?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";

	Connection conn = null;
	PreparedStatement pstmt = null;

	//전체 리스트 read
	public ArrayList<NoticeDO> list(){
		connectDB();
		String query = "select * from notice";

		ArrayList<NoticeDO> datas = new ArrayList<NoticeDO>();

		try {
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				NoticeDO tmp = new NoticeDO();
				tmp.setnId(rs.getInt("nId"));
				tmp.setnName(rs.getString("nName"));
				tmp.setnDescript(rs.getString("nDescript"));
				tmp.setnWriter(rs.getString("nWriter"));
				tmp.setnDate(rs.getDate("nDate"));
				tmp.setnFrom(rs.getInt("nFrom"));
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
	public ArrayList<NoticeDO> NoticeList(int nFrom){
		connectDB();
		String query = "select * from notice where nFrom=" + Integer.toString(nFrom);
		
		ArrayList<NoticeDO> datas = new ArrayList<NoticeDO>();

		try {
			pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				NoticeDO tmp = new NoticeDO();
				tmp.setnId(rs.getInt("nId"));
				tmp.setnName(rs.getString("nName"));
				tmp.setnDescript(rs.getString("nDescript"));
				tmp.setnWriter(rs.getString("nWriter"));
				tmp.setnDate(rs.getDate("nDate"));
				tmp.setnFrom(rs.getInt("nFrom"));
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
	public void createNotice(String _nName, String _nDescript, String _nWriter, int _nFrom) {
		connectDB();
		String query = "insert into notice (nName, nDescript, nWriter, nFrom) values(?,?,?,?)";		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _nName);
			pstmt.setString(2, _nDescript);
			pstmt.setString(3, _nWriter);
			pstmt.setInt(4, _nFrom);

			int n = pstmt.executeUpdate();


		}catch(SQLException e) {
			e.printStackTrace();
			return;
		}finally {
			closeDB();
		}
	}


	//공지사항 read
	public NoticeDO readNotice(int _nId) {
		connectDB();
		String query = "select * from notice where nId=?";

		NoticeDO data = new NoticeDO();
		try {
			pstmt = conn.prepareStatement(query);				
			pstmt.setInt(1, _nId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
		
			data.setnId(rs.getInt("nId"));
			data.setnName(rs.getString("nName"));
			data.setnDescript(rs.getString("nDescript"));
			data.setnWriter(rs.getString("nWriter"));
			data.setnDate(rs.getDate("nDate"));
			data.setnFrom(rs.getInt("nFrom"));
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
	public void updateNotice(String _nName, String _nDescript, int _nId) {
		connectDB();
		String query = "update notice set nName=?, nDescript=?, nDate=now() where nId=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _nName);
			pstmt.setString(2, _nDescript);
			//pstmt.setDate(3, _nDate);
			pstmt.setInt(3, _nId);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}
	

	public void deleteNotice(int _nId) {
		connectDB();
		String query = "delete from notice where nId=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, _nId);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}
	
	public void deleteProject(int _nFrom) {
		connectDB();
		String query = "delete from notice where nfrom=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, _nFrom);

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
