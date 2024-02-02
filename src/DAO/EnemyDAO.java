package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.EnemyDTO;

public class EnemyDAO extends DAO{
	public EnemyDTO getEnemy(String a) {
		EnemyDTO result = null;
		ResultSet rs = null;
		if (getConn()) {
			try {
				PreparedStatement psmt = null;
				String sql = "select * from enemy where enemyid=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, a);
				rs = psmt.executeQuery();
				while (rs.next()) {
					EnemyDTO e = new EnemyDTO();
					e.setEnemyId(a);
					e.setMaxHP(rs.getInt("MaxHp"));
					e.setHP(rs.getInt("HP"));
					e.setATK(rs.getInt("ATK"));
					e.setDEF(rs.getInt("DEF"));
					e.setGiveEXP(rs.getInt("GiveEXP"));
					result = e;
				}
			} catch (Exception e) {
				e.printStackTrace();
// TODO: handle exception
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
// TODO: handle exception
				}
			}
		}
		return result;	
	}
}
