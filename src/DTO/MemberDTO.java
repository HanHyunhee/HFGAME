package DTO;

public class MemberDTO {
	private String Name=null;
	private String Id=null; 
	private String Password = null;
	private String Email = null; 
//	private String PhoneNumber = null; 
	private Boolean IsLogin = false;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
//	public String getPhoneNumber() {
//		return PhoneNumber;
//	}
//	public void setPhoneNumber(String phoneNumber) {
//		PhoneNumber = phoneNumber;
//	}
	public Boolean getIsLogin() {
		return IsLogin;
	}
	public void setIsLogin(Boolean isLogin) {
		IsLogin = isLogin;
	} 
}
