package DTO;

public class PlayerDTO {
	private String PlayerId = null;
	private String MemberId = null;
	private int PlayerLevel = 1;
	private int MaxHP = 20;
	private int HP = 20;		//default 20		
	private int ATK = 3;				
	private int DEF =0;				
	private int EXP = 0;		
	private int Gold = 200;
	
	
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public int getPlayerLevel() {
		return PlayerLevel;
	}
	public void setPlayerLevel(int level) {
		PlayerLevel = level;
	}
	
	
	public int getMaxHP() {
		return MaxHP;
	}
	public void setMaxHP(int maxHP) {
		MaxHP = maxHP;
	}
//	private String Ability = null; // 老窜 昏力
//	private int MP = 0;		// 老窜 昏力		
	
	
	public String getPlayerId() {
		return PlayerId;
	}
	public void setPlayerId(String playerId) {
		PlayerId = playerId;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
//	public int getMP() {
//		return MP;
//	}
//	public void setMP(int mP) {
//		MP = mP;
//	}
	public int getATK() {
		return ATK;
	}
	public void setATK(int aTK) {
		ATK = aTK;
	}
	public int getDEF() {
		return DEF;
	}
	public void setDEF(int dEF) {
		DEF = dEF;
	}
//	public String getAbility() {
//		return Ability;
//	}
//	public void setAbility(String ability) {
//		Ability = ability;
//	}
	public int getEXP() {
		return EXP;
	}
	public void setEXP(int eXP) {
		EXP = eXP;
	}
	public int getGold() {
		return Gold;
	}
	public void setGold(int gold) {
		Gold = gold;
	}	
}
