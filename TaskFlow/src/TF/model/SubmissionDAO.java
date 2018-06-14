package TF.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubmissionDAO {
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TaskFlow?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";

	Connection conn = null;
	PreparedStatement pstmt = null;

	public ArrayList<SubmissionDO> list(){
		connectDB();
		String query = "select * from Submission";

		ArrayList<SubmissionDO> datas = new ArrayList<SubmissionDO>();

		try {
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				SubmissionDO tmp = new SubmissionDO();
				tmp.setComment("comment");
				tmp.setFilename("filename");
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

	public void upload(String _pCode, String _spCode, String _writer, String _comment, String _filename) {
		connectDB();
		String query = "insert into Submission (pCode, spCode, writer, comment, filename) values(?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _pCode);
			pstmt.setString(2, _spCode);
			pstmt.setString(3, _writer);
			pstmt.setString(4, _comment);
			pstmt.setString(5, _filename);

			int n = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
			return;
		}finally {
			closeDB();
		}
	}	

	public ArrayList<SubmissionDO> getSubmissionList(String _pCode, String _spCode) {
		connectDB();
		String query = "select * from Submission where pCode=? AND spCode=?";
		ArrayList<SubmissionDO> datas = new ArrayList<SubmissionDO>();
		
		try {
			pstmt = conn.prepareStatement(query);				
			pstmt.setString(1, _pCode);
			pstmt.setString(2, _spCode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				SubmissionDO tmp = new SubmissionDO();
				tmp.setSmId(rs.getInt("smId"));
				tmp.setpCode(rs.getString("pCode"));
				tmp.setSpCode(rs.getString("spCode"));
				tmp.setWriter(rs.getString("writer"));
				tmp.setsDate(rs.getString("sDate"));
				tmp.setComment(rs.getString("comment"));
				tmp.setFilename(rs.getString("filename"));
				datas.add(tmp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			closeDB();
		}
		return datas;
	}
	
	
	public void delete(String _smId) {
		connectDB();
		String query = "delete from Submission where smId=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _smId);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}
	
	public void deleteProject(String _pCode) {
		connectDB();
		String query = "delete from Submission where pCode=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _pCode);

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
