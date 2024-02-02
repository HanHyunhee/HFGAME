package DTO;

public class PetDTO {
	private int PetId = 0;
	private int ATK = 0;				
	private String Ability = null;
	
	
	public int getPetId() {
		return PetId;
	}
	public void setPetId(int petId) {
		PetId = petId;
	}
	public int getATK() {
		return ATK;
	}
	public void setATK(int aTK) {
		ATK = aTK;
	}
	public String getAbility() {
		return Ability;
	}
	public void setAbility(String ability) {
		Ability = ability;
	}				
}
