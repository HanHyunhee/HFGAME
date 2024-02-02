package DAO;

import DTO.PlayerDTO;

public class PlayerDAO extends DAO{
	public void insert(PlayerDTO pdto) {
		if (getConn()) { // insert into enrolldto values(?,?,?,?,?,?) 6매개변수 넘겨줄거임.
			try {
				psmt = null; // super class 에 선언되어있음.
				String sql = "insert into Player values(?,?,?,?,?,?,?,?,?)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, pdto.getPlayerId());
				psmt.setString(2, pdto.getMemberId());
				psmt.setInt(3, pdto.getPlayerLevel());
				psmt.setInt(4, pdto.getMaxHP());
				psmt.setInt(5, pdto.getHP());
				psmt.setInt(6, pdto.getATK());
				psmt.setInt(7, pdto.getDEF());
				psmt.setInt(8, pdto.getEXP());
				psmt.setInt(9, pdto.getGold());
				psmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				allClose();
			}
		}
	}
	
}
