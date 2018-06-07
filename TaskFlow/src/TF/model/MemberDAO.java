package TF.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/TaskFlow?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";

	Connection conn = null;
	PreparedStatement pstmt = null;

	public ArrayList<MemberDO> list(){
		connectDB();
		String query = "select * from member";

		ArrayList<MemberDO> datas = new ArrayList<MemberDO>();

		try {
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				MemberDO tmp = new MemberDO();
				tmp.setId(rs.getString("id"));
				tmp.setPw(rs.getString("pw"));
				tmp.setName(rs.getString("name"));
				tmp.setEmail(rs.getString("email"));
				tmp.setPhone(rs.getString("phone"));
				tmp.setProject(rs.getString("project"));
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

	public void join(String _id, String _pw, String _name, String _email, String _phone) {
		connectDB();
		String query = "insert into member (id, pw, name, email, phone) values(?,?,?,?,?)";		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _id);
			pstmt.setString(2, _pw);
			pstmt.setString(3, _name);
			pstmt.setString(4, _email);
			pstmt.setString(5, _phone);

			int n = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
			return;
		}finally {
			closeDB();
		}
	}	

	public MemberDO getInfo(String _id) {
		connectDB();
		String query = "select * from member where id=?";

		MemberDO data = new MemberDO();
		try {
			pstmt = conn.prepareStatement(query);				
			pstmt.setString(1, _id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();

			data.setId(rs.getString("id"));
			data.setPw(rs.getString("pw"));
			data.setName(rs.getString("name"));
			data.setEmail(rs.getString("email"));
			data.setPhone(rs.getString("phone"));
			data.setProject(rs.getString("project"));
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
	public void update(String _id, String _pw, String _name, String _email, String _phone ) {
		connectDB();
		String query = "update member set pw=?, name=?, email=?, phone=? where id=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _pw);
			pstmt.setString(2, _name);
			pstmt.setString(3, _email);
			pstmt.setString(4, _phone);
			pstmt.setString(5, _id);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}

	public void updateproject(String _id, String _project ) {
		connectDB();
		String query = "update member set project=? where id=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _project);
			pstmt.setString(2, _id);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}
	
	public void delete(String _id) {
		connectDB();
		String query = "delete from member where id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _id);

			int n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		finally {
			closeDB();
		}
	}
	
	// 로그인시 아이디, 비밀번호 체크 메서드
    // 아이디, 비밀번호를 인자로 받는다.
    public int loginCheck(String _id, String _pw) 
    {
    	
    	connectDB();
        String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
        int x = -1;
        String query = "select pw from member where id=?";
        try {
        	pstmt = conn.prepareStatement(query);
            pstmt.setString(1, _id);
            ResultSet rs = pstmt.executeQuery();
 
            if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
            {
                dbPW = rs.getString("pw"); // 비번을 변수에 넣는다.
 
                if (dbPW.equals(_pw)) 
                    x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
                else                  
                    x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
                
            } else {
                x = -1; // 해당 아이디가 없을 경우
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDB();
		}
        return x;
    } // end loginCheck()

	
	

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
