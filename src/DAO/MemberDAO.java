package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.MemberDTO;

public class MemberDAO extends DAO {

//	private boolean getIsLogin;

	public void insert(MemberDTO d) {

		// TODO Auto-generated method stub
		/*
		 * 1. 드라이버로드 <한번만> - 가장 적당 한 위치로 객체가 생성될 때 딱 한번 실행하는 생성자에서 코딩 2. 컨넥션 자원 얻기 < 작업
		 * 수행시 마다 > - 반복으로사용할예정, 메서드로 정의 3. 쿼리 만들기 4. 쿼리 전송 5. 쿼리 결과값 리턴받기 <insert,
		 * delete, update 리턴값이 int, <select는 객체 한 개 이상 *** > 6. 리턴값 처리 7. 커넥션 자원 반납하기
		 */
		if (getConn()) { // insert into enrolldto values(?,?,?,?,?,?) 6매개변수 넘겨줄거임.
			try {
				psmt = null; // super class 에 선언되어있음.
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

	// 로그인하면 스트링타입으로 받고, 매개변수로 아이디 패스워드만 스트링으로 넘겨주자.! 아이디있으면 매개변수로 넘겨준 id 와 불린 값으로 자바내에 저장.
	// 매서드 호출한곳에서 리턴받은값을 통해 아이디를 저장하고, 리턴값이 null 이면 로그인안된상태, 스트링으로 리턴받은게 있으면 로그인된 상태를 저장하고 로그인된아이디에저장.
	public String login(String jid, String jpw) {
		ResultSet rs = null;
		String logResult=null;
		if (getConn()) { // insert into enrolldto values(?,?,?,?,?,?) 6매개변수 넘겨줄거임.
			try {
				psmt = null; // super class 에 선언되어있음.
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
////		  1. 드라이버로드 <한번만> - 가장 적당 한 위치로 객체가 생성될 때 딱 한번 실행하는 생성자에서 코딩 2. 컨넥션 자원 얻기 < 작업
////		  수행시 마다 > - 반복으로사용할예정, 메서드로 정의 3. 쿼리 만들기 4. 쿼리 전송 5. 쿼리 결과값 리턴받기 <insert,
////		  delete, update 리턴값이 int, <select는 객체 한 개 이상 *** > 6. 리턴값 처리 7. 커넥션 자원 반납하기
//		if (getConn()) { // insert into enrolldto values(?,?,?,?,?,?) 6매개변수 넘겨줄거임.
//			try {
//				psmt = null; // super class 에 선언되어있음.
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
