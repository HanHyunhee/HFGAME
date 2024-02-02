package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.MemberDTO;

public class MemberDAO extends DAO {

//	private boolean getIsLogin;

	public void insert(MemberDTO d) {

		// TODO Auto-generated method stub
		/*
		 * 1. ����̹��ε� <�ѹ���> - ���� ���� �� ��ġ�� ��ü�� ������ �� �� �ѹ� �����ϴ� �����ڿ��� �ڵ� 2. ���ؼ� �ڿ� ��� < �۾�
		 * ����� ���� > - �ݺ����λ���ҿ���, �޼���� ���� 3. ���� ����� 4. ���� ���� 5. ���� ����� ���Ϲޱ� <insert,
		 * delete, update ���ϰ��� int, <select�� ��ü �� �� �̻� *** > 6. ���ϰ� ó�� 7. Ŀ�ؼ� �ڿ� �ݳ��ϱ�
		 */
		if (getConn()) { // insert into enrolldto values(?,?,?,?,?,?) 6�Ű����� �Ѱ��ٰ���.
			try {
				psmt = null; // super class �� ����Ǿ�����.
				String sql = "insert into Member1 values(?,?,?,?,?)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, d.getName());
				psmt.setString(2, d.getId());
				psmt.setString(3, d.getPassword());
				psmt.setString(4, d.getEmail());
				psmt.setInt(5, 0);
				psmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				allClose();
			}
		}
	}

	// �α����ϸ� ��Ʈ��Ÿ������ �ް�, �Ű������� ���̵� �н����常 ��Ʈ������ �Ѱ�����.! ���̵������� �Ű������� �Ѱ��� id �� �Ҹ� ������ �ڹٳ��� ����.
	// �ż��� ȣ���Ѱ����� ���Ϲ������� ���� ���̵� �����ϰ�, ���ϰ��� null �̸� �α��ξȵȻ���, ��Ʈ������ ���Ϲ����� ������ �α��ε� ���¸� �����ϰ� �α��εȾ��̵�����.
	public String login(String jid, String jpw) {
		ResultSet rs = null;
		String logResult=null;
		if (getConn()) { // insert into enrolldto values(?,?,?,?,?,?) 6�Ű����� �Ѱ��ٰ���.
			try {
				psmt = null; // super class �� ����Ǿ�����.
				String sql = "select * from member1 where id=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, jid);
				rs = psmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("PassWord").equals(jpw)) {
						logResult = rs.getString("id");
//						System.out.println(logResult);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				allClose();
			}
		}
		return logResult;
	}

//	public boolean findId(String id) {
//		ArrayList<MemberDTO> views = new ArrayList<>();
//		ResultSet rs = null;
//		boolean find = false;
////		  1. ����̹��ε� <�ѹ���> - ���� ���� �� ��ġ�� ��ü�� ������ �� �� �ѹ� �����ϴ� �����ڿ��� �ڵ� 2. ���ؼ� �ڿ� ��� < �۾�
////		  ����� ���� > - �ݺ����λ���ҿ���, �޼���� ���� 3. ���� ����� 4. ���� ���� 5. ���� ����� ���Ϲޱ� <insert,
////		  delete, update ���ϰ��� int, <select�� ��ü �� �� �̻� *** > 6. ���ϰ� ó�� 7. Ŀ�ؼ� �ڿ� �ݳ��ϱ�
//		if (getConn()) { // insert into enrolldto values(?,?,?,?,?,?) 6�Ű����� �Ѱ��ٰ���.
//			try {
//				psmt = null; // super class �� ����Ǿ�����.
//				String sql = "select ? from Member";
//				psmt = conn.prepareStatement(sql);
//				psmt.setString(1, id);
//				psmt.executeQuery();
//				rs = psmt.executeQuery();
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				allClose();
//			}
//		}
//	}

}
