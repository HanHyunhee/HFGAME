package DTO;

public class InventoryDTO {
	private int SlotNumber = 0;				
	private int PlayerId = 0;				
	private int EquipmentId =0;
	
	
	public int getSlotNumber() {
		return SlotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		SlotNumber = slotNumber;
	}
	public int getPlayerId() {
		return PlayerId;
	}
	public void setPlayerId(int playerId) {
		PlayerId = playerId;
	}
	public int getEquipmentId() {
		return EquipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		EquipmentId = equipmentId;
	}				
}
