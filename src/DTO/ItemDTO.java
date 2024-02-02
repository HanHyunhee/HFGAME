package DTO;

public class ItemDTO {
	private int ItemId =0;				
	private String ItemName = null;				
	private String ItemType = null;				
	private int ATK = 0 ;				
	private int DEF = 0;				
	private String ItemOption = null;				
	private int Price = 0;
	
	
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getItemType() {
		return ItemType;
	}
	public void setItemType(String itemType) {
		ItemType = itemType;
	}
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
	public String getItemOption() {
		return ItemOption;
	}
	public void setItemOption(String itemOption) {
		ItemOption = itemOption;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}				
}
