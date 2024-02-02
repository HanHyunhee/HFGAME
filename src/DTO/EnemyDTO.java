package DTO;

public class EnemyDTO {
	private String EnemyId = null;				
	private int MaxHP = 0;
	private int HP = 0;
	private int ATK =0;				
	private int DEF = 0;				
	private int GiveEXP = 0;
	
//	private int MP =0;				
//	private String Ability = null;
	
	public int getMaxHP() {
		return MaxHP;
	}
	public void setMaxHP(int maxHP) {
		MaxHP = maxHP;
	}
	
	public String getEnemyId() {
		return EnemyId;
	}
	public void setEnemyId(String enemyId) {
		EnemyId = enemyId;
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
	public int getGiveEXP() {
		return GiveEXP;
	}
	public void setGiveEXP(int giveEXP) {
		GiveEXP = giveEXP;
	}				
}
