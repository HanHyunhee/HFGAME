package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {

	public final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public final String username = "system";
	public final String pass = "oracle";
//	pass = "oracle"; // pass ������ final keyword �� ������ �Ұ����� �����̱� ������ �����Ϸ����ϸ� ������ ������.
	public Connection conn = null;
	public PreparedStatement psmt = null;

	public DAO() {

	}

	public static void driverLoad() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Member ����̹� �ε� ����");
		} catch (Exception e) {
			System.out.println("Member ����̹� �ε� ����");
		}
	}

	public boolean getConn() {
		try {
			conn = DriverManager.getConnection(url, username, pass);

			System.out.println("���ؼ� ����");

			return true;
		} catch (Exception e) {
			System.out.println("���ؼ� ����");
		}
		return false;
	}

	public void allClose() { // �ڿ� �ݳ�
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
