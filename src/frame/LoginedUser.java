package frame;

public class LoginedUser {
//	public String loginedUser = null;
//	public boolean loginState = false;
	private String loginedUser = null;
	private boolean loginState = false;

	

	public String getLoginedUser() {
		return loginedUser;
	}
	
	public boolean isLoginState() {
		return loginState;
	}

	public void setLoginState(boolean loginState) {
		this.loginState = loginState;
	}

	public void setLoginedUser(String loginedUser) {
		this.loginedUser = loginedUser;
	} 
	
}
