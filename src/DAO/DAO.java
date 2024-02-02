package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {

	public final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public final String username = "system";
	public final String pass = "oracle";
//	pass = "oracle"; // pass 변수는 final keyword 로 변경이 불가능한 상태이기 때문에 변경하려고하면 오류가 날것임.
	public Connection conn = null;
	public PreparedStatement psmt = null;

	public DAO() {

	}

	public static void driverLoad() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Member 드라이버 로드 성공");
		} catch (Exception e) {
			System.out.println("Member 드라이버 로드 실패");
		}
	}

	public boolean getConn() {
		try {
			conn = DriverManager.getConnection(url, username, pass);

			System.out.println("컨넥션 성공");

			return true;
		} catch (Exception e) {
			System.out.println("컨넥션 실패");
		}
		return false;
	}

	public void allClose() { // 자원 반납
		try {
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

}
